package project.spritesheetmaker.utility;

public class StringUtils {
	
	public static boolean isArguement(String string)
	{		
		if(string.length() > 1)
		{
			char[] chars = string.toCharArray();
			for(int i = 0; i < 2; i++)
			{
				if(chars[i] != '-')
				{
					return false;
				}
			}
		} else
		{
			return false;
		}
		return true;
	}

}
