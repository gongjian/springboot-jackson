package org.gongjian.jackson;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonFilter("AnimalFilter")
@JsonTypeInfo(use = Id.NAME, property = "@type")
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface AnimalFilter {
	
	@JsonIgnore
	boolean isEmpty();

}
