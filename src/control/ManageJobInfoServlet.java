package control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Charlotte514 on 2017/6/23.
 */
public class ManageJobInfoServlet extends HttpServlet {
    //用于从删除管理界面获取删除关键词，搜寻该HR名下符合关键词的Offer
    //返回到删除管理界面显示


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

    }
}
