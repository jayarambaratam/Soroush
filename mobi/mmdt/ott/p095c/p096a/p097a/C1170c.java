package mobi.mmdt.ott.p095c.p096a.p097a;

import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;

/* renamed from: mobi.mmdt.ott.c.a.a.c */
public class C1170c extends C1167x {
    public C1170c(String str, String[] strArr, String[] strArr2) {
        super(str);
        put("HashMethods", new JSONArray(new ArrayList(Arrays.asList(strArr))));
        put("EncryptionMethods", new JSONArray(new ArrayList(Arrays.asList(strArr))));
        remove("RequestId");
    }
}
