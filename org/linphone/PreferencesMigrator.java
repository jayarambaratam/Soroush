package org.linphone;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.p086a.C1134b;
import mobi.mmdt.ott.p086a.C1136d;
import net.frakbot.glowpadbackport.BuildConfig;
import org.linphone.core.LinphoneCore;

public class PreferencesMigrator {
    private LinphonePreferences mNewPrefs;
    private SharedPreferences mOldPrefs;
    private Resources mResources;

    public PreferencesMigrator(Context context) {
        this.mNewPrefs = LinphonePreferences.instance();
        this.mResources = context.getResources();
        this.mOldPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    private void deleteAllOldPreferences() {
        Editor edit = this.mOldPrefs.edit();
        edit.clear();
        edit.commit();
    }

    private void doAccountMigration(int i, boolean z) {
        String valueOf = i == 0 ? BuildConfig.FLAVOR : String.valueOf(i);
        String prefString = getPrefString(getString(C1136d.pref_username_key) + valueOf, null);
        String prefString2 = getPrefString(getString(C1136d.pref_auth_userid_key) + valueOf, null);
        String prefString3 = getPrefString(getString(C1136d.pref_passwd_key) + valueOf, null);
        String prefString4 = getPrefString(getString(C1136d.pref_domain_key) + valueOf, null);
        if (prefString != null && prefString.length() > 0 && prefString3 != null) {
            this.mNewPrefs.setNewAccountUsername(prefString);
            this.mNewPrefs.setNewAccountUserId(prefString2);
            this.mNewPrefs.setNewAccountDomain(prefString4);
            this.mNewPrefs.setNewAccountPassword(prefString3);
            this.mNewPrefs.setNewAccountProxy(getPrefString(getString(C1136d.pref_proxy_key) + valueOf, null));
            this.mNewPrefs.setNewAccountExpires(getPrefString(C1136d.pref_expire_key, null));
            if (getPrefBoolean(getString(C1136d.pref_enable_outbound_proxy_key) + valueOf, false)) {
                this.mNewPrefs.setNewAccountOutboundProxyEnabled(true);
            }
            if (this.mResources.getBoolean(C1134b.enable_push_id)) {
                valueOf = this.mNewPrefs.getPushNotificationRegistrationID();
                prefString = getString(C1136d.push_sender_id);
                if (valueOf != null && this.mNewPrefs.isPushNotificationEnabled()) {
                    this.mNewPrefs.setNewAccountContactParameters("app-id=" + prefString + ";pn-type=google;pn-tok=" + valueOf);
                }
            }
            try {
                this.mNewPrefs.saveNewAccount();
            } catch (Throwable e) {
                C1104b.m6368b((Object) this, e);
            }
            if (z) {
                this.mNewPrefs.setDefaultAccount(i);
            }
        }
    }

    private void doAccountsMigration() {
        LinphoneCore lcIfManagerNotDestroyedOrNull = LinphoneManager.getLcIfManagerNotDestroyedOrNull();
        lcIfManagerNotDestroyedOrNull.clearAuthInfos();
        lcIfManagerNotDestroyedOrNull.clearProxyConfigs();
        int i = 0;
        while (i < this.mOldPrefs.getInt(getString(C1136d.pref_extra_accounts), 1)) {
            doAccountMigration(i, i == getPrefInt(C1136d.pref_default_account_key, 0));
            i++;
        }
    }

    private boolean getPrefBoolean(int i, boolean z) {
        return this.mOldPrefs.getBoolean(this.mResources.getString(i), z);
    }

    private boolean getPrefBoolean(String str, boolean z) {
        return this.mOldPrefs.getBoolean(str, z);
    }

    private int getPrefInt(int i, int i2) {
        return this.mOldPrefs.getInt(this.mResources.getString(i), i2);
    }

    private String getPrefString(int i, String str) {
        return this.mOldPrefs.getString(this.mResources.getString(i), str);
    }

    private String getPrefString(String str, String str2) {
        return this.mOldPrefs.getString(str, str2);
    }

    private String getString(int i) {
        return this.mResources.getString(i);
    }

    public void doMigration() {
        this.mNewPrefs.firstLaunchSuccessful();
        this.mNewPrefs.removePreviousVersionAuthInfoRemoval();
        this.mNewPrefs.setFrontCamAsDefault(getPrefBoolean(C1136d.pref_video_use_front_camera_key, true));
        this.mNewPrefs.setWifiOnlyEnabled(Boolean.valueOf(getPrefBoolean(C1136d.pref_wifi_only_key, false)));
        this.mNewPrefs.useRandomPort(getPrefBoolean(C1136d.pref_transport_use_random_ports_key, true), false);
        this.mNewPrefs.setPushNotificationEnabled(getPrefBoolean(C1136d.pref_push_notification_key, false));
        this.mNewPrefs.setPushNotificationRegistrationID(getPrefString(C1136d.push_reg_id_key, null));
        this.mNewPrefs.setDebugEnabled(getPrefBoolean(C1136d.pref_debug_key, false));
        this.mNewPrefs.setBackgroundModeEnabled(getPrefBoolean(C1136d.pref_background_mode_key, true));
        this.mNewPrefs.setAnimationsEnabled(getPrefBoolean(C1136d.pref_animation_enable_key, false));
        this.mNewPrefs.setAutoStart(getPrefBoolean(C1136d.pref_autostart_key, false));
        this.mNewPrefs.setSharingPictureServerUrl(getPrefString(C1136d.pref_image_sharing_server_key, null));
        this.mNewPrefs.setRemoteProvisioningUrl(getPrefString(C1136d.pref_remote_provisioning_key, null));
        doAccountsMigration();
        deleteAllOldPreferences();
    }

    public boolean isMigrationNeeded() {
        return this.mOldPrefs.getInt(getString(C1136d.pref_extra_accounts), -1) != -1;
    }
}
