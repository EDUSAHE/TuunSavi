package com.example.tuunsavi.domain.mixtecvariant.usecase

import com.example.tuunsavi.data.local.repository.MixtecVariantRepository
import com.example.tuunsavi.domain.mixtecvariant.model.MixtecVariant
import com.example.tuunsavi.domain.mixtecvariant.model.toMixtecVariant
import javax.inject.Inject

class GetMixtecVariants @Inject constructor(
    private val mixtecVariantRepository: MixtecVariantRepository
){
    suspend operator fun invoke(): List<MixtecVariant> {
        return mixtecVariantRepository.getAllMixtecVariants().map { it.toMixtecVariant() }
    }
}