package com.vladh.notekotlin.di

import com.vladh.notekotlin.mvp.presenters.MainPresenter
import com.vladh.notekotlin.mvp.presenters.NotePresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(NoteDaoModule::class))
interface AppComponent {
    fun inject(mainPresenter: MainPresenter)

    fun inject(notePresenter: NotePresenter)
}