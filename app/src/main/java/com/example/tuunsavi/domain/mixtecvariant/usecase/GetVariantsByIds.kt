package com.example.tuunsavi.domain.mixtecvariant.usecase


import com.example.tuunsavi.data.local.repository.MixtecVariantRepository
import com.example.tuunsavi.domain.mixtecvariant.model.MixtecVariant
import com.example.tuunsavi.domain.mixtecvariant.model.toMixtecVariant
import javax.inject.Inject

class GetVariantsByIds @Inject constructor(
    private val mixtecVariantRepository: MixtecVariantRepository

) {
    suspend operator fun invoke(idsVariants: List<Int>): List<MixtecVariant> {
        return mixtecVariantRepository.getVariantsByIds(idsVariants).map { it.toMixtecVariant() }
    }

}