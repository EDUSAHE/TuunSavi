package com.example.tuunsavi.data.local.repository

import com.example.tuunsavi.data.local.dao.SpanishWordDAO
import com.example.tuunsavi.data.local.model.SpanishWordEntity
import javax.inject.Inject

class SpanishWordRepository @Inject constructor(
    private val spanishWordDAO: SpanishWordDAO
) {
    fun getSpanishWordsBySemanticField(idSemanticField: Int): List<SpanishWordEntity> {
        return spanishWordDAO.getSpanishWordsBySemanticField(idSemanticField)
    }
}