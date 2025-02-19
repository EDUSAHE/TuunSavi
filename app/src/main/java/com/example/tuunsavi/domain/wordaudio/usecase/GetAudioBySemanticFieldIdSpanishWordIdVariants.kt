package com.example.tuunsavi.domain.wordaudio.usecase

import com.example.tuunsavi.data.local.repository.WordAudioRepository
import com.example.tuunsavi.domain.wordaudio.model.WordAudio
import com.example.tuunsavi.domain.wordaudio.model.toWordAudio
import javax.inject.Inject

class GetAudioBySemanticFieldIdSpanishWordIdVariants @Inject constructor(
    private val wordAudioRepository: WordAudioRepository
) {
    suspend operator fun invoke(idSemanticField: Int, idSpanishWord: Int, idVariants: List<Int>): List<WordAudio> {
        return wordAudioRepository.getAudioBySemanticFieldIdSpanishWordIdVariants(idSemanticField, idSpanishWord, idVariants).map { it.toWordAudio() }
    }
}