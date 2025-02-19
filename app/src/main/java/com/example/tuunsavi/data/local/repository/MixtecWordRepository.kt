package com.example.tuunsavi.data.local.repository

import com.example.tuunsavi.data.local.dao.MixtecWordDAO
import com.example.tuunsavi.data.local.model.MixtecWordEntity
import javax.inject.Inject

class MixtecWordRepository @Inject constructor(
    private val mixtecWordDAO: MixtecWordDAO
) {
    fun getWordsBySemanticFieldIdSpanishWordIdVariants(idSpanishWord: Int, idSemanticField: Int, idVariants: List<Int>): List<MixtecWordEntity> {
        return mixtecWordDAO.getWordsBySemanticFieldIdSpanishWordIdVariants(idSpanishWord, idSemanticField, idVariants)
    }
}