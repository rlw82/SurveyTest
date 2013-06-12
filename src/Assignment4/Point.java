package Assignment4;

import edu.drexel.cs350.graphics.Renderer;

public class Point extends Feature
{
	private int x,y;
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}

	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public Point(final Renderer rend, int x, int y)
	{
		this.gfx = rend;
		this.x = x;
		this.y = y;
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
		drawPoint(this.x,this.y);
	}
}
