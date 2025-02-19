package com.example.tuunsavi.domain.spanishword.model

import com.example.tuunsavi.data.local.model.SpanishWordEntity

data class SpanishWord(
    val idSpanishWord: Int,
    val spanishWord: String,
    val idSemanticField: Int
)

fun SpanishWordEntity.toSpanishWord(): SpanishWord {
    return SpanishWord(
        idSpanishWord = idSpanishWord,
        spanishWord = spanishWord,
        idSemanticField = idSemanticField
    )
}

fun SpanishWord.toSpanishWordEntity(): SpanishWordEntity {
    return SpanishWordEntity(
        idSpanishWord = idSpanishWord,
        spanishWord = spanishWord,
        idSemanticField = idSemanticField
    )
}