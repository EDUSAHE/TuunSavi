package com.example.tuunsavi.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.tuunsavi.data.local.model.MixtecWordEntity

@Dao
interface MixtecWordDAO {
    @Query("SELECT * FROM MixtecWord WHERE idSemanticField = :idSemanticField AND idSpanishWord = :idSpanishWord AND idVariant IN (:idVariants)")
    fun getWordsBySemanticFieldIdSpanishWordIdVariants(idSpanishWord: Int, idSemanticField: Int, idVariants: List<Int>): List<MixtecWordEntity>
}