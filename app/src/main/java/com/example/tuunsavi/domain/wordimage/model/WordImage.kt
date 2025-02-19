package com.example.tuunsavi.domain.wordimage.model

import com.example.tuunsavi.data.local.model.WordImageEntity

data class WordImage(
    val idSpanishWord: Int,
    val idSemanticField: Int,
    val pathImage: String
)

fun WordImageEntity.toWordImage(): WordImage {
    return WordImage(
        idSpanishWord = idSpanishWord,
        idSemanticField = idSemanticField,
        pathImage = pathImage
    )
}

fun WordImage.toWordImageEntity(): WordImageEntity {
    return WordImageEntity(
        idSpanishWord = idSpanishWord,
        idSemanticField = idSemanticField,
        pathImage = pathImage
    )
}
