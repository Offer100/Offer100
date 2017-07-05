package model; /**
 * Created by zhangk on 17-7-3.
 */
public class JobSearcherTester {
    public static void main(String []args) {
        System.out.println("into main.");
        JobSearcher jobSearcher = new JobSearcher();
        jobSearcher.search("Python工程师");
    }
}
