package com.p063b.p064a;

import android.graphics.Matrix;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import javax.xml.parsers.SAXParserFactory;
import mobi.mmdt.ott.C1317h;
import net.frakbot.glowpadbackport.BuildConfig;
import org.apache.http.myHttp.HttpStatus;
import org.apache.http.myHttp.protocol.HTTP;
import org.apache.http.myHttp.util.LangUtils;
import org.jivesoftware.smack.tcp.XMPPTCPConnection.PacketWriter;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager;
import org.jivesoftware.smackx.privacy.packet.PrivacyItem;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout.Text;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import org.linphone.core.Privacy;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;

/* renamed from: com.b.a.cp */
public class cp extends DefaultHandler2 {
    protected static HashSet<String> f3448a;
    private static HashMap<String, Integer> f3449l;
    private static HashMap<String, ac> f3450m;
    private static HashMap<String, Integer> f3451n;
    private static HashMap<String, at> f3452o;
    private static HashMap<String, C0927l> f3453p;
    private static /* synthetic */ int[] f3454q;
    private C0929n f3455b;
    private be f3456c;
    private boolean f3457d;
    private int f3458e;
    private boolean f3459f;
    private String f3460g;
    private StringBuilder f3461h;
    private boolean f3462i;
    private StringBuilder f3463j;
    private HashSet<String> f3464k;

    static {
        f3449l = new HashMap();
        f3450m = new HashMap(9);
        f3451n = new HashMap(13);
        f3452o = new HashMap(3);
        f3453p = new HashMap();
        f3448a = new HashSet();
        f3449l.put("aliceblue", Integer.valueOf(15792383));
        f3449l.put("antiquewhite", Integer.valueOf(16444375));
        f3449l.put("aqua", Integer.valueOf(InBandBytestreamManager.MAXIMUM_BLOCK_SIZE));
        f3449l.put("aquamarine", Integer.valueOf(8388564));
        f3449l.put("azure", Integer.valueOf(15794175));
        f3449l.put("beige", Integer.valueOf(16119260));
        f3449l.put("bisque", Integer.valueOf(16770244));
        f3449l.put("black", Integer.valueOf(0));
        f3449l.put("blanchedalmond", Integer.valueOf(16772045));
        f3449l.put("blue", Integer.valueOf(255));
        f3449l.put("blueviolet", Integer.valueOf(9055202));
        f3449l.put("brown", Integer.valueOf(10824234));
        f3449l.put("burlywood", Integer.valueOf(14596231));
        f3449l.put("cadetblue", Integer.valueOf(6266528));
        f3449l.put("chartreuse", Integer.valueOf(8388352));
        f3449l.put("chocolate", Integer.valueOf(13789470));
        f3449l.put("coral", Integer.valueOf(16744272));
        f3449l.put("cornflowerblue", Integer.valueOf(6591981));
        f3449l.put("cornsilk", Integer.valueOf(16775388));
        f3449l.put("crimson", Integer.valueOf(14423100));
        f3449l.put("cyan", Integer.valueOf(InBandBytestreamManager.MAXIMUM_BLOCK_SIZE));
        f3449l.put("darkblue", Integer.valueOf(139));
        f3449l.put("darkcyan", Integer.valueOf(35723));
        f3449l.put("darkgoldenrod", Integer.valueOf(12092939));
        f3449l.put("darkgray", Integer.valueOf(11119017));
        f3449l.put("darkgreen", Integer.valueOf(25600));
        f3449l.put("darkgrey", Integer.valueOf(11119017));
        f3449l.put("darkkhaki", Integer.valueOf(12433259));
        f3449l.put("darkmagenta", Integer.valueOf(9109643));
        f3449l.put("darkolivegreen", Integer.valueOf(5597999));
        f3449l.put("darkorange", Integer.valueOf(16747520));
        f3449l.put("darkorchid", Integer.valueOf(10040012));
        f3449l.put("darkred", Integer.valueOf(9109504));
        f3449l.put("darksalmon", Integer.valueOf(15308410));
        f3449l.put("darkseagreen", Integer.valueOf(9419919));
        f3449l.put("darkslateblue", Integer.valueOf(4734347));
        f3449l.put("darkslategray", Integer.valueOf(3100495));
        f3449l.put("darkslategrey", Integer.valueOf(3100495));
        f3449l.put("darkturquoise", Integer.valueOf(52945));
        f3449l.put("darkviolet", Integer.valueOf(9699539));
        f3449l.put("deeppink", Integer.valueOf(16716947));
        f3449l.put("deepskyblue", Integer.valueOf(49151));
        f3449l.put("dimgray", Integer.valueOf(6908265));
        f3449l.put("dimgrey", Integer.valueOf(6908265));
        f3449l.put("dodgerblue", Integer.valueOf(2003199));
        f3449l.put("firebrick", Integer.valueOf(11674146));
        f3449l.put("floralwhite", Integer.valueOf(16775920));
        f3449l.put("forestgreen", Integer.valueOf(2263842));
        f3449l.put("fuchsia", Integer.valueOf(16711935));
        f3449l.put("gainsboro", Integer.valueOf(14474460));
        f3449l.put("ghostwhite", Integer.valueOf(16316671));
        f3449l.put("gold", Integer.valueOf(16766720));
        f3449l.put("goldenrod", Integer.valueOf(14329120));
        f3449l.put("gray", Integer.valueOf(8421504));
        f3449l.put("green", Integer.valueOf(Privacy.DEFAULT));
        f3449l.put("greenyellow", Integer.valueOf(11403055));
        f3449l.put("grey", Integer.valueOf(8421504));
        f3449l.put("honeydew", Integer.valueOf(15794160));
        f3449l.put("hotpink", Integer.valueOf(16738740));
        f3449l.put("indianred", Integer.valueOf(13458524));
        f3449l.put("indigo", Integer.valueOf(4915330));
        f3449l.put("ivory", Integer.valueOf(16777200));
        f3449l.put("khaki", Integer.valueOf(15787660));
        f3449l.put("lavender", Integer.valueOf(15132410));
        f3449l.put("lavenderblush", Integer.valueOf(16773365));
        f3449l.put("lawngreen", Integer.valueOf(8190976));
        f3449l.put("lemonchiffon", Integer.valueOf(16775885));
        f3449l.put("lightblue", Integer.valueOf(11393254));
        f3449l.put("lightcoral", Integer.valueOf(15761536));
        f3449l.put("lightcyan", Integer.valueOf(14745599));
        f3449l.put("lightgoldenrodyellow", Integer.valueOf(16448210));
        f3449l.put("lightgray", Integer.valueOf(13882323));
        f3449l.put("lightgreen", Integer.valueOf(9498256));
        f3449l.put("lightgrey", Integer.valueOf(13882323));
        f3449l.put("lightpink", Integer.valueOf(16758465));
        f3449l.put("lightsalmon", Integer.valueOf(16752762));
        f3449l.put("lightseagreen", Integer.valueOf(2142890));
        f3449l.put("lightskyblue", Integer.valueOf(8900346));
        f3449l.put("lightslategray", Integer.valueOf(7833753));
        f3449l.put("lightslategrey", Integer.valueOf(7833753));
        f3449l.put("lightsteelblue", Integer.valueOf(11584734));
        f3449l.put("lightyellow", Integer.valueOf(16777184));
        f3449l.put("lime", Integer.valueOf(65280));
        f3449l.put("limegreen", Integer.valueOf(3329330));
        f3449l.put("linen", Integer.valueOf(16445670));
        f3449l.put("magenta", Integer.valueOf(16711935));
        f3449l.put("maroon", Integer.valueOf(8388608));
        f3449l.put("mediumaquamarine", Integer.valueOf(6737322));
        f3449l.put("mediumblue", Integer.valueOf(HttpStatus.SC_RESET_CONTENT));
        f3449l.put("mediumorchid", Integer.valueOf(12211667));
        f3449l.put("mediumpurple", Integer.valueOf(9662683));
        f3449l.put("mediumseagreen", Integer.valueOf(3978097));
        f3449l.put("mediumslateblue", Integer.valueOf(8087790));
        f3449l.put("mediumspringgreen", Integer.valueOf(64154));
        f3449l.put("mediumturquoise", Integer.valueOf(4772300));
        f3449l.put("mediumvioletred", Integer.valueOf(13047173));
        f3449l.put("midnightblue", Integer.valueOf(1644912));
        f3449l.put("mintcream", Integer.valueOf(16121850));
        f3449l.put("mistyrose", Integer.valueOf(16770273));
        f3449l.put("moccasin", Integer.valueOf(16770229));
        f3449l.put("navajowhite", Integer.valueOf(16768685));
        f3449l.put("navy", Integer.valueOf(128));
        f3449l.put("oldlace", Integer.valueOf(16643558));
        f3449l.put("olive", Integer.valueOf(8421376));
        f3449l.put("olivedrab", Integer.valueOf(7048739));
        f3449l.put("orange", Integer.valueOf(16753920));
        f3449l.put("orangered", Integer.valueOf(16729344));
        f3449l.put("orchid", Integer.valueOf(14315734));
        f3449l.put("palegoldenrod", Integer.valueOf(15657130));
        f3449l.put("palegreen", Integer.valueOf(10025880));
        f3449l.put("paleturquoise", Integer.valueOf(11529966));
        f3449l.put("palevioletred", Integer.valueOf(14381203));
        f3449l.put("papayawhip", Integer.valueOf(16773077));
        f3449l.put("peachpuff", Integer.valueOf(16767673));
        f3449l.put("peru", Integer.valueOf(13468991));
        f3449l.put("pink", Integer.valueOf(16761035));
        f3449l.put("plum", Integer.valueOf(14524637));
        f3449l.put("powderblue", Integer.valueOf(11591910));
        f3449l.put("purple", Integer.valueOf(8388736));
        f3449l.put("red", Integer.valueOf(16711680));
        f3449l.put("rosybrown", Integer.valueOf(12357519));
        f3449l.put("royalblue", Integer.valueOf(4286945));
        f3449l.put("saddlebrown", Integer.valueOf(9127187));
        f3449l.put("salmon", Integer.valueOf(16416882));
        f3449l.put("sandybrown", Integer.valueOf(16032864));
        f3449l.put("seagreen", Integer.valueOf(3050327));
        f3449l.put("seashell", Integer.valueOf(16774638));
        f3449l.put("sienna", Integer.valueOf(10506797));
        f3449l.put("silver", Integer.valueOf(12632256));
        f3449l.put("skyblue", Integer.valueOf(8900331));
        f3449l.put("slateblue", Integer.valueOf(6970061));
        f3449l.put("slategray", Integer.valueOf(7372944));
        f3449l.put("slategrey", Integer.valueOf(7372944));
        f3449l.put("snow", Integer.valueOf(16775930));
        f3449l.put("springgreen", Integer.valueOf(65407));
        f3449l.put("steelblue", Integer.valueOf(4620980));
        f3449l.put("tan", Integer.valueOf(13808780));
        f3449l.put("teal", Integer.valueOf(32896));
        f3449l.put("thistle", Integer.valueOf(14204888));
        f3449l.put("tomato", Integer.valueOf(16737095));
        f3449l.put("turquoise", Integer.valueOf(4251856));
        f3449l.put("violet", Integer.valueOf(15631086));
        f3449l.put("wheat", Integer.valueOf(16113331));
        f3449l.put("white", Integer.valueOf(16777215));
        f3449l.put("whitesmoke", Integer.valueOf(16119285));
        f3449l.put("yellow", Integer.valueOf(16776960));
        f3449l.put("yellowgreen", Integer.valueOf(10145074));
        f3450m.put("xx-small", new ac(0.694f, by.pt));
        f3450m.put("x-small", new ac(0.833f, by.pt));
        f3450m.put("small", new ac(10.0f, by.pt));
        f3450m.put("medium", new ac(12.0f, by.pt));
        f3450m.put("large", new ac(14.4f, by.pt));
        f3450m.put("x-large", new ac(17.3f, by.pt));
        f3450m.put("xx-large", new ac(20.7f, by.pt));
        f3450m.put("smaller", new ac(83.33f, by.percent));
        f3450m.put("larger", new ac(120.0f, by.percent));
        f3451n.put("normal", Integer.valueOf(HttpStatus.SC_BAD_REQUEST));
        f3451n.put("bold", Integer.valueOf(700));
        f3451n.put("bolder", Integer.valueOf(1));
        f3451n.put("lighter", Integer.valueOf(-1));
        f3451n.put("100", Integer.valueOf(100));
        f3451n.put("200", Integer.valueOf(HttpStatus.SC_OK));
        f3451n.put("300", Integer.valueOf(HttpStatus.SC_MULTIPLE_CHOICES));
        f3451n.put("400", Integer.valueOf(HttpStatus.SC_BAD_REQUEST));
        f3451n.put("500", Integer.valueOf(PacketWriter.QUEUE_SIZE));
        f3451n.put("600", Integer.valueOf(600));
        f3451n.put("700", Integer.valueOf(700));
        f3451n.put("800", Integer.valueOf(800));
        f3451n.put("900", Integer.valueOf(900));
        f3452o.put("normal", at.Normal);
        f3452o.put("italic", at.Italic);
        f3452o.put("oblique", at.Oblique);
        f3453p.put(PrivacyItem.SUBSCRIPTION_NONE, C0927l.None);
        f3453p.put("xMinYMin", C0927l.XMinYMin);
        f3453p.put("xMidYMin", C0927l.XMidYMin);
        f3453p.put("xMaxYMin", C0927l.XMaxYMin);
        f3453p.put("xMinYMid", C0927l.XMinYMid);
        f3453p.put("xMidYMid", C0927l.XMidYMid);
        f3453p.put("xMaxYMid", C0927l.XMaxYMid);
        f3453p.put("xMinYMax", C0927l.XMinYMax);
        f3453p.put("xMidYMax", C0927l.XMidYMax);
        f3453p.put("xMaxYMax", C0927l.XMaxYMax);
        f3448a.add("Structure");
        f3448a.add("BasicStructure");
        f3448a.add("ConditionalProcessing");
        f3448a.add("Image");
        f3448a.add("Style");
        f3448a.add("ViewportAttribute");
        f3448a.add("Shape");
        f3448a.add("BasicText");
        f3448a.add("PaintAttribute");
        f3448a.add("BasicPaintAttribute");
        f3448a.add("OpacityAttribute");
        f3448a.add("BasicGraphicsAttribute");
        f3448a.add("Marker");
        f3448a.add("Gradient");
        f3448a.add("Pattern");
        f3448a.add("Clip");
        f3448a.add("BasicClip");
        f3448a.add("Mask");
        f3448a.add("View");
    }

