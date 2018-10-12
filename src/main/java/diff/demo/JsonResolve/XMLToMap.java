package diff.demo.JsonResolve;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLToMap {


    public static Map<String, Object> getXML(File f) {
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            SAXReader reader = new SAXReader();
            Document doc = reader.read(f);
            Element root = doc.getRootElement();
            Element foo;
            for (Iterator i = root.elementIterator("param"); i.hasNext(); ) {
                foo = (Element) i.next();
                map.put(foo.elementText("key"), foo.elementText("type"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

}