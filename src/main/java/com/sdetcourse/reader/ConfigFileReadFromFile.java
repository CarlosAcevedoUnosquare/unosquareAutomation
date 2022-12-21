package com.sdetcourse.reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.Iterator;

public class ConfigFileReadFromFile {
	
	public void getJsonAmazonUrl() {
		JSONParser parser = new JSONParser();
		try {
	        Object obj = parser.parse(new FileReader("configFile.json"));
	        JSONObject jsonObject = (JSONObject) obj;
	        JSONArray urlList = (JSONArray) jsonObject.get("AMAZON_URL");
	        Iterator<JSONObject> iteratorURL = urlList.iterator();
	        System.out.println(iteratorURL.next());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public String getJsonValueOf(String URL) {
		String returnURL = null;
		JSONParser parser = new JSONParser();
		try {
	        Object obj = parser.parse(new FileReader("configFile.json"));
	        JSONObject jsonObject = (JSONObject) obj;
	        returnURL = (String) jsonObject.get(URL);
	        /*
	        JSONArray urlList = (JSONArray) jsonObject.get(URL);
	        Iterator<JSONObject> iteratorURL = urlList.iterator();
	        System.out.println(iteratorURL.next());
	        returnURL = urlList.toJSONString();
	        */
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return returnURL;
	}
	
	 @SuppressWarnings("unchecked")
	    public static void main(String[] args) {
		 ConfigFileReadFromFile configFileReadFromFile = new ConfigFileReadFromFile();
		 String test = configFileReadFromFile.getJsonValueOf("AMAZON_URL");
		 System.out.println("El valor es: " + test);
		 /*
	        JSONParser parser = new JSONParser();
	        try {
	            Object obj = parser.parse(new FileReader("configFile.json"));
	            // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
	            JSONObject jsonObject = (JSONObject) obj;
	            // A JSON array. JSONObject supports java.util.List interface.
	            JSONArray companyList = (JSONArray) jsonObject.get("Company List");
	            JSONArray urlList = (JSONArray) jsonObject.get("AMAZON_URL");
	            // An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
	            // Iterators differ from enumerations in two ways:
	            // 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
	            // 2. Method names have been improved.
	            Iterator<JSONObject> iterator = companyList.iterator();
	            Iterator<JSONObject> iteratorURL = urlList.iterator();
	            System.out.println(iteratorURL.next());
	            while (iterator.hasNext()) {
	                System.out.println(iterator.next());
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }*/
	    }
}
