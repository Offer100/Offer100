package control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Charlotte514 on 2017/6/23.
 * get hotwords from TrendSearchers.jsp,sendRedirect to TrendSearchersResult.jsp
 */
public class TrendSearcherServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String hotword=req.getParameter("hotword");




        //
        System.out.println("ok");
        resp.sendRedirect("../TrendSearchersResult.jsp");
    }
}
