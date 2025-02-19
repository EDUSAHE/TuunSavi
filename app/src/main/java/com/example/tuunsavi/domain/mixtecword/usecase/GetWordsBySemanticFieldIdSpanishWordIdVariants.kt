package com.example.tuunsavi.domain.mixtecword.usecase

import com.example.tuunsavi.data.local.repository.MixtecWordRepository
import com.example.tuunsavi.domain.mixtecword.model.MixtecWord
import com.example.tuunsavi.domain.mixtecword.model.toMixtecWord
import javax.inject.Inject

class GetWordsBySemanticFieldIdSpanishWordIdVariants @Inject constructor(
    private val mixtecWordRepository: MixtecWordRepository

) {
    suspend operator fun invoke(idSpanishWord: Int, idSemanticField: Int, idVariants: List<Int>): List<MixtecWord> {
        return mixtecWordRepository.getWordsBySemanticFieldIdSpanishWordIdVariants(idSpanishWord, idSemanticField, idVariants).map { it.toMixtecWord() }
    }
}