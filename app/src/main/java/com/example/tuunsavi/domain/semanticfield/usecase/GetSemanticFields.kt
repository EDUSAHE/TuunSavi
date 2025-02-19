package com.example.tuunsavi.domain.semanticfield.usecase

import com.example.tuunsavi.data.local.repository.SemanticFieldRepository
import com.example.tuunsavi.domain.semanticfield.model.SemanticField
import com.example.tuunsavi.domain.semanticfield.model.toSemanticField
import javax.inject.Inject

class GetSemanticFields @Inject constructor(
    private val semanticFieldRepository: SemanticFieldRepository
) {
    suspend operator fun invoke(): List<SemanticField> {
        return semanticFieldRepository.getAllSemanticFields().map { it.toSemanticField() }
    }
}