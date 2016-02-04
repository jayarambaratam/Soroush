package org.linphone.core;

import java.util.Vector;

public interface LinphoneCall {

    public class State {
        public static final State CallEnd;
        public static final State CallIncomingEarlyMedia;
        public static final State CallReleased;
        public static final State CallUpdatedByRemote;
        public static final State CallUpdating;
        public static final State Connected;
        public static final State Error;
        public static final State Idle;
        public static final State IncomingReceived;
        public static final State OutgoingEarlyMedia;
        public static final State OutgoingInit;
        public static final State OutgoingProgress;
        public static final State OutgoingRinging;
        public static final State Paused;
        public static final State PausedByRemote;
        public static final State Pausing;
        public static final State Refered;
        public static final State Resuming;
        public static final State StreamsRunning;
        private static Vector<State> values;
        private final String mStringValue;
        private final int mValue;

        static {
            values = new Vector();
            Idle = new State(0, "Idle");
            IncomingReceived = new State(1, "IncomingReceived");
            OutgoingInit = new State(2, "OutgoingInit");
            OutgoingProgress = new State(3, "OutgoingProgress");
            OutgoingRinging = new State(4, "OutgoingRinging");
            OutgoingEarlyMedia = new State(5, "OutgoingEarlyMedia");
            Connected = new State(6, "Connected");
            StreamsRunning = new State(7, "StreamsRunning");
            Pausing = new State(8, "Pausing");
            Paused = new State(9, "Paused");
            Resuming = new State(10, "Resuming");
            Refered = new State(11, "Refered");
            Error = new State(12, "Error");
            CallEnd = new State(13, "CallEnd");
            PausedByRemote = new State(14, "PausedByRemote");
            CallUpdatedByRemote = new State(15, "UpdatedByRemote");
            CallIncomingEarlyMedia = new State(16, "IncomingEarlyMedia");
            CallUpdating = new State(17, "Updating");
            CallReleased = new State(18, "Released");
        }

        private State(int i, String str) {
            this.mValue = i;
            values.addElement(this);
            this.mStringValue = str;
        }

        public static State fromInt(int i) {
            for (int i2 = 0; i2 < values.size(); i2++) {
                State state = (State) values.elementAt(i2);
                if (state.mValue == i) {
                    return state;
                }
            }
            throw new RuntimeException("state not found [" + i + "]");
        }

        public String toString() {
            return this.mStringValue;
        }

        public final int value() {
            return this.mValue;
        }
    }

    boolean cameraEnabled();

    void enableCamera(boolean z);

    void enableEchoCancellation(boolean z);

    void enableEchoLimiter(boolean z);

    LinphoneCallStats getAudioStats();

    String getAuthenticationToken();

    float getAverageQuality();

    LinphoneCallLog getCallLog();

    LinphoneCallParams getCurrentParamsCopy();

    float getCurrentQuality();

    CallDirection getDirection();

    int getDuration();

    float getPlayVolume();

    LinphoneAddress getRemoteAddress();

    String getRemoteContact();

    LinphoneCallParams getRemoteParams();

    String getRemoteUserAgent();

    LinphoneCall getReplacedCall();

    State getState();

    State getTransferState();

    LinphoneCall getTransferTargetCall();

    LinphoneCall getTransfererCall();

    LinphoneCallStats getVideoStats();

    boolean isAuthenticationTokenVerified();

    boolean isEchoCancellationEnabled();

    boolean isEchoLimiterEnabled();

    boolean isInConference();

    void sendInfoMessage(LinphoneInfoMessage linphoneInfoMessage);

    void setAuthenticationTokenVerified(boolean z);

    void startRecording();

    void stopRecording();

    void takeSnapshot(String str);

    void zoomVideo(float f, float f2, float f3);
}
