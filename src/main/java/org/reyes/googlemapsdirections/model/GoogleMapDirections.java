package org.reyes.googlemapsdirections.model;

import java.util.ArrayList;

/**
 * Class to deserialize the JSON from Google Map Directions into. Just deserialize the pieces we are interested in.
 */
public class GoogleMapDirections
{
    /** Array of routes. */
    public ArrayList<GoogleMapRoutes> routes;

    /**  Set to "NOT_FOUND" if it can't find a route. Status is "OK" if it worked. */
    public String status;

    /** Each route can have legs. */
    public static class GoogleMapRoutes
    {
        public ArrayList<GoogleMapLeg> legs;
    }

    /** Each leg can have steps. */
    public static class GoogleMapLeg
    {
        public ArrayList<GoogleMapStep> steps;

        public GoogleMapLegDistance distance;

        public GoogleMapLegDuration duration;
    }

    /** Each step has directions. */
    public static class GoogleMapStep
    {
        public String html_instructions;
    }

    /** Distance */
    public static class GoogleMapLegDistance
    {
        public String text;
    }

    /** Duration */
    public static class GoogleMapLegDuration
    {
        public String text;
    }

}
