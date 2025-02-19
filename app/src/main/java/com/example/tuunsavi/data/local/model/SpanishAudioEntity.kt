package com.example.tuunsavi.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "SpanishAudio",
    foreignKeys = [
        ForeignKey(
            entity = SpanishWordEntity::class,
            parentColumns = ["idSpanishWord"],
            childColumns = ["idSpanishWord"],
            onDelete = ForeignKey.NO_ACTION
        ),
        ForeignKey(
            entity = SemanticFieldEntity::class,
            parentColumns = ["idSemanticField"],
            childColumns = ["idSemanticField"],
            onDelete = ForeignKey.NO_ACTION
        )
    ],
    indices = [
        Index(value = ["idSpanishWord"]),
        Index(value = ["idSemanticField"])
    ]
)
data class SpanishAudioEntity(
    @PrimaryKey val idSpanishWord: Int,
    @ColumnInfo(name = "idSemanticField") val idSemanticField: Int,
    @ColumnInfo(name = "pathAudio") val pathAudio : String
)