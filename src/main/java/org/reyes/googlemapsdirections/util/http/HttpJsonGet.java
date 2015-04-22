package org.reyes.googlemapsdirections.util.http;

import org.reyes.googlemapsdirections.util.jsonparser.JacksonFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;

/**
 * Generic class to run a HTTP GET and deserialize a JSON repsonse into a given object type.
 *
 * @param <T> The type of the object to deserialize the JSON into.
 */
public class HttpJsonGet<T>
{
    public static final Logger logger = LoggerFactory.getLogger(HttpJsonGet.class);

    /** Allow the caller to retrieve the status. */
    public int getHttpStatus()
    {
        return httpStatus;
    }

    /** The status returned if any. */
    private int httpStatus = 0;


    /** If we got a response and were able to convert it to string this will get the raw response if needed. */
    public String getResponse()
    {
        return response;
    }

    /** The response returned if any. */
    private String response;

    /**
     * Call the URI and get the info.
     *
     * @param uri The ready to go URI to use.
     * @param requestName Name of the request for logging.
     * @param returnType The return type to use. Java requires this for us to know the type inside the method.
     *
     * @return Object of type T.
     */
    public T getObject(final URI uri, final String requestName, final Class<T> returnType)
    {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        T returnValue = null;

        try
        {
            String url = uri.toString();
            HttpGet httpget = new HttpGet(url);

            logger.debug(url);

            // Create a custom response handler
            ResponseHandler<T> responseHandler = new ResponseHandler<T>()
            {
                public T handleResponse(final HttpResponse response) throws IOException
                {
                    httpStatus = response.getStatusLine().getStatusCode();

                    // Servers may return useful error information even when they return 4xx or 5xx
                    // series statuses, so we should still try to parse what is returned in that case.
                    if (httpStatus < 200 || httpStatus >= 300)
                    {
                        logger.warn(String.format("HttpJsonGet.getObject: %s returned bad status code: %s. Parsing the response may fail.", requestName, httpStatus));
                    }

                    HttpEntity entity = response.getEntity();

                    if (entity == null)
                    {
                        logger.error(String.format("HttpJsonGet.getObject: %s returned null entity.", requestName));
                        return null;
                    }

                    HttpJsonGet.this.response = EntityUtils.toString(entity);

                    T returnObj = null;

                    try
                    {
                        returnObj = JacksonFactory.getParser().readValue(HttpJsonGet.this.response, returnType);
                    }
                    catch(IOException ex)
                    {
                        String msg = String.format("HttpJsonGet.getObject: %s unable to parse JSON. Parser threw exception.", requestName);
                        logger.error(msg);
                        return null;
                    }

                    return returnObj;

                }
            };

            returnValue = httpclient.execute(httpget, responseHandler);

        }
        catch (IOException iex)
        {
            logger.error("HttpJsonGet.getObject: IOException caught.", iex);
        }
        finally
        {
            try
            {
                httpclient.close();
            }
            catch (IOException clex)
            {
                logger.error("HttpJsonGet.getObject: IOException caught during HttpClient.close().", clex);
            }
        }

        return returnValue;
    }
}
