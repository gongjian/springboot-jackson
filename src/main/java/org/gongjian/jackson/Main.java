package org.gongjian.jackson;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void main(String[] args) throws IOException {
		ObjectMapper om = new ObjectMapper();
		
		User user = new User();
		user.setId(1);
		user.setName("a\nb");
		
		System.out.println(om.writeValueAsString(user));
		
		String json = "{\"id\":1,\"name\":\"a\\nb\"}";
		User u = om.readValue(json, User.class);
		
		System.out.println(u.getName());

	}

}
