package org.apache.http.myHttp.message;

import net.frakbot.glowpadbackport.BuildConfig;
import org.apache.http.myHttp.Header;
import org.apache.http.myHttp.HttpVersion;
import org.apache.http.myHttp.ParseException;
import org.apache.http.myHttp.ProtocolVersion;
import org.apache.http.myHttp.RequestLine;
import org.apache.http.myHttp.StatusLine;
import org.apache.http.myHttp.annotation.Immutable;
import org.apache.http.myHttp.protocol.HTTP;
import org.apache.http.myHttp.util.Args;
import org.apache.http.myHttp.util.CharArrayBuffer;

@Immutable
public class BasicLineParser implements LineParser {
    @Deprecated
    public static final BasicLineParser DEFAULT;
    public static final BasicLineParser INSTANCE;
    protected final ProtocolVersion protocol;

    static {
        DEFAULT = new BasicLineParser();
        INSTANCE = new BasicLineParser();
    }

    public BasicLineParser() {
        this(null);
    }

    public BasicLineParser(ProtocolVersion protocolVersion) {
        if (protocolVersion == null) {
            protocolVersion = HttpVersion.HTTP_1_1;
        }
        this.protocol = protocolVersion;
    }

    public static Header parseHeader(String str, LineParser lineParser) {
        Args.notNull(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        if (lineParser == null) {
            lineParser = INSTANCE;
        }
        return lineParser.parseHeader(charArrayBuffer);
    }

    public static ProtocolVersion parseProtocolVersion(String str, LineParser lineParser) {
        Args.notNull(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        if (lineParser == null) {
            lineParser = INSTANCE;
        }
        return lineParser.parseProtocolVersion(charArrayBuffer, parserCursor);
    }

    public static RequestLine parseRequestLine(String str, LineParser lineParser) {
        Args.notNull(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        if (lineParser == null) {
            lineParser = INSTANCE;
        }
        return lineParser.parseRequestLine(charArrayBuffer, parserCursor);
    }

    public static StatusLine parseStatusLine(String str, LineParser lineParser) {
        Args.notNull(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        if (lineParser == null) {
            lineParser = INSTANCE;
        }
        return lineParser.parseStatusLine(charArrayBuffer, parserCursor);
    }

    protected ProtocolVersion createProtocolVersion(int i, int i2) {
        return this.protocol.forVersion(i, i2);
    }

    protected RequestLine createRequestLine(String str, String str2, ProtocolVersion protocolVersion) {
        return new BasicRequestLine(str, str2, protocolVersion);
    }

    protected StatusLine createStatusLine(ProtocolVersion protocolVersion, int i, String str) {
        return new BasicStatusLine(protocolVersion, i, str);
    }

    public boolean hasProtocolVersion(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        boolean z = true;
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        int pos = parserCursor.getPos();
        String protocol = this.protocol.getProtocol();
        int length = protocol.length();
        if (charArrayBuffer.length() < length + 4) {
            return false;
        }
        if (pos < 0) {
            pos = (charArrayBuffer.length() - 4) - length;
        } else if (pos == 0) {
            while (pos < charArrayBuffer.length() && HTTP.isWhitespace(charArrayBuffer.charAt(pos))) {
                pos++;
            }
        }
        if ((pos + length) + 4 > charArrayBuffer.length()) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (z2 && i < length) {
            z2 = charArrayBuffer.charAt(pos + i) == protocol.charAt(i);
            i++;
        }
        if (!z2) {
            z = z2;
        } else if (charArrayBuffer.charAt(pos + length) != '/') {
            z = false;
        }
        return z;
    }

    public Header parseHeader(CharArrayBuffer charArrayBuffer) {
        return new BufferedHeader(charArrayBuffer);
    }

    public ProtocolVersion parseProtocolVersion(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        Object obj = 1;
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        String protocol = this.protocol.getProtocol();
        int length = protocol.length();
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        skipWhitespace(charArrayBuffer, parserCursor);
        int pos2 = parserCursor.getPos();
        if ((pos2 + length) + 4 > upperBound) {
            throw new ParseException("Not a valid protocol version: " + charArrayBuffer.substring(pos, upperBound));
        }
        int i = 0;
        Object obj2 = 1;
        while (obj2 != null && i < length) {
            obj2 = charArrayBuffer.charAt(pos2 + i) == protocol.charAt(i) ? 1 : null;
            i++;
        }
        if (obj2 == null) {
            obj = obj2;
        } else if (charArrayBuffer.charAt(pos2 + length) != '/') {
            obj = null;
        }
        if (obj == null) {
            throw new ParseException("Not a valid protocol version: " + charArrayBuffer.substring(pos, upperBound));
        }
        int i2 = (length + 1) + pos2;
        int indexOf = charArrayBuffer.indexOf(46, i2, upperBound);
        if (indexOf == -1) {
            throw new ParseException("Invalid protocol version number: " + charArrayBuffer.substring(pos, upperBound));
        }
        try {
            int parseInt = Integer.parseInt(charArrayBuffer.substringTrimmed(i2, indexOf));
            indexOf++;
            i2 = charArrayBuffer.indexOf(32, indexOf, upperBound);
            if (i2 == -1) {
                i2 = upperBound;
            }
            try {
                indexOf = Integer.parseInt(charArrayBuffer.substringTrimmed(indexOf, i2));
                parserCursor.updatePos(i2);
                return createProtocolVersion(parseInt, indexOf);
            } catch (NumberFormatException e) {
                throw new ParseException("Invalid protocol minor version number: " + charArrayBuffer.substring(pos, upperBound));
            }
        } catch (NumberFormatException e2) {
            throw new ParseException("Invalid protocol major version number: " + charArrayBuffer.substring(pos, upperBound));
        }
    }

    public RequestLine parseRequestLine(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        try {
            skipWhitespace(charArrayBuffer, parserCursor);
            int pos2 = parserCursor.getPos();
            int indexOf = charArrayBuffer.indexOf(32, pos2, upperBound);
            if (indexOf < 0) {
                throw new ParseException("Invalid request line: " + charArrayBuffer.substring(pos, upperBound));
            }
            String substringTrimmed = charArrayBuffer.substringTrimmed(pos2, indexOf);
            parserCursor.updatePos(indexOf);
            skipWhitespace(charArrayBuffer, parserCursor);
            indexOf = parserCursor.getPos();
            int indexOf2 = charArrayBuffer.indexOf(32, indexOf, upperBound);
            if (indexOf2 < 0) {
                throw new ParseException("Invalid request line: " + charArrayBuffer.substring(pos, upperBound));
            }
            String substringTrimmed2 = charArrayBuffer.substringTrimmed(indexOf, indexOf2);
            parserCursor.updatePos(indexOf2);
            ProtocolVersion parseProtocolVersion = parseProtocolVersion(charArrayBuffer, parserCursor);
            skipWhitespace(charArrayBuffer, parserCursor);
            if (parserCursor.atEnd()) {
                return createRequestLine(substringTrimmed, substringTrimmed2, parseProtocolVersion);
            }
            throw new ParseException("Invalid request line: " + charArrayBuffer.substring(pos, upperBound));
        } catch (IndexOutOfBoundsException e) {
            throw new ParseException("Invalid request line: " + charArrayBuffer.substring(pos, upperBound));
        }
    }

    public StatusLine parseStatusLine(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        try {
            ProtocolVersion parseProtocolVersion = parseProtocolVersion(charArrayBuffer, parserCursor);
            skipWhitespace(charArrayBuffer, parserCursor);
            int pos2 = parserCursor.getPos();
            int indexOf = charArrayBuffer.indexOf(32, pos2, upperBound);
            int i = indexOf < 0 ? upperBound : indexOf;
            String substringTrimmed = charArrayBuffer.substringTrimmed(pos2, i);
            indexOf = 0;
            while (indexOf < substringTrimmed.length()) {
                if (Character.isDigit(substringTrimmed.charAt(indexOf))) {
                    indexOf++;
                } else {
                    throw new ParseException("Status line contains invalid status code: " + charArrayBuffer.substring(pos, upperBound));
                }
            }
            return createStatusLine(parseProtocolVersion, Integer.parseInt(substringTrimmed), i < upperBound ? charArrayBuffer.substringTrimmed(i, upperBound) : BuildConfig.FLAVOR);
        } catch (NumberFormatException e) {
            throw new ParseException("Status line contains invalid status code: " + charArrayBuffer.substring(pos, upperBound));
        } catch (IndexOutOfBoundsException e2) {
            throw new ParseException("Invalid status line: " + charArrayBuffer.substring(pos, upperBound));
        }
    }

    protected void skipWhitespace(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        while (pos < upperBound && HTTP.isWhitespace(charArrayBuffer.charAt(pos))) {
            pos++;
        }
        parserCursor.updatePos(pos);
    }
}
