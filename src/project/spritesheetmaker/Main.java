package project.spritesheetmaker;

import java.util.HashMap;

import project.spritesheetmaker.utility.LoggingUtils;
import project.spritesheetmaker.utility.StringUtils;

public class Main {
	
	public static void main(String[] args)
	{
		SpriteSheetMaker spriteSheetMaker = new SpriteSheetMaker();
		HashMap<String, String> argMap = new HashMap<String, String>();
		
		if(args.length > 0)
		{
			for(int i = 0; i < args.length; i++)
			{				
				// Arguments, that have a input value after.
				if(StringUtils.isArguement(args[i]))
				{
					String arguement = args[i].toLowerCase();
					String value = "";
					
					// Checking if value is correct and not missing
					try
					{
						value = args[i+1].toLowerCase();
						
						if(StringUtils.isArguement(value))
						{
							LoggingUtils.outputError("One of your value requiring arguements is missing a value, check your arguements. Program could now fail.", true);
						}
					} catch(Exception exception)
					{
						LoggingUtils.outputError("One of your value requiring arguements is missing a value, check your arguements. Program could now fail.", spriteSheetMaker.isDebugMode());
						if(spriteSheetMaker.isDebugMode())
						{
							exception.printStackTrace();
						}
					}
					
					if(spriteSheetMaker.isDebugMode())
						LoggingUtils.outputInfo(String.format("Loaded arguement and value '%s %s'.", arguement, value));
						
					// Adds argument and skips next argument
					argMap.put(arguement, value);
					i++;
				} else
				{
					// Single argument, that don't need a value after.
					String value = args[i].toLowerCase();
					switch(value)
					{
					
					case "-debugmode":
					{
						spriteSheetMaker.setDebugMode(true);
						break;
					}
					
					case "-headless":
					{
						spriteSheetMaker.setHeadless(true);
						break;
					}
					
					}
				}
			}
		}
		
		spriteSheetMaker.preInitialization(argMap);
	}

}
