package com.example.tuunsavi.domain.mixtecword.model

import com.example.tuunsavi.data.local.model.MixtecWordEntity

data class MixtecWord(
    val idMixtecWord: Int,
    val idVariant: Int,
    val idSemanticField: Int,
    val idSpanishWord: Int,
    val mixtecWord: String,
)

fun MixtecWordEntity.toMixtecWord(): MixtecWord {
    return MixtecWord(
        idMixtecWord = idMixtecWord,
        idVariant = idVariant,
        idSemanticField = idSemanticField,
        idSpanishWord = idSpanishWord,
        mixtecWord = mixtecWord
    )
}

fun MixtecWord.toMixtecWordEntity(): MixtecWordEntity {
    return MixtecWordEntity(
        idMixtecWord = idMixtecWord,
        idVariant = idVariant,
        idSemanticField = idSemanticField,
        idSpanishWord = idSpanishWord,
        mixtecWord = mixtecWord
    )
}
