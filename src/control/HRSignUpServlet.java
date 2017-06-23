package control;

import model.HR;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Charlotte514 on 2017/6/21.
 * uesd in HR account sign in system
 */
public class HRSignUpServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession();
        String email=(String)req.getParameter("register_mailbox");
        String pwd=(String)req.getParameter("register_password");
        HR aHR=new HR(email,pwd);
        //HR用户保存
        // aHR.add(aHR);

        //没有错误信息
        session.setAttribute("wrongMsg","");
        //转发至登录界面
        resp.sendRedirect("../login.jsp");

    }
}
