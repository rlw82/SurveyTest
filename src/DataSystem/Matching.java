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
		for (int i = 0; i < left.size(); i++)
		{
			used.add(false);
		}
		ArrayList<String> responses = new ArrayList<String>();
		for (int i = 0; i < left.size(); i++)
		{
			int temp = getChoice(used, i);
			used.set(temp, true);
			responses.add("" + i + "," + temp);
		}
		return new Response(this.prompt, responses);
	}

	//Get a specific choice for each matching choice
	private int getChoice(ArrayList<Boolean> choice, int i)
	{
		System.out.print("Choose the match to ");
		this.left.get(i).display(new ConsoleIO());
		System.out.println();
		for (int j = 0; j < this.right.size(); j++)
		{
			System.out.print("" + (j + 1) + ") ");
			this.right.get(j).display(new ConsoleIO());
			//Mark if it has been selected already
			if (choice.get(j))
				System.out.println(" X");
			else
				System.out.println();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Get valid input
		try
		{
			String temp = br.readLine();
			int check = Integer.parseInt(temp);
			if (check < 0 || check > this.right.size())
			{
				System.out.println("Invalid Choice, try again");
				return getChoice(choice, i);
			}
			else
			{
				if (choice.get(check - 1))
				{
					System.out.println("Already Chosen select again");
					return getChoice(choice, i);
				}
				else
				{
					return (check - 1);
				}
			}

		} catch (Exception e)
		{
			System.out.println("Invalid Choice, try again");
			return getChoice(choice, i);
		}
	}

	//Display a response to multiple choice
	public void displayAnswer(InputOutput io, Response response)
	{
		for (int i = 0; i < response.getValues().size(); i++)
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

	public boolean modify()
	{
		System.out.println("Make a Choice\n1) Edit Prompt\n2) Edit Left Choices\n3) Edit Right Choices\n4) Cancel");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			String temp = br.readLine();
			int choice = Integer.parseInt(temp);
			if(choice < 1 || choice > 4)
			{
				System.out.println("Invalid choice\n");
				return modify();
			}
			switch(choice){
			case 1:
				return super.modify();
			case 2:
				this.left = modifyChoiceSet(this.left);
				return true;
			case 3:
				this.right = modifyChoiceSet(this.right);
				return true;
			case 4:
				return false;
			}
		} catch (Exception e) {
			System.out.println("Invalid choice\n");
			return modify();
		}
		return false;
	}

	protected ArrayList<Choice> modifyChoiceSet(ArrayList<Choice> choices)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Choose a Choice");
		for(int i = 0; i < choices.size(); i++)
		{
			System.out.println(""+(i+1)+") ");
			choices.get(i).display(new ConsoleIO());
			System.out.println();
		}
		try{		
			String temp = br.readLine();
			int choice = Integer.parseInt(temp);
			if(choice < 1 || choice > choices.size())
			{
				Integer.parseInt("Throw");
			}
			System.out.println("Enter the new  value");
			choices.set(choice-1, new Choice(br.readLine()));
			return choices;
		} catch (Exception e) {
			System.out.println("Invalid Selection");
			return modifyChoiceSet(choices);
		}
	}
	public Matching(Prompt prompt_, ArrayList<Choice> left_,
			ArrayList<Choice> right_)
	{
		super(prompt_);
		this.left = left_;
		this.right = right_;
	}

	//Display the question title then display the choices tab separated
	public void display(InputOutput io)
	{
		super.display(io);
		for (int i = 0; i < left.size(); i++)
		{
			io.display("" + (i + 1) + ") ");
			left.get(i).display(io);
			io.display("\t" + (i + 1) + ") ");
			right.get(i).display(io);
			io.display("\n");
		}
	}

}
