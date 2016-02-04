package android.support.v4.view;

import android.view.View;

class ey {
    public static void m2876a(View view, fc fcVar) {
        if (fcVar != null) {
            view.animate().setListener(new ez(fcVar, view));
        } else {
            view.animate().setListener(null);
        }
    }
}
