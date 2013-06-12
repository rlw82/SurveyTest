package Assignment4;

import edu.drexel.cs350.graphics.Renderer;

public class Circle extends Feature
{
	private int x,y, radius;
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public int getRadius()
	{
		return this.radius;
	}
	
	public void setRadius(int radius)
	{
		this.radius = radius;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public Circle(final Renderer rend, int x, int y, int radius)
	{
		this.gfx = rend;
		this.x = x;
		this.y = y;
		this.radius = radius;
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
		drawCircle(this.x, this.y, this.radius);
	}

}
