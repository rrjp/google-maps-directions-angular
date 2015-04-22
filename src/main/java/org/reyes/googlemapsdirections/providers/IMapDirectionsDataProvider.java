package org.reyes.googlemapsdirections.providers;

import org.reyes.googlemapsdirections.model.MapDirections;

/**
 * Interface for a map directions provider in case we want to create more providers than just Google (e.g. MapQuest).
 */
public interface IMapDirectionsDataProvider
{
    MapDirections getDirections(String from, String to);
}
