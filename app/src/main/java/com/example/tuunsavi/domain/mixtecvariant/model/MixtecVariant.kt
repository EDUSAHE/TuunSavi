package com.example.tuunsavi.domain.mixtecvariant.model

import com.example.tuunsavi.data.local.model.MixtecVariantEntity

data class MixtecVariant(
    val idVariant: Int,
    val idVariantRegion: Int,
    val variantName : String
)

fun MixtecVariantEntity.toMixtecVariant():MixtecVariant {
    return MixtecVariant(
        idVariant = idVariant,
        idVariantRegion = idVariantRegion,
        variantName = variantName
    )
}

fun MixtecVariant.toMixtecVariantEntity() : MixtecVariantEntity {
    return MixtecVariantEntity(
        idVariant = idVariant,
        idVariantRegion = idVariantRegion,
        variantName = variantName
    )
}
