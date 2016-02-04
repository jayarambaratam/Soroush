package org.apache.http.myHttp.entity.mime.content;

import android.support.v7.widget.RecyclerView.ItemAnimator;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.myHttp.entity.ContentType;
import org.apache.http.myHttp.entity.mime.MIME;
import org.apache.http.myHttp.util.Args;

public class FileBody extends AbstractContentBody {
    private final File file;
    private final String filename;

    public FileBody(File file) {
        this(file, ContentType.DEFAULT_BINARY, file != null ? file.getName() : null);
    }

    @Deprecated
    public FileBody(File file, String str) {
        this(file, ContentType.create(str), null);
    }

    @Deprecated
    public FileBody(File file, String str, String str2) {
        this(file, null, str, str2);
    }

    @Deprecated
    public FileBody(File file, String str, String str2, String str3) {
        this(file, ContentType.create(str2, str3), str);
    }

    public FileBody(File file, ContentType contentType) {
        this(file, contentType, null);
    }

    public FileBody(File file, ContentType contentType, String str) {
        super(contentType);
        Args.notNull(file, "File");
        this.file = file;
        this.filename = str;
    }

    public long getContentLength() {
        return this.file.length();
    }

    public File getFile() {
        return this.file;
    }

    public String getFilename() {
        return this.filename;
    }

    public InputStream getInputStream() {
        return new FileInputStream(this.file);
    }

    public String getTransferEncoding() {
        return MIME.ENC_BINARY;
    }

    public void writeTo(OutputStream outputStream) {
        Args.notNull(outputStream, "Output stream");
        InputStream fileInputStream = new FileInputStream(this.file);
        try {
            byte[] bArr = new byte[ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
            }
            outputStream.flush();
        } finally {
            fileInputStream.close();
        }
    }
}
