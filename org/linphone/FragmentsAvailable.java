package org.linphone;

import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

public enum FragmentsAvailable {
    UNKNOW,
    DIALER,
    HISTORY,
    HISTORY_DETAIL,
    CONTACTS,
    CONTACT,
    EDIT_CONTACT,
    ABOUT,
    ABOUT_INSTEAD_OF_SETTINGS,
    ABOUT_INSTEAD_OF_CHAT,
    ACCOUNT_SETTINGS,
    SETTINGS,
    CHATLIST,
    CHAT;

    /* renamed from: org.linphone.FragmentsAvailable.1 */
    /* synthetic */ class C27931 {
        static final /* synthetic */ int[] $SwitchMap$org$linphone$FragmentsAvailable;

        static {
            $SwitchMap$org$linphone$FragmentsAvailable = new int[FragmentsAvailable.values().length];
            try {
                $SwitchMap$org$linphone$FragmentsAvailable[FragmentsAvailable.HISTORY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$org$linphone$FragmentsAvailable[FragmentsAvailable.HISTORY_DETAIL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$org$linphone$FragmentsAvailable[FragmentsAvailable.CONTACTS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$org$linphone$FragmentsAvailable[FragmentsAvailable.CONTACT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$org$linphone$FragmentsAvailable[FragmentsAvailable.EDIT_CONTACT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$org$linphone$FragmentsAvailable[FragmentsAvailable.DIALER.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$org$linphone$FragmentsAvailable[FragmentsAvailable.ABOUT_INSTEAD_OF_CHAT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$org$linphone$FragmentsAvailable[FragmentsAvailable.CHATLIST.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$org$linphone$FragmentsAvailable[FragmentsAvailable.CHAT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$org$linphone$FragmentsAvailable[FragmentsAvailable.ABOUT_INSTEAD_OF_SETTINGS.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$org$linphone$FragmentsAvailable[FragmentsAvailable.SETTINGS.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$org$linphone$FragmentsAvailable[FragmentsAvailable.ABOUT.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$org$linphone$FragmentsAvailable[FragmentsAvailable.ACCOUNT_SETTINGS.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    public boolean isRightOf(FragmentsAvailable fragmentsAvailable) {
        boolean z = true;
        switch (C27931.$SwitchMap$org$linphone$FragmentsAvailable[ordinal()]) {
            case VideoSize.CIF /*1*/:
                if (fragmentsAvailable != UNKNOW) {
                    z = false;
                }
                return z;
            case VideoSize.HVGA /*2*/:
                return HISTORY.isRightOf(fragmentsAvailable) || fragmentsAvailable == HISTORY;
            case Version.API03_CUPCAKE_15 /*3*/:
                return HISTORY_DETAIL.isRightOf(fragmentsAvailable) || fragmentsAvailable == HISTORY_DETAIL;
            case Version.API04_DONUT_16 /*4*/:
                return CONTACTS.isRightOf(fragmentsAvailable) || fragmentsAvailable == CONTACTS;
            case Version.API05_ECLAIR_20 /*5*/:
                return CONTACT.isRightOf(fragmentsAvailable) || fragmentsAvailable == CONTACT;
            case Version.API06_ECLAIR_201 /*6*/:
                return EDIT_CONTACT.isRightOf(fragmentsAvailable) || fragmentsAvailable == EDIT_CONTACT;
            case Version.API07_ECLAIR_21 /*7*/:
            case Version.API08_FROYO_22 /*8*/:
                return DIALER.isRightOf(fragmentsAvailable) || fragmentsAvailable == DIALER;
            case Version.API09_GINGERBREAD_23 /*9*/:
                return CHATLIST.isRightOf(fragmentsAvailable) || fragmentsAvailable == CHATLIST;
            case Version.API10_GINGERBREAD_MR1_233 /*10*/:
            case Version.API11_HONEYCOMB_30 /*11*/:
                return CHATLIST.isRightOf(fragmentsAvailable) || fragmentsAvailable == CHATLIST || fragmentsAvailable == ABOUT_INSTEAD_OF_CHAT;
            case Version.API12_HONEYCOMB_MR1_31X /*12*/:
            case Version.API13_HONEYCOMB_MR2_32 /*13*/:
                return SETTINGS.isRightOf(fragmentsAvailable) || fragmentsAvailable == SETTINGS;
            default:
                return false;
        }
    }

    public boolean shouldAddItselfToTheRightOf(FragmentsAvailable fragmentsAvailable) {
        boolean z = false;
        switch (C27931.$SwitchMap$org$linphone$FragmentsAvailable[ordinal()]) {
            case VideoSize.HVGA /*2*/:
                return fragmentsAvailable == HISTORY;
            case Version.API04_DONUT_16 /*4*/:
                return fragmentsAvailable == CONTACTS;
            case Version.API05_ECLAIR_20 /*5*/:
                if (fragmentsAvailable == CONTACT || fragmentsAvailable == CONTACTS) {
                    z = true;
                }
                return z;
            case Version.API09_GINGERBREAD_23 /*9*/:
                return fragmentsAvailable == CHATLIST;
            default:
                return false;
        }
    }

    public boolean shouldAddToBackStack() {
        return true;
    }

    public boolean shouldAnimate() {
        return true;
    }
}
