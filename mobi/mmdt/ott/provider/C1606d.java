package mobi.mmdt.ott.provider;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;

/* renamed from: mobi.mmdt.ott.provider.d */
public class C1606d extends SQLiteOpenHelper {
    private static C1606d f5395a;
    private final Context f5396b;
    private final C1613e f5397c;

    private C1606d(Context context) {
        super(context, "ott.db", null, 26);
        this.f5396b = context;
        this.f5397c = new C1613e();
    }

    @TargetApi(11)
    private C1606d(Context context, DatabaseErrorHandler databaseErrorHandler) {
        super(context, "ott.db", null, 26, databaseErrorHandler);
        this.f5396b = context;
        this.f5397c = new C1613e();
    }

    public static C1606d m8145a(Context context) {
        if (f5395a == null) {
            f5395a = C1606d.m8146b(context.getApplicationContext());
        }
        return f5395a;
    }

    private static C1606d m8146b(Context context) {
        return VERSION.SDK_INT < 11 ? C1606d.m8147c(context) : C1606d.m8148d(context);
    }

    private static C1606d m8147c(Context context) {
        return new C1606d(context);
    }

    @TargetApi(11)
    private static C1606d m8148d(Context context) {
        return new C1606d(context, new DefaultDatabaseErrorHandler());
    }

