//Russell Wiley
//CS 350
//Professor Salvage
package DataSystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

//Ranking is a Matching that matches one set of choices to 1-choices.size()
public class Ranking extends Matching
{
	private static final long serialVersionUID = 7552164284178692603L;

	public Response take()
	{
		return super.take();
	}

	public boolean modify()
	{
		System.out.println("Make a Choice\n1) Edit Prompt\n2) Edit Choices\n3) Cancel");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			String temp = br.readLine();
			int choice = Integer.parseInt(temp);
			if(choice < 1 || choice > 3)
			{
				System.out.println("Invalid choice\n");
				return modify();
			}
			switch(choice){
			case 1:
				return super.modify();
			case 2:
				this.right = modifyChoiceSet(this.right);
				return true;
			case 3:
				return false;
			}
		} catch (Exception e) {
			System.out.println("Invalid choice\n");
			return modify();
		}
		return false;
	}

	public void displayAnswer(InputOutput io, Response response)
	{
		super.displayAnswer(io, response);
	}

	//Can be more efficiently done
	public void display(InputOutput io)
	{
		this.prompt.display(io);
		for (int i = 0; i < left.size(); i++)
		{
			io.display("" + (i + 1) + ") ");
			right.get(i).display(io);
			io.display("\n");
		}
	}

	public String getType()
	{
		return "Ranking";
	}

	public Ranking(Prompt tempPrompt, ArrayList<Choice> ranks,
			ArrayList<Choice> numbers)
	{
		super(tempPrompt, numbers, ranks);
	}

}
