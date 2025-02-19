package com.example.tuunsavi.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "SpanishWord",
    foreignKeys = [
        ForeignKey(
            entity = SemanticFieldEntity::class,
            parentColumns = ["idSemanticField"] ,
            childColumns = ["idSemanticField"],
            onDelete = ForeignKey.NO_ACTION
        )
    ],
    indices = [Index(value = ["idSemanticField"])]
)
data class SpanishWordEntity(
    @PrimaryKey(autoGenerate = true) val idSpanishWord: Int = 1,
    @ColumnInfo(name = "idSemanticField")val idSemanticField : Int,
    @ColumnInfo(name = "spanishWord")val spanishWord : String,
)
