package org.gongjian.jackson;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

//@JsonTypeInfo(use = Id.CLASS, include = As.PROPERTY, property = "@class")
//@JsonSubTypes({ @Type(value = Lion.class, name = "lion"), @Type(value = Elephant.class, name = "elephant") })
//@JsonTypeInfo(use = Id.NAME, property = "@type")
public abstract class Animal {
	String name;
	String type;
}