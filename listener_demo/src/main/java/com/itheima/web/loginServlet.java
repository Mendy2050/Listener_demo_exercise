package com.itheima.web; /**
 * @author Mendy
 * @create 2023-05-31 19:21
 */

import com.itheima.pojo.User;
import com.itheima.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    private UserService service = new UserService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. acquire username and password
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //get the data of checkbox
        String remember = request.getParameter("remember");

        //2.调用service查询
        User user = service.login(username, password);

        //3. 判断
        if(user != null){
            //login succeed, jump to the selectAllServlet

            //Check if the user has selected 'Remember me'
            if("1".equals(remember)){
                // the user has selected 'Remember me', so we need to send out cookies
                //1.1 create cookie object
                Cookie c_username = new Cookie("username",username);
                Cookie c_password = new Cookie("password",password);

                //1.2 set cookie duration
                c_username.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);

                //1.3 send out cookie object
                response.addCookie(c_username);
                response.addCookie(c_password);
            }


            //save the successfully-login user object to session scope
            HttpSession session = request.getSession();
            session.setAttribute("user",user);

            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/selectAllServlet");

        }else{
            //login failed

            //save the prompt message of "login failed" into request scope
            request.setAttribute("login_msg","there is something wrong with username or password");

            //jump to login.jsp
            request.getRequestDispatcher("/login.jsp").forward(request,response);


        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
