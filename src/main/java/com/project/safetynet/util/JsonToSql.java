//package com.project.safetynet.util;
//
//import java.util.Iterator;
//import java.util.Map;
//
//import com.fasterxml.jackson.core.JsonFactory;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class JsonToSql {
//	/**
//	 * 
//	 * @param tableName
//	 * @param json
//	 * @return String DDL SQL
//	 */
//	public String parse(String tableName, String json) {
//		JsonFactory factory = new JsonFactory();
//
//		StringBuilder sql = new StringBuilder(256);
//		sql.append("CREATE TABLE ").append(tableName).append(" ( ");
//
//		ObjectMapper mapper = new ObjectMapper(factory);
//		JsonNode rootNode = null;
//		try {
//			rootNode = mapper.readTree(json);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.fields();
//		while (fieldsIterator.hasNext()) {
//			Map.Entry<String, JsonNode> field = fieldsIterator.next();
//			System.out.println("Key: " + field.getKey() + "\tValue:" + field.getValue());
//
//			sql.append(field.getKey());
//
//			if (field.getValue().asText().contains("/")) {
//				sql.append(" STRING, ");
//			} else if (field.getValue().asText().contains("/")) {
//				sql.append(" DATE, ");
//			} else if (field.getValue().canConvertToInt()) {
//				sql.append(" INT, ");
//			} else if (field.getValue().canConvertToLong()) {
//				sql.append(" LONG, ");
//			}
//
//			else if (field.getValue().asText().length() > 25) {
//				sql.append(" VARCHAR( ").append(field.getValue().asText().length() + 25).append("), ");
//			} else {
//				sql.append(" VARCHAR(25), ");
//			}
//		}
//
//		// end table
//		sql.append(" ) ");
//		return sql.toString();
//
//	}
//
//	public static void main(String[] args) {
//		JsonToSql ddl = new JsonToSql();
//
//		String json = "{\"EMP_ID\":3001,\"FIRST_NAME\":\"John\",\"LAST_NAME\" :\"Boyd\", \"ADDRESS\":\"1509 Culver St\", \"CITY\" : \"Culver\", \"ZIP\" : \"97451\", \"PHONE\" : \"841-874-6512\",\"EMAIL\" : \"jaboyd@email.com\"}";
//		String ddlSQL = ddl.parse("PERSONS", json);
//
//		System.out.println("DDL=" + ddlSQL);
//
//		json = "{\"EMP_ID\":4001, \"ADDRESS\" : \"1509 Culver St\" , \"STATION\" : 3}";
//		ddlSQL = ddl.parse("FIRESTATIONS", json);
//
//		System.out.println("DDL=" + ddlSQL);
//
//	}
//}