    public void m8149a() {
        this.f5397c.m8225d(this.f5396b, getWritableDatabase());
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        C1104b.m6370d(this, "onCreate");
        this.f5397c.m8223b(this.f5396b, sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS blockedusers ( _id INTEGER PRIMARY KEY AUTOINCREMENT, blockedusers_user_Id TEXT NOT NULL, blockedusers_extra TEXT  );");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS conversations ( _id INTEGER PRIMARY KEY AUTOINCREMENT, conversations_message_id TEXT NOT NULL, conversations_event_type INTEGER NOT NULL, conversations_event TEXT, conversations_send_time INTEGER NOT NULL, conversations_receive_time INTEGER NOT NULL, conversations_my_vote TEXT, conversations_my_like INTEGER  DEFAULT 0, conversations_likes INTEGER NOT NULL DEFAULT 0, conversations_direction_type INTEGER NOT NULL, conversations_event_state INTEGER NOT NULL, conversations_party TEXT NOT NULL, conversations_peer_user_id TEXT NOT NULL, conversations_group_type INTEGER NOT NULL, conversations_reply_message_id TEXT, conversations_file_id INTEGER, conversations_sticker_id TEXT, conversations_extra TEXT , CONSTRAINT unique_message_id UNIQUE (conversations_message_id, conversations_direction_type) );");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS files ( _id INTEGER PRIMARY KEY AUTOINCREMENT, files_file_uri TEXT, files_file_url TEXT, files_server_file_id TEXT, files_type INTEGER NOT NULL, files_name TEXT NOT NULL, files_size INTEGER NOT NULL, files_progress INTEGER NOT NULL, files_thumbnail_uri TEXT, files_thumbnail_url TEXT, files_duration INTEGER, files_download_state INTEGER NOT NULL, files_thumbnail_download_state INTEGER NOT NULL, files_audio_state INTEGER, files_audio_playing_time INTEGER NOT NULL, files_extra TEXT  );");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS CHANNELS ( _id INTEGER PRIMARY KEY AUTOINCREMENT, CHANNELS_id TEXT NOT NULL, CHANNELS_name TEXT NOT NULL, CHANNELS_description TEXT, CHANNELS_avatar_url TEXT, CHANNELS_avatar_thumbnail_url TEXT, CHANNELS_followers INTEGER NOT NULL, CHANNELS_is_mute INTEGER NOT NULL, CHANNELS_my_role INTEGER NOT NULL, CHANNELS_channel_owner TEXT NOT NULL, CHANNELS_creation_date INTEGER NOT NULL, CHANNELS_is_reply_allowed INTEGER NOT NULL, CHANNELS_extra TEXT , CONSTRAINT unique_group_id UNIQUE (CHANNELS_id) ON CONFLICT REPLACE );");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS PrivateGroups ( _id INTEGER PRIMARY KEY AUTOINCREMENT, PrivateGroups_group_id TEXT NOT NULL, PrivateGroups_name TEXT NOT NULL, PrivateGroups_thumbnail_url TEXT, PrivateGroups_avatar_url TEXT, PrivateGroups_description TEXT, PrivateGroups_is_mute INTEGER NOT NULL, PrivateGroups_my_role INTEGER NOT NULL, PrivateGroups_creation_date INTEGER NOT NULL, PrivateGroups_extra TEXT ,CONSTRAINT unique_group_id UNIQUE (PrivateGroups_group_id) ON CONFLICT REPLACE );");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS members ( _id INTEGER PRIMARY KEY AUTOINCREMENT, members_nick_name TEXT, members_avatar_url TEXT, members_avatar_thumbnail_url TEXT, members_user_id TEXT NOT NULL, members_local_phone_number TEXT, members_last_online INTEGER DEFAULT -1, members_is_local_user INTEGER NOT NULL, members_can_reply INTEGER NOT NULL, members_is_anouncer INTEGER NOT NULL, members_local_name TEXT, members_moto TEXT, members_local_image_uri TEXT, members_is_new_user INTEGER NOT NULL ,members_is_synced_contact INTEGER NOT NULL, members_is_deactivated_user INTEGER NOT NULL, members_extra TEXT , CONSTRAINT unique_user_id UNIQUE (members_user_id) ON CONFLICT REPLACE );");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS members_group ( _id INTEGER PRIMARY KEY AUTOINCREMENT, members_group_group_id TEXT NOT NULL, members_group_user_id TEXT NOT NULL, members_group_user_role INTEGER NOT NULL, members_group_added_by_me INTEGER NOT NULL, members_group_extra TEXT , CONSTRAINT unique_user_group UNIQUE (members_group_group_id, members_group_user_id) ON CONFLICT REPLACE );");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS stickers ( _id INTEGER PRIMARY KEY AUTOINCREMENT, stickers_complete_sticker_id TEXT NOT NULL, stickers_sticker_id INTEGER NOT NULL, stickers_package_id INTEGER NOT NULL, stickers_sticker_version INTEGER NOT NULL, stickers_original_uri TEXT NOT NULL, stickers_thumbnail_uri TEXT NOT NULL, stickers_download_state INTEGER NOT NULL, stickers_x_axis INTEGER NOT NULL, stickers_y_axis INTEGER NOT NULL, stickers_ver_span INTEGER NOT NULL, stickers_hor_span INTEGER NOT NULL, stickers_extra TEXT , CONSTRAINT sticker_unique_id UNIQUE (stickers_package_id, stickers_sticker_id,stickers_sticker_version) ON CONFLICT REPLACE );");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS stickerspackage ( _id INTEGER PRIMARY KEY AUTOINCREMENT, stickerspackage_package_version INTEGER NOT NULL, stickerspackage_package_id INTEGER NOT NULL, stickerspackage_progress INTEGER NOT NULL, stickerspackage_download_state INTEGER NOT NULL, stickerspackage_download_id INTEGER NOT NULL, stickerspackage_count INTEGER NOT NULL, stickerspackage_price TEXT NOT NULL, stickerspackage_designer TEXT NOT NULL, stickerspackage_field TEXT NOT NULL, stickerspackage_name TEXT NOT NULL, stickerspackage_is_hidden INTEGER NOT NULL DEFAULT 0, stickerspackage_thumbnail_uri TEXT NOT NULL, stickerspackage_description TEXT, stickerspackage_extra TEXT , CONSTRAINT package_unique_id UNIQUE (stickerspackage_package_id, stickerspackage_package_version) ON CONFLICT REPLACE );");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS syncedcontacts ( _id INTEGER PRIMARY KEY AUTOINCREMENT, syncedcontacts_phone_number TEXT NOT NULL, syncedcontacts_extra_field TEXT , CONSTRAINT unique_syncedcontacts_phone_number UNIQUE (syncedcontacts_phone_number) ON CONFLICT ABORT );");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS userinchatstates ( _id INTEGER PRIMARY KEY AUTOINCREMENT, userinchatstates_sender TEXT NOT NULL, userinchatstates_party TEXT NOT NULL, userinchatstates_state INTEGER NOT NULL, userinchatstates_extra TEXT , CONSTRAINT unique_sender_party UNIQUE (userinchatstates_party, userinchatstates_sender) ON CONFLICT REPLACE );");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS recentemoji ( _id INTEGER PRIMARY KEY AUTOINCREMENT, recentemoji_value TEXT NOT NULL, recentemoji_usage_count INTEGER NOT NULL, recentemoji_extra TEXT , CONSTRAINT unique_recentemoji_value UNIQUE (recentemoji_value) ON CONFLICT ABORT );");
        this.f5397c.m8224c(this.f5396b, sQLiteDatabase);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        this.f5397c.m8221a(this.f5396b, sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.f5397c.m8222a(this.f5396b, sQLiteDatabase, i, i2);
    }
}
