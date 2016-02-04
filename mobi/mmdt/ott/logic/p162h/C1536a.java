package mobi.mmdt.ott.logic.p162h;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import net.frakbot.glowpadbackport.BuildConfig;
import org.jivesoftware.smackx.xdata.FormField;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* renamed from: mobi.mmdt.ott.logic.h.a */
public class C1536a {
    public static synchronized C1538c m7759a(File file) {
        C1538c c1538c;
        synchronized (C1536a.class) {
            try {
                Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
                parse.getDocumentElement().normalize();
                Element documentElement = parse.getDocumentElement();
                String replaceAll = documentElement.getAttribute("version").replaceAll("[^0-9]", BuildConfig.FLAVOR);
                String attribute = documentElement.getAttribute("package_number");
                String attribute2 = documentElement.getAttribute("sticker_count");
                String attribute3 = documentElement.getAttribute("price");
                String attribute4 = documentElement.getAttribute("designer");
                String attribute5 = documentElement.getAttribute(FormField.ELEMENT);
                String attribute6 = documentElement.getAttribute("name");
                String attribute7 = documentElement.getAttribute("thumbnail");
                String attribute8 = documentElement.getAttribute("description");
                ArrayList arrayList = new ArrayList();
                NodeList elementsByTagName = parse.getElementsByTagName("StickerItem");
                for (int i = 0; i < elementsByTagName.getLength(); i++) {
                    Node item = elementsByTagName.item(i);
                    if (item.getNodeType() == (short) 1) {
                        Element element = (Element) item;
                        String attribute9 = element.getAttribute("sticker_number");
                        String attribute10 = element.getAttribute("ver-span");
                        String attribute11 = element.getAttribute("hor-span");
                        String attribute12 = element.getAttribute("x-axis");
                        String attribute13 = element.getAttribute("y-axis");
                        arrayList.add(new C1539d(Integer.parseInt(attribute), Integer.parseInt(attribute9), Integer.parseInt(attribute10), Integer.parseInt(attribute11), Integer.parseInt(attribute12), Integer.parseInt(attribute13), element.getElementsByTagName("original-image-name").item(0).getTextContent(), element.getElementsByTagName("thumbnail-image-name").item(0).getTextContent()));
                    }
                }
                c1538c = new C1538c(Integer.parseInt(replaceAll), Integer.parseInt(attribute), Integer.parseInt(attribute2), attribute3, attribute4, attribute5, attribute6, attribute7, attribute8, arrayList);
            } catch (Throwable e) {
                C1104b.m6364a((Object) C1536a.class, e);
                c1538c = null;
            }
        }
        return c1538c;
    }
}
