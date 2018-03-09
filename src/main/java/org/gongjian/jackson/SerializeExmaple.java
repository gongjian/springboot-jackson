package org.gongjian.jackson;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class SerializeExmaple {

	public static void main(String[] args) throws Exception {
		Zoo zoo = new Zoo("SH Wild Park", "ShangHai");
		Lion lion = new Lion("Samba");
        Elephant elephant = new Elephant("Manny");
        elephant.setXxx("xxx");
        List<Animal> animals = new ArrayList<Animal>();
        
        animals.add(lion);
        animals.add(elephant);
        zoo.setAnimals(animals);
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerSubtypes(new NamedType(Elephant.class, "Elephant"));
		mapper.registerSubtypes(new NamedType(Lion.class, "Lion"));
		
		mapper.addMixIn(Animal.class, AnimalFilter.class);
		
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("AnimalFilter",  
                SimpleBeanPropertyFilter.serializeAllExcept("name"));  
		mapper.setFilterProvider(filterProvider);
		
		mapper.writeValue(new File("zoo.json"), zoo);
		
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.writeValue(new File("zoo.json"), zoo);
        
        
        
	}

}
