package com.example.tuunsavi.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.tuunsavi.data.local.model.WordImageEntity

@Dao
interface WordImageDAO {
    @Query("SELECT * FROM WordImage WHERE idSemanticField = :idSemanticField")
    fun getWordImagesByIdSemanticField(idSemanticField: Int): List<WordImageEntity>
}