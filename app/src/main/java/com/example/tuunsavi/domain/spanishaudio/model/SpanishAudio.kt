package com.example.tuunsavi.domain.spanishaudio.model

import com.example.tuunsavi.data.local.model.SpanishAudioEntity

data class SpanishAudio(
    val idSpanishWord: Int,
    val idSemanticField: Int,
    val pathAudio: String
)

fun SpanishAudioEntity.toSpanishAudio(): SpanishAudio {
    return SpanishAudio(
        idSpanishWord = idSpanishWord,
        idSemanticField = idSemanticField,
        pathAudio = pathAudio
    )
}

fun SpanishAudio.toSpanishAudioEntity(): SpanishAudioEntity {
    return SpanishAudioEntity(
        idSpanishWord = idSpanishWord,
        idSemanticField = idSemanticField,
        pathAudio = pathAudio
    )
}
