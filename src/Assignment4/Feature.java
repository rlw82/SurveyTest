package Assignment4;

import edu.drexel.cs350.graphics.Renderer;

public abstract class Feature
{
	protected Renderer gfx;

	public void drawLine(int x1, int y1, int x2, int y2)
	{
		gfx.drawLine(x1, y1, x2, y2);
	}
	
	public void drawPoint(int x, int y)
	{
		gfx.drawPoint(x, y);
	}
	
	public void drawCircle(int x, int y, int radius)
	{
		gfx.drawCircle(x, y, radius);
	}
	
	public void drawText(int x, int y, String text, int size)
	{
		gfx.drawText(x, y, text, size);
	}
	
	public abstract void translate(int dx, int dy);
	public abstract void render();
}
