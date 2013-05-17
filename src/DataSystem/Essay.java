package DataSystem;

import java.util.Scanner;

public class Essay extends Question {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9216347102043281617L;
	private String data;

	public void setData(String value) {
		this.data = value;
	}

	public String getData() {
		return this.data;
	}

	public void display() {
		super.display();
	}

	public Response take() {
		this.display();
		return new Response();

	}

	//All you need for an essay and a short answer is a prompt
	public void create() {
		super.create();
	}

	public Prompt getPrompt()
	{
		return this.prompt;
	}
	
	public void modify() {
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public void save() {
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public Essay(Prompt prompt_, String responce_) {
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public Essay() {
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

}
