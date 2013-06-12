package Assignment4;

import java.util.ArrayList;
import java.util.Arrays;
import edu.drexel.cs350.graphics.Renderer;

public class Polygon extends Feature
{
	private ArrayList<Point> points;
	
	public Polygon(Renderer rend, final Assignment4.Point ...pts)
	{
		this.gfx = rend;
		this.points = new ArrayList<Point>(Arrays.asList(pts));
	}
	
	public int size()
	{
		return points.size();
	}
	
	public Point get(int i)
	{
		return this.points.get(i);
	}
	
	public void set(int i, Point p)
	{
		this.points.set(i, p);
	}
	
	public void add(int x, int y)
	{
		this.points.add(new Point(this.gfx, x, y));
	}
	
	public void add(Point p)
	{
		this.points.add(p);
	}
	
	public void add(int i, int x, int y)
	{
		this.points.add(i,new Point(this.gfx, x, y));
	}
	
	public void add(int i, Point p)
	{
		this.points.add(i,p);
	}
	
	public void remove(int i)
	{
		this.points.remove(i);
	}
	
	public void remove(Point p)
	{
		this.points.remove(p);
	}
	
	@Override
	public void translate(int dx, int dy)
	{
		for(int i = 0; i < this.points.size(); i++)
			points.get(i).translate(dx, dy);
	}

	@Override
	public void render()
	{
		for(int i = 1; i < points.size(); i++)
		{
			if(i == points.size()-1)
				drawLine(points.get(i).getX(),points.get(i).getY(),points.get(0).getX(),points.get(0).getY());
			else
				drawLine(points.get(i-1).getX(),points.get(i-1).getX(),points.get(i).getX(),points.get(i).getX());
		}
	}

}
