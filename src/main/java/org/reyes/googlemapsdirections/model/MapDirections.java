package org.reyes.googlemapsdirections.model;

import org.reyes.googlemapsdirections.util.jsonparser.JsonObject;

import java.util.ArrayList;

/**
 * Data transfer class for JSON serialization of response.
 */
public class MapDirections extends JsonObject
{
    /** Distance */
    public String distance;

    /** How long to get there. */
    public String duration;

    /** The steps to get there. */
    public ArrayList<String> steps;

    /** Message if there was an error */
    public String errorMessage;
}
