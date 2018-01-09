package com.personnel.utils;

import java.util.HashMap;
import java.util.Map;

public class Utils {
	public static Map<String, Object> toMap(Page page) {
		Map<String,Object> map =  new HashMap<>();
    	map.put("page", page);
    	return map;
	}
}
