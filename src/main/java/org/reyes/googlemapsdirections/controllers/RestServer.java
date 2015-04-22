package org.reyes.googlemapsdirections.controllers;

import org.apache.commons.lang3.StringUtils;
import org.reyes.googlemapsdirections.model.MapDirections;
import org.reyes.googlemapsdirections.providers.IMapDirectionsDataProvider;
import org.reyes.googlemapsdirections.util.jsonparser.JacksonFactory;
import org.reyes.googlemapsdirections.util.manifest.About;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.*;
import java.util.*;
import java.util.jar.Manifest;

/**
 * Entry point for the servlet.
 */
@Component
@Path("/")
public class RestServer
{
    public static final Logger log = LoggerFactory.getLogger(RestServer.class);

    @Context
    protected HttpServletRequest httpRequest;

    @Autowired
    protected IMapDirectionsDataProvider googleMapDirectionsDataProvider;

    /**
     * Gets the JSON list of partners.
     *
     * @return JSON response with list of partners or error response.
     */
    @GET
    @Path("/directions")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDirectionsJson(@QueryParam("from") String sFrom,
                                      @QueryParam("to") String sTo)
    {
        if (StringUtils.isBlank(sFrom) || StringUtils.isBlank(sTo))
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        try
        {
            MapDirections mapDirections = googleMapDirectionsDataProvider.getDirections(sFrom, sTo);

            if (mapDirections == null)
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

            String returnValue = mapDirections.toJsonString();

            if (StringUtils.isBlank(returnValue))
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

            return Response.ok(returnValue).build();
        }
        catch (Exception e)
        {
            log.error("", e);
            throw new WebApplicationException(e);
        }
    }

    /**
     * Get config info.
     *
     * @return Response containing version and build info in plain text format.
     */
    @GET
    @Path("/about")
    @Produces(MediaType.TEXT_PLAIN)
    public Response about()
    {
        try
        {
            final Manifest manifest = About.explodedWarManifest(httpRequest.getSession().getServletContext());
            StreamingOutput so = new StreamingOutput() {
                public void write(OutputStream os) throws IOException, WebApplicationException {
                    manifest.write(os);
                }
            };

            return Response.ok(so).build();
        }
        catch (FileNotFoundException e)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        catch (Exception e)
        {
            log.error("", e);
            throw new WebApplicationException(e);
        }
    }

    /**
     * Get config info.
     *
     * @return Response containing version and build info in JSON format.
     */
    @GET
    @Path("/about")
    @Produces(MediaType.APPLICATION_JSON)
    public Response aboutJson()
    {
        try
        {
            Manifest manifest = About.explodedWarManifest(httpRequest.getSession().getServletContext());
            return Response.ok(new TreeMap<Object, Object>(manifest.getMainAttributes())).build();
        }
        catch (FileNotFoundException e)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        catch (Exception e)
        {
            log.error("", e);
            throw new WebApplicationException(e);
        }
    }
}
