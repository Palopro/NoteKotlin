@file:JvmName("PrefsUtils")

package com.vladh.notekotlin.utils

import android.content.Context
import android.content.SharedPreferences
import kotlin.properties.Delegates

private var prefs by Delegates.notNull<SharedPreferences>()

fun initPrefs(context: Context) {
    prefs = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
}

fun getNotesSortMethodName(defaultValue: String): String = prefs.getString("sort_method", defaultValue)

fun setNotesSortMethod(sortMethod: String) {
    prefs.edit().putString("sort_method", sortMethod).apply()
}