package Assignment4;

import edu.drexel.cs350.graphics.Renderer;

public class Text extends Feature
{
	private int x,y,size;
	private String text;
	public static final int SIZE=12;
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public String getText()
	{
		return this.text;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public void setSize(int sz)
	{
		this.size = sz;
	}
	
	public void setSize(final String t)
	{
		this.text = t;
	}
	
	public Text(final Renderer rend, int x, int y, final String text, int size)
	{
		this.gfx = rend;
		this.x = x;
		this.y = y;
		this.text = text;
		this.size = size;
	}
	
	public Text(final Renderer rend, int x, int y, String text)
	{
		this.gfx = rend;
		this.x = x;
		this.y = y;
		this.text = text;
	}
	
	@Override
	public void translate(int dx, int dy)
	{
		this.x += dx;
		this.y += dy;
	}

	@Override
	public void render()
	{
		drawText(this.x,this.y,this.text,this.size);
	}
}
