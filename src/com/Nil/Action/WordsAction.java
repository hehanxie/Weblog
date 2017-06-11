package com.Nil.Action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.Nil.Database.Words;
import com.Nil.Database.WordsDao;
import com.opensymphony.xwork2.Action;

public class WordsAction implements Action
{
	private int num;
	private String authorName;
	private String content;
	private int liker;
	private String time;
	
	private List<Words> wordsList;
	
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

	public String getTime()
	{
		return time;
	}

	public void setTime(String time)
	{
		this.time = time;
	}
	
	public List<Words> getWordsList()
	{
		return wordsList;
	}

	public void setWordsList(List<Words> wordsList)
	{
		this.wordsList = wordsList;
	}
	
	@Override
	public String execute() throws Exception
	{
		
		return null;
	}
	
	public String saveToDatabase() throws Exception 
	{
		WordsDao wd = new WordsDao();
		if (wd.saveToDatabase(authorName, content, liker))
		{
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String getAllWords() throws Exception 
	{
		wordsList =  new ArrayList();
		WordsDao wd = new WordsDao();
		wordsList = wd.findAllWords();
		Collections.reverse(wordsList);
		System.out.println("print all words");
		return SUCCESS;
	}
	
	public String deleteWords() throws Exception 
	{
		
		return SUCCESS;
	}
	
}
