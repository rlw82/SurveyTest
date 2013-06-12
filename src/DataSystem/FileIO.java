package DataSystem;

import java.io.IOException;

import edu.drexel.cs350.graphics.ImageFileRenderer;
import edu.drexel.cs350.graphics.PostScriptRenderer;

public class FileIO extends InputOutput
{
	private static final long serialVersionUID = -8729453886159567663L;

	private String totalString;
	
	public FileIO()
	{
		this.totalString = "";
	}
	public void display(String stream)
	{
		totalString+=stream;
	}

	public void outputToPNG(String file) throws IOException
	{
		String[] lines = totalString.split("\n");
		int maxWidth = lines[0].length();
		int line = lines.length;
		for(int i = 1; i < lines.length; i++)
		{
			if(lines[i].length() > maxWidth)
			{
				maxWidth = lines[i].length();
			}
		}
		ImageFileRenderer ifr = new ImageFileRenderer("png", file);
		ifr.initialize(maxWidth*12, line*15);
		for(int i = 0; i < lines.length; i++)
		{
			ifr.drawText(0, i*15, lines[i], 12);
		}
		ifr.render();
		System.out.println("File outputted to " + file);
	}
	
	public void outputToPS(String file) throws IOException
	{
		String[] lines = totalString.split("\n");
		int maxWidth = lines[0].length();
		int line = lines.length;
		for(int i = 1; i < lines.length; i++)
		{
			if(lines[i].length() > maxWidth)
			{
				maxWidth = lines[i].length();
			}
		}
		PostScriptRenderer ifr = new PostScriptRenderer(file);
		ifr.initialize(maxWidth*12, line);
		ifr.drawText(0, 0, totalString, 12);
		ifr.render();
		System.out.println("File outputted to " + file);
	}
	
	public String getTotalString()
	{
		return totalString;
	}

	public void setTotalString(String totalString)
	{
		this.totalString = totalString;
	}
}
