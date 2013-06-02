package DataSystem;

import java.util.ArrayList;

public class Matching extends Question
{
	private static final long serialVersionUID = -2192435490657815108L;
	protected ArrayList<Choice> left;
	protected ArrayList<Choice> right;

	public Response take()
	{
		this.prompt.display(new ConsoleIO());
		ArrayList<Boolean> used = new ArrayList<Boolean>();
		for(int i = 0; i < left.size(); i++)
		{
			used.set(i, false);
		}
		ArrayList<String> responses = new ArrayList<String>();
		for(int i = 0; i < left.size(); i++)
		{
			
		}
	}

	public void modify()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}
	
	public Matching(Prompt prompt_, ArrayList<Choice> left_,ArrayList<Choice> right_)
	{
		super(prompt_);
		this.left = left_;
		this.right = right_;
	}

	public void display(InputOutput io)
	{
		super.display(io);
		for(int i = 0; i < left.size(); i++)
		{
			io.display(""+(i+1)+") ");
			left.get(i).display(io);
			io.display("\t"+(i+1)+") ");
			right.get(i).display(io);
			io.display("\n");
		}
	}

}
