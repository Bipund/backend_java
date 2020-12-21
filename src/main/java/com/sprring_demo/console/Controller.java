package com.sprring_demo.console;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@RestController
public class Controller {

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@CrossOrigin
	@Transactional
	public JSONObject login(@RequestBody Object parameter) {
		System.out.println("inside the login controller");
			
	
		JSONObject result = new JSONObject();
		try {
		   	JSONObject jo = new JSONObject();
			jo.putAll((Map) parameter);
			System.out.println(jo);
			System.out.println("this is test"+jo.get("username"));
				if(jo.get("username").equals("User")) {
					if(jo.get("password").equals("password")) {
						result.put("code", 200);
						result.put("name", "Login Successfully.");	
					}else {
						result.put("code", 400);
						result.put("message", "Incorrect Password");
					}
					
				}else {
					result.put("code", 400);
					result.put("message", "Username is not valid");
				}
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("code", 400);
			result.put("message", "their is an error");
		}
		return result;
	}
	
}