    public cp() {
        this.f3455b = null;
        this.f3456c = null;
        this.f3457d = false;
        this.f3459f = false;
        this.f3460g = null;
        this.f3461h = null;
        this.f3462i = false;
        this.f3463j = null;
        this.f3464k = null;
    }

    private static Set<String> m5649A(String str) {
        cr crVar = new cr(str);
        Set hashSet = new HashSet();
        while (!crVar.m5750c()) {
            String m = crVar.m5760m();
            int indexOf = m.indexOf(45);
            if (indexOf != -1) {
                m = m.substring(0, indexOf);
            }
            hashSet.add(new Locale(m, BuildConfig.FLAVOR, BuildConfig.FLAVOR).getLanguage());
            crVar.m5751d();
        }
        return hashSet;
    }

    private void m5650A(Attributes attributes) {
        m5685a("<mask>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        af afVar = new af();
        afVar.u = this.f3455b;
        afVar.v = this.f3456c;
        m5672a((bg) afVar, attributes);
        m5691b((bg) afVar, attributes);
        m5670a((bb) afVar, attributes);
        m5661a(afVar, attributes);
        this.f3456c.m5445a(afVar);
        this.f3456c = afVar;
    }

    private static Set<String> m5651B(String str) {
        cr crVar = new cr(str);
        Set hashSet = new HashSet();
        while (!crVar.m5750c()) {
            hashSet.add(crVar.m5760m());
            crVar.m5751d();
        }
        return hashSet;
    }

    private void m5652B(Attributes attributes) {
        m5685a("<style>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        int i = 0;
        boolean z = true;
        String str = "all";
        while (i < attributes.getLength()) {
            boolean z2;
            String trim = attributes.getValue(i).trim();
            switch (cp.m5687a()[cq.m5742a(attributes.getLocalName(i)).ordinal()]) {
                case C1317h.Theme_actionModePopupWindowStyle /*39*/:
                    str = trim;
                    z2 = z;
                    break;
                case C1317h.Theme_panelBackground /*78*/:
                    z2 = trim.equals("text/css");
                    break;
                default:
                    z2 = z;
                    break;
            }
            i++;
            z = z2;
        }
        if (z && C0913a.m5424a(r0, C0921f.screen)) {
            this.f3462i = true;
            return;
        }
        this.f3457d = true;
        this.f3458e = 1;
    }

    private void m5653C(String str) {
        this.f3455b.m5797a(new C0913a(C0921f.screen).m5432a(str));
    }

    private static int m5654a(cr crVar) {
        int i = 0;
        int intValue = crVar.m5755h().intValue();
        if (!crVar.m5745a('%')) {
            return intValue >= 0 ? intValue > 255 ? 255 : intValue : 0;
        } else {
            if (intValue >= 0) {
                i = intValue > 100 ? 100 : intValue;
            }
            return (i * 255) / 100;
        }
    }

    protected static ac m5655a(String str) {
        if (str.length() == 0) {
            throw new SAXException("Invalid length value (empty string)");
        }
        int length = str.length();
        by byVar = by.px;
        char charAt = str.charAt(length - 1);
        if (charAt == '%') {
            length--;
            byVar = by.percent;
        } else if (length > 2 && Character.isLetter(charAt) && Character.isLetter(str.charAt(length - 2))) {
            length -= 2;
            try {
                byVar = by.valueOf(str.substring(length).toLowerCase(Locale.US));
            } catch (IllegalArgumentException e) {
                throw new SAXException("Invalid length unit specifier: " + str);
            }
        }
        try {
            return new ac(Float.parseFloat(str.substring(0, length)), byVar);
        } catch (Exception e2) {
            throw new SAXException("Invalid length value: " + str, e2);
        }
    }

    private static bj m5656a(String str, String str2) {
        if (!str.startsWith("url(")) {
            return cp.m5703h(str);
        }
        int indexOf = str.indexOf(")");
        if (indexOf == -1) {
            throw new SAXException("Bad " + str2 + " attribute. Unterminated url() reference");
        }
        String trim = str.substring(4, indexOf).trim();
        bj bjVar = null;
        String trim2 = str.substring(indexOf + 1).trim();
        if (trim2.length() > 0) {
            bjVar = cp.m5703h(trim2);
        }
        return new ah(trim, bjVar);
    }

    private void m5657a(aa aaVar, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (cq.m5742a(attributes.getLocalName(i)) == cq.transform) {
                aaVar.m5433a(m5693c(attributes.getValue(i)));
            }
        }
    }

    private void m5658a(ab abVar, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (cp.m5687a()[cq.m5742a(attributes.getLocalName(i)).ordinal()]) {
                case C1317h.Theme_actionMenuTextColor /*26*/:
                    abVar.f3213e = cp.m5655a(trim);
                    if (!abVar.f3213e.m5467c()) {
                        break;
                    }
                    throw new SAXException("Invalid <use> element. height cannot be negative");
                case C1317h.Theme_actionModeStyle /*27*/:
                    if (!"http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        break;
                    }
                    abVar.f3209a = trim;
                    break;
                case C1317h.Theme_actionButtonStyle /*49*/:
                    cp.m5674a((bk) abVar, trim);
                    break;
                case C1317h.Theme_colorPrimary /*82*/:
                    abVar.f3212d = cp.m5655a(trim);
                    if (!abVar.f3212d.m5467c()) {
                        break;
                    }
                    throw new SAXException("Invalid <use> element. width cannot be negative");
                case C1317h.Theme_colorPrimaryDark /*83*/:
                    abVar.f3210b = cp.m5655a(trim);
                    break;
                case C1317h.Theme_colorAccent /*84*/:
                    abVar.f3211c = cp.m5655a(trim);
                    break;
                default:
                    break;
            }
        }
    }

