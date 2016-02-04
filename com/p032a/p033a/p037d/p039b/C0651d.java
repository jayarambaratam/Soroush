package com.p032a.p033a.p037d.p039b;

import android.util.Log;
import com.p032a.p033a.p037d.C0676b;
import com.p032a.p033a.p037d.p039b.p041b.C0620c;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.a.a.d.b.d */
class C0651d<DataType> implements C0620c {
    final /* synthetic */ C0617a f2623a;
    private final C0676b<DataType> f2624b;
    private final DataType f2625c;

    public C0651d(C0617a c0617a, C0676b<DataType> c0676b, DataType dataType) {
        this.f2623a = c0617a;
        this.f2624b = c0676b;
        this.f2625c = dataType;
    }

    public boolean m4636a(File file) {
        boolean z = false;
        OutputStream outputStream = null;
        try {
            outputStream = this.f2623a.f2582l.m4635a(file);
            z = this.f2624b.m4699a(this.f2625c, outputStream);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                }
            }
        } catch (Throwable e2) {
            if (Log.isLoggable("DecodeJob", 3)) {
                Log.d("DecodeJob", "Failed to find file to write to disk cache", e2);
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                }
            }
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e4) {
                }
            }
        }
        return z;
    }
}
