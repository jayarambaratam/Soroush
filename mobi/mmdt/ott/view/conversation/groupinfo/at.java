package mobi.mmdt.ott.view.conversation.groupinfo;

import java.util.ArrayList;
import mobi.mmdt.ott.provider.p172f.C1614a;

class at implements Runnable {
    final /* synthetic */ GroupInfoActivity f7448a;

    at(GroupInfoActivity groupInfoActivity) {
        this.f7448a = groupInfoActivity;
    }

    public void run() {
        String[] b = C1614a.m8232b(this.f7448a.m8494q(), this.f7448a.f7414y);
        ArrayList arrayList = new ArrayList();
        for (Object add : b) {
            arrayList.add(add);
        }
        this.f7448a.runOnUiThread(new au(this, arrayList));
    }
}
