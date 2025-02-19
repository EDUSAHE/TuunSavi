package com.example.tuunsavi.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.tuunsavi.data.local.model.SemanticFieldEntity

@Dao
interface SemanticFieldDAO {

    @Query("SELECT * FROM SemanticField")
    fun getAllSemanticFields(): List<SemanticFieldEntity>
}