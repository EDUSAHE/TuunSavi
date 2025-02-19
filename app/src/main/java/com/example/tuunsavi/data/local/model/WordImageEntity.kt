package com.example.tuunsavi.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "WordImage",
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
data class WordImageEntity(
    @PrimaryKey val idSpanishWord: Int,
    @ColumnInfo(name = "idSemanticField") val idSemanticField: Int,
    @ColumnInfo(name = "pathImage") val pathImage : String
)
