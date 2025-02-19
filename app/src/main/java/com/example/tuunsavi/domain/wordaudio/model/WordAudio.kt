package com.example.tuunsavi.domain.wordaudio.model

import com.example.tuunsavi.data.local.model.WordAudioEntity

data class WordAudio(
    val idMixtecWord: Int,
    val idSemanticField: Int,
    val idSpanishWord: Int,
    val idVariant: Int,
    val pathAudio: String
)

fun WordAudioEntity.toWordAudio(): WordAudio {
    return WordAudio(
        idMixtecWord = idMixtecWord,
        idSemanticField = idSemanticField,
        idSpanishWord = idSpanishWord,
        idVariant = idVariant,
        pathAudio = pathAudio
    )
}

fun WordAudio.toWordAudioEntity(): WordAudioEntity {
    return WordAudioEntity(
        idMixtecWord = idMixtecWord,
        idSemanticField = idSemanticField,
        idSpanishWord = idSpanishWord,
        idVariant = idVariant,
        pathAudio = pathAudio
    )
}
