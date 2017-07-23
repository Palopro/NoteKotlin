package com.vladh.notekotlin

import android.content.Context
import com.activeandroid.app.Application
import com.vladh.notekotlin.di.AppComponent
import com.vladh.notekotlin.di.DaggerAppComponent
import com.vladh.notekotlin.di.NoteDaoModule
import com.vladh.notekotlin.utils.initPrefs

class NoteInApplication : Application() {

    companion object {
        lateinit var graph: AppComponent
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()

        initPrefs(this)

        context = this
        graph = DaggerAppComponent.builder().noteDaoModule(NoteDaoModule()).build()
    }

}