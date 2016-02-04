package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import java.util.ArrayList;
import mobi.mmdt.componentsutils.C1114a;
import mobi.mmdt.ott.view.call.CallActivity;
import mobi.mmdt.ott.view.components.mediaviewer.ImageViewerActivity;
import mobi.mmdt.ott.view.components.mediaviewer.MediaViewerActivity;
import mobi.mmdt.ott.view.contact.contactprofileinfo.ContactProfileInfoActivity;
import mobi.mmdt.ott.view.conversation.C1988a;
import mobi.mmdt.ott.view.conversation.activities.BulkMessageConversationActivity;
import mobi.mmdt.ott.view.conversation.activities.ChannelConversationActivity;
import mobi.mmdt.ott.view.conversation.activities.GroupConversationActivity;
import mobi.mmdt.ott.view.conversation.activities.SingleConversationActivity;
import mobi.mmdt.ott.view.conversation.forward.ForwardActivity;
import mobi.mmdt.ott.view.conversation.groupinfo.AddParticipantsGroupContactSelectionListActivity;
import mobi.mmdt.ott.view.conversation.sharedmediaviewer.SharedMediaViewerActivity;
import mobi.mmdt.ott.view.main.MainActivity;
import mobi.mmdt.ott.view.main.basenavigation.ac;
import mobi.mmdt.ott.view.settings.forceupdate.ForceUpdateActivity;
import mobi.mmdt.ott.view.settings.mainsettings.profile_info.ProfileInfoSettingsActivity;
import mobi.mmdt.ott.view.settings.synctime.SyncTimeActivity;
import mobi.mmdt.ott.view.stickermarket.StickerMarketActivity;
import mobi.mmdt.ott.view.stickermarket.stickersettings.StickerSettingsActivity;

