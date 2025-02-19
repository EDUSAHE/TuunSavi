package com.example.tuunsavi.data.local.repository

import com.example.tuunsavi.data.local.dao.MixtecVariantDAO
import com.example.tuunsavi.data.local.model.MixtecVariantEntity
import javax.inject.Inject

class MixtecVariantRepository @Inject constructor(
    private val mixtecVariantDAO: MixtecVariantDAO
) {
    fun getAllMixtecVariants(): List<MixtecVariantEntity>{
        return mixtecVariantDAO.getAllMixtecVariants()
    }

    fun getVariantsByIds(idsVariants: List<Int>): List<MixtecVariantEntity>{
        return mixtecVariantDAO.getVariantsByIds(idsVariants)
    }
}