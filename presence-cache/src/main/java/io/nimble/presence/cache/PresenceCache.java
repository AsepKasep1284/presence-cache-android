package io.nimble.presence.cache;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * A bounded, app-private cache for presence values supplied by the host app.
 */
public final class PresenceCache {
    private static final String STORE = "presence_cache";

    private final SharedPreferences preferences;

    private PresenceCache(Context context) {
        preferences = context.getApplicationContext()
                .getSharedPreferences(STORE, Context.MODE_PRIVATE);
    }

    public static PresenceCache create(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        return new PresenceCache(context);
    }

    public void put(String memberId, String state) {
        requireValue(memberId, "memberId");
        requireValue(state, "state");
        preferences.edit().putString(memberId, state).apply();
    }

    public String get(String memberId) {
        requireValue(memberId, "memberId");
        return preferences.getString(memberId, null);
    }

    public void remove(String memberId) {
        requireValue(memberId, "memberId");
        preferences.edit().remove(memberId).apply();
    }

    public void clear() {
        preferences.edit().clear().apply();
    }

    private static void requireValue(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " must not be blank");
        }
    }
}

