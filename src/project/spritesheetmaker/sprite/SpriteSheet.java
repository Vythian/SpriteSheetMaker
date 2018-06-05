package project.spritesheetmaker.sprite;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import project.spritesheetmaker.utility.LoggingUtils;

public class SpriteSheet {
	
	private BufferedImage bufferedImage;
	
	private int rowcount;
	private SheetData sheetData;
	
	public SpriteSheet(SheetData data)
	{
		this.sheetData = data;
		this.rowcount = Math.round(sheetData.spriteCount/sheetData.spritesPerRow);
		
		int imageWidth = sheetData.spriteWidth * sheetData.spritesPerRow;
		int imageHeight = rowcount * sheetData.spriteHeight;
		bufferedImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
	}
	
	public boolean make()
	{
		for(int y = 0; y < bufferedImage.getHeight(); y++)
		{
			for(int x = 0; x < bufferedImage.getWidth(); x++)
			{
				bufferedImage.setRGB(x, y, Color.TRANSLUCENT);
			}
		}
		
		ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
		
		File spritesDir = new File(sheetData.spritesPath);
		
		if(!spritesDir.isDirectory())
		{
			LoggingUtils.outputError(String.format("The file at path '%s' is not a directory or it doesn't exist", sheetData.spritesPath), true);
			return false;
		}
		
		for(File spriteFile : spritesDir.listFiles())
		{
			try 
			{
				BufferedImage image = ImageIO.read(spriteFile);
				if(image != null)
				{
					images.add(ImageIO.read(spriteFile));
				}
			} catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
		
		Graphics2D g2 = bufferedImage.createGraphics();
		int imageCount = 0;
		
		for(int row = 0; row < rowcount; row++)
		{
			for(int col = 0; col < sheetData.spritesPerRow; col++)
			{
				g2.drawImage(images.get(imageCount), col*sheetData.spriteWidth, row*sheetData.spriteHeight, null);
				imageCount++;
			}
		}
		g2.dispose();
		
		try {
			ImageIO.write(bufferedImage, "png", new File(sheetData.exportPath + sheetData.exportName));
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		LoggingUtils.outputInfo("Finished making image");
		return true;
	}

}
