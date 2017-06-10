package com.Nil.Database;

public class Words 
{
	private int num;
	private String authorName;
	private String content;
	private int liker;
	
	public int getNum() 
	{
		return num;
	}
	
	public void setNum(int num) 
	{
		this.num = num;
	}

	public String getAuthorName() 
	{
		return authorName;
	}

	public void setAuthorName(String authorName) 
	{
		this.authorName = authorName;
	}


	public String getContent() 
	{
		return content;
	}

	public void setContent(String content) 
	{
		this.content = content;
	}

	public int getLiker() 
	{
		return liker;
	}

	public void setLiker(int liker) 
	{
		this.liker = liker;
	}

	Words(){}
	
	Words(String authorName, String content, int liker)
	{
		this.authorName = authorName;
		this.content = content;
		this.liker = liker;
	}
	
}
