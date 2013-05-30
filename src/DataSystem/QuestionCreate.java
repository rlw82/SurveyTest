package DataSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class QuestionCreate {
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
			Prompt tempPrompt = promptPrompt();
			if(tempPrompt == null)
				return null;
			Question tempQuest;
			ArrayList<Choice> tempChoice;
			ArrayList<Choice> tempChoice2;
			switch (choice)
			{
			case 1:
				tempChoice = new ArrayList<Choice>();
				tempChoice.add(new Choice("True"));
				tempChoice.add(new Choice("False"));
				tempQuest = new TrueFalse(tempPrompt, tempChoice);
				return tempQuest;
			case 2:
				tempChoice = multipleChoicePrompt();
				if(tempChoice == null)
				{
					System.out.println("Question Canceled");
					return null;
				}
				tempQuest = new MultipleChoice(tempPrompt, tempChoice);
				System.out.println("");
				return tempQuest;
			case 3:
				tempQuest = new ShortAnswer(tempPrompt);
				return tempQuest;
			case 4:
				tempQuest = new Essay(tempPrompt);
				return tempQuest;
			case 5:
				tempChoice = rankingPrompt();
				tempChoice2 = new ArrayList<Choice>();
				if(tempChoice == null)
				{
					System.out.println("Question Canceled");
					return null;
				}
				for(int i = 0; i < tempChoice.size(); i++)
				{
					tempChoice2.add(new Choice("" + i));
				}
				tempQuest = new Ranking(tempPrompt,tempChoice, tempChoice2);
				return tempQuest;
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
	
	
	
	private ArrayList<ArrayList<Choice>> matchingPrompt() {
		// TODO Auto-generated method stub
		return null;
	}



	private ArrayList<Choice> rankingPrompt() {
		// TODO Auto-generated method stub
		return null;
	}



	private ArrayList<Choice> multipleChoicePrompt() {
		// TODO Auto-generated method stub
		return null;
	}

	private Prompt promptPrompt() throws IOException
	{
		System.out.println("Enter a prompt('Q' to cancel)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String temp = br.readLine();
		if (temp.toLowerCase().equals("q"))
			return null;
		else
			return new Prompt(temp);
	}
}
