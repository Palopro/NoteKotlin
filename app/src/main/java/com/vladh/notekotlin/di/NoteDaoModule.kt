package com.vladh.notekotlin.di

import com.vladh.notekotlin.mvp.models.NoteDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NoteDaoModule {

    @Provides
    @Singleton
    fun provideNoteDao(): NoteDao = NoteDao()
}