package DataSystem;

import java.util.ArrayList;
import java.util.HashMap;

public class ResponseComparison implements java.io.Serializable
{
	protected HashMap<Prompt, ArrayList<String>> answer;
	private static final long serialVersionUID = 7389044652354777516L;

	public boolean compare(ResponseComparison responce1, ResponseComparison responce2)
	{
		return false;
	}

	public void setAnswers(HashMap<Prompt, ArrayList<String>> value)
	{
		this.answer = value;
	}

	public HashMap<Prompt, ArrayList<String>> getAnswers()
	{
		return this.answer;
	}

}
