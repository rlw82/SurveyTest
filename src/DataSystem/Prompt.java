package DataSystem;

public class Prompt implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4046878163899659905L;
	private String prompt_;

	public void setPrompt_(String value)
	{
		this.prompt_ = value;
	}

	public String getPrompt_()
	{
		return this.prompt_;
	}

	public void display(InputOutput io)
	{
		io.display(this.prompt_);
	}

	public Prompt(String prompt)
	{
		prompt_ = prompt;
	}

	public Prompt()
	{
	}

}
