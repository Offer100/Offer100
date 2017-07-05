package model; /**
 * Created by zhangk on 17-6-30.
 */

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.JiebaSegmenter.SegMode;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class JobSearcher {
    private class WordIndex {
        public int id;
        public String word, indexList;
    }

    private Map<String, String> wordIndexMap = new HashMap<>();

    public JobSearcher() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/offer100";
        Connection conn;
        try {
            conn = DriverManager.getConnection(url, "root", "mayapril1996");
            Statement statement = conn.createStatement();
            String sql = "select * from index_table";
            ResultSet result = statement.executeQuery(sql);
            wordIndexMap.clear();
            while (result.next()) {
                WordIndex wordIndex = new WordIndex();
                wordIndex.id = result.getInt(1);
                wordIndex.word = result.getString(2);
                wordIndex.indexList = result.getString(3);
                wordIndexMap.put(wordIndex.word, wordIndex.indexList);
            }
            System.out.println(wordIndexMap.size());
            result.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private int[] turnIndexArray(String indexStr) {
        String[] indexStringArray = indexStr.split(",");
        int[] indexIntArray = new int[50];
        int i = 0;
        for (String index: indexStringArray) {
            indexIntArray[i++] = Integer.valueOf(index).intValue();
            if (i == 50) {
                break;
            }
        }
        return indexIntArray;
    }

    public int[] search(String input) {
        int[] result = new int[1000];
        String[] wordList = new String[50];
        JiebaSegmenter segmenter = new JiebaSegmenter();
        String wordString = segmenter.process(input, SegMode.SEARCH).toString();
        int index_n = 0;
        int word_s;
        int word_t = 1;
        int i = 0;
        while (true) {
            word_s = wordString.indexOf('[', word_t);
            if (word_s == -1) {
                break;
            }
            word_t = wordString.indexOf(',', word_s);
            String word = wordString.substring(word_s + 1, word_t);
            wordList[i++] = word;
//            Frequency myFrequency = new Frequency();
//            myFrequency.update(word, null);
            if (this.wordIndexMap.containsKey(word)) {
                int[] indexIntArray = turnIndexArray(this.wordIndexMap.get(word));
                for (int index: indexIntArray) {
                    boolean flag = true;
                    for (int num : result) {
                        if (num == index) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        result[index_n++] = index;
                    }
                    if (index_n == 1000) {
                        break;
                    }
                }
            }
            if (index_n == 1000) {
                break;
            }
        }
        return result;
    }
}


