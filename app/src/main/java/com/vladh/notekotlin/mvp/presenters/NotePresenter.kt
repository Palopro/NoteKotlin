package com.vladh.notekotlin.mvp.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.vladh.notekotlin.NoteInApplication
import com.vladh.notekotlin.bus.NoteDeleteAction
import com.vladh.notekotlin.bus.NoteEditAction
import com.vladh.notekotlin.mvp.models.Note
import com.vladh.notekotlin.mvp.models.NoteDao
import com.vladh.notekotlin.mvp.views.NoteView
import org.greenrobot.eventbus.EventBus
import java.util.*
import javax.inject.Inject

@InjectViewState
class NotePresenter : MvpPresenter<NoteView>() {

    @Inject
    lateinit var noteDao: NoteDao
    lateinit var note: Note
    var mNotePosition: Int = -1

    init {
        NoteInApplication.graph.inject(this)
    }

    fun showNote(noteId: Long, notePosition: Int) {
        mNotePosition = notePosition
        note = noteDao.getNoteById(noteId)
        viewState.showNote(note)
    }

    fun saveNote(title: String, text: String) {
        note.title = title
        note.text = text
        note.changeDate = Date()
        noteDao.saveNote(note)
        EventBus.getDefault().post(NoteEditAction(mNotePosition))
        viewState.onNoteSaved()
    }

    fun deleteNote() {
        noteDao.deleteNote(note)
        EventBus.getDefault().post(NoteDeleteAction(mNotePosition))
        viewState.onNoteDeleted()
    }

    fun showNoteDeleteDialog() {
        viewState.showNoteDeleteDialog()
    }

    fun hideNoteDeleteDialog() {
        viewState.hideNoteDeleteDialog()
    }

    fun showNoteInfoDialog() {
        viewState.showNoteInfoDialog(note.getInfo())
    }

    fun hideNoteInfoDialog() {
        viewState.hideNoteInfoDialog()
    }
}