package Demo.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.print.DocFlavor;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;

public class JsoupDemo1 {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
//      获取XML路径
        String path= URLDecoder.decode(JsoupDemo1.class.getClassLoader().getResource("Demo/Jsoup/a.xml").getPath());
//        导入XML文件到内存
        Document document = Jsoup.parse(new File(path), "GBK");
//        获取XML文件中的元素对象
        Elements name = document.getElementsByTag("name");
        System.out.println(name.size());
//根据索引获取指定对象
        Element element = name.get(0);
        String text = element.text();
        System.out.println(text);

//        parse方法的重载
        URL url = new URL("https://baike.sogou.com/v63211637.htm?fromTitle=jsoup");
        Document document1 = Jsoup.parse(url, 10000);
        System.out.println(document1);
    }
}
