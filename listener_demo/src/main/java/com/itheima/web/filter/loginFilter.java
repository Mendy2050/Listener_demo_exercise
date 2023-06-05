package com.itheima.web.filter; /**
 * @author Mendy
 * @create 2023-06-05 16:36
 */


import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class loginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;

        //0. if the accessing resource path if related to register and login
        //0.1 define the accessing resource path array
        String[] urls = {"/login.jsp","/imgs/","/css/","/loginServlet","/register.jsp","/registerServlet","/checkCodeServlet"};

        //0. acquire current accessing resource path
//        String url = req.getRequestURL().toString();
        String url = req.getServletPath().toString();

        // loop check
        for (String u : urls) {
            if(url.contains(u)){
                //find the path, it means allow the pass
                chain.doFilter(req, response);

                // close the whole method
                return;
            }
        }


        //1. check if there is user object in session object
        //1.1. acquired user object
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        //1.2. check  if user object is null
        if(user != null){
            //user has already logged in
            // allow the pass
            chain.doFilter(req, response);
        }else{
            //Invalid Request, user has not logged in yet
            // jump to log in page, save prompt message, forward response and request
            req.setAttribute("login_msg","您尚未登陆");
            req.getRequestDispatcher("/login.jsp").forward(req,response);
        }

    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }


}
