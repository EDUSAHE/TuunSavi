package com.example.tuunsavi.domain.semanticfield.model

import com.example.tuunsavi.data.local.model.SemanticFieldEntity

data class SemanticField(
    val idSemanticField: Int,
    val semanticField: String
)

fun SemanticFieldEntity.toSemanticField(): SemanticField {
    return SemanticField(
        idSemanticField = idSemanticField,
        semanticField = semanticField
    )
}

fun SemanticField.toSemanticFieldEntity(): SemanticFieldEntity {
    return SemanticFieldEntity(
        idSemanticField = idSemanticField,
        semanticField = semanticField
    )
}