package com.j2y.algo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class BaseMethods {
	public static YAMLMapper yamlMapper=new YAMLMapper();
	public static final ObjectMapper mapper=new ObjectMapper();
	
	public static String clear(String json) {
		return json.replaceAll("//.*?\n", "\n");
	}
}
