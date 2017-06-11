package com.Nil.Database;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Words 
{
	private int num;
	private String authorName;
	private String content;
	private int liker;
	private String time;
	
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

	public Words(){}
	
	Words(String authorName, String content, int liker)
	{
		this.authorName = authorName;
		this.content = content;
		this.liker = liker;
		
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		this.setTime(time);
	}

}
