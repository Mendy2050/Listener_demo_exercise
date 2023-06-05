package com.itheima.web; /**
 * @author Mendy
 * @create 2023-05-30 13:12
 */

import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectByIdServlet")
public class selectByIdServlet extends HttpServlet {

    //for repeat use
    private BrandService service = new BrandService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. accept id
        String id = request.getParameter("id");

        //2. call service for search
        Brand brand = service.selectById(Integer.parseInt(id));

        //3.save to request scope
        request.setAttribute("brand",brand);

        //4. forward to update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request,response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
