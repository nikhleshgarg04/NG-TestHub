package com.lr.nextgen.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.lr.nextgen.base.BaseClass;

public class UtilsClass {

	
	public Map<String, String> InputMemberInMap(Class cls) {
        Map<String, String> jsonPathMap = new HashMap<String, String>();
        try {

            for (Field fields : cls.getFields()) {
                jsonPathMap.put(fields.getName(),
                        fields.get(fields.getName()).toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jsonPathMap;
    }
}
