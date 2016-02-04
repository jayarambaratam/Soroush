package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;

class cu {
    static RemoteInput[] m1235a(cw[] cwVarArr) {
        if (cwVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[cwVarArr.length];
        for (int i = 0; i < cwVarArr.length; i++) {
            cw cwVar = cwVarArr[i];
            remoteInputArr[i] = new Builder(cwVar.m1225a()).setLabel(cwVar.m1226b()).setChoices(cwVar.m1227c()).setAllowFreeFormInput(cwVar.m1228d()).addExtras(cwVar.m1229e()).build();
        }
        return remoteInputArr;
    }
}
