package DataSystem;

import java.util.ArrayList;
import java.util.HashMap;

public class Survey implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7199734700246684141L;
	
	public void Create()
	{
		throw new UnsupportedOperationException("not implemented");
	}
	
	public void modifyQuestions()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public String seralize(String filename)
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public ArrayList<HashMap<Response, Integer>> tabulate()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	private Question questions;

	public void setQuestions(Question value)
	{
		this.questions = value;
	}

	public Question getQuestions()
	{
		return this.questions;
	}

	private Response responses;

	public void setResponces(Response value)
	{
		this.responses = value;
	}

	public Response getResponces()
	{
		return this.responses;
	}

	public Survey()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public Survey(String title)
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

}
