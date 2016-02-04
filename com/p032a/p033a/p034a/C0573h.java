package com.p032a.p033a.p034a;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import org.jivesoftware.smack.util.StringUtils;

/* renamed from: com.a.a.a.h */
final class C0573h {
    static final Charset f2379a;
    static final Charset f2380b;

    static {
        f2379a = Charset.forName(StringUtils.USASCII);
        f2380b = Charset.forName(StringUtils.UTF8);
    }

    static void m4277a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    static void m4278a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file2 = listFiles[i];
            if (file2.isDirectory()) {
                C0573h.m4278a(file2);
            }
            if (file2.delete()) {
                i++;
            } else {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }
}
