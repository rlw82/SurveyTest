package Assignment4;

import edu.drexel.cs350.graphics.Renderer;

public class FeatureFactory
{
	private Renderer gfx;
	
	public Renderer getRenderer()
	{
		return this.gfx;
	}
	
	public Geometry createGeometry(int width, int height)
	{
		return new Geometry(width,height);
	}
	
	public Point createPoint(int x, int y)
	{
		return new Point(this.gfx,x,y);
	}
	
	public Circle createCircle(int x, int y, int radius)
	{
		return new Circle(this.gfx,x,y,radius);
	}
	
	public Rectangle createRectangle(int x1, int y1, int x2, int y2)
	{
		return new Rectangle(this.gfx,x1,y1,x2,y2);
	}
	
	public Polygon createPolygon(Point ...pts)
	{
		return new Polygon(this.gfx, pts);
	}
	
	public Text createText(int x, int y, String text)
	{
		return new Text(this.gfx,x,y,text);
	}
	
	public Text createText(int x, int y, String text, int size)
	{
		return new Text(this.gfx,x,y,text,size);
	}
	
	public FeatureFactory(Renderer rend)
	{
		this.gfx = rend;
	}
}
