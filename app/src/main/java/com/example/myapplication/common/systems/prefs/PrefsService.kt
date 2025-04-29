package com.example.myapplication.common.systems.prefs

import android.content.Context
import androidx.core.content.edit
import com.example.myapplication.ui.compose.dialog.Gender

class PrefsService(context: Context, appId: String) {
    private val prefs = context.getSharedPreferences(appId, Context.MODE_PRIVATE)

    companion object {
        const val ageTokenKey = "ageTokenKey"
        const val genderTokenKey = "genderTokenKey"
    }

    var age: Int?
        get() = prefs.getInt(ageTokenKey, 0)
        set(value) {
            prefs.edit {
                value?.let { putInt(ageTokenKey, it) }
            }
        }
    var gender: Gender?
        get() {
            val result = prefs.getString(genderTokenKey, null)
            if (result != null)
                return Gender.valueOf(result)
            else
                return null
        }

        set(value) {
            prefs.edit {
                putString(genderTokenKey, value?.name)
            }
        }
}