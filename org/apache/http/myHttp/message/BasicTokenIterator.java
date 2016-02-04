package org.apache.http.myHttp.message;

import java.util.NoSuchElementException;
import org.apache.http.myHttp.HeaderIterator;
import org.apache.http.myHttp.ParseException;
import org.apache.http.myHttp.TokenIterator;
import org.apache.http.myHttp.annotation.NotThreadSafe;
import org.apache.http.myHttp.util.Args;

@NotThreadSafe
public class BasicTokenIterator implements TokenIterator {
    public static final String HTTP_SEPARATORS = " ,;=()<>@:\\\"/[]?{}\t";
    protected String currentHeader;
    protected String currentToken;
    protected final HeaderIterator headerIt;
    protected int searchPos;

    public BasicTokenIterator(HeaderIterator headerIterator) {
        this.headerIt = (HeaderIterator) Args.notNull(headerIterator, "Header iterator");
        this.searchPos = findNext(-1);
    }

    protected String createToken(String str, int i, int i2) {
        return str.substring(i, i2);
    }

    protected int findNext(int i) {
        int findTokenSeparator;
        if (i >= 0) {
            findTokenSeparator = findTokenSeparator(i);
        } else if (!this.headerIt.hasNext()) {
            return -1;
        } else {
            this.currentHeader = this.headerIt.nextHeader().getValue();
            findTokenSeparator = 0;
        }
        int findTokenStart = findTokenStart(findTokenSeparator);
        if (findTokenStart < 0) {
            this.currentToken = null;
            return -1;
        }
        findTokenSeparator = findTokenEnd(findTokenStart);
        this.currentToken = createToken(this.currentHeader, findTokenStart, findTokenSeparator);
        return findTokenSeparator;
    }

    protected int findTokenEnd(int i) {
        Args.notNegative(i, "Search position");
        int length = this.currentHeader.length();
        int i2 = i + 1;
        while (i2 < length && isTokenChar(this.currentHeader.charAt(i2))) {
            i2++;
        }
        return i2;
    }

    protected int findTokenSeparator(int i) {
        int notNegative = Args.notNegative(i, "Search position");
        Object obj = null;
        int length = this.currentHeader.length();
        while (obj == null && notNegative < length) {
            char charAt = this.currentHeader.charAt(notNegative);
            if (isTokenSeparator(charAt)) {
                obj = 1;
            } else if (isWhitespace(charAt)) {
                notNegative++;
            } else if (isTokenChar(charAt)) {
                throw new ParseException("Tokens without separator (pos " + notNegative + "): " + this.currentHeader);
            } else {
                throw new ParseException("Invalid character after token (pos " + notNegative + "): " + this.currentHeader);
            }
        }
        return notNegative;
    }

    protected int findTokenStart(int i) {
        int notNegative = Args.notNegative(i, "Search position");
        Object obj = null;
        while (obj == null && this.currentHeader != null) {
            int length = this.currentHeader.length();
            Object obj2 = obj;
            int i2 = notNegative;
            Object obj3 = obj2;
            while (obj3 == null && i2 < length) {
                char charAt = this.currentHeader.charAt(i2);
                if (isTokenSeparator(charAt) || isWhitespace(charAt)) {
                    i2++;
                } else if (isTokenChar(this.currentHeader.charAt(i2))) {
                    obj3 = 1;
                } else {
                    throw new ParseException("Invalid character before token (pos " + i2 + "): " + this.currentHeader);
                }
            }
            if (obj3 == null) {
                if (this.headerIt.hasNext()) {
                    this.currentHeader = this.headerIt.nextHeader().getValue();
                    i2 = 0;
                } else {
                    this.currentHeader = null;
                }
            }
            obj2 = obj3;
            notNegative = i2;
            obj = obj2;
        }
        return obj != null ? notNegative : -1;
    }

    public boolean hasNext() {
        return this.currentToken != null;
    }

    protected boolean isHttpSeparator(char c) {
        return HTTP_SEPARATORS.indexOf(c) >= 0;
    }

    protected boolean isTokenChar(char c) {
        return Character.isLetterOrDigit(c) ? true : Character.isISOControl(c) ? false : !isHttpSeparator(c);
    }

    protected boolean isTokenSeparator(char c) {
        return c == ',';
    }

    protected boolean isWhitespace(char c) {
        return c == '\t' || Character.isSpaceChar(c);
    }

    public final Object next() {
        return nextToken();
    }

    public String nextToken() {
        if (this.currentToken == null) {
            throw new NoSuchElementException("Iteration already finished.");
        }
        String str = this.currentToken;
        this.searchPos = findNext(this.searchPos);
        return str;
    }

    public final void remove() {
        throw new UnsupportedOperationException("Removing tokens is not supported.");
    }
}
