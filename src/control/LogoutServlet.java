package control;

import model.HR;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Charlotte514 on 2017/7/5.
 */
public class LogoutServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession();
        HR aHR=(HR)session.getAttribute("HR");

        if(aHR==null||aHR.getMail()==null||aHR.getMail().equals("")){
            //HR不存在
            //直接重定向
            resp.sendRedirect("../JobSearch.jsp");
        }else{
            aHR=null;
            session.setAttribute("HR",aHR);
            resp.sendRedirect("../JobSearch.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
