package org.linphone.core;

import java.util.Vector;

public interface LinphoneAddress {

    public class TransportType {
        public static TransportType LinphoneTransportTcp;
        public static TransportType LinphoneTransportTls;
        public static TransportType LinphoneTransportUdp;
        private static Vector<TransportType> values;
        private final String mStringValue;
        private final int mValue;

        static {
            values = new Vector();
            LinphoneTransportUdp = new TransportType(0, "LinphoneTransportUdp");
            LinphoneTransportTcp = new TransportType(1, "LinphoneTransportTcp");
            LinphoneTransportTls = new TransportType(2, "LinphoneTransportTls");
        }

        private TransportType(int i, String str) {
            this.mValue = i;
            values.addElement(this);
            this.mStringValue = str;
        }

        public static TransportType fromInt(int i) {
            for (int i2 = 0; i2 < values.size(); i2++) {
                TransportType transportType = (TransportType) values.elementAt(i2);
                if (transportType.mValue == i) {
                    return transportType;
                }
            }
            throw new RuntimeException("state not found [" + i + "]");
        }

        public int toInt() {
            return this.mValue;
        }

        public String toString() {
            return this.mStringValue;
        }
    }

    String asString();

    String asStringUriOnly();

    void clean();

    String getDisplayName();

    String getDomain();

    String getPort();

    int getPortInt();

    TransportType getTransport();

    String getUserName();

    void setDisplayName(String str);

    void setDomain(String str);

    void setPort(String str);

    void setPortInt(int i);

    void setTransport(TransportType transportType);

    void setUserName(String str);

    String toString();
}
