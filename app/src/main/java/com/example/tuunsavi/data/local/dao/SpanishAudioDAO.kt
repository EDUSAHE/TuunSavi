package com.example.tuunsavi.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.tuunsavi.data.local.model.SpanishAudioEntity

@Dao
interface SpanishAudioDAO {
    @Query("SELECT * FROM SpanishAudio WHERE idSemanticField = :idSemanticField")
    fun getSpanishAudiosByIdSemanticField(idSemanticField: Int): List<SpanishAudioEntity>
}