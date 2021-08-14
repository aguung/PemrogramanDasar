package com.devfutech.pemrogramandasar.data.local

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.devfutech.pemrogramandasar.utils.dataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AppPreferences @Inject constructor(
    @ApplicationContext val context: Context
) {

    val intro: Flow<Boolean>
        get() = context.dataStore.data.map { preferences ->
            preferences[KEY_INTRO] ?: false
        }

    suspend fun saveIntro(intro: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[KEY_INTRO] = intro
        }
    }

    val guideHome: Flow<Boolean>
        get() = context.dataStore.data.map { preferences ->
            preferences[KEY_GUIDE_HOME] ?: false
        }

    suspend fun saveGuideHome(guide: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[KEY_GUIDE_HOME] = guide
        }
    }

    companion object {
        val KEY_INTRO = booleanPreferencesKey("key_intro")
        val KEY_GUIDE_HOME = booleanPreferencesKey("key_guide_home")
    }
}