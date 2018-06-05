package project.spritesheetmaker;

import java.util.HashMap;

import project.spritesheetmaker.utility.LoggingUtils;

public class SpriteSheetMaker {
	
	private boolean debugMode = false;
	private boolean headless = false;
	
	private HashMap<String, String> argMap;
	private int filterColor = 11780472;
	
	public SpriteSheetMaker()
	{
		
	}
	
	public void preInitialization(HashMap<String, String> arguements)
	{
		// Moves the loaded arguments from main to sprite sheet maker
		argMap = arguements;
		
		// Loads filter color argument if it exists.
		if(argMap.containsKey("--filtercolor"))
		{
			String arg = argMap.get("--filtercolor");
			try
			{
				filterColor = Integer.parseInt(arg);
			} catch(Exception exception)
			{
				LoggingUtils.outputError(String.format("'%s' is not a number, for filtercolor arguement.", arg), debugMode);
				if(debugMode)
				{
					exception.printStackTrace();
				}
			}
		}
		
		Initialization();
	}
	
	public void Initialization()
	{
		
		
		
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
