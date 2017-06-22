package control;

import model.HR;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Charlotte514 on 2017/6/21.
 * used in HR account sign up for system
 */
public class HRLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession();

        String email=req.getParameter("login_mailbox");
        String pwd=req.getParameter("login_password");
        HR aHR=new HR(email,pwd);

        try {
            if( aHR.check(aHR)){
                //匹配成功
                //重定向到HR招聘信息管理界面
                session.setAttribute("HR",aHR);
                resp.sendRedirect("../HR_management.jsp");
            }else{
                //匹配失败
                //转发至登录界面
                req.setAttribute("wrongMsg","用户密码不匹配，请核对!");
                req.getRequestDispatcher("../login.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            //SQL错误
            //转发至登录界面
            req.setAttribute("srongMsg","请正确填写用户邮箱和密码");
            req.getRequestDispatcher("../login.jsp").forward(req,resp);
        }
    }
}
