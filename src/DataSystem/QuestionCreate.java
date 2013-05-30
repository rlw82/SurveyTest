package DataSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class QuestionCreate {
	//Does all the implementation for creating different Questions
	public Question createQuestion() throws IOException
	{
		System.out.println("Choose an option\n1) T/F question\n2) multiple choice question\n3) "
				+ "short answer question\n4) essay question\n5) ranking question\n6) matching question\n7) return to previous menu");
		String temp = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		temp = br.readLine();
		int choice = -1;
		try
		{
			//Will go into exception if input is not an integer
			choice = Integer.parseInt(temp);
		}
		catch (Exception e)
		{
			//Catch invalid input, non digit
			System.out.println("Invalid entry enter a single digit 1-7\n\n\n\n\n");
			return createQuestion();
		}
		//Not valid choices for this menu, let the user know and prompt again
		if (choice > 7 || choice < 1)
		{
			System.out.println("Invalid entry enter a single digit 1-7\n\n\n\n\n");
			return createQuestion();
		}
		else
		{
			if(choice == 7)
				return null;
			//Every question needs a prompt so prompt the user
			Prompt tempPrompt = promptPrompt();
			if(tempPrompt == null)
				return null;
			Question tempQuest;
			ArrayList<Choice> tempChoice;
			ArrayList<Choice> tempChoice2;
			//Always check the returned values if they're null
			//null means to cancel the question and go back to the creation menu
			switch (choice)
			{
			//TrueFalse obviously always have the same choices
			case 1:
				tempChoice = new ArrayList<Choice>();
				tempChoice.add(new Choice("True"));
				tempChoice.add(new Choice("False"));
				tempQuest = new TrueFalse(tempPrompt, tempChoice);
				return tempQuest;
			//Get the choices desired for multiple choice
			case 2:
				tempChoice = singleChoicePrompt();
				if(tempChoice == null)
				{
					System.out.println("Question Canceled");
					return null;
				}
				tempQuest = new MultipleChoice(tempPrompt, tempChoice);
				System.out.println("");
				return tempQuest;
			//ShortAnswer only needs to have the prompt initialized
			case 3:
				tempQuest = new ShortAnswer(tempPrompt);
				return tempQuest;
			//Essay only needs to have the prompt initialized
			case 4:
				tempQuest = new Essay(tempPrompt);
				return tempQuest;
			//Get the entries you want to rank
			case 5:
				tempChoice = singleChoicePrompt();
				tempChoice2 = new ArrayList<Choice>();
				//Quit out of the user desires
				if(tempChoice == null)
				{
					System.out.println("Question Canceled");
					return null;
				}
				//A ranking is just a matching with numbers instead of other values
				//So create the second matching set to be 1-size
				for(int i = 0; i < tempChoice.size(); i++)
				{
					tempChoice2.add(new Choice("" + (i+1)));
				}
				tempQuest = new Ranking(tempPrompt,tempChoice, tempChoice2);
				return tempQuest;
			//Get both sets to match
			case 6:
				ArrayList<ArrayList<Choice>> tempData = matchingPrompt();
				if(tempData == null)
				{
					System.out.println("Question Canceled");
					return null;					
				}
				tempChoice = tempData.get(0);
				tempChoice2 = tempData.get(1);
				tempQuest = new Matching(tempPrompt, tempChoice, tempChoice2);
				return tempQuest;
			default:
				return null;
			}
		}
	}

	//Get the number of choices for a Multiple Choice, Ranking, or Matching
	private int getNumberOfChoices() throws IOException
	{
		System.out.println("Enter the number of choices(\"Q\" to quit)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		//Make sure the user gave us an int
		try
		{
			int i = Integer.parseInt(temp);
			//If the int is not above 0, there are no choices so prompt them again
			if(i <= 0)
			{
				System.out.println("Number must be larger than 0, try again\n\n\n");
				return getNumberOfChoices();
			}
			return i;
		} catch (Exception e) {
			//Only case where a non int is a valid choice
			if(temp.toLowerCase().equals("q"))
			{
				return -1;
			}
			System.out.println("Invalid choice, try again\n\n\n");
			return getNumberOfChoices();
		}
	}
	
	//Prompt the user for a number of choices then prompts until that many choices are created
	//Can only quit out during getting the number of choices
	//Matching requires two sets of choices
	private ArrayList<ArrayList<Choice>> matchingPrompt() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numChoices = getNumberOfChoices();
		//Signal that the user quit out
		if(numChoices == -1)
		{
			return null;
		}
		
		ArrayList<ArrayList<Choice>> choices = new ArrayList<ArrayList<Choice>>();
		choices.add(new ArrayList<Choice>());
		choices.add(new ArrayList<Choice>());
		//Go through and get all the choices
		//No invalid inputs since its open to the user what they want
		for(int i = 0; i < numChoices; i++)
		{
			System.out.println("Enter a Choice");
			choices.get(0).add(new Choice(br.readLine()));
		}
		
		//Go through and get all the choices
		//No invalid inputs since its open to the user what they want
		for(int i = 0; i < numChoices; i++)
		{
			System.out.println("Enter a Choice");
			choices.get(1).add(new Choice(br.readLine()));
		}
		
		return choices;
	}
	
	//Prompt the user for a number of choices then prompts until that many choices are created
	//Can only quit out during getting the number of choices
	//Since both a MultipleChoice and a Ranking will only prompt the user for one set of choices
	//This can be used with both
	private ArrayList<Choice> singleChoicePrompt() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numChoices = getNumberOfChoices();
		//Signal that the user quit out
		if(numChoices == -1)
		{
			return null;
		}
		ArrayList<Choice> choices = new ArrayList<Choice>();
		//Go through and get all the choices
		//No invalid inputs since its open to the user what they want
		for(int i = 0; i < numChoices; i++)
		{
			System.out.println("Enter a Choice");
			choices.add(new Choice(br.readLine()));
		}
		return choices;
	}

	//All questions need at least a Prompt, so prompt the user for a Prompt
	private Prompt promptPrompt() throws IOException
	{
		System.out.println("Enter a prompt('Q' to cancel)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String temp = br.readLine();
		//Signal to cancel question
		if (temp.toLowerCase().equals("q"))
			return null;
		else
			return new Prompt(temp);
	}
}
