package project.spritesheetmaker.sprite;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
	
	public boolean make(File file)
	{
		for(int y = 0; y < bufferedImage.getHeight(); y++)
		{
			for(int x = 0; x < bufferedImage.getWidth(); x++)
			{
				bufferedImage.setRGB(x, y, Color.TRANSLUCENT);
			}
		}
		
		BufferedImage tempImage = null;
		
		try {
			 tempImage = ImageIO.read(new File("C:/Users/vythi/Desktop/temp.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Graphics2D g2 = bufferedImage.createGraphics();
		for(int row = 0; row < rowcount; row++)
		{
			for(int col = 0; col < sheetData.spritesPerRow+1; col++)
			{
				g2.drawImage(tempImage, row*sheetData.spriteWidth, col*sheetData.spriteHeight, null);
			}
		}
		g2.dispose();
		
		try {
			ImageIO.write(bufferedImage, "png", file);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		LoggingUtils.outputInfo("Finished making image");
		return true;
	}

}
