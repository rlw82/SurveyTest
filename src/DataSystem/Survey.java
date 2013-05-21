package DataSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Survey implements java.io.Serializable
{
	private static final long serialVersionUID = -7199734700246684141L;
	protected String title;
	protected ArrayList<Question> questions;

	public Survey()
	{
		//Just a default constructor is needed
	}

	public void display()
	{
		for (int i = 0; i < questions.size(); i++)
			questions.get(i).display();
	}

	public ArrayList<Response> take()
	{
		throw new UnsupportedOperationException("not implemented");
	}

	public void create()
	{
		//Prompt user for choice
		System.out.println("Enter a choice");
		System.out
				.println("1) Add a New Question\n2) Display Current Survey3) Quit");
		String temp = "";
		Scanner scan = new Scanner(System.in);
		temp = scan.next();
		int choice = -1;
		try
		{
			//Will go into exception if input is not an integer
			choice = Integer.parseInt(temp);
		}
		catch (Exception e)
		{
			//Catch invalid input, non digit
			System.out.println("Invalid entry enter a single digit 1-3\n\n\n\n\n");
			create();
			scan.close();
			return;
		}
		//Not valid choices for this menu, let the user know and prompt again
		if (choice > 3 || choice < 1)
		{
			System.out.println("Invalid entry enter a single digit 1-3\n\n\n\n\n");
			create();
			scan.close();
			return;
		}
		else
		{
			switch (choice)
			{
			case 1:
				if (questions.size() == 0)
				{
					System.out.println("Creating new survey, enter title");
					this.title = scan.next();
					Question tempQuestion = questionMenu();
					if (tempQuestion == null)
					{
						System.out
								.println("Cancelling survey, returning to main menu\n\n\n\n\n");
						scan.close();
						return;
					}
					else
						this.questions.add(tempQuestion);
				}
			case 2:
				if (questions.size() == 0)
				{
					System.out.println("No questions to display yet!\n\n\n\n\n");
					scan.close();
					create();
					return;
				}
			}
			scan.close();
			return;
		}
	}

	private Question questionMenu()
	{
		System.out
				.println("Choose an option\n1) T/F question\n2) multiple choice question\n3) "
						+ "short answer question\n4) essay question\n5) ranking question\n6) matching question\n7) return to previous menu");
		String temp = "";
		Scanner scan = new Scanner(System.in);
		temp = scan.next();
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
			scan.close();
			return questionMenu();
		}
		//Not valid choices for this menu, let the user know and prompt again
		if (choice > 7 || choice < 1)
		{
			System.out.println("Invalid entry enter a single digit 1-7\n\n\n\n\n");
			scan.close();
			return questionMenu();
		}
		else
		{
			Question tempQuest;
			scan.close();
			switch (choice)
			{
			case 1:
				tempQuest = new TrueFalse();
				tempQuest.create();
				return tempQuest;
			case 2:
				tempQuest = new MultipleChoice();
				tempQuest.create();
				return tempQuest;
			case 3:
				tempQuest = new ShortAnswer();
				tempQuest.create();
				return tempQuest;
			case 4:
				tempQuest = new Essay();
				tempQuest.create();
				return tempQuest;
			case 5:
				tempQuest = new Ranking();
				tempQuest.create();
				return tempQuest;
			case 6:
				tempQuest = new Matching();
				tempQuest.create();
				return tempQuest;
			default:
				return null;
			}
		}
	}

	public String getClassType()
	{
		return "Survey";
	}

	public void modifyQuestions()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public String seralize(String filename)
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public ArrayList<HashMap<Response, Integer>> tabulate()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public void setQuestions(ArrayList<Question> value)
	{
		this.questions = value;
	}

	public ArrayList<Question> getQuestions()
	{
		return this.questions;
	}

	private ArrayList<Response> responses;

	public void setResponces(ArrayList<Response> value)
	{
		this.responses = value;
	}

	public ArrayList<Response> getResponces()
	{
		return this.responses;
	}

}
