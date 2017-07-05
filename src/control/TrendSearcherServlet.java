package control;

import model.Frequency;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Charlotte514 on 2017/6/23.
 * get hotwords from TrendSearchers.jsp,sendRedirect to TrendSearchersResult.jsp
 */
public class TrendSearcherServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String hotword=req.getParameter("hotword");
        HttpSession session=req.getSession();
        Frequency frequency=new Frequency();
        String filename=null;
        String fileURL= null;

        Map<String,Integer> counts=null;
        //错误信息置空
        session.setAttribute("wrongMsg","");
        //创建绘图用的数据集
        DefaultCategoryDataset defaultCategoryDataset=new DefaultCategoryDataset();

        //获取三十天数据(有序)
        //counts=frequency.searchAll(hotword,30);
        if(counts!=null&&counts.size()>=0) {
            //添加数据集数据
            for (Map.Entry<String, Integer> entry : counts.entrySet()) {
                //从远时间到近时间
                defaultCategoryDataset.addValue(entry.getValue(), hotword, entry.getKey());
            }
            //创建JFreeChart对象

            JFreeChart chart = ChartFactory.createLineChart(hotword + "点击率30天表",
                    "日期",
                    "点击量",
                    defaultCategoryDataset,
                    PlotOrientation.VERTICAL, true,
                    false,
                    false);
            CategoryPlot categoryPlot = chart.getCategoryPlot();

            LineAndShapeRenderer renderer = (LineAndShapeRenderer) categoryPlot.getRenderer();
            renderer.setBaseShapesVisible(true); // series 点（即数据点）可见
            renderer.setBaseLinesVisible(true); // series 点（即数据点）间有连线可见
            renderer.setUseSeriesOffset(true); // 设置偏移量
            renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
            renderer.setBaseItemLabelsVisible(true);

            //保存图片
            filename = ServletUtilities.saveChartAsJPEG(chart, 1200, 800, session);
            fileURL=req.getContextPath()+"/DisplayChart?filename="+filename;


        }else{

            session.setAttribute("wrongMsg","缺乏数据绘图。");
        }

        //URL
        session.setAttribute("fileURL",fileURL);
        session.setAttribute("filename",filename);

        //重定向

        resp.sendRedirect("../TrendSearchersResult.jsp");
    }
}
