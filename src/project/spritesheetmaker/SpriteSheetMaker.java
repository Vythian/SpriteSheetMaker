package project.spritesheetmaker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import project.spritesheetmaker.sprite.SheetData;
import project.spritesheetmaker.sprite.SpriteSheet;
import project.spritesheetmaker.utility.LoggingUtils;

public class SpriteSheetMaker {
	
	private boolean debugMode = false;
	private boolean headless = false;
	
	private HashMap<String, String> argMap;
	private File settingsFile;
	
	public SpriteSheetMaker()
	{
		
	}
	
	public void preInitialization(HashMap<String, String> arguements)
	{
		// Moves the loaded arguments from main to sprite sheet maker
		argMap = arguements;
		
		// Loads filter color argument if it exists.
		if(argMap.containsKey("--settings"))
		{
			String arg = argMap.get("--settings");
			settingsFile = new File(arg);
			if(!settingsFile.exists())
			{
				LoggingUtils.outputError(String.format("Could not find settings file at path '%s'", arg), true);
			}
		}
		
		Initialization();
	}
	
	public void Initialization()
	{
		
		if(!headless)
		{
			// Launch GUI
		} else
		{
			Gson gson = new Gson();
			JsonReader reader;
			try {
				reader = new JsonReader(new FileReader(settingsFile));
				SheetData sheetData = gson.fromJson(reader, SheetData.class);
				SpriteSheet spriteSheet = new SpriteSheet(sheetData);
				spriteSheet.make();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		postInitialization();
	}
	
	public void postInitialization()
	{
		
	}
	
	public boolean isDebugMode()
	{
		return debugMode;
	}
	
	public boolean isHeadless()
	{
		return headless;
	}
	
	public void setDebugMode(boolean value)
	{
		debugMode = value;
	}
	
	public void setHeadless(boolean value)
	{
		headless = value;
	}

}
