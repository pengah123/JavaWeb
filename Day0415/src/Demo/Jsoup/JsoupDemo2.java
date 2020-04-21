package Demo.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;

public class JsoupDemo2 {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
//      获取XML路径
        String path= URLDecoder.decode(JsoupDemo2.class.getClassLoader().getResource("Demo/Jsoup/a.xml").getPath());
//        导入XML文件到内存
        Document document = Jsoup.parse(new File(path), "GBK");
//        获取XML文件中的元素对象
        Elements name = document.getElementsByTag("name");
//        获取第一个student标签
        Element student1 = document.getElementsByTag("Student").get(0);
//        获取student1中的所有name标签
        Elements name1 = student1.getElementsByTag("name");
//        attr方法
        String number = student1.attr("numbeR");
        System.out.println(number);
//        text和html方法
        String text = student1.text();
        String html = student1.html();
        System.out.println(text);
        System.out.println("===============================");
        System.out.println(html);
        System.out.println("===============================");

//
        Elements ans = document.select("student[number=001]>age");
        System.out.println(ans);

    }
}
