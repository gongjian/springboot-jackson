package org.gongjian.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Elephant extends Animal {
	private String name;
	private String xxx;

	public String getXxx() {
		return xxx;
	}

	public void setXxx(String xxx) {
		this.xxx = xxx;
	}

	@JsonCreator
	public Elephant(@JsonProperty("name") String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return "herbivorous";
	}

	@Override
	public String toString() {
		return "Elephant [getName()=" + getName() + ", getType()=" + getType() + "]";
	}

}
