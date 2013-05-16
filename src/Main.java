import java.util.ArrayList;
import java.util.Scanner;

import DataSystem.Survey;
import DataSystem.Test;
public class Main
{
	//Use ArrayLists for variable length in java
	//A loaded survey or test will be put into the ArrayList loadedSurveys with
	//surveyLocations and testLocations giving amounts of either and locations where they are in loadedSurveys
	public ArrayList<Survey> loadedSurveys;
	public ArrayList<Integer> surveyLocations;
	public ArrayList<Integer> testLocations;
	public static void main(String[] args)
	{
		//Prompt user for choice
		System.out.println("Enter a choice\n");
		System.out.println("1) Create a new Survey\n2) Create a new Test\n3) Display Survey\n" +
				"4) Display a Test\n5) Load a Survey\n6) Load a Test\n7) Save a Survey\n8) Save a Test\n9) Quit");
		String temp = "";
		Scanner scan = new Scanner(System.in);
		temp = scan.next();
		int choice = -1;
		try{
			//Will go into exception if input is not an integer
			choice = Integer.parseInt(temp);
		} catch(Exception e){
			//Catch invalid input, non digit
			System.out.println("Invalid entry enter a single digit 1-9\n\n\n\n\n");
			main(args);
			scan.close();
			return;
		}
		//Not valid choices for this menu, let the user know and prompt again
		if(choice > 9 || choice < 1)
		{
			System.out.println("Invalid entry enter a single digit 1-9\n\n\n\n\n");
			main(args);
			scan.close();
			return;
		}
		else
		{
			switch(choice){
			case 1:
				Survey tempSurvey = new Survey();
				tempSurvey.Create();
				break;
			case 2:
				Test tempTest = new Test();
				tempTest.Create();
				break;
			case 3:
				if(surveyLocations.size())
			}
			scan.close();
		}
	}
}
