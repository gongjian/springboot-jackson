package org.gongjian.jackson;

//@JsonTypeInfo(use = Id.CLASS, include = As.PROPERTY, property = "@class")
//@JsonSubTypes({ @Type(value = Lion.class, name = "lion"), @Type(value = Elephant.class, name = "elephant") })
//@JsonTypeInfo(use = Id.NAME, property = "@type")
public abstract class Animal {
	String name;
	String type;
}