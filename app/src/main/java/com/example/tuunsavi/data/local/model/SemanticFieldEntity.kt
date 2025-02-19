package com.example.tuunsavi.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "SemanticField")
data class SemanticFieldEntity(
    @PrimaryKey(autoGenerate = true) val idSemanticField: Int = 1,
    @ColumnInfo(name = "semanticField")val semanticField : String
)
