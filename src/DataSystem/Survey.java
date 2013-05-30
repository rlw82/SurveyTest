package DataSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Survey implements java.io.Serializable
{
	private static final long serialVersionUID = -7199734700246684141L;
	protected String title;
	protected InputOutput io;
	protected ArrayList<Question> questions;

	public Survey()
	{
		//Just a default constructor is needed
		questions = new ArrayList<Question>();
	}

	public void display()
	{
		for (int i = 0; i < questions.size(); i++)
			questions.get(i).display(this.io);
	}

	public ArrayList<Response> take()
	{
		throw new UnsupportedOperationException("not implemented");
	}

	public InputOutput getIO()
	{
		return this.io;
	}
	
	public void setIO(InputOutput io_)
	{
		this.io = io_;
	}
	
	public void create() throws IOException
	{
		//Prompt user for choice
		System.out.println("\nEnter a choice");
		System.out
				.println("1) Add a New Question\n2) Display Current Questions\n3) Quit");
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
			System.out.println("Invalid entry enter a single digit 1-3\n\n\n\n\n");
			this.create();
			return;
		}
		//Not valid choices for this menu, let the user know and prompt again
		if (choice > 3 || choice < 1)
		{
			System.out.println("Invalid entry enter a single digit 1-3\n\n\n\n\n");
			this.create();
			return;
		}
		else
		{
			switch (choice)
			{
			case 1:
				try{
					if (questions.size() == 0)
					{
						System.out.println("Creating new survey, enter title");
						br = new BufferedReader(new InputStreamReader(System.in));
						this.title = br.readLine();
						Question tempQuestion = new QuestionCreate().createQuestion();
						if(tempQuestion.getPrompt() == null)
						{
							System.out.println("Cancelling survey, returning to main menu\n\n\n\n\n");
							return;
						}
						else
						{
							this.questions.add(tempQuestion);
							this.create();
							return;
						}
					}
					else
					{
						Question tempQuestion = new QuestionCreate().createQuestion();
						if(tempQuestion.getPrompt() == null)
						{
							System.out.println("Cancelling current question\n\n\n\n\n");
							return;
						}
						else
						{
							this.questions.add(tempQuestion);
							this.create();
							return;
						}
					}
				} catch(Exception e) {
					System.out.println(e.toString());
					br = new BufferedReader(new InputStreamReader(System.in));
					this.title = br.readLine();
					Question tempQuestion = new QuestionCreate().createQuestion();
					if (tempQuestion == null)
					{
						System.out.println("Cancelling survey, returning to main menu\n\n\n\n\n");
						return;
					}
					else
					{
						this.questions.add(tempQuestion);
						this.create();
						return;
					}
				}
			case 2:
			try{
				if (questions.size() == 0)
				{
					System.out.println("No questions to display yet!\n\n\n\n\n");
					this.create();
					return;
				}
			} catch(Exception e) {
				System.out.println("No questions to display yet!\n\n\n\n\n");
				this.create();
				return;
			}
			}
			return;
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
