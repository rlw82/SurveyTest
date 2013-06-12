package Assignment4;

import java.util.ArrayList;
import java.util.Iterator;

public class Geometry
{
	private ArrayList<Feature> features;
	private int width,height;
	
	public Geometry(int w, int h)
	{
		this.width = w;
		this.height = h;
		this.features = new ArrayList<Feature>();
	}
	
	public Iterator<Feature> iterator()
	{
		return this.features.iterator();
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
	public int count()
	{
		return this.features.size();
	}
	
	public void add(Feature f)
	{
		this.features.add(f);
	}
	
	public void remove(Feature f)
	{
		this.features.remove(f);
	}
	
	public void render()
	{
		for(int i = 0; i < features.size(); i++)
		{
			this.features.get(i).render();
		}
	}
}
