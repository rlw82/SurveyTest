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

public class Test extends Survey
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8529910696342239131L;

	public void modifyAnswers()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}
	
	//Display to the current io
	public void display()
	{
		this.io.display(this.title + "\n\nQuestions\n\n");
		for (int i = 0; i < questions.size(); i++)
		{
			this.io.display("" + (i+1) + ")");
			questions.get(i).display(this.io);
			this.io.display("\nAnswer(s) for this question\n");
			for(int j = 0; j < correctAnswers.get(i).size(); j++)
			{
				questions.get(i).displayAnswer(this.io, correctAnswers.get(i).get(j));
			}
		}
		
	}
	
	public double grade()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	//Create all the needed parts for a Test
	public void create(String type) throws IOException
	{
		//First create all the questions
		super.create("Test");
		//Then create the correct answers
		if (questions.size() != 0 && this.correctAnswers.size() == 0)
		{
			System.out.println("Enter the Correct Answers for the Questions");
			//Get all the responses for all the questions
			for(int i = 0; i < questions.size(); i++)
			{
				Question tempQues = questions.get(i);
				correctAnswers.add(createCorrectAnswer(tempQues));
			}
		}
		//If test is cancelled during previous creation there will be no questions;
		else
			return;
	}

	//Get the list of correct responses from the specific question
	//In another method to easily recurse to get correct input
	private ArrayList<Response> createCorrectAnswer(Question quest) throws IOException
	{
		//Create the return
		ArrayList<Response> questResponses = new ArrayList<Response>();
		//MultipleChoice and ShortAnswers can have multiple correct answers
		if(quest.getType().equals("Essay"))
		{
			questResponses.add(new Response(quest.getPrompt(), new ArrayList<String>()));
			return questResponses;
		}
		if(quest.getType().equals("MultipleChoice") || quest.getType().equals("ShortAnswer"))
		{
			System.out.println("How many answers does this Question have?");
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				//Test if they give a correct input
				try{
					String temp = br.readLine();
					int amount = Integer.parseInt(temp);
					if(amount < 1)
					{
						//If the amount of responses is less than one go into the catch
						Integer.parseInt("Catch");
					}
					else
					{
						//Get the amount of responses for the question
						for(int i = 0; i < amount; i ++)
						{
							questResponses.add(quest.take());
						}
						return questResponses;
					}
				} catch (Exception e) {
					System.out.println("\nInvalid Input, Try Again\n\n");
					return this.createCorrectAnswer(quest);
				}
			}
		}
		//Other Questions will only have 1 correct response
		questResponses.add(quest.take());
		return questResponses;
	}
	
	//Output to a file
	public void serialize() throws Exception
	{
		File verifyFolder = new File("tests\\");
		if(!verifyFolder.exists())
			verifyFolder.mkdirs();
		
		File createFile = new File("tests\\" + this.title + ".dat");
		
		if(!createFile.exists())
			createFile.createNewFile();
		
		FileOutputStream fileOut = new FileOutputStream(createFile);
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(this);
    File testsFile = new File("tests.txt");
    
    if(!testsFile.exists())
    	testsFile.createNewFile();
    
    FileReader fr = new FileReader("tests.txt");
    BufferedReader bro = new BufferedReader(fr);
    String collection = "";
    String temp = bro.readLine();
    while(temp!=null)
    {
    	if(!temp.toLowerCase().equals((this.title+".dat").toLowerCase()))
    	{
    		collection = collection + temp + "\n";
    	}
  		temp = bro.readLine();
    }
    FileWriter fw = new FileWriter("tests.txt");
    BufferedWriter bw = new BufferedWriter(fw);
    
    bw.write(collection + this.title + ".dat\n");
    System.out.println("File saved at tests\\" + this.title + ".dat");
    
    //Close all the streams
    bw.close();
    fw.close();
    out.close();
    fileOut.close();
	}
	
	//Initialize new variable
	public Test()
	{
		//Just need a default constructor, object is either loaded in through serialization or created from line by line input
		super();
		this.correctAnswers = new ArrayList<ArrayList<Response>>();
	}

	private ArrayList<ArrayList<Response>> correctAnswers;

	public void setCorrectAnswers(ArrayList<ArrayList<Response>> value)
	{
		this.correctAnswers = value;
	}

	public ArrayList<ArrayList<Response>> getCorrectAnswers()
	{
		return this.correctAnswers;
	}

}
