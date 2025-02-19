package com.example.tuunsavi.domain.spanishword.usecase

import com.example.tuunsavi.data.local.repository.SpanishWordRepository
import com.example.tuunsavi.domain.spanishword.model.SpanishWord
import com.example.tuunsavi.domain.spanishword.model.toSpanishWord
import javax.inject.Inject

class GetSpanishWordsBySemanticField @Inject constructor(
    private val spanishWordRepository: SpanishWordRepository
) {
    suspend operator fun invoke(idSemanticField: Int): List<SpanishWord> {
        return spanishWordRepository.getSpanishWordsBySemanticField(idSemanticField).map { it.toSpanishWord() }

    }
}