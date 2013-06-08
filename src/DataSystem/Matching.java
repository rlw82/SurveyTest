package DataSystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
			int temp = getChoice(used, i);
			used.set(temp,true);
			responses.add(""+ i + "," +temp);	
		}
		return new Response(this.prompt, responses);
	}

	private int getChoice(ArrayList<Boolean> choice, int i)
	{
		System.out.print("Choose the match to ");
		this.left.get(i).display(new ConsoleIO());
		System.out.println();
		for(int j = 0; j < this.right.size(); j++)
		{
			System.out.println(""+(j+1)+") ");
			this.right.get(j).display(new ConsoleIO());
			if(choice.get(j))
				System.out.println("X");
			else
				System.out.println();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String temp = br.readLine();
			int check = Integer.parseInt(temp);
			if(check < 0 || check > this.right.size())
			{
				System.out.println("Invalid Choice, try again");
				return getChoice(choice, i);
			}
			else
			{
				if(!choice.get(check-1))
				{
					System.out.println("Already Chosen select again");
				}
				else
				{
					return (check - 1);
				}
			}
				
		} catch (Exception e) {
			System.out.println("Invalid Choice, try again");
			return getChoice(choice, i);
		}
		//Should never get here
		return -1;
	}
	
	public void modify()
	{
		
	}
	
	public Matching(Prompt prompt_, ArrayList<Choice> left_,ArrayList<Choice> right_)
	{
		super(prompt_);
		this.left = left_;
		this.right = right_;
	}

	//Display the question title then display the choices tab separated
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
