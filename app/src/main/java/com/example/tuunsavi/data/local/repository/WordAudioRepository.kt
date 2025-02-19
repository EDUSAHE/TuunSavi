package com.example.tuunsavi.data.local.repository

import com.example.tuunsavi.data.local.dao.WordAudioDAO
import com.example.tuunsavi.data.local.model.WordAudioEntity
import javax.inject.Inject

class WordAudioRepository @Inject constructor(
    private val wordAudioDAO: WordAudioDAO
){
    fun getAudioBySemanticFieldIdSpanishWordIdVariants(idSemanticField: Int, idSpanishWord: Int, idVariants: List<Int>): List<WordAudioEntity> {
        return wordAudioDAO.getAudioBySemanticFieldIdSpanishWordIdVariants(idSemanticField, idSpanishWord, idVariants)
    }
}