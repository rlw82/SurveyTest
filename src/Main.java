//Russell Wiley
//CS 350
//Professor Salvage

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.Scanner;

import DataSystem.Survey;
import DataSystem.Test;

//Driver menu for the test/survey system
//Any created surveys will get stored in folders and files on your local machine
//.\surveys.txt and .\tests.txt store lists of locations of serialized surveys and tests in the folders
//.\survey\* and .\test\*
//Saving is done in the creating sub menus
//This is all that needs to be done on this menu for Homework 2
public class Main
{
	//Current Loaded Survey or Test
	public static Survey currentSurvey = null;

	public static void main(String[] args) throws IOException
	{
		//Prompt user for choice
		System.out.println("Enter a choice\n");
		System.out
				.println("1) Create a new Survey\n2) Create a new Test\n3) Display current Survey/Test\n"
						+ "4) Load a Survey\n5) Load a Test\n6) Quit");
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
			System.out.println("Invalid entry enter a single digit 1-6\n\n\n\n\n");
			main(args);
			return;
		}
		//Not valid choices for this menu, let the user know and prompt again
		if (choice > 6 || choice < 1)
		{
			System.out.println("Invalid entry enter a single digit 1-6\n\n\n\n\n");
			main(args);
			return;
		}
		else
		{
			switch (choice)
			{
			case 1:
				currentSurvey = new Survey();
				currentSurvey.create();
				main(args);
				return;
			case 2:
				currentSurvey = new Test();
				currentSurvey.create();
				main(args);
				return;
			case 3:
				try{
					currentSurvey.display();
				} catch (Exception e) {
					System.out.println("No Survey/Test currently active in System\n\n\n\n\n");
				}
				main(args);
				return;
			case 4:
				try
				{
					FileReader fr = new FileReader(".\\surveys.txt");
					br = new BufferedReader(fr);
					String surveyList = "";
					temp = br.readLine();
					while (!temp.equals(null))
					{
						//Ensures no blank lines since file is edited inside system
						if (!temp.equals(""))
							surveyList = surveyList + temp;
						temp = br.readLine();
					}
					loadSurveyTest(surveyList, "Survey");
				}
				catch (FileNotFoundException e)
				{
					System.out.println("No surveys have been created yet...");
					main(args);
					return;
				}
				catch (Exception e)
				{
					try
					{
						System.out
								.println("File has been edited outside of system check at "
										+ (new FileReader(".\\surveys.txt")).toString());
					}
					catch (FileNotFoundException e1)
					{
						//Already tested for...
					}
					br.close();
					System.exit(-1);
				}
			case 5:
				try
				{
					FileReader fr = new FileReader(".\\tests.txt");
					br = new BufferedReader(fr);
					String surveyList = "";
					temp = br.readLine();
					while (!temp.equals(null))
					{
						//Ensures no blank lines since file is edited inside system
						if (!temp.equals(""))
							surveyList = surveyList + temp;
						temp = br.readLine();
					}
					loadSurveyTest(surveyList, "Test");
				}
				catch (FileNotFoundException e)
				{
					System.out.println("No tests have been created yet...");
					main(args);
					return;
				}
				catch (Exception e)
				{
					try
					{
						System.out
								.println("File has been edited outside of system check at "
										+ (new FileReader(".\\tests.txt")).toString());
					}
					catch (FileNotFoundException e1)
					{
						//Already tested for...
					}
					br.close();
					System.exit(-1);
				}
			case 6:
				System.out.println("Exiting");
				br.close();
				System.exit(1);
			default:
				//won't get here
			}
		}
	}

	//Menu for loading a survey or test
	//Since the only difference would be the casting of the object, just take an argument for the type you're
	//doing
	@SuppressWarnings("resource")
	private static void loadSurveyTest(String surveyList, String type)
	{
		System.out.println("Select a " + type);
		String temp = "";
		String[] surveys = surveyList.split("\n");
		for (int i = 0; i < surveys.length; i++)
		{
			System.out.println("" + (i + 1) + ") "
					+ surveys[i].substring(0, surveys[i].lastIndexOf('.')));
		}
		System.out.println("" + (surveys.length + 1) + ") Exit");
		int choice = -1;
		Scanner scan = new Scanner(System.in);
		temp = scan.nextLine();
		try
		{
			//Will go into exception if input is not an integer
			choice = Integer.parseInt(temp);
		}
		catch (Exception e)
		{
			//Catch invalid input, non digit
			System.out.println("Invalid entry enter a number for a " + type
					+ " \n\n\n\n\n");
			loadSurveyTest(surveyList, type);
			return;
		}
		//Not valid choices for this menu, let the user know and prompt again
		if (choice > surveys.length + 1 || choice < 1)
		{
			System.out.println("Invalid entry enter a number for a " + type
					+ " \n\n\n\n\n");
			loadSurveyTest(surveyList, type);
			return;
		}
		else
		{
			if (choice == surveys.length + 1)
			{
				System.out.println("Current working file not updated");
				return;
			}
			try
			{
				//Deserialize the selected survey or test
				FileInputStream fis = new FileInputStream(surveys[choice + 1]);
				ObjectInputStream ois = new ObjectInputStream(fis);
				switch (type.toLowerCase())
				{
				case "survey":
					currentSurvey = (Survey) ois.readObject();
					break;
				case "test":
					currentSurvey = (Test) ois.readObject();
					break;
				default:
					//won't happen
					break;
				}
				fis.close();
				ois.close();
			}
			catch (Exception e)
			{
				System.out.println("File was not serialized correctly");
				scan.close();
				System.exit(0);
			}
		}
	}
}
