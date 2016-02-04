package android.support.v4.app;

import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Iterator;

public class bh {
    private static final bp f867a;

    static {
        if (VERSION.SDK_INT >= 21) {
            f867a = new br();
        } else if (VERSION.SDK_INT >= 20) {
            f867a = new bq();
        } else if (VERSION.SDK_INT >= 19) {
            f867a = new bx();
        } else if (VERSION.SDK_INT >= 16) {
            f867a = new bw();
        } else if (VERSION.SDK_INT >= 14) {
            f867a = new bv();
        } else if (VERSION.SDK_INT >= 11) {
            f867a = new bu();
        } else if (VERSION.SDK_INT >= 9) {
            f867a = new bt();
        } else {
            f867a = new bs();
        }
    }

    private static void m1150b(bf bfVar, ArrayList<bi> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bfVar.m1144a((bi) it.next());
        }
    }

    private static void m1151b(bg bgVar, by byVar) {
        if (byVar == null) {
            return;
        }
        if (byVar instanceof bl) {
            bl blVar = (bl) byVar;
            ck.m1217a(bgVar, blVar.e, blVar.g, blVar.f, blVar.f881a);
        } else if (byVar instanceof bo) {
            bo boVar = (bo) byVar;
            ck.m1218a(bgVar, boVar.e, boVar.g, boVar.f, boVar.f911a);
        } else if (byVar instanceof bk) {
            bk bkVar = (bk) byVar;
            ck.m1216a(bgVar, bkVar.e, bkVar.g, bkVar.f, bkVar.f878a, bkVar.f879b, bkVar.f880c);
        }
    }
}
