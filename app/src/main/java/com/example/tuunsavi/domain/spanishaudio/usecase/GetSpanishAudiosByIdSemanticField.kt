package com.example.tuunsavi.domain.spanishaudio.usecase

import com.example.tuunsavi.data.local.repository.SpanishAudioRepository
import com.example.tuunsavi.domain.spanishaudio.model.SpanishAudio
import com.example.tuunsavi.domain.spanishaudio.model.toSpanishAudio
import javax.inject.Inject

class GetSpanishAudiosByIdSemanticField @Inject constructor(
    private val spanishAudioRepository: SpanishAudioRepository
) {
    suspend operator fun invoke(idSemanticField: Int): List<SpanishAudio> {
        return spanishAudioRepository.getSpanishAudiosByIdSemanticField(idSemanticField).map { it.toSpanishAudio() }
    }
}