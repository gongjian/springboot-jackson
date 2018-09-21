package org.gongjian.jackson;

import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.util.StdDateFormat;

public class JsonTest {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		String str = "{\"birthDay\":\"1986-05-04\", \"name\":\"james\"}";
		ObjectMapper mapper = new ObjectMapper();
		mapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		
		DeserializationConfig dcfg = mapper.getDeserializationConfig();
		SerializationConfig scfg = mapper.getSerializationConfig();
		
		StdDateFormat df = new StdDateFormat();
		df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		df.setCalendar(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")));
		
		dcfg.with(df);
		scfg.with(df);
		
		Student st = mapper.readValue(str, Student.class);
		
		System.out.println(st.getBirthDay());
		System.out.println(mapper.writeValueAsString(st));

	}

}
