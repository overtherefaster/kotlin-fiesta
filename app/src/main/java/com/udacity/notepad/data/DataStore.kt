package com.udacity.notepad.data

import android.content.Context
import org.jetbrains.anko.doAsync

object DataStore {

    @JvmStatic
    lateinit var notes: NoteDatabase
        private set

    fun init(context: Context) {
        notes = NoteDatabase(context)
    }

    fun execute(runnable: Runnable) {
        doAsync { runnable.run() }
    }

    // more kotlin-ey, take lambda param instead of runnable
    fun exeute(fn: () -> Unit)
    {
        doAsync { fn() }
    }
}
