package com.Nil.Action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Nil.Database.HibernateUtil;
import com.Nil.Database.Words;
import com.Nil.Database.WordsDao;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class WordsAction implements Action
{
	private int num;
	private String authorName;
	private String content;
	private int liker;
	private String time;
	private int page;
	
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
	
	public int getPage()
	{
		return page;
	}

	public void setPage(int page)
	{
		this.page = page;
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
	
	public String saveToDatabase()
	{
		System.out.println(0);
		try
		{
			WordsDao wd = new WordsDao();
			if (wd.saveToDatabase(authorName, content, liker))
			{
				//System.out.println(1);
				return SUCCESS;
			}
		}
		catch (Exception e)
		{
			//System.out.println(2);
			return "fail";
		}
		//System.out.println(2);
		return "fail";
	}
	
	public String getAllWords() throws Exception 
	{
		int in;
		Map session = ActionContext.getContext().getSession();
		if (session.get("beginIndex") == null)
		{
			in = 0;
		}
		else
		{			
			String index = session.get("beginIndex").toString();
			in = Integer.parseInt(index);	
		}
		
		wordsList =  new ArrayList();
		WordsDao wd = new WordsDao();
		wordsList = wd.findAllWords(in);
		
		return SUCCESS;
	}
	
	public String deleteWords() throws Exception 
	{
		WordsDao wd = new WordsDao();
		String n = String.valueOf(num);
		if (wd.deleteWords(n))
		{
			return SUCCESS;
		}
		return ERROR;
	}

	public String lastPage()
	{
		int in;
		Map session = ActionContext.getContext().getSession();
		if (session.get("beginIndex") == null)
		{
			in = 0;
		}
		else
		{
			String index = session.get("beginIndex").toString();
			System.out.println("current page is " + index);
			in = Integer.parseInt(index);
			in -= 5;
			if (in <= 0)
			{
				in = 0;
			}
		}	
		page = in;
		
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().put("beginIndex", String.valueOf(in));
		System.out.println("last page");
		return SUCCESS;
		
	}
	
	public String nextPage()
	{
		int in;
		Map session = ActionContext.getContext().getSession();
		if (session.get("beginIndex") == null)
		{
			in = 5;
		}
		else
		{			
			String index = session.get("beginIndex").toString();
			
			in = Integer.parseInt(index);	
			in += 5;
			Session s = HibernateUtil.getSession();
			Criteria c = s.createCriteria(Words.class);
			int maxBeginIndex = c.list().size()/5 * 5;
			if (in >= maxBeginIndex)
			{
				in = maxBeginIndex;
			}
		}
		page = in;
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().put("beginIndex", String.valueOf(in));
		
		System.out.println("next page");
		return SUCCESS;
		
	}
	
}
