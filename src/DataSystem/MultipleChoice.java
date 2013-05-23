package DataSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MultipleChoice extends Question
{
	private static final long serialVersionUID = 7005563851486654225L;

	public Response take()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	private ArrayList<Choice> choices;

	public void setChoices(ArrayList<Choice> value)
	{
		this.choices = value;
	}

	public ArrayList<Choice> getChoices()
	{
		return this.choices;
	}

	public MultipleChoice()
	{

	}

	public void create() throws IOException
	{
		super.create();
		Scanner scan = new Scanner(System.in);
		System.out.println("Make a selection\n");
		System.out.println("1) Create another Question\n2) End Questions");
		String temp = scan.next();
		scan.close();
		int choice;
		try
		{
			choice = Integer.parseInt(temp);

		}
		catch (Exception e)
		{
			System.out
					.println("Invalid selection choose a single digit 1-2\n\n\n\n\n");
			create();
			return;
		}

		if (choice < 1 || choice > 2)
		{
			System.out
					.println("Invalid selection choose a single digit 1-2\n\n\n\n\n");
			create();
			return;
		}
		switch (choice)
		{
		case 1:

		}
	}

	public MultipleChoice(Prompt prompt_, ArrayList<Choice> answers)
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public void display()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public void modify()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public void save()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

}
