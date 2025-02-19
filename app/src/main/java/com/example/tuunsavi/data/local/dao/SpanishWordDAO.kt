package com.example.tuunsavi.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.tuunsavi.data.local.model.SpanishWordEntity

@Dao
interface SpanishWordDAO {
    @Query("SELECT * FROM SpanishWord WHERE idSemanticField = :idSemanticField")
    fun getSpanishWordsBySemanticField(idSemanticField: Int): List<SpanishWordEntity>
}