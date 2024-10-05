package com.j2y;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.j2y.algo.JsonToYaml;

public class JtyApplication {

	public static void main(String[] args) {
		try (BufferedReader reader=new BufferedReader(new InputStreamReader(System.in))){
			StringBuilder jsonString =new StringBuilder();
			String line;
			System.out.println("Enter Json String (Press Enter Twice To Finish)");
			while((line=reader.readLine())!=null && !line.isEmpty()) {
				jsonString.append(line).append("\n");
			}
			System.out.println("______Converted Json Entered________"+"\n"+"____________________________________");
			System.out.println(JsonToYaml.convertJsonToSchema(jsonString.toString()));
			System.out.println("_____________________________________"+"\n"+"Copy Above Converted YAML");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	public static void start() {
		try (BufferedReader reader=new BufferedReader(new InputStreamReader(System.in))){
			StringBuilder jsonString =new StringBuilder();
			String line;
			System.out.println("Enter Json String (Press Enter Twice To Finish)");
			while((line=reader.readLine())!=null && !line.isEmpty()) {
				jsonString.append(line).append("\n");
			}
			System.out.println("______Converted Json Entered________"+"\n"+"____________________________________");
			System.out.println(JsonToYaml.convertJsonToSchema(jsonString.toString()));
			System.out.println("_____________________________________"+"\n"+"Copy Above Converted YAML");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
