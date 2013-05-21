package DataSystem;

import java.util.ArrayList;
import java.util.HashMap;

public class ResponseComparison implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7389044652354777516L;

	public boolean compare(ResponseComparison responce1,
			ResponseComparison responce2)
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	private HashMap<Prompt, ArrayList<Response>> answers;

	public void setAnswers(HashMap<Prompt, ArrayList<Response>> value)
	{
		this.answers = value;
	}

	public HashMap<Prompt, ArrayList<Response>> getAnswers()
	{
		return this.answers;
	}

}
