package com.Nil.Interceptor;

import java.util.Map;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorityInterceptor extends AbstractInterceptor 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//拦截Action处理的拦截方法
    public String intercept(ActionInvocation invocation) throws Exception
	{
    	System.out.println(1);
		//取得请求相关的ActionContext实例
		Map session = ActionContext.getContext().getSession();
		//取出名为user的Session属性
		String user = (String)session.get("username");
		System.out.println(user);
		if (user != null)
		{
			return invocation.invoke();
		}
		//直接返回login的逻辑视图
		System.out.println(2);
		return "none";//"login"
    }
    
}
