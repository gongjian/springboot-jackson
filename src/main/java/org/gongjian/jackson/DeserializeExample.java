package org.gongjian.jackson;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class DeserializeExample {

	public static void main(String[] args) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.registerSubtypes(new NamedType(Elephant.class, "Elephant"));
		mapper.registerSubtypes(new NamedType(Lion.class, "Lion"));
		
		mapper.addMixIn(Animal.class, AnimalFilter.class);
		
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("AnimalFilter",  
                SimpleBeanPropertyFilter.serializeAllExcept("name"));  
		mapper.setFilterProvider(filterProvider);
		
		Zoo zoo = mapper.readValue(new File("zoo.json"), Zoo.class);
		System.out.println(zoo);
	}
}