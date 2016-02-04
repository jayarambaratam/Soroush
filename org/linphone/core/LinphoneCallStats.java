package org.linphone.core;

import java.util.Vector;

public interface LinphoneCallStats {

    public class IceState {
        public static IceState Failed;
        public static IceState HostConnection;
        public static IceState InProgress;
        public static IceState NotActivated;
        public static IceState ReflexiveConnection;
        public static IceState RelayConnection;
        private static Vector<IceState> values;
        private final String mStringValue;
        protected final int mValue;

        static {
            values = new Vector();
            NotActivated = new IceState(0, "Not activated");
            Failed = new IceState(1, "Failed");
            InProgress = new IceState(2, "In progress");
            HostConnection = new IceState(3, "Host connection");
            ReflexiveConnection = new IceState(4, "Reflexive connection");
            RelayConnection = new IceState(5, "Relay connection");
        }

        private IceState(int i, String str) {
            this.mValue = i;
            values.addElement(this);
            this.mStringValue = str;
        }

        public static IceState fromInt(int i) {
            for (int i2 = 0; i2 < values.size(); i2++) {
                IceState iceState = (IceState) values.elementAt(i2);
                if (iceState.mValue == i) {
                    return iceState;
                }
            }
            throw new RuntimeException("IceState not found [" + i + "]");
        }

        public String toString() {
            return this.mStringValue;
        }
    }

    public class MediaType {
        public static MediaType Audio;
        public static MediaType Video;
        private static Vector<MediaType> values;
        private final String mStringValue;
        protected final int mValue;

        static {
            values = new Vector();
            Audio = new MediaType(0, "Audio");
            Video = new MediaType(1, "Video");
        }

        private MediaType(int i, String str) {
            this.mValue = i;
            values.addElement(this);
            this.mStringValue = str;
        }

        public static MediaType fromInt(int i) {
            for (int i2 = 0; i2 < values.size(); i2++) {
                MediaType mediaType = (MediaType) values.elementAt(i2);
                if (mediaType.mValue == i) {
                    return mediaType;
                }
            }
            throw new RuntimeException("MediaType not found [" + i + "]");
        }

        public String toString() {
            return this.mStringValue;
        }
    }

    float getDownloadBandwidth();

    IceState getIceState();

    float getJitterBufferSize();

    long getLatePacketsCumulativeNumber();

    float getLocalLateRate();

    float getLocalLossRate();

    MediaType getMediaType();

    float getReceiverInterarrivalJitter();

    float getReceiverLossRate();

    float getRoundTripDelay();

    float getSenderInterarrivalJitter();

    float getSenderLossRate();

    float getUploadBandwidth();
}