/* renamed from: mobi.mmdt.ott.view.a.a */
public class C1659a {
    public static PendingIntent m8424a(Context context, int i) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(603979776);
        intent.putExtra("KEY_PAGE_START", ac.TOP.ordinal());
        return PendingIntent.getActivity(context, i, intent, 134217728);
    }

    public static PendingIntent m8425a(Context context, int i, String str, C1988a c1988a) {
        Intent intent = new Intent(context, CallActivity.class);
        intent.putExtra("key_contact_user_id_string", str);
        intent.putExtra("key_start_mode", c1988a.ordinal());
        return PendingIntent.getActivity(context, i, intent, 134217728);
    }

    public static PendingIntent m8426a(Context context, String str, int i) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(603979776);
        intent.putExtra("KEY_PAGE_START", ac.TOP.ordinal());
        intent.putExtra("KEY_START_SINGLE_PARTY", str);
        return PendingIntent.getActivity(context, i, intent, 134217728);
    }

    public static void m8427a(Activity activity) {
        new Handler().postDelayed(new C1667i(activity, new Intent(activity, ProfileInfoSettingsActivity.class)), 10);
    }

    public static void m8428a(Activity activity, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse(str), "video/*");
        new Handler().postDelayed(new C1673o(activity, intent), 10);
    }

    public static void m8429a(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, SingleConversationActivity.class);
        intent.putExtra("KEY_PEER_PARTY", str);
        intent.putExtra("key_to_forward_message_id", str2);
        new Handler().postDelayed(new C1670l(activity, intent), 10);
    }

    public static void m8430a(Activity activity, String str, String str2, String str3) {
        Intent intent = new Intent(activity, MediaViewerActivity.class);
        intent.putExtra("KEY_PEER_PARTY", str2);
        intent.putExtra("KEY_TITLE", str3);
        intent.putExtra("KEY_CURRENT_MEDIA_PATH", str);
        new Handler().postDelayed(new C1672n(activity, intent), 10);
    }

    public static void m8431a(Activity activity, String str, ArrayList<String> arrayList) {
        Intent intent = new Intent(activity, AddParticipantsGroupContactSelectionListActivity.class);
        intent.putExtra("KEY_GROUP_ID", str);
        intent.putExtra("KEY_CHECKED_USERNAME_ARRAYLIST", arrayList);
        new Handler().postDelayed(new C1666h(activity, intent), 10);
    }

    public static void m8432a(Activity activity, String str, boolean z) {
        Intent intent = new Intent(activity, SingleConversationActivity.class);
        intent.putExtra("KEY_PEER_PARTY", str);
        new Handler().postDelayed(new C1660b(activity, intent, z), 10);
    }

    public static void m8433a(Activity activity, String str, boolean z, boolean z2) {
        Intent intent = new Intent(activity, ContactProfileInfoActivity.class);
        intent.putExtra("KEY_CONTACT_USER_ID_STRING", str);
        intent.putExtra("KEY_SHOW_LOCAL_INFO_BOOLEAN", z);
        new Handler().postDelayed(new C1668j(activity, intent, z2), 10);
    }

    public static void m8434a(Activity activity, ArrayList<String> arrayList, boolean z) {
        Intent intent = new Intent(activity, BulkMessageConversationActivity.class);
        intent.putExtra("KEY_PEER_PARTIES_ARRAYLIST", arrayList);
        new Handler().postDelayed(new C1665g(activity, intent, z), 10);
    }

    public static void m8435a(Context context) {
        Intent intent = new Intent(context, ForceUpdateActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void m8436a(Context context, String str) {
        Intent intent = new Intent(context, CallActivity.class);
        intent.putExtra("key_contact_user_id_string", str);
        intent.putExtra("key_start_mode", C1988a.RINGING.ordinal());
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static PendingIntent m8437b(Context context, String str, int i) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(603979776);
        intent.putExtra("KEY_PAGE_START", ac.TOP.ordinal());
        intent.putExtra("KEY_START_GROUP_PARTY", str);
        return PendingIntent.getActivity(context, i, intent, 134217728);
    }

    public static void m8438b(Activity activity) {
        new Handler().postDelayed(new C1676r(activity, new Intent(activity, StickerSettingsActivity.class)), 10);
    }

    public static void m8439b(Activity activity, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse(str), C1114a.m6429g(str));
        intent.setFlags(268435456);
        new Handler().postDelayed(new C1675q(activity, intent), 10);
    }

    public static void m8440b(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, SingleConversationActivity.class);
        intent.putExtra("KEY_PEER_PARTY", str);
        intent.putExtra("key_to_share_message", str2);
        intent.putExtra("key_is_share_mode", true);
        new Handler().postDelayed(new C1680v(activity, intent), 10);
    }

    public static void m8441b(Activity activity, String str, boolean z) {
        Intent intent = new Intent(activity, GroupConversationActivity.class);
        intent.putExtra("KEY_PARTY", str);
        new Handler().postDelayed(new C1684z(activity, intent, z), 10);
    }

    public static void m8442b(Context context) {
        Intent intent = new Intent(context, SyncTimeActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static PendingIntent m8443c(Context context, String str, int i) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(603979776);
        intent.putExtra("KEY_PAGE_START", ac.BOTTOM.ordinal());
        intent.putExtra("KEY_START_CHANNEL_PARTY", str);
        return PendingIntent.getActivity(context, i, intent, 134217728);
    }

    public static void m8444c(Activity activity) {
        new Handler().postDelayed(new C1679u(activity, new Intent(activity, StickerMarketActivity.class)), 10);
    }

    public static void m8445c(Activity activity, String str) {
        Intent intent = new Intent(activity, CallActivity.class);
        intent.putExtra("key_contact_user_id_string", str);
        intent.putExtra("key_start_mode", C1988a.MAKE_CALL.ordinal());
        new Handler().postDelayed(new C1677s(activity, intent), 10);
    }

    public static void m8446c(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, SingleConversationActivity.class);
        intent.putExtra("KEY_PEER_PARTY", str);
        intent.putExtra("key_to_share_image_uri", str2);
        intent.putExtra("key_is_share_mode", true);
        new Handler().postDelayed(new C1681w(activity, intent), 10);
    }

    public static void m8447c(Activity activity, String str, boolean z) {
        Intent intent = new Intent(activity, ChannelConversationActivity.class);
        intent.putExtra("KEY_PARTY", str);
        new Handler().postDelayed(new C1664f(activity, intent, z), 10);
    }

    public static void m8448d(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, SingleConversationActivity.class);
        intent.putExtra("KEY_PEER_PARTY", str);
        intent.putExtra("key_to_share_video_uri", str2);
        intent.putExtra("key_is_share_mode", true);
        new Handler().postDelayed(new C1682x(activity, intent), 10);
    }

    public static void m8449d(Activity activity, String str, boolean z) {
        Intent intent = new Intent(activity, ContactProfileInfoActivity.class);
        intent.putExtra("KEY_CONTACT_USER_ID_STRING", str);
        intent.putExtra("KEY_IS_NOT_SHOW_START_CHAT_BOOLEAN", true);
        new Handler().postDelayed(new C1669k(activity, intent, z), 10);
    }

    public static void m8450e(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, SingleConversationActivity.class);
        intent.putExtra("KEY_PEER_PARTY", str);
        intent.putExtra("key_to_share_file_uri", str2);
        intent.putExtra("key_is_share_mode", true);
        new Handler().postDelayed(new C1683y(activity, intent), 10);
    }

    public static void m8451e(Activity activity, String str, boolean z) {
        Intent intent = new Intent(activity, ForwardActivity.class);
        intent.putExtra("key_to_forward_message_id", str);
        intent.putExtra("key_is_forward_mode", true);
        new Handler().postDelayed(new C1678t(activity, intent, z), 10);
    }

    public static void m8452f(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, GroupConversationActivity.class);
        intent.putExtra("KEY_PARTY", str);
        intent.putExtra("key_to_forward_message_id", str2);
        new Handler().postDelayed(new aa(activity, intent), 10);
    }

    public static void m8453g(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, GroupConversationActivity.class);
        intent.putExtra("KEY_PARTY", str);
        intent.putExtra("key_to_share_message", str2);
        intent.putExtra("key_is_share_mode", true);
        new Handler().postDelayed(new ab(activity, intent), 10);
    }

    public static void m8454h(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, GroupConversationActivity.class);
        intent.putExtra("KEY_PARTY", str);
        intent.putExtra("key_to_share_image_uri", str2);
        intent.putExtra("key_is_share_mode", true);
        new Handler().postDelayed(new C1661c(activity, intent), 10);
    }

    public static void m8455i(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, GroupConversationActivity.class);
        intent.putExtra("KEY_PARTY", str);
        intent.putExtra("key_to_share_video_uri", str2);
        intent.putExtra("key_is_share_mode", true);
        new Handler().postDelayed(new C1662d(activity, intent), 10);
    }

    public static void m8456j(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, GroupConversationActivity.class);
        intent.putExtra("KEY_PARTY", str);
        intent.putExtra("key_to_share_file_uri", str2);
        intent.putExtra("key_is_share_mode", true);
        new Handler().postDelayed(new C1663e(activity, intent), 10);
    }

    public static void m8457k(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, ImageViewerActivity.class);
        intent.putExtra("KEY_CURRENT_MEDIA_PATH", str);
        intent.putExtra("KEY_TITLE", str2);
        new Handler().postDelayed(new C1671m(activity, intent), 10);
    }

    public static void m8458l(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, SharedMediaViewerActivity.class);
        intent.putExtra("KEY_PEER_PARTY", str);
        intent.putExtra("KEY_TITLE_TEXT", str2);
        new Handler().postDelayed(new C1674p(activity, intent), 10);
    }
}
