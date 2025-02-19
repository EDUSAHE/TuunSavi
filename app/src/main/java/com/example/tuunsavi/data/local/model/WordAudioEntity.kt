package com.example.tuunsavi.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "WordAudio",
    foreignKeys = [
        ForeignKey(
            entity = MixtecWordEntity::class,
            parentColumns = ["idMixtecWord"],
            childColumns = ["idMixtecWord"],
            onDelete = ForeignKey.NO_ACTION
        ),
        ForeignKey(
            entity = SemanticFieldEntity::class,
            parentColumns = ["idSemanticField"],
            childColumns = ["idSemanticField"],
            onDelete = ForeignKey.NO_ACTION
        ),
        ForeignKey(
            entity = SpanishWordEntity::class,
            parentColumns = ["idSpanishWord"],
            childColumns = ["idSpanishWord"],
            onDelete = ForeignKey.NO_ACTION
        ),
        ForeignKey(
            entity = MixtecVariantEntity::class,
            parentColumns = ["idVariant"],
            childColumns = ["idVariant"],
            onDelete = ForeignKey.NO_ACTION
        )
    ],
    indices = [
        Index(value = ["idMixtecWord"]),
        Index(value = ["idSemanticField"]),
        Index(value = ["idSpanishWord"]),
        Index(value = ["idVariant"])
    ]
)
data class WordAudioEntity(
    @PrimaryKey val idMixtecWord: Int,
    @ColumnInfo(name = "idSemanticField")val idSemanticField : Int,
    @ColumnInfo(name = "idSpanishWord")val idSpanishWord : Int,
    @ColumnInfo(name = "idVariant")val idVariant : Int,
    @ColumnInfo(name = "pathAudio")val pathAudio : String
)
