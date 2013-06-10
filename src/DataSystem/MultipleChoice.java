//Russell Wiley
//CS 350
//Professor Salvage
package DataSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MultipleChoice extends Question
{
	private static final long serialVersionUID = 7005563851486654225L;

	//Get a response
	public Response take() throws IOException
	{
		this.display(new ConsoleIO());
		System.out.println("Enter a choice");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		try
		{
			ArrayList<String> tempArr = new ArrayList<String>();
			int tempint = Integer.parseInt(temp);
			//Make sure the response is possible
			if (tempint < 1 || tempint > this.choices.size())
			{
				System.out.println("Invalid selection try again");
				return this.take();
			}
			else
			{
				tempArr.add("" + (tempint - 1));
				return new Response(this.prompt, tempArr);
			}
		} catch (Exception e)
		{
			System.out.println("\nInvalid selection");
		}
		return null;
	}

	protected ArrayList<Choice> choices;

	public void setChoices(ArrayList<Choice> value)
	{
		this.choices = value;
	}

	public ArrayList<Choice> getChoices()
	{
		return this.choices;
	}

	public String getType()
	{
		return "MultipleChoice";
	}

	public MultipleChoice(Prompt prompt_, ArrayList<Choice> choice_)
	{
		super(prompt_);
		this.choices = choice_;
	}
	
	private ArrayList<Choice> modifyChoiceSet(ArrayList<Choice> choices)
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
	
	//Display the response passed in
	public void displayAnswer(InputOutput io, Response response)
	{
		String temp = response.getValues().get(0);
		int choice = Integer.parseInt(temp);
		choices.get(choice).display(io);
		io.display("\n");
	}

	//Display the question
	public void display(InputOutput io)
	{
		super.display(io);
		for (int i = 0; i < choices.size(); i++)
		{
			io.display("" + (i + 1) + ") ");
			choices.get(i).display(io);
			io.display("\n");
		}
	}

	public boolean modify()
	{
		System.out.println("Make a Choice\n1) Edit Prompt\n2) Edit Choices\n3) Cancel");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			String temp = br.readLine();
			int choice = Integer.parseInt(temp);
			if(choice < 1 || choice > 3)
			{
				System.out.println("Invalid choice\n");
				return modify();
			}
			switch(choice){
			case 1:
				return super.modify();
			case 2:
				this.choices = modifyChoiceSet(this.choices);
				return true;
			case 3:
				return false;
			}
		} catch (Exception e) {
			System.out.println("Invalid choice\n");
			return modify();
		}
		return false;
	}
}
