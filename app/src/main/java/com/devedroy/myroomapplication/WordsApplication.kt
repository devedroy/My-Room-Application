package com.devedroy.myroomapplication

import android.app.Application
import com.devedroy.myroomapplication.data.local.WordRepository
import com.devedroy.myroomapplication.data.local.WordRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WordsApplication : Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())
    private val database by lazy { WordRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { WordRepository(database.wordDao()) }
}