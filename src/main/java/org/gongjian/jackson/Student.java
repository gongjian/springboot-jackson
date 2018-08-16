package org.gongjian.jackson;

import java.util.Date;

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

}
