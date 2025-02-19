package com.example.tuunsavi.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.tuunsavi.data.local.model.WordAudioEntity

@Dao
interface WordAudioDAO {
    @Query("SELECT * FROM WordAudio WHERE idSemanticField = :idSemanticField AND idSpanishWord = :idSpanishWord AND idVariant IN (:idVariants)")
    fun getAudioBySemanticFieldIdSpanishWordIdVariants(idSemanticField: Int, idSpanishWord: Int, idVariants: List<Int>): List<WordAudioEntity>
}