import java.util.HashSet;
import java.util.Set;
public class Question
{
   
   private Prompt prompt;
   
   public void setPrompt(Prompt value) {
      this.prompt = value;
   }
   
   public Prompt getPrompt() {
      return this.prompt;
   }
   
	
	public void display()
	{
		//To do
	}
	
	public Answer take()
	{
		return new Answer();
	}
		
	public void modify()
	{
		
	}
	
	public void save()
	{
		
	}
}