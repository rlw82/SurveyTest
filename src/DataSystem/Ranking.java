package DataSystem;

import java.util.ArrayList;

public class Ranking extends Matching
{
	private static final long serialVersionUID = 7552164284178692603L;

	public Response take()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public void modify()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public void display(InputOutput io)
	{
		this.prompt.display(io);
		for(int i = 0; i < left.size(); i++)
		{
			io.display(""+(i+1)+") ");
			right.get(i).display(io);
			io.display("\n");
		}
	}
	
	public Ranking(Prompt tempPrompt, ArrayList<Choice> ranks,ArrayList<Choice> numbers)
	{
		super(tempPrompt, numbers, ranks);
	}

}
