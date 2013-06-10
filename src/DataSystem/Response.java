//Russell Wiley
//CS 350
//Professor Salvage
package DataSystem;

import java.util.ArrayList;

//Response class contains the data for how the user answers questions
public class Response implements java.io.Serializable
{
	private static final long serialVersionUID = 2549913857878546785L;
	private Prompt key;
	private ArrayList<String> values;

	public Response(Prompt key_, ArrayList<String> values_)
	{
		this.setKey(key_);
		this.values = values_;
	}

	public Response()
	{

	}

	public ArrayList<String> getValues()
	{
		return this.values;
	}

	public int hashCode()
	{
		return 0;
	}
	
	public boolean equals(Object obj)
	{
		if(this.key.equals(((Response) obj).getKey()))
		{
			for(int i = 0; i < this.values.size(); i++)
			{
				if(!((Response) obj).getValues().get(i).toLowerCase().equals(this.values.get(i).toLowerCase()))
				{
					return false;
				}
			}
			return true;
		}
		return false;
	}
	public Prompt getKey()
	{
		return key;
	}

	public void setKey(Prompt key)
	{
		this.key = key;
	}

}
