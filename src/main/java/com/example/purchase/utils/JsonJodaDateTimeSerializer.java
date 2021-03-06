package com.example.purchase.utils;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * When passing JSON around, it's good to use a standard text representation of
 * the date, rather than the full details of a Joda DateTime object. Therefore,
 * this will serialize the value to the ISO-8601 standard:
 * <pre>yyyy-MM-dd'T'HH:mm:ss.SSSZ</pre>
 */
public class JsonJodaDateTimeSerializer extends JsonSerializer<DateTime> {

    private static DateTimeFormatter formatter = ISODateTimeFormat.dateTime();

	@Override
	public void serialize(DateTime value, JsonGenerator gen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		  gen.writeString(formatter.print(value));
		
	}

}