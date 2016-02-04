package mobi.mmdt.ott.view.components.fileselector;

import java.io.File;
import java.io.FileFilter;
import mobi.mmdt.componentsutils.C1114a;

/* renamed from: mobi.mmdt.ott.view.components.fileselector.c */
class C1812c implements FileFilter {
    final /* synthetic */ C1811b f5834a;

    C1812c(C1811b c1811b) {
        this.f5834a = c1811b;
    }

    public boolean accept(File file) {
        if (!file.isFile()) {
            return true;
        }
        return FileSelectorActivity.f5791i.containsKey(C1114a.m6428f(file.getAbsolutePath()).toLowerCase());
    }
}
