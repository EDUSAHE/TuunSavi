package com.example.tuunsavi.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.tuunsavi.data.local.model.MixtecVariantEntity

@Dao
interface MixtecVariantDAO {
    @Query("SELECT * FROM MixtecVariant")
    fun getAllMixtecVariants(): List<MixtecVariantEntity>

    @Query("SELECT * FROM MixtecVariant WHERE idVariant IN (:idsVariants)")
    fun getVariantsByIds(idsVariants: List<Int>): List<MixtecVariantEntity>
}