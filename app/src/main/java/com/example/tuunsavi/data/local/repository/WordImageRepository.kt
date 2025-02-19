package com.example.tuunsavi.data.local.repository

import com.example.tuunsavi.data.local.dao.WordImageDAO
import com.example.tuunsavi.data.local.model.WordImageEntity
import javax.inject.Inject

class WordImageRepository @Inject constructor(
    private val wordImageDAO: WordImageDAO
) {
    fun getWordImagesByIdSemanticField(idSemanticField: Int): List<WordImageEntity> {
        return wordImageDAO.getWordImagesByIdSemanticField(idSemanticField)
    }

}