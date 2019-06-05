package com.greeshma;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

import io.restassured.path.json.JsonPath;

public class JsonExample {

	public static void main(String[] args) {

		try {
			String jsondata = new String(Files.readAllBytes(Paths.get("D://config.json")));
			JsonPath path = new JsonPath(jsondata);
			Set<Object> keys = path.getMap("formats").keySet();
			for(Object key : keys){
				if(!path.getMap("formats."+key).keySet().isEmpty()){
					Set<Object> subKeys = path.getMap("formats."+key).keySet();
					for(Object subkey : subKeys){
					System.out.println(subkey + ":"+ path.get("formats."+key+"."+subkey));
					}
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
