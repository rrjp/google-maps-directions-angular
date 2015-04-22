package org.reyes.googlemapsdirections.util.jsonparser;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/** Intended to allow child classes to get a JSON document when calling toString()  */
public class JsonObject
{
	/** local copy of the object mapper */
	private static ObjectMapper mapper = JacksonFactory.getParser();
	
	/** use Jackson to convert the object to a string 
	 * @return the JSON document representing this object, or Object.toString(), on error */
	public final String toJsonString()
    {
		try
        {
			return mapper.writeValueAsString(this);
		}
		catch (IOException e)
        {
			return(super.toString());
		}
	}
	
	@Override
	public final String toString() {
		return this.toJsonString();
	}

	/** convert a string to a JSON response
	 * @param object an object to convert to a JSON
	 * @return the string representation of the object, or Object.toString() on error 
	 */
	public static String toJson(Object object)
    {
		try
        {
			return mapper.writeValueAsString(object);
		}
		catch (IOException e)
        {
			return(object.toString());
		}
	}
}
