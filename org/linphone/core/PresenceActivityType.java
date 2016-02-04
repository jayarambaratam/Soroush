package org.linphone.core;

import mobi.mmdt.ott.C1317h;
import org.linphone.mediastream.Version;

public enum PresenceActivityType {
    Offline(0),
    Online(1),
    Appointment(2),
    Away(3),
    Breakfast(4),
    Busy(5),
    Dinner(6),
    Holiday(7),
    InTransit(8),
    LookingForWork(9),
    Lunch(10),
    Meal(11),
    Meeting(12),
    OnThePhone(13),
    Other(14),
    Performance(15),
    PermanentAbsence(16),
    Playing(17),
    Presentation(18),
    Shopping(19),
    Sleeping(20),
    Spectator(21),
    Steering(22),
    Travel(23),
    TV(24),
    Unknown(25),
    Vacation(26),
    Working(27),
    Worship(28),
    Invalid(29);
    
    protected final int mValue;

    private PresenceActivityType(int i) {
        this.mValue = i;
    }

    protected static PresenceActivityType fromInt(int i) {
        switch (i) {
            case VideoSize.QCIF /*0*/:
                return Offline;
            case VideoSize.CIF /*1*/:
                return Online;
            case VideoSize.HVGA /*2*/:
                return Appointment;
            case Version.API03_CUPCAKE_15 /*3*/:
                return Away;
            case Version.API04_DONUT_16 /*4*/:
                return Breakfast;
            case Version.API05_ECLAIR_20 /*5*/:
                return Busy;
            case Version.API06_ECLAIR_201 /*6*/:
                return Dinner;
            case Version.API07_ECLAIR_21 /*7*/:
                return Holiday;
            case Version.API08_FROYO_22 /*8*/:
                return InTransit;
            case Version.API09_GINGERBREAD_23 /*9*/:
                return LookingForWork;
            case Version.API10_GINGERBREAD_MR1_233 /*10*/:
                return Lunch;
            case Version.API11_HONEYCOMB_30 /*11*/:
                return Meal;
            case Version.API12_HONEYCOMB_MR1_31X /*12*/:
                return Meeting;
            case Version.API13_HONEYCOMB_MR2_32 /*13*/:
                return OnThePhone;
            case Version.API14_ICE_CREAM_SANDWICH_40 /*14*/:
                return Other;
            case Version.API15_ICE_CREAM_SANDWICH_403 /*15*/:
                return Performance;
            case Version.API16_JELLY_BEAN_41 /*16*/:
                return PermanentAbsence;
            case Version.API17_JELLY_BEAN_42 /*17*/:
                return Playing;
            case Version.API18_JELLY_BEAN_43 /*18*/:
                return Presentation;
            case Version.API19_KITKAT_44 /*19*/:
                return Shopping;
            case C1317h.Toolbar_navigationIcon /*20*/:
                return Sleeping;
            case C1317h.Toolbar_navigationContentDescription /*21*/:
                return Spectator;
            case C1317h.Toolbar_logoDescription /*22*/:
                return Steering;
            case C1317h.Toolbar_titleTextColor /*23*/:
                return Travel;
            case C1317h.Toolbar_subtitleTextColor /*24*/:
                return TV;
            case C1317h.Theme_actionMenuTextAppearance /*25*/:
                return Unknown;
            case C1317h.Theme_actionMenuTextColor /*26*/:
                return Vacation;
            case C1317h.Theme_actionModeStyle /*27*/:
                return Working;
            case C1317h.Theme_actionModeCloseButtonStyle /*28*/:
                return Worship;
            default:
                return Invalid;
        }
    }

    public int toInt() {
        return this.mValue;
    }
}
