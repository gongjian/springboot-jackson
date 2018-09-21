package org.gongjian.jackson;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Student {
	
	private Date birthDay;

	public Date getBirthDay() {
		return birthDay;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	Map<String, Object> map = new HashMap<>();
	
	@JsonAnySetter
	public void setOtherInfos(String key, Object value) {
		this.map.put(key, value);
	}
	
	public Map<String, Object> getOtherInfos() {
		return map;
	}
	
	

}
