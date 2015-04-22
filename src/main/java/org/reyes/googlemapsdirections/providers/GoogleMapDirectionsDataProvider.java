package org.reyes.googlemapsdirections.providers;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.URIBuilder;
import org.reyes.googlemapsdirections.model.GoogleMapDirections;
import org.reyes.googlemapsdirections.model.MapDirections;
import org.reyes.googlemapsdirections.util.http.HttpJsonGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.ArrayList;

/**
 * Provides directions from Google Maps API.
 */
public class GoogleMapDirectionsDataProvider implements IMapDirectionsDataProvider
{
    /** Logger */
    public static final Logger logger = LoggerFactory.getLogger(GoogleMapDirectionsDataProvider.class);

    /** Status returned from the API when it worked. */
    public static final String cs_goodStatus = "OK";

    /** Status returned from the API when it didn't work. */
    public static final String cs_badStatus = "NOT_FOUND";

    /** Message returned when it didn't work. Not taking the time for i18n now. */
    public static final String cs_errorMsg = "Error retrieving directions.";

    /**
     * Google API key. Injected from the applicationContext.xml.
     */
    private String m_sApiKey = "";

    /**
     * Getter for m_sApiKey.
     *
     * @return Google API key.
     */
    public String getApiKey()
    {
        return m_sApiKey;
    }

    /**
     * Setter for m_sApiKey. Called by Spring in applicationContext.xml.
     *
     * @param apiKey Google API key.
     */
    public void setApiKey(String apiKey)
    {
        m_sApiKey = apiKey;
    }

    /**
     * Google API base URL. Injected from the applicationContext.xml.
     */
    private String m_sApiBaseUrl = "";

    /**
     * Getter for m_sApiBaseUrl.
     *
     * @return Google API Base Url.
     */
    public String getApiBaseUrl()
    {
        return m_sApiBaseUrl;
    }

    /**
     * Setter for m_sApiBaseUrl. Called by Spring in applicationContext.xml.
     *
     * @param apiBaseUrl Google Base Url.
     */
    public void setApiBaseUrl(String apiBaseUrl)
    {
        m_sApiBaseUrl = apiBaseUrl;
    }


    /**
     * Given from and to strings, call Google API to get directions.
     *
     * @param from Starting point for directions.
     * @param to   Ending point for directions.
     *
     * @return Object containing the directions or error.
     */
    @Override
    public MapDirections getDirections(String from, String to)
    {
        MapDirections directions = null;

        try
        {
            URIBuilder uriBuilder = new URIBuilder(m_sApiBaseUrl)
                    .addParameter("origin", from)
                    .addParameter("destination", to);

            if (!StringUtils.isBlank(m_sApiKey))
                uriBuilder = uriBuilder.addParameter("key", m_sApiKey);

            URI uri = uriBuilder.build();

            HttpJsonGet<GoogleMapDirections> directionsGet = new HttpJsonGet<GoogleMapDirections>();

            GoogleMapDirections googleMapDirections = directionsGet.getObject(uri, "GetGoogleDirections", GoogleMapDirections.class);

            directions = convertDirections(googleMapDirections);
        }
        catch(Exception ex)
        {
            String msg = String.format("GoogleMapDirectionsDataProvider.getDirections: Exception thrown calling Google: %s", ex.toString());
            logger.error(msg, ex);
            directions = new MapDirections();
            directions.errorMessage = msg;
        }

        return directions;
    }

    /**
     * Convert Google Maps directions to a more simplified version we will return to callers.
     *
     * @param googleMapDirections Object we deserialized JSON returned from Google into.
     *
     * @return Simplified directions object.
     */
    public MapDirections convertDirections(GoogleMapDirections googleMapDirections)
    {
        MapDirections mapDirections = new MapDirections();

        // Parse out Google map directions to flatten the "routes" and "legs" stuff as we will only support one leg.
        if (googleMapDirections == null || !googleMapDirections.status.equalsIgnoreCase(cs_goodStatus))
        {
            mapDirections.errorMessage = cs_errorMsg;
            return mapDirections;
        }

        if (googleMapDirections.routes != null && !googleMapDirections.routes.isEmpty())
            if (googleMapDirections.routes.get(0) != null && !googleMapDirections.routes.get(0).legs.isEmpty())
                if (googleMapDirections.routes.get(0).legs.get(0).steps != null && !googleMapDirections.routes.get(0).legs.get(0).steps.isEmpty())
                {
                    mapDirections.steps = new ArrayList<String>();
                    for (GoogleMapDirections.GoogleMapStep mapStep : googleMapDirections.routes.get(0).legs.get(0).steps)
                    {
                        mapDirections.steps.add(mapStep.html_instructions);
                    }

                    mapDirections.distance = googleMapDirections.routes.get(0).legs.get(0).distance.text;
                    mapDirections.duration = googleMapDirections.routes.get(0).legs.get(0).duration.text;
                }

        return mapDirections;
    }

}
