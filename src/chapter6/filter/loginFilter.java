package chapter6.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chapter6.beans.User;

@WebFilter(urlPatterns={"/edit/*", "/setting/*"})
//@WebFilter("/setting")
public class loginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		//ログインしていなかったら、リダイレクト処理を施す
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
	    User user = (User) req.getSession().getAttribute("loginUser");
	    List<String> errorMessages = new ArrayList<String>();
	    if (user == null) {
	    	errorMessages.add("ログインしてください");
	    	req.getSession().setAttribute("errorMessages", errorMessages);
	    	res.sendRedirect("./login");
	    	return;
	    }
		chain.doFilter(request, response); // サーブレットを実行

	}

	@Override
	public void init(FilterConfig config) {
	}

	@Override
	public void destroy() {
	}

}
