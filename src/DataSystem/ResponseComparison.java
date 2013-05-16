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

	private HashMap<Object, ArrayList<Object>> answers;

	public void setAnswers(HashMap<Object, ArrayList<Object>> value)
	{
		this.answers = value;
	}

	public HashMap<Object, ArrayList<Object>> getAnswers()
	{
		return this.answers;
	}

}
