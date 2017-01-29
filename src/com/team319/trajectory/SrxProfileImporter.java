package com.team319.trajectory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class SrxProfileImporter {

	public String path; 

	public SrxProfileImporter (String directory){
		this.path = directory;
	}
	
	public CombinedSrxMotionProfile importCombinedSRXMotionProfile (String profileName){
		//these are actually json files, so append appropriately
		String fileName = profileName + "_SRX_Combined.json";
		
		//get the full filepath
		
		String relativeFilePath = joinFilePaths(this.path, fileName);
		File file = new File(relativeFilePath);
		
		JSONObject combinedJson = null;
		JSONParser parser = new JSONParser();
		
		try {
			String profileData = readFile(file.getAbsolutePath());
			combinedJson = (JSONObject) parser.parse(profileData);
		} catch (Exception e) {
			return null;
		}
		
		CombinedSrxMotionProfile cSrxProfile = new CombinedSrxMotionProfile(combinedJson);
		
		return cSrxProfile;
		
	}
	
	static String readFile(String path) throws IOException 
	{
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded);
	}


	public static String joinFilePaths(String path1, String path2) {
		File file1 = new File(path1);
		File file2 = new File(file1, path2);
		return file2.getPath();
	}

}
