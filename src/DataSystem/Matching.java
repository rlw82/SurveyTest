//Russell Wiley
//CS 350
//Professor Salvage
package DataSystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Matching extends Question
{
	private static final long serialVersionUID = -2192435490657815108L;
	protected ArrayList<Choice> left;
	protected ArrayList<Choice> right;

	//Get a response
	public Response take()
	{
		this.prompt.display(new ConsoleIO());
		ArrayList<Boolean> used = new ArrayList<Boolean>();
		for(int i = 0; i < left.size(); i++)
		{
			used.add(false);
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

	//Get a specific choice for each matching choice
	private int getChoice(ArrayList<Boolean> choice, int i)
	{
		System.out.print("Choose the match to ");
		this.left.get(i).display(new ConsoleIO());
		System.out.println();
		for(int j = 0; j < this.right.size(); j++)
		{
			System.out.print(""+(j+1)+") ");
			this.right.get(j).display(new ConsoleIO());
			//Mark if it has been selected already
			if(choice.get(j))
				System.out.println(" X");
			else
				System.out.println();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Get valid input
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
				if(choice.get(check-1))
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
	
	//Display a response to multiple choice
	public void displayAnswer(InputOutput io, Response response)
	{
		for(int i = 0; i < response.getValues().size(); i++)
		{
			String[] pair = response.getValues().get(i).split(",");
			int one = Integer.parseInt(pair[0]);
			int two = Integer.parseInt(pair[1]);
			left.get(one).display(io);
			io.display(" is matched to ");
			right.get(two).display(io);
			io.display("\n");
		}
	}
	
	public String getType()
	{
		return "Matching";
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
