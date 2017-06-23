package control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Charlotte514 on 2017/6/23.
 */
public class JobSearcherServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String keyword=req.getParameter("keyword");

        //TODO
        //查询函数

        //保存进session

        //重定向到结果显示界面。

    }
}
