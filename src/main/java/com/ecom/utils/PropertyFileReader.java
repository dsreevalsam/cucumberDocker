package com.ecom.utils;


import java.util.ResourceBundle;

public class PropertyFileReader {
	

	private ResourceBundle properties = null;

	public PropertyFileReader(String propertyFileName) {
		this.properties = ResourceBundle.getBundle(propertyFileName);
	}

	/**
	 * Gets a string value given the key
	 */
	public String getString(String Key) {
		String res = null;
		try {
			res = properties.getString(Key);
		} catch (Exception Ex) {
			System.out.println("[ERROR] Expected Key " + Key + " does not exist in the properties file, returning null!");
		}
		return res;
	}


}
