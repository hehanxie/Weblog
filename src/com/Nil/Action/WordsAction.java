package com.Nil.Action;

import com.Nil.Database.WordsDao;
import com.opensymphony.xwork2.Action;

public class WordsAction implements Action
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

	@Override
	public String execute() throws Exception 
	{
		WordsDao wd = new WordsDao();
		if (wd.save(authorName, content, liker))
		{
			return SUCCESS;
		}
		return ERROR;
	}
}
