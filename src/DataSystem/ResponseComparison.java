package DataSystem;

import java.util.ArrayList;
import java.util.HashMap;

public class ResponseComparison implements java.io.Serializable
{
	protected HashMap<Prompt, ArrayList<Response>> answer;
	private static final long serialVersionUID = 7389044652354777516L;

	public boolean compare(ResponseComparison responce1,
			ResponseComparison responce2)
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public void setAnswers(HashMap<Prompt, ArrayList<Response>> value)
	{
		this.answer = value;
	}

	public HashMap<Prompt, ArrayList<Response>> getAnswers()
	{
		return this.answer;
	}

}
