package control;

import model.Sub;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Charlotte514 on 2017/6/23.
 */
public class SubscriptionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession();
        String email=req.getParameter("email");
        String direction=req.getParameter("industry-category");
        String fromURL = req.getHeader("referer");
        if(email!=null&&direction!=null) {
            Sub mSub = new Sub(email, direction);

            //
            //mSub.add();

            //保存处理结果
            System.out.println("here");
            //session.setAttribute("wrongMsg","good");
            session.setAttribute("wrongMsg", "订阅邮箱："+mSub.getMail()+"订阅信息："+mSub.getDirection()+"已保存成功");
        }else{
            session.setAttribute("wrongMsg","订阅失败，请重试");
        }

        resp.sendRedirect("../JobSearchResult.jsp");
    }
}
