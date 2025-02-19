package com.example.tuunsavi.data.local.repository

import com.example.tuunsavi.data.local.dao.SpanishAudioDAO
import com.example.tuunsavi.data.local.model.SpanishAudioEntity
import javax.inject.Inject

class SpanishAudioRepository @Inject constructor(
    private val spanishAudioDAO: SpanishAudioDAO
) {
    fun getSpanishAudiosByIdSemanticField(idSemanticField: Int): List<SpanishAudioEntity> {
        return spanishAudioDAO.getSpanishAudiosByIdSemanticField(idSemanticField)
    }
}