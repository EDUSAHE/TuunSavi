package com.example.tuunsavi.data.local.repository

import com.example.tuunsavi.data.local.dao.SemanticFieldDAO
import com.example.tuunsavi.data.local.model.SemanticFieldEntity
import javax.inject.Inject

class SemanticFieldRepository @Inject constructor(
    private val semanticFieldDAO: SemanticFieldDAO
) {
    fun getAllSemanticFields(): List<SemanticFieldEntity>{
        return semanticFieldDAO.getAllSemanticFields()
    }

}