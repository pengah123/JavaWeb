package Demo.Jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;
/*Xpath*/
public class JsoupDemo3 {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, XpathSyntaxErrorException {
//      获取XML路径
        String path= URLDecoder.decode(JsoupDemo3.class.getClassLoader().getResource("Demo/Jsoup/a.xml").getPath());
//        导入XML文件到内存
        Document document = Jsoup.parse(new File(path), "GBK");
//        获取jxDocument对象，只有这个对象才能使用xpath语法
        JXDocument jxDocument = new JXDocument(document);

//        获取页面所有student标签对象
        List<JXNode> jxNodes = jxDocument.selN("//student/name");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
            System.out.println("====================");
        }
//       获取具有某种属性的标签
        List<JXNode> jxNodes1 = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode : jxNodes1) {
            System.out.println(jxNode);
            System.out.println("====================");
        }
    }
}
