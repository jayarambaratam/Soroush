package android.support.v4.app;

import android.os.Bundle;

class cy {
    static Bundle m1236a(cw cwVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", cwVar.m1225a());
        bundle.putCharSequence("label", cwVar.m1226b());
        bundle.putCharSequenceArray("choices", cwVar.m1227c());
        bundle.putBoolean("allowFreeFormInput", cwVar.m1228d());
        bundle.putBundle("extras", cwVar.m1229e());
        return bundle;
    }

    static Bundle[] m1237a(cw[] cwVarArr) {
        if (cwVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[cwVarArr.length];
        for (int i = 0; i < cwVarArr.length; i++) {
            bundleArr[i] = m1236a(cwVarArr[i]);
        }
        return bundleArr;
    }
}
