package mobi.mmdt.ott.logic.p161g;

import android.util.Log;
import mobi.mmdt.ott.logic.p112a.p113a.p114a.C1320a;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.g.d */
class C1532d implements C1531e {
    final /* synthetic */ C1530c f5132a;

    C1532d(C1530c c1530c) {
        this.f5132a = c1530c;
    }

    public void m7717a(int i, float f) {
    }

    public void m7718a(C1533f c1533f, String str) {
        if (c1533f.equals(C1533f.f5134b) || c1533f.equals(C1533f.f5135c)) {
            if (this.f5132a.f5129d != null) {
                this.f5132a.f5130e = false;
            } else {
                this.f5132a.f5130e = false;
            }
        } else if (c1533f.equals(C1533f.f5140h) || c1533f.equals(C1533f.f5139g)) {
            if (this.f5132a.f5129d != null) {
                this.f5132a.f5130e = true;
            } else {
                this.f5132a.f5130e = true;
            }
        } else if ((c1533f.equals(C1533f.f5146n) || c1533f.equals(C1533f.f5145m)) && this.f5132a.f5129d != null && this.f5132a.f5130e) {
        }
        String toLowerCase = str.toLowerCase();
        boolean z = true;
        switch (toLowerCase.hashCode()) {
            case -2120467137:
                if (toLowerCase.equals("call paused by remote")) {
                    z = true;
                    break;
                }
                break;
            case -2119211739:
                if (toLowerCase.equals("call terminated")) {
                    z = true;
                    break;
                }
                break;
            case -1147311558:
                if (toLowerCase.equals("outgoing call in progress")) {
                    z = true;
                    break;
                }
                break;
            case -881026536:
                if (toLowerCase.equals("incoming call")) {
                    z = false;
                    break;
                }
                break;
            case -805912137:
                if (toLowerCase.equals("busy here")) {
                    z = true;
                    break;
                }
                break;
            case -579210487:
                if (toLowerCase.equals("connected")) {
                    z = true;
                    break;
                }
                break;
            case -443104976:
                if (toLowerCase.equals("call paused")) {
                    z = true;
                    break;
                }
                break;
            case -335770198:
                if (toLowerCase.equals("resuming")) {
                    z = true;
                    break;
                }
                break;
            case -188109835:
                if (toLowerCase.equals("not found")) {
                    z = true;
                    break;
                }
                break;
            case -153084238:
                if (toLowerCase.equals("starting outgoing call")) {
                    z = true;
                    break;
                }
                break;
            case -123687464:
                if (toLowerCase.equals("remote ringing")) {
                    z = true;
                    break;
                }
                break;
            case 114465400:
                if (toLowerCase.equals("call ended")) {
                    z = true;
                    break;
                }
                break;
            case 279713067:
                if (toLowerCase.equals("pausing call")) {
                    z = true;
                    break;
                }
                break;
            case 1455337362:
                if (toLowerCase.equals("streams running")) {
                    z = true;
                    break;
                }
                break;
            case 1793542782:
                if (toLowerCase.equals("call declined.")) {
                    z = true;
                    break;
                }
                break;
            case 1847855295:
                if (toLowerCase.equals("call released")) {
                    z = true;
                    break;
                }
                break;
            case 1960761768:
                if (toLowerCase.equals("connected (streams running)")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case VideoSize.QCIF /*0*/:
                this.f5132a.f5131f = false;
                this.f5132a.f5127b = "Incomming call ...";
                break;
            case VideoSize.CIF /*1*/:
                this.f5132a.f5131f = false;
                this.f5132a.f5127b = "Try to make a call...";
                break;
            case VideoSize.HVGA /*2*/:
                this.f5132a.f5131f = false;
                this.f5132a.f5127b = "Try to make a call...";
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f5132a.f5131f = false;
                this.f5132a.f5127b = "RINGING...";
                break;
            case Version.API04_DONUT_16 /*4*/:
            case Version.API08_FROYO_22 /*8*/:
            case Version.API09_GINGERBREAD_23 /*9*/:
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                this.f5132a.f5131f = false;
                this.f5132a.f5127b = "In Call";
                break;
            case Version.API06_ECLAIR_201 /*6*/:
                this.f5132a.f5131f = false;
                this.f5132a.f5127b = "In Call";
                break;
            case Version.API07_ECLAIR_21 /*7*/:
                this.f5132a.f5127b = "Call finished.";
                break;
            case Version.API10_GINGERBREAD_MR1_233 /*10*/:
                this.f5132a.f5127b = "The subscriber you are calling is busy on another call.";
                this.f5132a.f5131f = true;
                break;
            case Version.API11_HONEYCOMB_30 /*11*/:
                this.f5132a.f5127b = "Call finished.";
                break;
            case Version.API12_HONEYCOMB_MR1_31X /*12*/:
                this.f5132a.f5127b = "on hold.";
                break;
            case Version.API13_HONEYCOMB_MR2_32 /*13*/:
                this.f5132a.f5127b = "on hold.";
                break;
            case Version.API14_ICE_CREAM_SANDWICH_40 /*14*/:
                this.f5132a.f5127b = "The subscriber rejected your call.";
                this.f5132a.f5131f = true;
                break;
            case Version.API15_ICE_CREAM_SANDWICH_403 /*15*/:
                this.f5132a.f5131f = false;
                this.f5132a.f5127b = "In Call";
                break;
            case Version.API16_JELLY_BEAN_41 /*16*/:
                this.f5132a.f5131f = true;
                this.f5132a.f5127b = "The subscriber you are calling is not online at the moment.";
                break;
            default:
                Log.d("CallManager", "Could not recognized state : " + str);
                this.f5132a.f5131f = true;
                this.f5132a.f5127b = str;
                break;
        }
        C0002c.m2a().m17c(new C1320a(c1533f, this.f5132a.f5127b, null));
    }
}
