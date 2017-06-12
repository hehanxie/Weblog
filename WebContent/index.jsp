<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0022)https://blog.daraw.cn/ -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
  
  <title>DaraW | Code is Poetry</title>

  <meta name="author" content="DaraW">
  
  <meta name="description" content="JavaScript Developer">
  
  <meta id="viewport" name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">

  <meta property="og:site_name" content="DaraW"/>

  <meta property="og:image" content="/favicon.ico"/>
  

  <link rel="icon">
  <link rel="alternate" title="DaraW" type="application/atom+xml">
  <link rel="stylesheet" href="./assets/css/style_index.css" media="screen" type="text/css">
</head>


<body onload="wordsList">
<div class="blog">
  <div class="content">

<header>
  <div class="site-branding">
    <h1 class="site-title">
      <a href="load.jsp">Hello</a>
    </h1>
    <p class="site-description">Code is Poetry</p>
  </div>
  <nav class="site-navigation">
    <ul>
      
      	<li><a href="" >主页</a></li>
      
        <li><a href="SaveWordsAction">撰写</a></li>
      
        <li><a href="">关于</a></li>
      
        <li><a href="">链接</a></li>
      
      	<%	
			if (session.getAttribute("username") != null)
			{
				%>
				<li><a href="LogoutAction">退出</a></li>
				<% 
			}
			else
			{
				%>
				<li><a href="LoginAction">登录</a></li>
				<%
			}
      	%>
    </ul>
  </nav>
</header>

<main class="site-main posts-loop">
    
  <article>
  	
  		<s:iterator value="wordsList" status="st">
  	<%-- 	<s:if test="#session.page<=#st.index&&#session.page+5>#st.index">
 --%>
  			
  	
  			<div class="article-content">
    			<div class="entry">  
					<p><s:property value="content" /><br></p>
				</div>
			</div>
		
  			<div class="article-footer">
    			<div class="article-meta pull-right">
      				<span>
        				<i class="icon-comments"></i>
        					<span>
          						<s:a href="DeleteWordsAction?num=%{num}">删除</s:a>
        					</span>
      				</span>
    			</div>
  			</div>
  			
  			<div class="article-top-meta">
    			<span class="posted-on">
      				<a  rel="bookmark">
        				<time class="entry-date published" datetime="2017-03-23T11:01:15.000Z">
          				<p><s:property value="time" /><br></p>
        				</time>
      				</a>
    			</span>
  			</div>
  			
  		</s:iterator>
  	
  </article>



<nav class="pagination">
	
	<a href="wordsList" class="pagination-next">上一页</a>
	<a href="wordsList" class="pagination-next">下一页</a>
  
</nav>
    </main>

<footer class="site-footer">
  <p class="site-info">
    Proudly powered by <a target="_blank">Hexo</a> and
    Theme by <a target="_blank">Hacker</a>
    <br>
    
    © 2017 DaraW
    
  </p>
</footer>
    

  </div>
</div>

</body><div></div></html>