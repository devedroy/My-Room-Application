package com.devedroy.myroomapplication.data.local

import androidx.annotation.WorkerThread
import com.devedroy.myroomapplication.data.local.Word
import com.devedroy.myroomapplication.data.local.WordDao
import kotlinx.coroutines.flow.Flow

class WordRepository(
    private val wordDao: WordDao
) {
    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}