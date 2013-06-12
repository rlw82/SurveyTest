package Assignment4;

import edu.drexel.cs350.graphics.Renderer;

public class Rectangle extends Feature
{
	private int x1,x2,y1,y2;

	public int getX1()
	{
		return this.x1;
	}
	
	public int getX2()
	{
		return this.x2;
	}
	
	public int getY1()
	{
		return this.y1;
	}
	
	public int getY2()
	{
		return this.y2;
	}
	
	public void setX1(int x1)
	{
		this.x1 = x1;
	}
	
	public void setX2(int x2)
	{
		this.x2 = 2;
	}
	
	public void setY1(int y1)
	{
		this.y1 = y1;
	}
	
	public void setY2(int y2)
	{
		this.y2 = y2;
	}
	
	public Rectangle(final Renderer rend, int x1, int y1, int x2, int y2)
	{
		this.gfx = rend;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	@Override
	public void translate(int dx, int dy)
	{
		this.x1 += dx;
		this.x2 += dx;
		this.y1 += dy;
		this.y2 += dy;
	}

	@Override
	public void render()
	{
		drawLine(x1,y1,x1,y2);
		drawLine(x1,y2,x2,y2);
		drawLine(x2,y2,x2,y1);
		drawLine(x2,y1,x1,y1);
	}
}
