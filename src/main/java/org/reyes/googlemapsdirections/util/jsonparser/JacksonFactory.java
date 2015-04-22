package org.reyes.googlemapsdirections.util.jsonparser;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/** Factory class for initializing and managing the Jackson Object Mapper */
public class JacksonFactory {
	/** the object mapper */
	private static ObjectMapper mapper = null;
	
	/** Returns the global copy of the object mapper 
	 * @return the global object mapper */
	public synchronized static ObjectMapper getParser()
    {
		if (mapper == null)
        {
			mapper = new ObjectMapper();
            mapper.setSerializationInclusion(Include.NON_NULL);
			mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);  // ignore props we don't know about
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);           // Last line doesn't seem to be working on the server (but works in the debugger), so added this one.
		}
		
		return mapper;
	}
}
