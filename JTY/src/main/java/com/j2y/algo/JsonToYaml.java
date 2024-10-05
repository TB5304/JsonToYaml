package com.j2y.algo;

import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonToYaml extends BaseMethods{
	public static String convertJsonToSchema(String jsonString) {
		try {
				JsonNode jsonNode = mapper.readTree(clear(jsonString));
				JsonNode schemaNode = formatToNode(jsonNode, true, "");
				return yamlMapper.writeValueAsString(schemaNode);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return "Failure"  ;
	}

	private static JsonNode formatToNode(JsonNode jsonNode, boolean b, String string) {
		ArrayNode reqArray;
		if (jsonNode.isObject()) { 
			ObjectNode schema = mapper.createObjectNode(); schema.put("type", "object");
			ObjectNode properties = schema.putObject("properties"); Iterator<String> fieldNames = jsonNode.fieldNames();
			reqArray = mapper.createArrayNode();
			while (fieldNames.hasNext()) {
				String fieldName = fieldNames.next();
				JsonNode fieldValue = jsonNode.get(fieldName);
				if (fieldValue.isNull() || fieldValue.isMissingNode()) {
					continue;
				}
				reqArray.add(fieldName);
				properties.set(fieldName, formatToNode(fieldValue, false, fieldName));
			}

			if (!reqArray.isEmpty()) {
				schema.putArray("required").addAll(reqArray);
			}
			return schema;
		}
		else if (jsonNode.isArray() ) {
				ArrayNode schema= mapper.createArrayNode();
				JsonNode firstElement = jsonNode.get(0);
				if (firstElement != null) {
					schema.add(formatToNode(firstElement, false, ""));
				}
				ObjectNode arraySchema = mapper.createObjectNode(); arraySchema.put("type", "array");
				arraySchema.put("type","array");
				arraySchema.set("items", schema);
				return arraySchema;

		}else if (jsonNode.isTextual()) {
				 return mapper.createObjectNode().put("type", "string" );
		} else if (jsonNode.isNumber()) {
				return mapper.createObjectNode().put("type", "integer");		
		} else if (jsonNode.isBoolean()) {
				return mapper.createObjectNode().put("type", "boolean");
		}
		else if (jsonNode.isNull()) {
			return mapper.createObjectNode().put("type", "null");
		}
		else {
			return null;
		}
	
	
	}
}
