package project.spritesheetmaker.utility;

public class LoggingUtils {
	
	public static void outputError(String value, boolean debugMode)
	{
		System.out.println("[Error] " + value);
		if(!debugMode)
			outputInfo("Add --debugMode to your arguements for more info.");
	}
	
	public static void outputInfo(String value)
	{
		System.out.println("[Info] " + value);
	}

}
