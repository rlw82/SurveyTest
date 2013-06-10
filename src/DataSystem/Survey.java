//Russell Wiley
//CS 350
//Professor Salvage
package DataSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
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

	//Initilize variables
	public Survey()
	{
		title = null;
		io = new ConsoleIO();
		questions = new ArrayList<Question>();
		responses = new ArrayList<ArrayList<Response>>();
	}

	public String getType()
	{
		return "Survey";
	}
	
	//No correct answers to display
	public void display()
	{
		this.io.display(this.title + "\n\nQuestions\n\n");
		for (int i = 0; i < questions.size(); i++)
		{
			this.io.display("" + (i + 1) + ")");
			questions.get(i).display(this.io);
			this.io.display("\n");
		}
	}

	//Add to the responses of the survey the new set
	public void take() throws IOException
	{
		responses.add(new ArrayList<Response>());
		for (int i = 0; i < questions.size(); i++)
		{
			responses.get(responses.size() - 1).add(questions.get(i).take());
		}
		System.out.println("Your response is number " + responses.size());
	}

	//Go through all the steps to creating a survey
	public void create(String type) throws IOException
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
		} catch (Exception e)
		{
			//Catch invalid input, non digit
			System.out.println("Invalid entry enter a single digit 1-3\n\n\n");
			create(type);
			return;
		}
		//Not valid choices for this menu, let the user know and prompt again
		if (choice > 3 || choice < 1)
		{
			System.out.println("Invalid entry enter a single digit 1-3\n\n\n");
			create(type);
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
						System.out.println("Creating new " + type
								+ ", enter title");
						br = new BufferedReader(
								new InputStreamReader(System.in));
						this.title = br.readLine();
						Question tempQuestion = new QuestionCreate()
								.createQuestion();
						if (tempQuestion.getPrompt() == null)
						{
							System.out.println("Cancelling " + type
									+ ", returning to main menu\n\n\n");
							this.title = null;
							return;
						}
						else
						{
							this.questions.add(tempQuestion);
							create(type);
							return;
						}
					}
					else
					{
						Question tempQuestion = new QuestionCreate()
								.createQuestion();
						if (tempQuestion.getPrompt() == null)
						{
							return;
						}
						else
						{
							this.questions.add(tempQuestion);
							create(type);
							return;
						}
					}
				} catch (Exception e)
				{
					System.out.println("Cancelling  " + type
							+ ", returning to main menu\n\n\n");
					this.title = null;
					return;
				}
			case 2:
				try
				{
					if (questions.size() == 0)
					{
						System.out
								.println("No questions to display yet!\n\n\n");
						create(type);
						return;
					}
					else
						this.display();
					create(type);
					return;
				} catch (Exception e)
				{
					System.out.println("No questions to display yet!\n\n\n");
					create(type);
					return;
				}
			case 3:
				return;
			}
			return;
		}
	}

	//Output to a file
	public void serialize() throws Exception
	{
		File verifyFolder = new File("surveys\\");
		if (!verifyFolder.exists())
			verifyFolder.mkdirs();

		File createFile = new File("surveys\\" + this.title + ".dat");

		if (!createFile.exists())
			createFile.createNewFile();

		File testsFile = new File("surveys.txt");

		if (!testsFile.exists())
			testsFile.createNewFile();
		
		FileOutputStream fileOut = new FileOutputStream(createFile);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(this);
		FileReader fr = new FileReader("surveys.txt");
		BufferedReader bro = new BufferedReader(fr);
		String collection = "";
		String temp = bro.readLine();
		while (temp != null)
		{
			if (!temp.toLowerCase().equals((this.title + ".dat").toLowerCase()))
			{
				collection = collection + temp + "\n";
			}
			temp = bro.readLine();
		}
		FileWriter fw = new FileWriter("surveys.txt");
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write(collection + this.title + ".dat\n");
		System.out.println("File saved at surveys\\" + this.title + ".dat");

		//Close all the streams
		bro.close();
		bw.close();
		fw.close();
		out.close();
		fileOut.close();
	}

	public ArrayList<HashMap<Response, Integer>> tabulate()
	{
		ArrayList<HashMap<Response,Integer>> tempArr = new ArrayList<HashMap<Response,Integer>>();
		for(int i = 0; i < questions.size(); i++)
		{
			HashMap<Response, Integer> tempHash = new HashMap<Response,Integer>();
			for(int j = 0; j < responses.size(); j++)
			{
				if(!tempHash.containsKey(responses.get(j).get(i)))
				{
					tempHash.put(responses.get(j).get(i), 1);
				}
				else
				{
					tempHash.put(responses.get(j).get(i), tempHash.get(responses.get(j).get(i))+1);
				}
			}
			tempArr.add(tempHash);
		}
		return tempArr;
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

	public void modify() throws Exception
	{
		System.out.println("Select an Option\n1) Modify Title\n2) Modify a Question\n3) Add a Question\n4) Exit");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		try{
			int choice = Integer.parseInt(temp);
			if(choice < 1 || choice > 4)
			{
				System.out.println("Invalid selection\n");
				modify();
				return;
			}
			else
			{
				switch(choice){
				case 1:
					System.out.println("Enter the new Title");
					this.title = br.readLine();
					modify();
					return;
				case 2:
					questionModify();
					modify();
					return;
				case 3:
					try
					{
						Question tempQuestion = new QuestionCreate().createQuestion();
						if (tempQuestion.getPrompt() == null)
						{
							modify();
							return;
						}
						else
						{
							this.questions.add(tempQuestion);
							modify();
							return;
						}
					} catch (Exception e) {
						modify();
						return;
					}
				case 4:
					return;
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid selection\n");
			modify();
			return;
		}
	}

	protected void questionModify()
	{
		System.out.println("Choose a Question to Modify");
		for(int i = 0; i < questions.size(); i++)
		{
			System.out.println(""+(i+1)+ ") " + questions.get(i).getType() + ": "
					+ questions.get(i).getPrompt().getPrompt_());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			String temp = br.readLine();
			int choice = Integer.parseInt(temp);
			if(choice < 1 || choice > questions.size())
			{
				System.out.println("Invalid choice\n");
				questionModify();
				return;
			}
			else
			{
				System.out.println("WARNING MODIFYING QUESTIONS WILL REMOVE ALL RESPONSES(Deleting will only remove that Question)");
				System.out.println("Would you like to modify or delete the question?(Y to modify)");
				temp = br.readLine();
				if(!temp.toLowerCase().equals("y"))
				{
					questions.remove(choice-1);
					for(int i = 0; i < responses.size(); i++)
					{
						responses.get(i).remove(choice-1);
					}
					return;
				}
				modifyQuestion(questions.get(choice-1),choice-1);				
			}
		} catch (Exception e) {
			System.out.println("Invalid choice\n");
			questionModify();
			return;
		}
	}

	//Can overwrite this in test to prompt to just modify the correct answer
	private void modifyQuestion(Question question, int index) throws IOException
	{
		if(question.modify())
		{
			responses = new ArrayList<ArrayList<Response>>();
		}
	}
}
