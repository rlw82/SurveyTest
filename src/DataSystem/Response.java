package DataSystem;

import java.util.ArrayList;

public class Response extends ResponseComparison
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2549913857878546785L;

	public Response(Prompt key_, ArrayList<String> values_)
	{
		this.key = key_;
		this.values = values_;
	}

	public Response()
	{

	}

}
