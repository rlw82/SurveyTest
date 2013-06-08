package DataSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Survey implements java.io.Serializable
{
	private static final long serialVersionUID = -7199734700246684141L;
	protected String title;
	protected InputOutput io;
	protected ArrayList<Question> questions;
	protected ArrayList<ArrayList<Response>> responses;

	public Survey()
	{
		title = null;
		io = new ConsoleIO();
		questions = new ArrayList<Question>();
		responses = new ArrayList<ArrayList<Response>>();
	}

	public void display()
	{
		this.io.display(this.title + "\n\nQuestions\n\n");
		for (int i = 0; i < questions.size(); i++)
		{
			this.io.display("" + (i+1) + ")");
			questions.get(i).display(this.io);
			this.io.display("\n");
		}
	}

	public void take() throws IOException
	{
		responses.add(new ArrayList<Response>());
		for(int i = 0; i < questions.size(); i++)
		{
			responses.get(responses.size()-1).add(questions.get(i).take());
		}
		System.out.println("Your response is number " + responses.size());
	}

	public void create() throws IOException
	{
		//Prompt user for choice
		System.out.println("\nEnter a choice");
		System.out
				.println("1) Add a New Question\n2) Display Current Questions\n3) Stop Adding Questions");
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
			System.out.println("Invalid entry enter a single digit 1-3\n\n\n");
			this.create();
			return;
		}
		//Not valid choices for this menu, let the user know and prompt again
		if (choice > 3 || choice < 1)
		{
			System.out.println("Invalid entry enter a single digit 1-3\n\n\n");
			this.create();
			return;
		}
		else
		{
			switch (choice)
			{
			case 1:
				try
				{
					if (questions.size() == 0)
					{
						System.out.println("Creating new survey, enter title");
						br = new BufferedReader(new InputStreamReader(System.in));
						this.title = br.readLine();
						Question tempQuestion = new QuestionCreate().createQuestion();
						if (tempQuestion.getPrompt() == null)
						{
							System.out.println("Cancelling survey, returning to main menu\n\n\n");
							this.title = null;
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
						if (tempQuestion.getPrompt() == null)
						{
							return;
						}
						else
						{
							this.questions.add(tempQuestion);
							this.create();
							return;
						}
					}
				}
				catch (Exception e)
				{
						System.out.println("Cancelling survey, returning to main menu\n\n\n");
						this.title = null;
						return;
				}
			case 2:
				try
				{
					if (questions.size() == 0)
					{
						System.out.println("No questions to display yet!\n\n\n");
						this.create();
						return;
					}
					else
						this.display();
				}
				catch (Exception e)
				{
					System.out.println("No questions to display yet!\n\n\n");
					this.create();
					return;
				}
			case 3:
				return;
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

	//Output to a file
	public void serialize() throws Exception
	{
		File verifyFolder = new File("surveys\\");
		if(!verifyFolder.exists())
			verifyFolder.mkdirs();
		
		File createFile = new File("surveys\\" + this.title + ".dat");
		
		if(!createFile.exists())
			createFile.createNewFile();
		
		FileOutputStream fileOut = new FileOutputStream(createFile);
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(this);
    
    FileWriter fw = new FileWriter("surveys.txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    
    bw.write(this.title + ".dat\n");
    System.out.println("File saved at surveys\\" + this.title + ".dat");
    
    //Close all the streams
    bw.close();
    fw.close();
    out.close();
    fileOut.close();
	}

	public ArrayList<HashMap<Response, Integer>> tabulate()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	//Getters
	
	public ArrayList<ArrayList<Response>> getResponces()
	{
		return this.responses;
	}

	public String getTitle()
	{
		return this.title;
	}


	public ArrayList<Question> getQuestions()
	{
		return this.questions;
	}

	public InputOutput getIO()
	{
		return this.io;
	}

	public void setIO(InputOutput io_)
	{
		this.io = io_;
	}
	
	//Setters
	

	public void setQuestions(ArrayList<Question> value)
	{
		this.questions = value;
	}
	
	public void setResponces(ArrayList<ArrayList<Response>> value)
	{
		this.responses = value;
	}
}