    private void m5659a(ad adVar, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (cp.m5687a()[cq.m5742a(attributes.getLocalName(i)).ordinal()]) {
                case C1317h.Theme_colorControlNormal /*85*/:
                    adVar.f3224a = cp.m5655a(trim);
                    break;
                case C1317h.Theme_colorControlActivated /*86*/:
                    adVar.f3225b = cp.m5655a(trim);
                    break;
                case C1317h.Theme_colorControlHighlight /*87*/:
                    adVar.f3226c = cp.m5655a(trim);
                    break;
                case C1317h.Theme_colorButtonNormal /*88*/:
                    adVar.f3227d = cp.m5655a(trim);
                    break;
                default:
                    break;
            }
        }
    }

    private void m5660a(ae aeVar, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (cp.m5687a()[cq.m5742a(attributes.getLocalName(i)).ordinal()]) {
                case C1317h.Theme_actionModeCopyDrawable /*33*/:
                    aeVar.f3233e = cp.m5655a(trim);
                    if (!aeVar.f3233e.m5467c()) {
                        break;
                    }
                    throw new SAXException("Invalid <marker> element. markerHeight cannot be negative");
                case C1317h.Theme_actionModePasteDrawable /*34*/:
                    if ("strokeWidth".equals(trim)) {
                        aeVar.f3229a = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        aeVar.f3229a = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute markerUnits");
                    }
                case C1317h.Theme_actionModeSelectAllDrawable /*35*/:
                    aeVar.f3232d = cp.m5655a(trim);
                    if (!aeVar.f3232d.m5467c()) {
                        break;
                    }
                    throw new SAXException("Invalid <marker> element. markerWidth cannot be negative");
                case C1317h.Theme_dialogTheme /*42*/:
                    if (!"auto".equals(trim)) {
                        aeVar.f3234f = Float.valueOf(cp.m5697e(trim));
                        break;
                    } else {
                        aeVar.f3234f = Float.valueOf(Float.NaN);
                        break;
                    }
                case C1317h.Theme_buttonBarButtonStyle /*51*/:
                    aeVar.f3230b = cp.m5655a(trim);
                    break;
                case C1317h.Theme_selectableItemBackground /*52*/:
                    aeVar.f3231c = cp.m5655a(trim);
                    break;
                default:
                    break;
            }
        }
    }

    private void m5661a(af afVar, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (cp.m5687a()[cq.m5742a(attributes.getLocalName(i)).ordinal()]) {
                case C1317h.Theme_actionMenuTextColor /*26*/:
                    afVar.f3240f = cp.m5655a(trim);
                    if (!afVar.f3240f.m5467c()) {
                        break;
                    }
                    throw new SAXException("Invalid <mask> element. height cannot be negative");
                case LangUtils.HASH_OFFSET /*37*/:
                    if ("objectBoundingBox".equals(trim)) {
                        afVar.f3236b = Boolean.valueOf(false);
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        afVar.f3236b = Boolean.valueOf(true);
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute maskContentUnits");
                    }
                case C1317h.Theme_actionModeWebSearchDrawable /*38*/:
                    if ("objectBoundingBox".equals(trim)) {
                        afVar.f3235a = Boolean.valueOf(false);
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        afVar.f3235a = Boolean.valueOf(true);
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute maskUnits");
                    }
                case C1317h.Theme_colorPrimary /*82*/:
                    afVar.f3239e = cp.m5655a(trim);
                    if (!afVar.f3239e.m5467c()) {
                        break;
                    }
                    throw new SAXException("Invalid <mask> element. width cannot be negative");
                case C1317h.Theme_colorPrimaryDark /*83*/:
                    afVar.f3237c = cp.m5655a(trim);
                    break;
                case C1317h.Theme_colorAccent /*84*/:
                    afVar.f3238d = cp.m5655a(trim);
                    break;
                default:
                    break;
            }
        }
    }

    private void m5662a(ai aiVar, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (cp.m5687a()[cq.m5742a(attributes.getLocalName(i)).ordinal()]) {
                case Version.API14_ICE_CREAM_SANDWICH_40 /*14*/:
                    aiVar.f3243a = cp.m5737y(trim);
                    break;
                case C1317h.Theme_listDividerAlertDialog /*44*/:
                    aiVar.f3244b = Float.valueOf(cp.m5697e(trim));
                    if (aiVar.f3244b.floatValue() >= 0.0f) {
                        break;
                    }
                    throw new SAXException("Invalid <path> element. pathLength cannot be negative");
                default:
                    break;
            }
        }
    }

    private void m5663a(al alVar, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (cp.m5687a()[cq.m5742a(attributes.getLocalName(i)).ordinal()]) {
                case C1317h.Theme_actionMenuTextColor /*26*/:
                    alVar.f3253g = cp.m5655a(trim);
                    if (!alVar.f3253g.m5467c()) {
                        break;
                    }
                    throw new SAXException("Invalid <pattern> element. height cannot be negative");
                case C1317h.Theme_actionModeStyle /*27*/:
                    if (!"http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        break;
                    }
                    alVar.f3254h = trim;
                    break;
                case C1317h.Theme_actionDropDownStyle /*45*/:
                    if ("objectBoundingBox".equals(trim)) {
                        alVar.f3248b = Boolean.valueOf(false);
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        alVar.f3248b = Boolean.valueOf(true);
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute patternContentUnits");
                    }
                case C1317h.Theme_dropdownListPreferredItemHeight /*46*/:
                    alVar.f3249c = m5693c(trim);
                    break;
                case C1317h.Theme_spinnerDropDownItemStyle /*47*/:
                    if ("objectBoundingBox".equals(trim)) {
                        alVar.f3247a = Boolean.valueOf(false);
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        alVar.f3247a = Boolean.valueOf(true);
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute patternUnits");
                    }
                case C1317h.Theme_colorPrimary /*82*/:
                    alVar.f3252f = cp.m5655a(trim);
                    if (!alVar.f3252f.m5467c()) {
                        break;
                    }
                    throw new SAXException("Invalid <pattern> element. width cannot be negative");
                case C1317h.Theme_colorPrimaryDark /*83*/:
                    alVar.f3250d = cp.m5655a(trim);
                    break;
                case C1317h.Theme_colorAccent /*84*/:
                    alVar.f3251e = cp.m5655a(trim);
                    break;
                default:
                    break;
            }
        }
    }

    private void m5664a(am amVar, Attributes attributes, String str) {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (cq.m5742a(attributes.getLocalName(i)) == cq.points) {
                cr crVar = new cr(attributes.getValue(i));
                List<Float> arrayList = new ArrayList();
                crVar.m5751d();
                while (!crVar.m5750c()) {
                    Float f = crVar.m5753f();
                    if (f == null) {
                        throw new SAXException("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                    }
                    crVar.m5752e();
                    Float f2 = crVar.m5753f();
                    if (f2 == null) {
                        throw new SAXException("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                    }
                    crVar.m5752e();
                    arrayList.add(f);
                    arrayList.add(f2);
                }
                amVar.f3255a = new float[arrayList.size()];
                int i2 = 0;
                for (Float floatValue : arrayList) {
                    int i3 = i2 + 1;
                    amVar.f3255a[i2] = floatValue.floatValue();
                    i2 = i3;
                }
            }
        }
    }

    private void m5665a(ao aoVar, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (cp.m5687a()[cq.m5742a(attributes.getLocalName(i)).ordinal()]) {
                case C1317h.Theme_actionMenuTextColor /*26*/:
                    aoVar.f3259d = cp.m5655a(trim);
                    if (!aoVar.f3259d.m5467c()) {
                        break;
                    }
                    throw new SAXException("Invalid <rect> element. height cannot be negative");
                case C1317h.Theme_activityChooserViewStyle /*57*/:
                    aoVar.f3260f = cp.m5655a(trim);
                    if (!aoVar.f3260f.m5467c()) {
                        break;
                    }
                    throw new SAXException("Invalid <rect> element. rx cannot be negative");
                case C1317h.Theme_toolbarStyle /*58*/:
                    aoVar.f3261g = cp.m5655a(trim);
                    if (!aoVar.f3261g.m5467c()) {
                        break;
                    }
                    throw new SAXException("Invalid <rect> element. ry cannot be negative");
                case C1317h.Theme_colorPrimary /*82*/:
                    aoVar.f3258c = cp.m5655a(trim);
                    if (!aoVar.f3258c.m5467c()) {
                        break;
                    }
                    throw new SAXException("Invalid <rect> element. width cannot be negative");
                case C1317h.Theme_colorPrimaryDark /*83*/:
                    aoVar.f3256a = cp.m5655a(trim);
                    break;
                case C1317h.Theme_colorAccent /*84*/:
                    aoVar.f3257b = cp.m5655a(trim);
                    break;
                default:
                    break;
            }
        }
    }

    private void m5666a(aq aqVar, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (cp.m5687a()[cq.m5742a(attributes.getLocalName(i)).ordinal()]) {
                case C1317h.Theme_textAppearanceLargePopupMenu /*40*/:
                    aqVar.f3262a = m5689b(trim);
                    break;
                default:
                    break;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m5667a(com.p063b.p064a.ar r7, java.lang.String r8) {
        /*
        r4 = 124; // 0x7c float:1.74E-43 double:6.13E-322;
        r6 = 47;
        r0 = 0;
        r1 = "|caption|icon|menu|message-box|small-caption|status-bar|";
        r2 = new java.lang.StringBuilder;
        r3 = java.lang.String.valueOf(r4);
        r2.<init>(r3);
        r2 = r2.append(r8);
        r2 = r2.append(r4);
        r2 = r2.toString();
        r1 = r1.indexOf(r2);
        r2 = -1;
        if (r1 == r2) goto L_0x0024;
    L_0x0023:
        return;
    L_0x0024:
        r5 = new com.b.a.cr;
        r5.<init>(r8);
        r1 = r0;
        r3 = r0;
    L_0x002b:
        r2 = r5.m5748b(r6);
        r5.m5751d();
        if (r2 != 0) goto L_0x003c;
    L_0x0034:
        r0 = new org.xml.sax.SAXException;
        r1 = "Invalid font style attribute: missing font size and family";
        r0.<init>(r1);
        throw r0;
    L_0x003c:
        if (r0 == 0) goto L_0x005d;
    L_0x003e:
        if (r3 == 0) goto L_0x005d;
    L_0x0040:
        r4 = r0;
        r0 = r3;
    L_0x0042:
        r1 = com.p063b.p064a.cp.m5711l(r2);
        r2 = r5.m5745a(r6);
        if (r2 == 0) goto L_0x0096;
    L_0x004c:
        r5.m5751d();
        r2 = r5.m5760m();
        if (r2 != 0) goto L_0x0090;
    L_0x0055:
        r0 = new org.xml.sax.SAXException;
        r1 = "Invalid font style attribute: missing line-height";
        r0.<init>(r1);
        throw r0;
    L_0x005d:
        r4 = "normal";
        r4 = r2.equals(r4);
        if (r4 != 0) goto L_0x002b;
    L_0x0065:
        if (r0 != 0) goto L_0x0071;
    L_0x0067:
        r0 = f3451n;
        r0 = r0.get(r2);
        r0 = (java.lang.Integer) r0;
        if (r0 != 0) goto L_0x002b;
    L_0x0071:
        r4 = r0;
        if (r3 != 0) goto L_0x0081;
    L_0x0074:
        r0 = f3452o;
        r0 = r0.get(r2);
        r0 = (com.p063b.p064a.at) r0;
        if (r0 == 0) goto L_0x0082;
    L_0x007e:
        r3 = r0;
        r0 = r4;
        goto L_0x002b;
    L_0x0081:
        r0 = r3;
    L_0x0082:
        if (r1 != 0) goto L_0x0042;
    L_0x0084:
        r1 = "small-caps";
        r1 = r2.equals(r1);
        if (r1 == 0) goto L_0x0042;
    L_0x008c:
        r1 = r2;
        r3 = r0;
        r0 = r4;
        goto L_0x002b;
    L_0x0090:
        com.p063b.p064a.cp.m5655a(r2);
        r5.m5751d();
    L_0x0096:
        r2 = r5.m5766s();
        r2 = com.p063b.p064a.cp.m5709k(r2);
        r7.f3289o = r2;
        r7.f3290p = r1;
        if (r4 != 0) goto L_0x00bc;
    L_0x00a4:
        r1 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
    L_0x00a6:
        r1 = java.lang.Integer.valueOf(r1);
        r7.f3291q = r1;
        if (r0 != 0) goto L_0x00b0;
    L_0x00ae:
        r0 = com.p063b.p064a.at.Normal;
    L_0x00b0:
        r7.f3292r = r0;
        r0 = r7.f3275a;
        r2 = 122880; // 0x1e000 float:1.72192E-40 double:6.0711E-319;
        r0 = r0 | r2;
        r7.f3275a = r0;
        goto L_0x0023;
    L_0x00bc:
        r1 = r4.intValue();
        goto L_0x00a6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.cp.a(com.b.a.ar, java.lang.String):void");
    }

    protected static void m5668a(ar arVar, String str, String str2) {
        if (str2.length() != 0 && !str2.equals("inherit")) {
            switch (cp.m5687a()[cq.m5742a(str).ordinal()]) {
                case VideoSize.HVGA /*2*/:
                    arVar.f3297w = cp.m5733w(str2);
                    arVar.f3275a |= 1048576;
                case Version.API03_CUPCAKE_15 /*3*/:
                    arVar.f3267E = cp.m5690b(str2, str);
                    arVar.f3275a |= 268435456;
                case Version.API05_ECLAIR_20 /*5*/:
                    arVar.f3268F = cp.m5721q(str2);
                    arVar.f3275a |= 536870912;
                case Version.API06_ECLAIR_201 /*6*/:
                    arVar.f3288n = cp.m5705i(str2);
                    arVar.f3275a |= 4096;
                case Version.API09_GINGERBREAD_23 /*9*/:
                    arVar.f3294t = cp.m5719p(str2);
                    arVar.f3275a |= 68719476736L;
                case Version.API15_ICE_CREAM_SANDWICH_403 /*15*/:
                    if (str2.indexOf(124) >= 0 || "|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".indexOf(new StringBuilder(String.valueOf('|')).append(str2).append('|').toString()) == -1) {
                        throw new SAXException("Invalid value for \"display\" attribute: " + str2);
                    }
                    arVar.f3263A = Boolean.valueOf(!str2.equals(PrivacyItem.SUBSCRIPTION_NONE));
                    arVar.f3275a |= 16777216;
                case Version.API16_JELLY_BEAN_41 /*16*/:
                    arVar.f3276b = cp.m5656a(str2, "fill");
                    arVar.f3275a |= 1;
                case Version.API17_JELLY_BEAN_42 /*17*/:
                    arVar.f3277c = cp.m5721q(str2);
                    arVar.f3275a |= 2;
                case Version.API18_JELLY_BEAN_43 /*18*/:
                    arVar.f3278d = Float.valueOf(cp.m5699f(str2));
                    arVar.f3275a |= 4;
                case Version.API19_KITKAT_44 /*19*/:
                    cp.m5667a(arVar, str2);
                case C1317h.Toolbar_navigationIcon /*20*/:
                    arVar.f3289o = cp.m5709k(str2);
                    arVar.f3275a |= 8192;
                case C1317h.Toolbar_navigationContentDescription /*21*/:
                    arVar.f3290p = cp.m5711l(str2);
                    arVar.f3275a |= 16384;
                case C1317h.Toolbar_logoDescription /*22*/:
                    arVar.f3291q = cp.m5713m(str2);
                    arVar.f3275a |= 32768;
                case C1317h.Toolbar_titleTextColor /*23*/:
                    arVar.f3292r = cp.m5715n(str2);
                    arVar.f3275a |= 65536;
                case C1317h.Theme_actionModeBackground /*29*/:
                    arVar.f3298x = cp.m5690b(str2, str);
                    arVar.f3299y = arVar.f3298x;
                    arVar.f3300z = arVar.f3298x;
                    arVar.f3275a |= 14680064;
                case C1317h.Theme_actionModeSplitBackground /*30*/:
                    arVar.f3298x = cp.m5690b(str2, str);
                    arVar.f3275a |= 2097152;
                case C1317h.Theme_actionModeCloseDrawable /*31*/:
                    arVar.f3299y = cp.m5690b(str2, str);
                    arVar.f3275a |= 4194304;
                case HTTP.SP /*32*/:
                    arVar.f3300z = cp.m5690b(str2, str);
                    arVar.f3275a |= 8388608;
                case C1317h.Theme_actionModeShareDrawable /*36*/:
                    arVar.f3269G = cp.m5690b(str2, str);
                    arVar.f3275a |= 1073741824;
                case C1317h.Theme_textAppearanceSmallPopupMenu /*41*/:
                    arVar.f3287m = Float.valueOf(cp.m5699f(str2));
                    arVar.f3275a |= 2048;
                case C1317h.Theme_dialogPreferredPadding /*43*/:
                    arVar.f3296v = cp.m5731v(str2);
                    arVar.f3275a |= 524288;
                case C1317h.Theme_toolbarNavigationButtonStyle /*59*/:
                    if (str2.equals("currentColor")) {
                        arVar.f3270H = C0935t.m5809a();
                    } else {
                        arVar.f3270H = cp.m5705i(str2);
                    }
                    arVar.f3275a |= 2147483648L;
                case C1317h.Theme_popupMenuStyle /*60*/:
                    arVar.f3271I = Float.valueOf(cp.m5699f(str2));
                    arVar.f3275a |= 4294967296L;
                case C1317h.Theme_editTextBackground /*63*/:
                    if (str2.equals("currentColor")) {
                        arVar.f3265C = C0935t.m5809a();
                    } else {
                        arVar.f3265C = cp.m5705i(str2);
                    }
                    arVar.f3275a |= 67108864;
                case C1317h.Theme_imageButtonStyle /*64*/:
                    arVar.f3266D = Float.valueOf(cp.m5699f(str2));
                    arVar.f3275a |= 134217728;
                case C1317h.Theme_textAppearanceSearchResultTitle /*65*/:
                    arVar.f3279e = cp.m5656a(str2, "stroke");
                    arVar.f3275a |= 8;
                case C1317h.Theme_textAppearanceSearchResultSubtitle /*66*/:
                    if (PrivacyItem.SUBSCRIPTION_NONE.equals(str2)) {
                        arVar.f3285k = null;
                    } else {
                        arVar.f3285k = cp.m5728t(str2);
                    }
                    arVar.f3275a |= 512;
                case C1317h.Theme_textColorSearchUrl /*67*/:
                    arVar.f3286l = cp.m5655a(str2);
                    arVar.f3275a |= 1024;
                case C1317h.Theme_searchViewStyle /*68*/:
                    arVar.f3282h = cp.m5723r(str2);
                    arVar.f3275a |= 64;
                case C1317h.Theme_listPreferredItemHeight /*69*/:
                    arVar.f3283i = cp.m5725s(str2);
                    arVar.f3275a |= 128;
                case C1317h.Theme_listPreferredItemHeightSmall /*70*/:
                    arVar.f3284j = Float.valueOf(cp.m5697e(str2));
                    arVar.f3275a |= 256;
                case C1317h.Theme_listPreferredItemHeightLarge /*71*/:
                    arVar.f3280f = Float.valueOf(cp.m5699f(str2));
                    arVar.f3275a |= 16;
                case C1317h.Theme_listPreferredItemPaddingLeft /*72*/:
                    arVar.f3281g = cp.m5655a(str2);
                    arVar.f3275a |= 32;
                case C1317h.Theme_listPopupWindowStyle /*75*/:
                    arVar.f3295u = cp.m5729u(str2);
                    arVar.f3275a |= 262144;
                case C1317h.Theme_textAppearanceListItem /*76*/:
                    arVar.f3293s = cp.m5717o(str2);
                    arVar.f3275a |= 131072;
                case C1317h.Theme_panelMenuListWidth /*79*/:
                    arVar.f3274L = cp.m5735x(str2);
                    arVar.f3275a |= 34359738368L;
                case C1317h.Theme_colorSwitchThumbNormal /*89*/:
                    if (str2.equals("currentColor")) {
                        arVar.f3272J = C0935t.m5809a();
                    } else {
                        arVar.f3272J = cp.m5705i(str2);
                    }
                    arVar.f3275a |= 8589934592L;
                case C1317h.Theme_controlBackground /*90*/:
                    arVar.f3273K = Float.valueOf(cp.m5699f(str2));
                    arVar.f3275a |= 17179869184L;
                case C1317h.Theme_alertDialogStyle /*91*/:
                    if (str2.indexOf(124) >= 0 || "|visible|hidden|collapse|".indexOf(new StringBuilder(String.valueOf('|')).append(str2).append('|').toString()) == -1) {
                        throw new SAXException("Invalid value for \"visibility\" attribute: " + str2);
                    }
                    arVar.f3264B = Boolean.valueOf(str2.equals("visible"));
                    arVar.f3275a |= 33554432;
                default:
            }
        }
    }

    private void m5669a(ba baVar, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (cp.m5687a()[cq.m5742a(attributes.getLocalName(i)).ordinal()]) {
                case C1317h.Theme_actionMenuTextColor /*26*/:
                    baVar.f3338d = cp.m5655a(trim);
                    if (!baVar.f3338d.m5467c()) {
                        break;
                    }
                    throw new SAXException("Invalid <svg> element. height cannot be negative");
                case C1317h.Theme_panelMenuListTheme /*80*/:
                    baVar.f3339e = trim;
                    break;
                case C1317h.Theme_colorPrimary /*82*/:
                    baVar.f3337c = cp.m5655a(trim);
                    if (!baVar.f3337c.m5467c()) {
                        break;
                    }
                    throw new SAXException("Invalid <svg> element. width cannot be negative");
                case C1317h.Theme_colorPrimaryDark /*83*/:
                    baVar.f3335a = cp.m5655a(trim);
                    break;
                case C1317h.Theme_colorAccent /*84*/:
                    baVar.f3336b = cp.m5655a(trim);
                    break;
                default:
                    break;
            }
        }
    }

    private void m5670a(bb bbVar, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (cp.m5687a()[cq.m5742a(attributes.getLocalName(i)).ordinal()]) {
                case C1317h.Theme_selectableItemBackgroundBorderless /*53*/:
                    bbVar.m5435a(cp.m5739z(trim));
                    break;
                case C1317h.Theme_borderlessButtonStyle /*54*/:
                    bbVar.m5434a(trim);
                    break;
                case C1317h.Theme_dividerVertical /*55*/:
                    bbVar.m5439c(cp.m5651B(trim));
                    break;
                case C1317h.Theme_dividerHorizontal /*56*/:
                    Collection k = cp.m5709k(trim);
                    bbVar.m5441d(k != null ? new HashSet(k) : new HashSet(0));
                    break;
                case C1317h.Theme_dropDownListViewStyle /*74*/:
                    bbVar.m5437b(cp.m5649A(trim));
                    break;
                default:
                    break;
            }
        }
    }

    private static void m5671a(bg bgVar, String str) {
        cr crVar = new cr(str.replaceAll("/\\*.*?\\*/", BuildConfig.FLAVOR));
        while (true) {
            String b = crVar.m5748b(':');
            crVar.m5751d();
            if (crVar.m5745a(':')) {
                crVar.m5751d();
                String b2 = crVar.m5748b(';');
                if (b2 != null) {
                    crVar.m5751d();
                    if (crVar.m5750c() || crVar.m5745a(';')) {
                        if (bgVar.f3199s == null) {
                            bgVar.f3199s = new ar();
                        }
                        cp.m5668a(bgVar.f3199s, b, b2);
                        crVar.m5751d();
                    }
                } else {
                    return;
                }
            }
            return;
        }
    }

    private void m5672a(bg bgVar, Attributes attributes) {
        int i = 0;
        while (i < attributes.getLength()) {
            String qName = attributes.getQName(i);
            if (qName.equals("id") || qName.equals("xml:id")) {
                bgVar.f3196p = attributes.getValue(i).trim();
                return;
            } else if (qName.equals("xml:space")) {
                String trim = attributes.getValue(i).trim();
                if ("default".equals(trim)) {
                    bgVar.f3197q = Boolean.FALSE;
                    return;
                } else if ("preserve".equals(trim)) {
                    bgVar.f3197q = Boolean.TRUE;
                    return;
                } else {
                    throw new SAXException("Invalid value for \"xml:space\" attribute: " + trim);
                }
            } else {
                i++;
            }
        }
    }

    private void m5673a(bh bhVar, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (cp.m5687a()[cq.m5742a(attributes.getLocalName(i)).ordinal()]) {
                case C1317h.Theme_colorControlNormal /*85*/:
                    bhVar.f3345f = cp.m5655a(trim);
                    break;
                case C1317h.Theme_colorControlActivated /*86*/:
                    bhVar.f3346g = cp.m5655a(trim);
                    break;
                case C1317h.Theme_colorControlHighlight /*87*/:
                    bhVar.f3347h = cp.m5655a(trim);
                    break;
                case C1317h.Theme_colorButtonNormal /*88*/:
                    bhVar.f3348i = cp.m5655a(trim);
                    break;
                default:
                    break;
            }
        }
    }

    private static void m5674a(bk bkVar, String str) {
        cr crVar = new cr(str);
        crVar.m5751d();
        C0928m c0928m = null;
        Object m = crVar.m5760m();
        if ("defer".equals(m)) {
            crVar.m5751d();
            m = crVar.m5760m();
        }
        C0927l c0927l = (C0927l) f3453p.get(m);
        crVar.m5751d();
        if (!crVar.m5750c()) {
            String m2 = crVar.m5760m();
            if (m2.equals("meet")) {
                c0928m = C0928m.Meet;
            } else if (m2.equals("slice")) {
                c0928m = C0928m.Slice;
            } else {
                throw new SAXException("Invalid preserveAspectRatio definition: " + str);
            }
        }
        bkVar.f3208w = new C0926k(c0927l, c0928m);
    }

    private void m5675a(bl blVar, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (cp.m5687a()[cq.m5742a(attributes.getLocalName(i)).ordinal()]) {
                case Version.API07_ECLAIR_21 /*7*/:
                    blVar.f3349f = cp.m5655a(trim);
                    break;
                case Version.API08_FROYO_22 /*8*/:
                    blVar.f3350g = cp.m5655a(trim);
                    break;
                case Version.API12_HONEYCOMB_MR1_31X /*12*/:
                    blVar.f3352i = cp.m5655a(trim);
                    break;
                case Version.API13_HONEYCOMB_MR2_32 /*13*/:
                    blVar.f3353j = cp.m5655a(trim);
                    break;
                case C1317h.Theme_buttonBarStyle /*50*/:
                    blVar.f3351h = cp.m5655a(trim);
                    if (!blVar.f3351h.m5467c()) {
                        break;
                    }
                    throw new SAXException("Invalid <radialGradient> element. r cannot be negative");
                default:
                    break;
            }
        }
    }

    private void m5676a(bm bmVar, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (cp.m5687a()[cq.m5742a(attributes.getLocalName(i)).ordinal()]) {
                case C1317h.Theme_actionButtonStyle /*49*/:
                    cp.m5674a((bk) bmVar, trim);
                    break;
                case C1317h.Theme_listChoiceBackgroundIndicator /*81*/:
                    bmVar.f3228x = cp.m5701g(trim);
                    break;
                default:
                    break;
            }
        }
    }

    private void m5677a(bp bpVar, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (cp.m5687a()[cq.m5742a(attributes.getLocalName(i)).ordinal()]) {
                case C1317h.Theme_actionModeStyle /*27*/:
                    if (!"http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        break;
                    }
                    bpVar.f3355a = trim;
                    break;
                default:
                    break;
            }
        }
    }

    private void m5678a(bu buVar, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (cp.m5687a()[cq.m5742a(attributes.getLocalName(i)).ordinal()]) {
                case C1317h.Theme_actionModeStyle /*27*/:
                    if (!"http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        break;
                    }
                    buVar.f3363a = trim;
                    break;
                case C1317h.Theme_editTextColor /*62*/:
                    buVar.f3364b = cp.m5655a(trim);
                    break;
                default:
                    break;
            }
        }
    }

    private void m5679a(bv bvVar, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (cp.m5687a()[cq.m5742a(attributes.getLocalName(i)).ordinal()]) {
                case Version.API10_GINGERBREAD_MR1_233 /*10*/:
                    bvVar.f3359d = cp.m5695d(trim);
                    break;
                case Version.API11_HONEYCOMB_30 /*11*/:
                    bvVar.f3360e = cp.m5695d(trim);
                    break;
                case C1317h.Theme_colorPrimaryDark /*83*/:
                    bvVar.f3357b = cp.m5695d(trim);
                    break;
                case C1317h.Theme_colorAccent /*84*/:
                    bvVar.f3358c = cp.m5695d(trim);
                    break;
                default:
                    break;
            }
        }
    }

    private void m5680a(bz bzVar, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (cp.m5687a()[cq.m5742a(attributes.getLocalName(i)).ordinal()]) {
                case C1317h.Theme_actionMenuTextColor /*26*/:
                    bzVar.f3382f = cp.m5655a(trim);
                    if (!bzVar.f3382f.m5467c()) {
                        break;
                    }
                    throw new SAXException("Invalid <use> element. height cannot be negative");
                case C1317h.Theme_actionModeStyle /*27*/:
                    if (!"http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        break;
                    }
                    bzVar.f3378a = trim;
                    break;
                case C1317h.Theme_colorPrimary /*82*/:
                    bzVar.f3381e = cp.m5655a(trim);
                    if (!bzVar.f3381e.m5467c()) {
                        break;
                    }
                    throw new SAXException("Invalid <use> element. width cannot be negative");
                case C1317h.Theme_colorPrimaryDark /*83*/:
                    bzVar.f3379c = cp.m5655a(trim);
                    break;
                case C1317h.Theme_colorAccent /*84*/:
                    bzVar.f3380d = cp.m5655a(trim);
                    break;
                default:
                    break;
            }
        }
    }

    private void m5681a(C0932q c0932q, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (cp.m5687a()[cq.m5742a(attributes.getLocalName(i)).ordinal()]) {
                case Version.API07_ECLAIR_21 /*7*/:
                    c0932q.f3584a = cp.m5655a(trim);
                    break;
                case Version.API08_FROYO_22 /*8*/:
                    c0932q.f3585b = cp.m5655a(trim);
                    break;
                case C1317h.Theme_buttonBarStyle /*50*/:
                    c0932q.f3586c = cp.m5655a(trim);
                    if (!c0932q.f3586c.m5467c()) {
                        break;
                    }
                    throw new SAXException("Invalid <circle> element. r cannot be negative");
                default:
                    break;
            }
        }
    }

    private void m5682a(C0933r c0933r, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (cp.m5687a()[cq.m5742a(attributes.getLocalName(i)).ordinal()]) {
                case Version.API04_DONUT_16 /*4*/:
                    if ("objectBoundingBox".equals(trim)) {
                        c0933r.f3587a = Boolean.valueOf(false);
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        c0933r.f3587a = Boolean.valueOf(true);
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute clipPathUnits");
                    }
                default:
                    break;
            }
        }
    }

    private void m5683a(C0937v c0937v, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (cp.m5687a()[cq.m5742a(attributes.getLocalName(i)).ordinal()]) {
                case Version.API07_ECLAIR_21 /*7*/:
                    c0937v.f3591a = cp.m5655a(trim);
                    break;
                case Version.API08_FROYO_22 /*8*/:
                    c0937v.f3592b = cp.m5655a(trim);
                    break;
                case C1317h.Theme_activityChooserViewStyle /*57*/:
                    c0937v.f3593c = cp.m5655a(trim);
                    if (!c0937v.f3593c.m5467c()) {
                        break;
                    }
                    throw new SAXException("Invalid <ellipse> element. rx cannot be negative");
                case C1317h.Theme_toolbarStyle /*58*/:
                    c0937v.f3594d = cp.m5655a(trim);
                    if (!c0937v.f3594d.m5467c()) {
                        break;
                    }
                    throw new SAXException("Invalid <ellipse> element. ry cannot be negative");
                default:
                    break;
            }
        }
    }

    private void m5684a(C0916w c0916w, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (cp.m5687a()[cq.m5742a(attributes.getLocalName(i)).ordinal()]) {
                case C1317h.Toolbar_subtitleTextColor /*24*/:
                    c0916w.f3342c = m5693c(trim);
                    break;
                case C1317h.Theme_actionMenuTextAppearance /*25*/:
                    if ("objectBoundingBox".equals(trim)) {
                        c0916w.f3341b = Boolean.valueOf(false);
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        c0916w.f3341b = Boolean.valueOf(true);
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute gradientUnits");
                    }
                case C1317h.Theme_actionModeStyle /*27*/:
                    if (!"http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        break;
                    }
                    c0916w.f3344e = trim;
                    break;
                case C1317h.Theme_popupWindowStyle /*61*/:
                    try {
                        c0916w.f3343d = C0938x.valueOf(trim);
                        break;
                    } catch (IllegalArgumentException e) {
                        throw new SAXException("Invalid spreadMethod attribute. \"" + trim + "\" is not a valid value.");
                    }
                default:
                    break;
            }
        }
    }

    private void m5685a(String str, Object... objArr) {
    }

    private void m5686a(Attributes attributes) {
        m5685a("<svg>", new Object[0]);
        ba baVar = new ba();
        baVar.u = this.f3455b;
        baVar.v = this.f3456c;
        m5672a((bg) baVar, attributes);
        m5691b((bg) baVar, attributes);
        m5670a((bb) baVar, attributes);
        m5676a((bm) baVar, attributes);
        m5669a(baVar, attributes);
        if (this.f3456c == null) {
            this.f3455b.m5796a(baVar);
        } else {
            this.f3456c.m5445a(baVar);
        }
        this.f3456c = baVar;
    }

    static /* synthetic */ int[] m5687a() {
        int[] iArr = f3454q;
        if (iArr == null) {
            iArr = new int[cq.values().length];
            try {
                iArr[cq.CLASS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[cq.UNSUPPORTED.ordinal()] = 92;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[cq.clip.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[cq.clipPathUnits.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[cq.clip_path.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[cq.clip_rule.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[cq.color.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[cq.cx.ordinal()] = 7;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[cq.cy.ordinal()] = 8;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[cq.d.ordinal()] = 14;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[cq.direction.ordinal()] = 9;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[cq.display.ordinal()] = 15;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[cq.dx.ordinal()] = 10;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr[cq.dy.ordinal()] = 11;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr[cq.fill.ordinal()] = 16;
            } catch (NoSuchFieldError e15) {
            }
            try {
                iArr[cq.fill_opacity.ordinal()] = 18;
            } catch (NoSuchFieldError e16) {
            }
            try {
                iArr[cq.fill_rule.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                iArr[cq.font.ordinal()] = 19;
            } catch (NoSuchFieldError e18) {
            }
            try {
                iArr[cq.font_family.ordinal()] = 20;
            } catch (NoSuchFieldError e19) {
            }
            try {
                iArr[cq.font_size.ordinal()] = 21;
            } catch (NoSuchFieldError e20) {
            }
            try {
                iArr[cq.font_style.ordinal()] = 23;
            } catch (NoSuchFieldError e21) {
            }
            try {
                iArr[cq.font_weight.ordinal()] = 22;
            } catch (NoSuchFieldError e22) {
            }
            try {
                iArr[cq.fx.ordinal()] = 12;
            } catch (NoSuchFieldError e23) {
            }
            try {
                iArr[cq.fy.ordinal()] = 13;
            } catch (NoSuchFieldError e24) {
            }
            try {
                iArr[cq.gradientTransform.ordinal()] = 24;
            } catch (NoSuchFieldError e25) {
            }
            try {
                iArr[cq.gradientUnits.ordinal()] = 25;
            } catch (NoSuchFieldError e26) {
            }
            try {
                iArr[cq.height.ordinal()] = 26;
            } catch (NoSuchFieldError e27) {
            }
            try {
                iArr[cq.href.ordinal()] = 27;
            } catch (NoSuchFieldError e28) {
            }
            try {
                iArr[cq.id.ordinal()] = 28;
            } catch (NoSuchFieldError e29) {
            }
            try {
                iArr[cq.marker.ordinal()] = 29;
            } catch (NoSuchFieldError e30) {
            }
            try {
                iArr[cq.markerHeight.ordinal()] = 33;
            } catch (NoSuchFieldError e31) {
            }
            try {
                iArr[cq.markerUnits.ordinal()] = 34;
            } catch (NoSuchFieldError e32) {
            }
            try {
                iArr[cq.markerWidth.ordinal()] = 35;
            } catch (NoSuchFieldError e33) {
            }
            try {
                iArr[cq.marker_end.ordinal()] = 32;
            } catch (NoSuchFieldError e34) {
            }
            try {
                iArr[cq.marker_mid.ordinal()] = 31;
            } catch (NoSuchFieldError e35) {
            }
            try {
                iArr[cq.marker_start.ordinal()] = 30;
            } catch (NoSuchFieldError e36) {
            }
            try {
                iArr[cq.mask.ordinal()] = 36;
            } catch (NoSuchFieldError e37) {
            }
            try {
                iArr[cq.maskContentUnits.ordinal()] = 37;
            } catch (NoSuchFieldError e38) {
            }
            try {
                iArr[cq.maskUnits.ordinal()] = 38;
            } catch (NoSuchFieldError e39) {
            }
            try {
                iArr[cq.media.ordinal()] = 39;
            } catch (NoSuchFieldError e40) {
            }
            try {
                iArr[cq.offset.ordinal()] = 40;
            } catch (NoSuchFieldError e41) {
            }
            try {
                iArr[cq.opacity.ordinal()] = 41;
            } catch (NoSuchFieldError e42) {
            }
            try {
                iArr[cq.orient.ordinal()] = 42;
            } catch (NoSuchFieldError e43) {
            }
            try {
                iArr[cq.overflow.ordinal()] = 43;
            } catch (NoSuchFieldError e44) {
            }
            try {
                iArr[cq.pathLength.ordinal()] = 44;
            } catch (NoSuchFieldError e45) {
            }
            try {
                iArr[cq.patternContentUnits.ordinal()] = 45;
            } catch (NoSuchFieldError e46) {
            }
            try {
                iArr[cq.patternTransform.ordinal()] = 46;
            } catch (NoSuchFieldError e47) {
            }
            try {
                iArr[cq.patternUnits.ordinal()] = 47;
            } catch (NoSuchFieldError e48) {
            }
            try {
                iArr[cq.points.ordinal()] = 48;
            } catch (NoSuchFieldError e49) {
            }
            try {
                iArr[cq.preserveAspectRatio.ordinal()] = 49;
            } catch (NoSuchFieldError e50) {
            }
            try {
                iArr[cq.r.ordinal()] = 50;
            } catch (NoSuchFieldError e51) {
            }
            try {
                iArr[cq.refX.ordinal()] = 51;
            } catch (NoSuchFieldError e52) {
            }
            try {
                iArr[cq.refY.ordinal()] = 52;
            } catch (NoSuchFieldError e53) {
            }
            try {
                iArr[cq.requiredExtensions.ordinal()] = 54;
            } catch (NoSuchFieldError e54) {
            }
            try {
                iArr[cq.requiredFeatures.ordinal()] = 53;
            } catch (NoSuchFieldError e55) {
            }
            try {
                iArr[cq.requiredFonts.ordinal()] = 56;
            } catch (NoSuchFieldError e56) {
            }
            try {
                iArr[cq.requiredFormats.ordinal()] = 55;
            } catch (NoSuchFieldError e57) {
            }
            try {
                iArr[cq.rx.ordinal()] = 57;
            } catch (NoSuchFieldError e58) {
            }
            try {
                iArr[cq.ry.ordinal()] = 58;
            } catch (NoSuchFieldError e59) {
            }
            try {
                iArr[cq.solid_color.ordinal()] = 59;
            } catch (NoSuchFieldError e60) {
            }
            try {
                iArr[cq.solid_opacity.ordinal()] = 60;
            } catch (NoSuchFieldError e61) {
            }
            try {
                iArr[cq.spreadMethod.ordinal()] = 61;
            } catch (NoSuchFieldError e62) {
            }
            try {
                iArr[cq.startOffset.ordinal()] = 62;
            } catch (NoSuchFieldError e63) {
            }
            try {
                iArr[cq.stop_color.ordinal()] = 63;
            } catch (NoSuchFieldError e64) {
            }
            try {
                iArr[cq.stop_opacity.ordinal()] = 64;
            } catch (NoSuchFieldError e65) {
            }
            try {
                iArr[cq.stroke.ordinal()] = 65;
            } catch (NoSuchFieldError e66) {
            }
            try {
                iArr[cq.stroke_dasharray.ordinal()] = 66;
            } catch (NoSuchFieldError e67) {
            }
            try {
                iArr[cq.stroke_dashoffset.ordinal()] = 67;
            } catch (NoSuchFieldError e68) {
            }
            try {
                iArr[cq.stroke_linecap.ordinal()] = 68;
            } catch (NoSuchFieldError e69) {
            }
            try {
                iArr[cq.stroke_linejoin.ordinal()] = 69;
            } catch (NoSuchFieldError e70) {
            }
            try {
                iArr[cq.stroke_miterlimit.ordinal()] = 70;
            } catch (NoSuchFieldError e71) {
            }
            try {
                iArr[cq.stroke_opacity.ordinal()] = 71;
            } catch (NoSuchFieldError e72) {
            }
            try {
                iArr[cq.stroke_width.ordinal()] = 72;
            } catch (NoSuchFieldError e73) {
            }
            try {
                iArr[cq.style.ordinal()] = 73;
            } catch (NoSuchFieldError e74) {
            }
            try {
                iArr[cq.systemLanguage.ordinal()] = 74;
            } catch (NoSuchFieldError e75) {
            }
            try {
                iArr[cq.text_anchor.ordinal()] = 75;
            } catch (NoSuchFieldError e76) {
            }
            try {
                iArr[cq.text_decoration.ordinal()] = 76;
            } catch (NoSuchFieldError e77) {
            }
            try {
                iArr[cq.transform.ordinal()] = 77;
            } catch (NoSuchFieldError e78) {
            }
            try {
                iArr[cq.type.ordinal()] = 78;
            } catch (NoSuchFieldError e79) {
            }
            try {
                iArr[cq.vector_effect.ordinal()] = 79;
            } catch (NoSuchFieldError e80) {
            }
            try {
                iArr[cq.version.ordinal()] = 80;
            } catch (NoSuchFieldError e81) {
            }
            try {
                iArr[cq.viewBox.ordinal()] = 81;
            } catch (NoSuchFieldError e82) {
            }
            try {
                iArr[cq.viewport_fill.ordinal()] = 89;
            } catch (NoSuchFieldError e83) {
            }
            try {
                iArr[cq.viewport_fill_opacity.ordinal()] = 90;
            } catch (NoSuchFieldError e84) {
            }
            try {
                iArr[cq.visibility.ordinal()] = 91;
            } catch (NoSuchFieldError e85) {
            }
            try {
                iArr[cq.width.ordinal()] = 82;
            } catch (NoSuchFieldError e86) {
            }
            try {
                iArr[cq.x.ordinal()] = 83;
            } catch (NoSuchFieldError e87) {
            }
            try {
                iArr[cq.x1.ordinal()] = 85;
            } catch (NoSuchFieldError e88) {
            }
            try {
                iArr[cq.x2.ordinal()] = 87;
            } catch (NoSuchFieldError e89) {
            }
            try {
                iArr[cq.y.ordinal()] = 84;
            } catch (NoSuchFieldError e90) {
            }
            try {
                iArr[cq.y1.ordinal()] = 86;
            } catch (NoSuchFieldError e91) {
            }
            try {
                iArr[cq.y2.ordinal()] = 88;
            } catch (NoSuchFieldError e92) {
            }
            f3454q = iArr;
        }
        return iArr;
    }

    private static ac m5688b(cr crVar) {
        return crVar.m5747a("auto") ? new ac(0.0f) : crVar.m5757j();
    }

    private Float m5689b(String str) {
        float f = 0.0f;
        if (str.length() == 0) {
            throw new SAXException("Invalid offset value in <stop> (empty string)");
        }
        int i;
        Object obj;
        int length = str.length();
        if (str.charAt(str.length() - 1) == '%') {
            i = length - 1;
            obj = 1;
        } else {
            i = length;
            obj = null;
        }
        try {
            float parseFloat = Float.parseFloat(str.substring(0, i));
            if (obj != null) {
                parseFloat /= 100.0f;
            }
            if (parseFloat >= 0.0f) {
                f = parseFloat > 100.0f ? 100.0f : parseFloat;
            }
            return Float.valueOf(f);
        } catch (Exception e) {
            throw new SAXException("Invalid offset value in <stop>: " + str, e);
        }
    }

    private static String m5690b(String str, String str2) {
        if (str.equals(PrivacyItem.SUBSCRIPTION_NONE)) {
            return null;
        }
        if (str.startsWith("url(") && str.endsWith(")")) {
            return str.substring(4, str.length() - 1).trim();
        }
        throw new SAXException("Bad " + str2 + " attribute. Expected \"none\" or \"url()\" format");
    }

    private void m5691b(bg bgVar, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            if (trim.length() != 0) {
                switch (cp.m5687a()[cq.m5742a(attributes.getLocalName(i)).ordinal()]) {
                    case VideoSize.CIF /*1*/:
                        bgVar.f3200t = C0913a.m5426b(trim);
                        break;
                    case C1317h.Theme_listPreferredItemPaddingRight /*73*/:
                        cp.m5671a(bgVar, trim);
                        break;
                    default:
                        if (bgVar.f3198r == null) {
                            bgVar.f3198r = new ar();
                        }
                        cp.m5668a(bgVar.f3198r, attributes.getLocalName(i), attributes.getValue(i).trim());
                        break;
                }
            }
        }
    }

    private void m5692b(Attributes attributes) {
        m5685a("<g>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        bb c0917z = new C0917z();
        c0917z.u = this.f3455b;
        c0917z.v = this.f3456c;
        m5672a((bg) c0917z, attributes);
        m5691b((bg) c0917z, attributes);
        m5657a((aa) c0917z, attributes);
        m5670a(c0917z, attributes);
        this.f3456c.m5445a(c0917z);
        this.f3456c = c0917z;
    }

    private Matrix m5693c(String str) {
        Matrix matrix = new Matrix();
        cr crVar = new cr(str);
        crVar.m5751d();
        while (!crVar.m5750c()) {
            String n = crVar.m5761n();
            if (n != null) {
                Float f;
                Float f2;
                Float f3;
                if (n.equals("matrix")) {
                    crVar.m5751d();
                    f = crVar.m5753f();
                    crVar.m5752e();
                    f2 = crVar.m5753f();
                    crVar.m5752e();
                    f3 = crVar.m5753f();
                    crVar.m5752e();
                    Float f4 = crVar.m5753f();
                    crVar.m5752e();
                    Float f5 = crVar.m5753f();
                    crVar.m5752e();
                    Float f6 = crVar.m5753f();
                    crVar.m5751d();
                    if (f6 == null || !crVar.m5745a(')')) {
                        throw new SAXException("Invalid transform list: " + str);
                    }
                    Matrix matrix2 = new Matrix();
                    matrix2.setValues(new float[]{f.floatValue(), f3.floatValue(), f5.floatValue(), f2.floatValue(), f4.floatValue(), f6.floatValue(), 0.0f, 0.0f, 1.0f});
                    matrix.preConcat(matrix2);
                } else if (n.equals("translate")) {
                    crVar.m5751d();
                    f = crVar.m5753f();
                    f2 = crVar.m5754g();
                    crVar.m5751d();
                    if (f == null || !crVar.m5745a(')')) {
                        throw new SAXException("Invalid transform list: " + str);
                    } else if (f2 == null) {
                        matrix.preTranslate(f.floatValue(), 0.0f);
                    } else {
                        matrix.preTranslate(f.floatValue(), f2.floatValue());
                    }
                } else if (n.equals("scale")) {
                    crVar.m5751d();
                    f = crVar.m5753f();
                    f2 = crVar.m5754g();
                    crVar.m5751d();
                    if (f == null || !crVar.m5745a(')')) {
                        throw new SAXException("Invalid transform list: " + str);
                    } else if (f2 == null) {
                        matrix.preScale(f.floatValue(), f.floatValue());
                    } else {
                        matrix.preScale(f.floatValue(), f2.floatValue());
                    }
                } else if (n.equals("rotate")) {
                    crVar.m5751d();
                    f = crVar.m5753f();
                    f2 = crVar.m5754g();
                    f3 = crVar.m5754g();
                    crVar.m5751d();
                    if (f == null || !crVar.m5745a(')')) {
                        throw new SAXException("Invalid transform list: " + str);
                    } else if (f2 == null) {
                        matrix.preRotate(f.floatValue());
                    } else if (f3 != null) {
                        matrix.preRotate(f.floatValue(), f2.floatValue(), f3.floatValue());
                    } else {
                        throw new SAXException("Invalid transform list: " + str);
                    }
                } else if (n.equals("skewX")) {
                    crVar.m5751d();
                    f = crVar.m5753f();
                    crVar.m5751d();
                    if (f == null || !crVar.m5745a(')')) {
                        throw new SAXException("Invalid transform list: " + str);
                    }
                    matrix.preSkew((float) Math.tan(Math.toRadians((double) f.floatValue())), 0.0f);
                } else if (n.equals("skewY")) {
                    crVar.m5751d();
                    f = crVar.m5753f();
                    crVar.m5751d();
                    if (f == null || !crVar.m5745a(')')) {
                        throw new SAXException("Invalid transform list: " + str);
                    }
                    matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians((double) f.floatValue())));
                } else if (n != null) {
                    throw new SAXException("Invalid transform list fn: " + n + ")");
                }
                if (crVar.m5750c()) {
                    break;
                }
                crVar.m5752e();
            } else {
                throw new SAXException("Bad transform function encountered in transform list: " + str);
            }
        }
        return matrix;
    }

    private void m5694c(Attributes attributes) {
        m5685a("<defs>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        aa c0936u = new C0936u();
        c0936u.u = this.f3455b;
        c0936u.v = this.f3456c;
        m5672a((bg) c0936u, attributes);
        m5691b((bg) c0936u, attributes);
        m5657a(c0936u, attributes);
        this.f3456c.m5445a(c0936u);
        this.f3456c = c0936u;
    }

    private static List<ac> m5695d(String str) {
        if (str.length() == 0) {
            throw new SAXException("Invalid length list (empty string)");
        }
        List<ac> arrayList = new ArrayList(1);
        cr crVar = new cr(str);
        crVar.m5751d();
        while (!crVar.m5750c()) {
            Float f = crVar.m5753f();
            if (f == null) {
                throw new SAXException("Invalid length list value: " + crVar.m5762o());
            }
            by p = crVar.m5763p();
            if (p == null) {
                p = by.px;
            }
            arrayList.add(new ac(f.floatValue(), p));
            crVar.m5752e();
        }
        return arrayList;
    }

    private void m5696d(Attributes attributes) {
        m5685a("<use>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        bz bzVar = new bz();
        bzVar.u = this.f3455b;
        bzVar.v = this.f3456c;
        m5672a((bg) bzVar, attributes);
        m5691b((bg) bzVar, attributes);
        m5657a((aa) bzVar, attributes);
        m5670a((bb) bzVar, attributes);
        m5680a(bzVar, attributes);
        this.f3456c.m5445a(bzVar);
        this.f3456c = bzVar;
    }

    private static float m5697e(String str) {
        if (str.length() == 0) {
            throw new SAXException("Invalid float value (empty string)");
        }
        try {
            return Float.parseFloat(str);
        } catch (Exception e) {
            throw new SAXException("Invalid float value: " + str, e);
        }
    }

    private void m5698e(Attributes attributes) {
        m5685a("<image>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        ab abVar = new ab();
        abVar.u = this.f3455b;
        abVar.v = this.f3456c;
        m5672a((bg) abVar, attributes);
        m5691b((bg) abVar, attributes);
        m5657a((aa) abVar, attributes);
        m5670a((bb) abVar, attributes);
        m5658a(abVar, attributes);
        this.f3456c.m5445a(abVar);
        this.f3456c = abVar;
    }

    private static float m5699f(String str) {
        float e = cp.m5697e(str);
        return e < 0.0f ? 0.0f : e > 1.0f ? 1.0f : e;
    }

    private void m5700f(Attributes attributes) {
        m5685a("<path>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        ai aiVar = new ai();
        aiVar.u = this.f3455b;
        aiVar.v = this.f3456c;
        m5672a((bg) aiVar, attributes);
        m5691b((bg) aiVar, attributes);
        m5657a((aa) aiVar, attributes);
        m5670a((bb) aiVar, attributes);
        m5662a(aiVar, attributes);
        this.f3456c.m5445a(aiVar);
    }

    private static C0930o m5701g(String str) {
        cr crVar = new cr(str);
        crVar.m5751d();
        Float f = crVar.m5753f();
        crVar.m5752e();
        Float f2 = crVar.m5753f();
        crVar.m5752e();
        Float f3 = crVar.m5753f();
        crVar.m5752e();
        Float f4 = crVar.m5753f();
        if (f == null || f2 == null || f3 == null || f4 == null) {
            throw new SAXException("Invalid viewBox definition - should have four numbers");
        } else if (f3.floatValue() < 0.0f) {
            throw new SAXException("Invalid viewBox. width cannot be negative");
        } else if (f4.floatValue() >= 0.0f) {
            return new C0930o(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue());
        } else {
            throw new SAXException("Invalid viewBox. height cannot be negative");
        }
    }

    private void m5702g(Attributes attributes) {
        m5685a("<rect>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        ao aoVar = new ao();
        aoVar.u = this.f3455b;
        aoVar.v = this.f3456c;
        m5672a((bg) aoVar, attributes);
        m5691b((bg) aoVar, attributes);
        m5657a((aa) aoVar, attributes);
        m5670a((bb) aoVar, attributes);
        m5665a(aoVar, attributes);
        this.f3456c.m5445a(aoVar);
    }

    private static bj m5703h(String str) {
        return str.equals(PrivacyItem.SUBSCRIPTION_NONE) ? null : str.equals("currentColor") ? C0935t.m5809a() : cp.m5705i(str);
    }

    private void m5704h(Attributes attributes) {
        m5685a("<circle>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        C0932q c0932q = new C0932q();
        c0932q.u = this.f3455b;
        c0932q.v = this.f3456c;
        m5672a((bg) c0932q, attributes);
        m5691b((bg) c0932q, attributes);
        m5657a((aa) c0932q, attributes);
        m5670a((bb) c0932q, attributes);
        m5681a(c0932q, attributes);
        this.f3456c.m5445a(c0932q);
    }

    private static C0934s m5705i(String str) {
        int i;
        int i2;
        int i3;
        if (str.charAt(0) == '#') {
            try {
                if (str.length() == 7) {
                    return new C0934s(Integer.parseInt(str.substring(1), 16));
                }
                if (str.length() == 4) {
                    int parseInt = Integer.parseInt(str.substring(1), 16);
                    i = parseInt & 3840;
                    i2 = parseInt & 240;
                    i3 = parseInt & 15;
                    return new C0934s((((((i << 12) | (i << 16)) | (i2 << 8)) | (i2 << 4)) | (i3 << 4)) | i3);
                }
                throw new SAXException("Bad hex colour value: " + str);
            } catch (NumberFormatException e) {
                throw new SAXException("Bad colour value: " + str);
            }
        } else if (!str.toLowerCase(Locale.US).startsWith("rgb(")) {
            return cp.m5707j(str);
        } else {
            cr crVar = new cr(str.substring(4));
            crVar.m5751d();
            i = cp.m5654a(crVar);
            crVar.m5752e();
            i2 = cp.m5654a(crVar);
            crVar.m5752e();
            i3 = cp.m5654a(crVar);
            crVar.m5751d();
            if (crVar.m5745a(')')) {
                return new C0934s(((i << 16) | (i2 << 8)) | i3);
            }
            throw new SAXException("Bad rgb() colour value: " + str);
        }
    }

    private void m5706i(Attributes attributes) {
        m5685a("<ellipse>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        C0937v c0937v = new C0937v();
        c0937v.u = this.f3455b;
        c0937v.v = this.f3456c;
        m5672a((bg) c0937v, attributes);
        m5691b((bg) c0937v, attributes);
        m5657a((aa) c0937v, attributes);
        m5670a((bb) c0937v, attributes);
        m5683a(c0937v, attributes);
        this.f3456c.m5445a(c0937v);
    }

    private static C0934s m5707j(String str) {
        Integer num = (Integer) f3449l.get(str.toLowerCase(Locale.US));
        if (num != null) {
            return new C0934s(num.intValue());
        }
        throw new SAXException("Invalid colour keyword: " + str);
    }

    private void m5708j(Attributes attributes) {
        m5685a("<line>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        ad adVar = new ad();
        adVar.u = this.f3455b;
        adVar.v = this.f3456c;
        m5672a((bg) adVar, attributes);
        m5691b((bg) adVar, attributes);
        m5657a((aa) adVar, attributes);
        m5670a((bb) adVar, attributes);
        m5659a(adVar, attributes);
        this.f3456c.m5445a(adVar);
    }

    private static List<String> m5709k(String str) {
        List<String> list = null;
        cr crVar = new cr(str);
        do {
            Object r = crVar.m5765r();
            if (r == null) {
                r = crVar.m5748b(',');
            }
            if (r == null) {
                break;
            }
            if (list == null) {
                list = new ArrayList();
            }
            list.add(r);
            crVar.m5752e();
        } while (!crVar.m5750c());
        return list;
    }

    private void m5710k(Attributes attributes) {
        m5685a("<polyline>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        am amVar = new am();
        amVar.u = this.f3455b;
        amVar.v = this.f3456c;
        m5672a((bg) amVar, attributes);
        m5691b((bg) amVar, attributes);
        m5657a((aa) amVar, attributes);
        m5670a((bb) amVar, attributes);
        m5664a(amVar, attributes, "polyline");
        this.f3456c.m5445a(amVar);
    }

    private static ac m5711l(String str) {
        ac acVar = (ac) f3450m.get(str);
        return acVar == null ? cp.m5655a(str) : acVar;
    }

    private void m5712l(Attributes attributes) {
        m5685a("<polygon>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        am anVar = new an();
        anVar.u = this.f3455b;
        anVar.v = this.f3456c;
        m5672a((bg) anVar, attributes);
        m5691b((bg) anVar, attributes);
        m5657a((aa) anVar, attributes);
        m5670a((bb) anVar, attributes);
        m5664a(anVar, attributes, "polygon");
        this.f3456c.m5445a(anVar);
    }

    private static Integer m5713m(String str) {
        Integer num = (Integer) f3451n.get(str);
        if (num != null) {
            return num;
        }
        throw new SAXException("Invalid font-weight property: " + str);
    }

    private void m5714m(Attributes attributes) {
        m5685a("<text>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        bv brVar = new br();
        brVar.u = this.f3455b;
        brVar.v = this.f3456c;
        m5672a((bg) brVar, attributes);
        m5691b((bg) brVar, attributes);
        m5657a((aa) brVar, attributes);
        m5670a((bb) brVar, attributes);
        m5679a(brVar, attributes);
        this.f3456c.m5445a(brVar);
        this.f3456c = brVar;
    }

    private static at m5715n(String str) {
        at atVar = (at) f3452o.get(str);
        if (atVar != null) {
            return atVar;
        }
        throw new SAXException("Invalid font-style property: " + str);
    }

    private void m5716n(Attributes attributes) {
        m5685a("<tspan>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        } else if (this.f3456c instanceof bt) {
            bv bqVar = new bq();
            bqVar.u = this.f3455b;
            bqVar.v = this.f3456c;
            m5672a((bg) bqVar, attributes);
            m5691b((bg) bqVar, attributes);
            m5670a((bb) bqVar, attributes);
            m5679a(bqVar, attributes);
            this.f3456c.m5445a(bqVar);
            this.f3456c = bqVar;
            if (bqVar.v instanceof bw) {
                bqVar.m5506a((bw) bqVar.v);
            } else {
                bqVar.m5506a(((bs) bqVar.v).m5503g());
            }
        } else {
            throw new SAXException("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
        }
    }

    private static ax m5717o(String str) {
        if (PrivacyItem.SUBSCRIPTION_NONE.equals(str)) {
            return ax.None;
        }
        if ("underline".equals(str)) {
            return ax.Underline;
        }
        if ("overline".equals(str)) {
            return ax.Overline;
        }
        if ("line-through".equals(str)) {
            return ax.LineThrough;
        }
        if ("blink".equals(str)) {
            return ax.Blink;
        }
        throw new SAXException("Invalid text-decoration property: " + str);
    }

    private void m5718o(Attributes attributes) {
        m5685a("<tref>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        } else if (this.f3456c instanceof bt) {
            bp bpVar = new bp();
            bpVar.u = this.f3455b;
            bpVar.v = this.f3456c;
            m5672a((bg) bpVar, attributes);
            m5691b((bg) bpVar, attributes);
            m5670a((bb) bpVar, attributes);
            m5677a(bpVar, attributes);
            this.f3456c.m5445a(bpVar);
            if (bpVar.v instanceof bw) {
                bpVar.m5504a((bw) bpVar.v);
            } else {
                bpVar.m5504a(((bs) bpVar.v).m5503g());
            }
        } else {
            throw new SAXException("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
        }
    }

    private static ay m5719p(String str) {
        if ("ltr".equals(str)) {
            return ay.LTR;
        }
        if ("rtl".equals(str)) {
            return ay.RTL;
        }
        throw new SAXException("Invalid direction property: " + str);
    }

    private void m5720p(Attributes attributes) {
        m5685a("<switch>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        bb bnVar = new bn();
        bnVar.u = this.f3455b;
        bnVar.v = this.f3456c;
        m5672a((bg) bnVar, attributes);
        m5691b((bg) bnVar, attributes);
        m5657a((aa) bnVar, attributes);
        m5670a(bnVar, attributes);
        this.f3456c.m5445a(bnVar);
        this.f3456c = bnVar;
    }

    private static as m5721q(String str) {
        if ("nonzero".equals(str)) {
            return as.NonZero;
        }
        if ("evenodd".equals(str)) {
            return as.EvenOdd;
        }
        throw new SAXException("Invalid fill-rule property: " + str);
    }

    private void m5722q(Attributes attributes) {
        m5685a("<symbol>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        bm boVar = new bo();
        boVar.u = this.f3455b;
        boVar.v = this.f3456c;
        m5672a((bg) boVar, attributes);
        m5691b((bg) boVar, attributes);
        m5670a((bb) boVar, attributes);
        m5676a(boVar, attributes);
        this.f3456c.m5445a(boVar);
        this.f3456c = boVar;
    }

    private static au m5723r(String str) {
        if ("butt".equals(str)) {
            return au.Butt;
        }
        if ("round".equals(str)) {
            return au.Round;
        }
        if ("square".equals(str)) {
            return au.Square;
        }
        throw new SAXException("Invalid stroke-linecap property: " + str);
    }

    private void m5724r(Attributes attributes) {
        m5685a("<marker>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        ae aeVar = new ae();
        aeVar.u = this.f3455b;
        aeVar.v = this.f3456c;
        m5672a((bg) aeVar, attributes);
        m5691b((bg) aeVar, attributes);
        m5670a((bb) aeVar, attributes);
        m5676a((bm) aeVar, attributes);
        m5660a(aeVar, attributes);
        this.f3456c.m5445a(aeVar);
        this.f3456c = aeVar;
    }

    private static av m5725s(String str) {
        if ("miter".equals(str)) {
            return av.Miter;
        }
        if ("round".equals(str)) {
            return av.Round;
        }
        if ("bevel".equals(str)) {
            return av.Bevel;
        }
        throw new SAXException("Invalid stroke-linejoin property: " + str);
    }

    private void m5726s(Attributes attributes) {
        m5685a("<linearGradiant>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        bh bhVar = new bh();
        bhVar.u = this.f3455b;
        bhVar.v = this.f3456c;
        m5672a((bg) bhVar, attributes);
        m5691b((bg) bhVar, attributes);
        m5684a((C0916w) bhVar, attributes);
        m5673a(bhVar, attributes);
        this.f3456c.m5445a(bhVar);
        this.f3456c = bhVar;
    }

    private void m5727t(Attributes attributes) {
        m5685a("<radialGradient>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        bl blVar = new bl();
        blVar.u = this.f3455b;
        blVar.v = this.f3456c;
        m5672a((bg) blVar, attributes);
        m5691b((bg) blVar, attributes);
        m5684a((C0916w) blVar, attributes);
        m5675a(blVar, attributes);
        this.f3456c.m5445a(blVar);
        this.f3456c = blVar;
    }

    private static ac[] m5728t(String str) {
        cr crVar = new cr(str);
        crVar.m5751d();
        if (crVar.m5750c()) {
            return null;
        }
        ac j = crVar.m5757j();
        if (j == null) {
            return null;
        }
        if (j.m5467c()) {
            throw new SAXException("Invalid stroke-dasharray. Dash segemnts cannot be negative: " + str);
        }
        float a = j.m5460a();
        List arrayList = new ArrayList();
        arrayList.add(j);
        while (!crVar.m5750c()) {
            crVar.m5752e();
            j = crVar.m5757j();
            if (j == null) {
                throw new SAXException("Invalid stroke-dasharray. Non-Length content found: " + str);
            } else if (j.m5467c()) {
                throw new SAXException("Invalid stroke-dasharray. Dash segemnts cannot be negative: " + str);
            } else {
                arrayList.add(j);
                a += j.m5460a();
            }
        }
        return a == 0.0f ? null : (ac[]) arrayList.toArray(new ac[arrayList.size()]);
    }

    private static aw m5729u(String str) {
        if ("start".equals(str)) {
            return aw.Start;
        }
        if ("middle".equals(str)) {
            return aw.Middle;
        }
        if ("end".equals(str)) {
            return aw.End;
        }
        throw new SAXException("Invalid text-anchor property: " + str);
    }

    private void m5730u(Attributes attributes) {
        m5685a("<stop>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        } else if (this.f3456c instanceof C0916w) {
            aq aqVar = new aq();
            aqVar.u = this.f3455b;
            aqVar.v = this.f3456c;
            m5672a((bg) aqVar, attributes);
            m5691b((bg) aqVar, attributes);
            m5666a(aqVar, attributes);
            this.f3456c.m5445a(aqVar);
            this.f3456c = aqVar;
        } else {
            throw new SAXException("Invalid document. <stop> elements are only valid inside <linearGradiant> or <radialGradient> elements.");
        }
    }

    private static Boolean m5731v(String str) {
        if ("visible".equals(str) || "auto".equals(str)) {
            return Boolean.TRUE;
        }
        if ("hidden".equals(str) || "scroll".equals(str)) {
            return Boolean.FALSE;
        }
        throw new SAXException("Invalid toverflow property: " + str);
    }

    private void m5732v(Attributes attributes) {
        m5685a("<solidColor>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        bg apVar = new ap();
        apVar.u = this.f3455b;
        apVar.v = this.f3456c;
        m5672a(apVar, attributes);
        m5691b(apVar, attributes);
        this.f3456c.m5445a(apVar);
        this.f3456c = apVar;
    }

    private static C0931p m5733w(String str) {
        if ("auto".equals(str)) {
            return null;
        }
        if (str.toLowerCase(Locale.US).startsWith("rect(")) {
            cr crVar = new cr(str.substring(5));
            crVar.m5751d();
            ac b = cp.m5688b(crVar);
            crVar.m5752e();
            ac b2 = cp.m5688b(crVar);
            crVar.m5752e();
            ac b3 = cp.m5688b(crVar);
            crVar.m5752e();
            ac b4 = cp.m5688b(crVar);
            crVar.m5751d();
            if (crVar.m5745a(')')) {
                return new C0931p(b, b2, b3, b4);
            }
            throw new SAXException("Bad rect() clip definition: " + str);
        }
        throw new SAXException("Invalid clip attribute shape. Only rect() is supported.");
    }

    private void m5734w(Attributes attributes) {
        m5685a("<clipPath>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        C0933r c0933r = new C0933r();
        c0933r.u = this.f3455b;
        c0933r.v = this.f3456c;
        m5672a((bg) c0933r, attributes);
        m5691b((bg) c0933r, attributes);
        m5657a((aa) c0933r, attributes);
        m5670a((bb) c0933r, attributes);
        m5682a(c0933r, attributes);
        this.f3456c.m5445a(c0933r);
        this.f3456c = c0933r;
    }

    private static az m5735x(String str) {
        if (PrivacyItem.SUBSCRIPTION_NONE.equals(str)) {
            return az.None;
        }
        if ("non-scaling-stroke".equals(str)) {
            return az.NonScalingStroke;
        }
        throw new SAXException("Invalid vector-effect property: " + str);
    }

    private void m5736x(Attributes attributes) {
        m5685a("<textPath>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        bu buVar = new bu();
        buVar.u = this.f3455b;
        buVar.v = this.f3456c;
        m5672a((bg) buVar, attributes);
        m5691b((bg) buVar, attributes);
        m5670a((bb) buVar, attributes);
        m5678a(buVar, attributes);
        this.f3456c.m5445a(buVar);
        this.f3456c = buVar;
        if (buVar.v instanceof bw) {
            buVar.m5509a((bw) buVar.v);
        } else {
            buVar.m5509a(((bs) buVar.v).m5503g());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.p063b.p064a.aj m5737y(java.lang.String r18) {
        /*
        r15 = new com.b.a.cr;
        r0 = r18;
        r15.<init>(r0);
        r7 = 0;
        r6 = 0;
        r5 = 0;
        r4 = 0;
        r3 = 0;
        r2 = 0;
        r1 = new com.b.a.aj;
        r1.<init>();
        r8 = r15.m5750c();
        if (r8 == 0) goto L_0x0019;
    L_0x0018:
        return r1;
    L_0x0019:
        r8 = r15.m5756i();
        r8 = r8.intValue();
        r9 = 77;
        if (r8 == r9) goto L_0x0029;
    L_0x0025:
        r9 = 109; // 0x6d float:1.53E-43 double:5.4E-322;
        if (r8 != r9) goto L_0x0018;
    L_0x0029:
        r9 = r4;
        r10 = r5;
        r11 = r8;
        r5 = r7;
        r4 = r6;
    L_0x002e:
        r15.m5751d();
        switch(r11) {
            case 65: goto L_0x0035;
            case 67: goto L_0x016f;
            case 72: goto L_0x02d5;
            case 76: goto L_0x0117;
            case 77: goto L_0x0092;
            case 81: goto L_0x0357;
            case 83: goto L_0x0224;
            case 84: goto L_0x03e0;
            case 86: goto L_0x0316;
            case 90: goto L_0x02c9;
            case 97: goto L_0x0035;
            case 99: goto L_0x016f;
            case 104: goto L_0x02d5;
            case 108: goto L_0x0117;
            case 109: goto L_0x0092;
            case 113: goto L_0x0357;
            case 115: goto L_0x0224;
            case 116: goto L_0x03e0;
            case 118: goto L_0x0316;
            case 122: goto L_0x02c9;
            default: goto L_0x0034;
        };
    L_0x0034:
        goto L_0x0018;
    L_0x0035:
        r6 = r15.m5753f();
        r15.m5752e();
        r7 = r15.m5753f();
        r15.m5752e();
        r8 = r15.m5753f();
        r15.m5752e();
        r14 = r15.m5758k();
        r15.m5752e();
        r16 = r15.m5758k();
        r15.m5752e();
        r3 = r15.m5753f();
        r15.m5752e();
        r2 = r15.m5753f();
        if (r2 == 0) goto L_0x0077;
    L_0x0065:
        r12 = r6.floatValue();
        r13 = 0;
        r12 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1));
        if (r12 < 0) goto L_0x0077;
    L_0x006e:
        r12 = r7.floatValue();
        r13 = 0;
        r12 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1));
        if (r12 >= 0) goto L_0x045d;
    L_0x0077:
        r2 = "SVGParser";
        r3 = new java.lang.StringBuilder;
        r4 = "Bad path coords for ";
        r3.<init>(r4);
        r3 = r3.append(r11);
        r4 = " path segment";
        r3 = r3.append(r4);
        r3 = r3.toString();
        android.util.Log.e(r2, r3);
        goto L_0x0018;
    L_0x0092:
        r3 = r15.m5753f();
        r15.m5752e();
        r2 = r15.m5753f();
        if (r2 != 0) goto L_0x00bb;
    L_0x009f:
        r2 = "SVGParser";
        r3 = new java.lang.StringBuilder;
        r4 = "Bad path coords for ";
        r3.<init>(r4);
        r3 = r3.append(r11);
        r4 = " path segment";
        r3 = r3.append(r4);
        r3 = r3.toString();
        android.util.Log.e(r2, r3);
        goto L_0x0018;
    L_0x00bb:
        r6 = 109; // 0x6d float:1.53E-43 double:5.4E-322;
        if (r11 != r6) goto L_0x00d7;
    L_0x00bf:
        r6 = r1.m5490a();
        if (r6 != 0) goto L_0x00d7;
    L_0x00c5:
        r3 = r3.floatValue();
        r3 = r3 + r5;
        r3 = java.lang.Float.valueOf(r3);
        r2 = r2.floatValue();
        r2 = r2 + r4;
        r2 = java.lang.Float.valueOf(r2);
    L_0x00d7:
        r4 = r3.floatValue();
        r5 = r2.floatValue();
        r1.m5485a(r4, r5);
        r3 = r3.floatValue();
        r9 = r2.floatValue();
        r2 = 109; // 0x6d float:1.53E-43 double:5.4E-322;
        if (r11 != r2) goto L_0x0114;
    L_0x00ee:
        r2 = 108; // 0x6c float:1.51E-43 double:5.34E-322;
    L_0x00f0:
        r4 = r9;
        r5 = r3;
        r6 = r9;
        r7 = r3;
        r8 = r2;
        r2 = r9;
    L_0x00f6:
        r15.m5751d();
        r9 = r15.m5750c();
        if (r9 != 0) goto L_0x0018;
    L_0x00ff:
        r9 = r15.m5764q();
        if (r9 == 0) goto L_0x0029;
    L_0x0105:
        r8 = r15.m5756i();
        r8 = r8.intValue();
        r9 = r4;
        r10 = r5;
        r11 = r8;
        r5 = r7;
        r4 = r6;
        goto L_0x002e;
    L_0x0114:
        r2 = 76;
        goto L_0x00f0;
    L_0x0117:
        r3 = r15.m5753f();
        r15.m5752e();
        r2 = r15.m5753f();
        if (r2 != 0) goto L_0x0140;
    L_0x0124:
        r2 = "SVGParser";
        r3 = new java.lang.StringBuilder;
        r4 = "Bad path coords for ";
        r3.<init>(r4);
        r3 = r3.append(r11);
        r4 = " path segment";
        r3 = r3.append(r4);
        r3 = r3.toString();
        android.util.Log.e(r2, r3);
        goto L_0x0018;
    L_0x0140:
        r6 = 108; // 0x6c float:1.51E-43 double:5.34E-322;
        if (r11 != r6) goto L_0x0156;
    L_0x0144:
        r3 = r3.floatValue();
        r3 = r3 + r5;
        r3 = java.lang.Float.valueOf(r3);
        r2 = r2.floatValue();
        r2 = r2 + r4;
        r2 = java.lang.Float.valueOf(r2);
    L_0x0156:
        r4 = r3.floatValue();
        r5 = r2.floatValue();
        r1.m5492b(r4, r5);
        r3 = r3.floatValue();
        r2 = r2.floatValue();
        r4 = r9;
        r5 = r10;
        r6 = r2;
        r7 = r3;
        r8 = r11;
        goto L_0x00f6;
    L_0x016f:
        r7 = r15.m5753f();
        r15.m5752e();
        r6 = r15.m5753f();
        r15.m5752e();
        r3 = r15.m5753f();
        r15.m5752e();
        r2 = r15.m5753f();
        r15.m5752e();
        r12 = r15.m5753f();
        r15.m5752e();
        r8 = r15.m5753f();
        if (r8 != 0) goto L_0x01b4;
    L_0x0198:
        r2 = "SVGParser";
        r3 = new java.lang.StringBuilder;
        r4 = "Bad path coords for ";
        r3.<init>(r4);
        r3 = r3.append(r11);
        r4 = " path segment";
        r3 = r3.append(r4);
        r3 = r3.toString();
        android.util.Log.e(r2, r3);
        goto L_0x0018;
    L_0x01b4:
        r13 = 99;
        if (r11 != r13) goto L_0x04b0;
    L_0x01b8:
        r12 = r12.floatValue();
        r12 = r12 + r5;
        r12 = java.lang.Float.valueOf(r12);
        r8 = r8.floatValue();
        r8 = r8 + r4;
        r8 = java.lang.Float.valueOf(r8);
        r7 = r7.floatValue();
        r7 = r7 + r5;
        r7 = java.lang.Float.valueOf(r7);
        r6 = r6.floatValue();
        r6 = r6 + r4;
        r6 = java.lang.Float.valueOf(r6);
        r3 = r3.floatValue();
        r3 = r3 + r5;
        r3 = java.lang.Float.valueOf(r3);
        r2 = r2.floatValue();
        r2 = r2 + r4;
        r2 = java.lang.Float.valueOf(r2);
        r13 = r8;
        r14 = r12;
        r8 = r2;
        r12 = r3;
        r3 = r6;
        r2 = r7;
    L_0x01f4:
        r2 = r2.floatValue();
        r3 = r3.floatValue();
        r4 = r12.floatValue();
        r5 = r8.floatValue();
        r6 = r14.floatValue();
        r7 = r13.floatValue();
        r1.m5487a(r2, r3, r4, r5, r6, r7);
        r3 = r12.floatValue();
        r2 = r8.floatValue();
        r7 = r14.floatValue();
        r6 = r13.floatValue();
        r4 = r9;
        r5 = r10;
        r8 = r11;
        goto L_0x00f6;
    L_0x0224:
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = r6 * r5;
        r3 = r6 - r3;
        r16 = java.lang.Float.valueOf(r3);
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = r3 * r4;
        r2 = r3 - r2;
        r17 = java.lang.Float.valueOf(r2);
        r3 = r15.m5753f();
        r15.m5752e();
        r2 = r15.m5753f();
        r15.m5752e();
        r7 = r15.m5753f();
        r15.m5752e();
        r6 = r15.m5753f();
        if (r6 != 0) goto L_0x026d;
    L_0x0251:
        r2 = "SVGParser";
        r3 = new java.lang.StringBuilder;
        r4 = "Bad path coords for ";
        r3.<init>(r4);
        r3 = r3.append(r11);
        r4 = " path segment";
        r3 = r3.append(r4);
        r3 = r3.toString();
        android.util.Log.e(r2, r3);
        goto L_0x0018;
    L_0x026d:
        r8 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        if (r11 != r8) goto L_0x04aa;
    L_0x0271:
        r7 = r7.floatValue();
        r7 = r7 + r5;
        r7 = java.lang.Float.valueOf(r7);
        r6 = r6.floatValue();
        r6 = r6 + r4;
        r6 = java.lang.Float.valueOf(r6);
        r3 = r3.floatValue();
        r3 = r3 + r5;
        r3 = java.lang.Float.valueOf(r3);
        r2 = r2.floatValue();
        r2 = r2 + r4;
        r2 = java.lang.Float.valueOf(r2);
        r8 = r2;
        r12 = r3;
        r13 = r6;
        r14 = r7;
    L_0x0299:
        r2 = r16.floatValue();
        r3 = r17.floatValue();
        r4 = r12.floatValue();
        r5 = r8.floatValue();
        r6 = r14.floatValue();
        r7 = r13.floatValue();
        r1.m5487a(r2, r3, r4, r5, r6, r7);
        r3 = r12.floatValue();
        r2 = r8.floatValue();
        r7 = r14.floatValue();
        r6 = r13.floatValue();
        r4 = r9;
        r5 = r10;
        r8 = r11;
        goto L_0x00f6;
    L_0x02c9:
        r1.m5491b();
        r2 = r9;
        r3 = r10;
        r4 = r9;
        r5 = r10;
        r6 = r9;
        r7 = r10;
        r8 = r11;
        goto L_0x00f6;
    L_0x02d5:
        r3 = r15.m5753f();
        if (r3 != 0) goto L_0x02f7;
    L_0x02db:
        r2 = "SVGParser";
        r3 = new java.lang.StringBuilder;
        r4 = "Bad path coords for ";
        r3.<init>(r4);
        r3 = r3.append(r11);
        r4 = " path segment";
        r3 = r3.append(r4);
        r3 = r3.toString();
        android.util.Log.e(r2, r3);
        goto L_0x0018;
    L_0x02f7:
        r6 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        if (r11 != r6) goto L_0x0304;
    L_0x02fb:
        r3 = r3.floatValue();
        r3 = r3 + r5;
        r3 = java.lang.Float.valueOf(r3);
    L_0x0304:
        r5 = r3.floatValue();
        r1.m5492b(r5, r4);
        r3 = r3.floatValue();
        r5 = r10;
        r6 = r4;
        r7 = r3;
        r8 = r11;
        r4 = r9;
        goto L_0x00f6;
    L_0x0316:
        r2 = r15.m5753f();
        if (r2 != 0) goto L_0x0338;
    L_0x031c:
        r2 = "SVGParser";
        r3 = new java.lang.StringBuilder;
        r4 = "Bad path coords for ";
        r3.<init>(r4);
        r3 = r3.append(r11);
        r4 = " path segment";
        r3 = r3.append(r4);
        r3 = r3.toString();
        android.util.Log.e(r2, r3);
        goto L_0x0018;
    L_0x0338:
        r6 = 118; // 0x76 float:1.65E-43 double:5.83E-322;
        if (r11 != r6) goto L_0x0345;
    L_0x033c:
        r2 = r2.floatValue();
        r2 = r2 + r4;
        r2 = java.lang.Float.valueOf(r2);
    L_0x0345:
        r4 = r2.floatValue();
        r1.m5492b(r5, r4);
        r2 = r2.floatValue();
        r4 = r9;
        r6 = r2;
        r7 = r5;
        r8 = r11;
        r5 = r10;
        goto L_0x00f6;
    L_0x0357:
        r3 = r15.m5753f();
        r15.m5752e();
        r2 = r15.m5753f();
        r15.m5752e();
        r7 = r15.m5753f();
        r15.m5752e();
        r6 = r15.m5753f();
        if (r6 != 0) goto L_0x038e;
    L_0x0372:
        r2 = "SVGParser";
        r3 = new java.lang.StringBuilder;
        r4 = "Bad path coords for ";
        r3.<init>(r4);
        r3 = r3.append(r11);
        r4 = " path segment";
        r3 = r3.append(r4);
        r3 = r3.toString();
        android.util.Log.e(r2, r3);
        goto L_0x0018;
    L_0x038e:
        r8 = 113; // 0x71 float:1.58E-43 double:5.6E-322;
        if (r11 != r8) goto L_0x04a6;
    L_0x0392:
        r7 = r7.floatValue();
        r7 = r7 + r5;
        r7 = java.lang.Float.valueOf(r7);
        r6 = r6.floatValue();
        r6 = r6 + r4;
        r6 = java.lang.Float.valueOf(r6);
        r3 = r3.floatValue();
        r3 = r3 + r5;
        r3 = java.lang.Float.valueOf(r3);
        r2 = r2.floatValue();
        r2 = r2 + r4;
        r2 = java.lang.Float.valueOf(r2);
        r4 = r6;
        r5 = r7;
    L_0x03b8:
        r6 = r3.floatValue();
        r7 = r2.floatValue();
        r8 = r5.floatValue();
        r12 = r4.floatValue();
        r1.m5486a(r6, r7, r8, r12);
        r3 = r3.floatValue();
        r2 = r2.floatValue();
        r7 = r5.floatValue();
        r6 = r4.floatValue();
        r4 = r9;
        r5 = r10;
        r8 = r11;
        goto L_0x00f6;
    L_0x03e0:
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = r6 * r5;
        r3 = r6 - r3;
        r6 = java.lang.Float.valueOf(r3);
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = r3 * r4;
        r2 = r3 - r2;
        r7 = java.lang.Float.valueOf(r2);
        r3 = r15.m5753f();
        r15.m5752e();
        r2 = r15.m5753f();
        if (r2 != 0) goto L_0x041b;
    L_0x03ff:
        r2 = "SVGParser";
        r3 = new java.lang.StringBuilder;
        r4 = "Bad path coords for ";
        r3.<init>(r4);
        r3 = r3.append(r11);
        r4 = " path segment";
        r3 = r3.append(r4);
        r3 = r3.toString();
        android.util.Log.e(r2, r3);
        goto L_0x0018;
    L_0x041b:
        r8 = 116; // 0x74 float:1.63E-43 double:5.73E-322;
        if (r11 != r8) goto L_0x0431;
    L_0x041f:
        r3 = r3.floatValue();
        r3 = r3 + r5;
        r3 = java.lang.Float.valueOf(r3);
        r2 = r2.floatValue();
        r2 = r2 + r4;
        r2 = java.lang.Float.valueOf(r2);
    L_0x0431:
        r4 = r6.floatValue();
        r5 = r7.floatValue();
        r8 = r3.floatValue();
        r12 = r2.floatValue();
        r1.m5486a(r4, r5, r8, r12);
        r5 = r6.floatValue();
        r4 = r7.floatValue();
        r3 = r3.floatValue();
        r2 = r2.floatValue();
        r6 = r2;
        r7 = r3;
        r8 = r11;
        r2 = r4;
        r3 = r5;
        r5 = r10;
        r4 = r9;
        goto L_0x00f6;
    L_0x045d:
        r12 = 97;
        if (r11 != r12) goto L_0x04a3;
    L_0x0461:
        r3 = r3.floatValue();
        r3 = r3 + r5;
        r3 = java.lang.Float.valueOf(r3);
        r2 = r2.floatValue();
        r2 = r2 + r4;
        r2 = java.lang.Float.valueOf(r2);
        r12 = r2;
        r13 = r3;
    L_0x0475:
        r2 = r6.floatValue();
        r3 = r7.floatValue();
        r4 = r8.floatValue();
        r5 = r14.booleanValue();
        r6 = r16.booleanValue();
        r7 = r13.floatValue();
        r8 = r12.floatValue();
        r1.m5488a(r2, r3, r4, r5, r6, r7, r8);
        r3 = r13.floatValue();
        r2 = r12.floatValue();
        r4 = r9;
        r5 = r10;
        r6 = r2;
        r7 = r3;
        r8 = r11;
        goto L_0x00f6;
    L_0x04a3:
        r12 = r2;
        r13 = r3;
        goto L_0x0475;
    L_0x04a6:
        r4 = r6;
        r5 = r7;
        goto L_0x03b8;
    L_0x04aa:
        r8 = r2;
        r12 = r3;
        r13 = r6;
        r14 = r7;
        goto L_0x0299;
    L_0x04b0:
        r13 = r8;
        r14 = r12;
        r8 = r2;
        r12 = r3;
        r3 = r6;
        r2 = r7;
        goto L_0x01f4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.cp.y(java.lang.String):com.b.a.aj");
    }

    private void m5738y(Attributes attributes) {
        m5685a("<pattern>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        al alVar = new al();
        alVar.u = this.f3455b;
        alVar.v = this.f3456c;
        m5672a((bg) alVar, attributes);
        m5691b((bg) alVar, attributes);
        m5670a((bb) alVar, attributes);
        m5676a((bm) alVar, attributes);
        m5663a(alVar, attributes);
        this.f3456c.m5445a(alVar);
        this.f3456c = alVar;
    }

    private static Set<String> m5739z(String str) {
        cr crVar = new cr(str);
        Set hashSet = new HashSet();
        while (!crVar.m5750c()) {
            String m = crVar.m5760m();
            if (m.startsWith("http://www.w3.org/TR/SVG11/feature#")) {
                hashSet.add(m.substring("http://www.w3.org/TR/SVG11/feature#".length()));
            } else {
                hashSet.add("UNSUPPORTED");
            }
            crVar.m5751d();
        }
        return hashSet;
    }

    private void m5740z(Attributes attributes) {
        m5685a("<view>", new Object[0]);
        if (this.f3456c == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        bm caVar = new ca();
        caVar.u = this.f3455b;
        caVar.v = this.f3456c;
        m5672a((bg) caVar, attributes);
        m5670a((bb) caVar, attributes);
        m5676a(caVar, attributes);
        this.f3456c.m5445a(caVar);
        this.f3456c = caVar;
    }

    protected C0929n m5741a(InputStream inputStream) {
        try {
            XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            xMLReader.setContentHandler(this);
            xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", this);
            xMLReader.parse(new InputSource(inputStream));
            return this.f3455b;
        } catch (Throwable e) {
            throw new co("File error", e);
        } catch (Throwable e2) {
            throw new co("XML Parser problem", e2);
        } catch (Throwable e22) {
            throw new co("SVG parse error: " + e22.getMessage(), e22);
        }
    }

    public void characters(char[] cArr, int i, int i2) {
        if (!this.f3457d) {
            if (this.f3459f) {
                if (this.f3461h == null) {
                    this.f3461h = new StringBuilder(i2);
                }
                this.f3461h.append(cArr, i, i2);
            } else if (this.f3462i) {
                if (this.f3463j == null) {
                    this.f3463j = new StringBuilder(i2);
                }
                this.f3463j.append(cArr, i, i2);
            } else if (this.f3456c instanceof bt) {
                bc bcVar = (bc) this.f3456c;
                int size = bcVar.f3202i.size();
                bi biVar = size == 0 ? null : (bi) bcVar.f3202i.get(size - 1);
                if (biVar instanceof bx) {
                    bx bxVar = (bx) biVar;
                    bxVar.f3366a += new String(cArr, i, i2);
                    return;
                }
                ((bc) this.f3456c).m5447a(new bx(new String(cArr, i, i2)));
            }
        }
    }

    public void comment(char[] cArr, int i, int i2) {
        if (!this.f3457d && this.f3462i) {
            if (this.f3463j == null) {
                this.f3463j = new StringBuilder(i2);
            }
            this.f3463j.append(cArr, i, i2);
        }
    }

    public void endDocument() {
        super.endDocument();
    }

    public void endElement(String str, String str2, String str3) {
        super.endElement(str, str2, str3);
        if (this.f3457d) {
            int i = this.f3458e - 1;
            this.f3458e = i;
            if (i == 0) {
                this.f3457d = false;
                return;
            }
        }
        if (!"http://www.w3.org/2000/svg".equals(str) && !BuildConfig.FLAVOR.equals(str)) {
            return;
        }
        if (str2.equals("title") || str2.equals("desc")) {
            this.f3459f = false;
            if (this.f3460g.equals("title")) {
                this.f3455b.m5799b(this.f3461h.toString());
            } else if (this.f3460g.equals("desc")) {
                this.f3455b.m5801c(this.f3461h.toString());
            }
            this.f3461h.setLength(0);
        } else if (str2.equals(XHTMLText.STYLE) && this.f3463j != null) {
            this.f3462i = false;
            m5653C(this.f3463j.toString());
            this.f3463j.setLength(0);
        } else if (str2.equals("svg") || str2.equals("defs") || str2.equals("g") || str2.equals("use") || str2.equals("image") || str2.equals(Text.ELEMENT) || str2.equals("tspan") || str2.equals("switch") || str2.equals("symbol") || str2.equals("marker") || str2.equals("linearGradient") || str2.equals("radialGradient") || str2.equals("stop") || str2.equals("clipPath") || str2.equals("textPath") || str2.equals("pattern") || str2.equals("view") || str2.equals("mask") || str2.equals("solidColor")) {
            this.f3456c = ((bi) this.f3456c).f3195v;
        }
    }

    public void startDocument() {
        super.startDocument();
        this.f3455b = new C0929n();
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        super.startElement(str, str2, str3, attributes);
        if (this.f3457d) {
            this.f3458e++;
        } else if (!"http://www.w3.org/2000/svg".equals(str) && !BuildConfig.FLAVOR.equals(str)) {
        } else {
            if (str2.equals("svg")) {
                m5686a(attributes);
            } else if (str2.equals("g")) {
                m5692b(attributes);
            } else if (str2.equals("defs")) {
                m5694c(attributes);
            } else if (str2.equals("use")) {
                m5696d(attributes);
            } else if (str2.equals("path")) {
                m5700f(attributes);
            } else if (str2.equals("rect")) {
                m5702g(attributes);
            } else if (str2.equals("circle")) {
                m5704h(attributes);
            } else if (str2.equals("ellipse")) {
                m5706i(attributes);
            } else if (str2.equals("line")) {
                m5708j(attributes);
            } else if (str2.equals("polyline")) {
                m5710k(attributes);
            } else if (str2.equals("polygon")) {
                m5712l(attributes);
            } else if (str2.equals(Text.ELEMENT)) {
                m5714m(attributes);
            } else if (str2.equals("tspan")) {
                m5716n(attributes);
            } else if (str2.equals("tref")) {
                m5718o(attributes);
            } else if (str2.equals("switch")) {
                m5720p(attributes);
            } else if (str2.equals("symbol")) {
                m5722q(attributes);
            } else if (str2.equals("marker")) {
                m5724r(attributes);
            } else if (str2.equals("linearGradient")) {
                m5726s(attributes);
            } else if (str2.equals("radialGradient")) {
                m5727t(attributes);
            } else if (str2.equals("stop")) {
                m5730u(attributes);
            } else if (str2.equals(XHTMLText.f8412A)) {
                m5692b(attributes);
            } else if (str2.equals("title") || str2.equals("desc")) {
                this.f3459f = true;
                this.f3460g = str2;
            } else if (str2.equals("clipPath")) {
                m5734w(attributes);
            } else if (str2.equals("textPath")) {
                m5736x(attributes);
            } else if (str2.equals("pattern")) {
                m5738y(attributes);
            } else if (str2.equals("image")) {
                m5698e(attributes);
            } else if (str2.equals("view")) {
                m5740z(attributes);
            } else if (str2.equals("mask")) {
                m5650A(attributes);
            } else if (str2.equals(XHTMLText.STYLE)) {
                m5652B(attributes);
            } else if (str2.equals("solidColor")) {
                m5732v(attributes);
            } else {
                this.f3457d = true;
                this.f3458e = 1;
            }
        }
    }
}
