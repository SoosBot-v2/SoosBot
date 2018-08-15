package SooBot.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Config {
	
	public static Object config = null;
	public static JSONObject objconfig = null;
	
	public static void loadConfig() throws FileNotFoundException, IOException, ParseException {
		File dir = new File("tmp");
		dir.mkdir();
		JSONParser parser = new JSONParser();
    	Object obj = null;
		obj = parser.parse(new FileReader("config.json"));
		config = obj;
        JSONObject jsonObject = (JSONObject) obj;
        objconfig = jsonObject;
        System.out.println("[INFO]: Successfully loaded Config.json");
	}
	
	@SuppressWarnings({ "unchecked" })
	public static void createConfig()  {
		File f = new File("config.json");
		if(f.exists()) {
			System.out.println("[INFO]: Found Config! No one must be created");
		}else{
			System.out.println("[WARNING]: No Config Found! Create one...");
			JSONObject obj = new JSONObject();
			obj.put("clientid", "404635892381384704");
			obj.put("token", "NaN");
			obj.put("status", "on Enjuu");
		
			try (FileWriter file = new FileWriter("config.json")) {
				file.write(obj.toJSONString());
				System.out.println("[INFO]: Successfully created Config...");
			} catch (IOException e) {
				System.err.println("[ERROR]: Can't create Config...");
				e.printStackTrace();
			}
		}
    
	}
	
	public static String getString(String string) {
		try{
			String result = (String) objconfig.get(string);
			return result;
		}catch (Exception e){
			return "Error Load "+string+ " in config.json! Is it possible that your String ins't a String?";
		}
	}
	
	
	public static Boolean getBool(String string) {
		try{
			Boolean result = (Boolean) objconfig.get(string);
			return result;
		}catch (Exception e){
			System.out.println("Error Loading the Config");
			return false;
		}
	}
	
	public static Long getLong(String string) {
		try{
			Long result = (Long) objconfig.get(string);
			return result;
		}catch (Exception e){
			System.out.println("Error Loading the Config");
			return null;
		}
	}

}