package com.Nil.Database;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

public class WordsDao 
{
	public boolean save(String authorName, String content, int liker)
	{
		Session s = null;
    	Transaction t = null;
    	try
    	{
    		s = HibernateUtil.getSession();
    		t = s.beginTransaction();
    		Map session = ActionContext.getContext().getSession();
    		String name = (String)session.get("username");
    		
    		System.out.println(name);
    		System.out.println(content);
    		System.out.println(liker);
    		
    		Words word = new Words(name, content, liker);
    		s.save(word);
    		t.commit();
    		return true;
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
	}
}
