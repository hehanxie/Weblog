package com.Nil.Database;

import org.hibernate.Criteria;
import org.hibernate.Session;  
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class UserDao 
{
    public void save(User user)
    {	
        Session session = HibernateUtil.getSession();  
        Transaction ts = session.beginTransaction();  
        try
        {  
            session.save(user);  
            ts.commit();  
        } 
        finally 
        {  
            if(session != null)  
                session.close();  
        }   
    }  

    public User findUserById(int id) 
    {  
        Session session = HibernateUtil.getSession();  
        try 
        {  
            User user = (User)session.get(User.class, id);  
            return user;  
        } 
        finally 
        {  
            if(session != null)  
                session.close();  
        }  
          
    } 
    
    public boolean loginCheck(String username,String password)
    {
    	Session s = null;
    	try
    	{
    	   s = HibernateUtil.getSession();	   
    	   Criteria c = s.createCriteria(User.class);
    	   //eq是等于，gt是大于，lt是小于,or是或
    	   c.add(Restrictions.eq("username",username));
    	   User user = (User)c.uniqueResult();
    	   System.out.println(c);
    	   if (user.getPassword().equals(password))
    	   {
    		   return true;
    	   }
    	   else
    	   {
    		   return false;
    	   }
    	}
    	finally
    	{
    	   if(s!=null)
    	   s.close();
    	}
    }
    
    public boolean registerUser(String username, String password)
    {
    	Session s = HibernateUtil.getSession();
    	Transaction t = null;
    	try
    	{
    		t = s.beginTransaction();
    		User newUser = new User(0, username, password);
    		s.save(newUser);
    		t.commit();
    		return true;
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
    }
    
}

