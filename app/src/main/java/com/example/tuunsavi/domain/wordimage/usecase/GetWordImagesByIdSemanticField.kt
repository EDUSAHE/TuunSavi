package com.example.tuunsavi.domain.wordimage.usecase

import com.example.tuunsavi.data.local.repository.WordImageRepository
import com.example.tuunsavi.domain.wordimage.model.WordImage
import com.example.tuunsavi.domain.wordimage.model.toWordImage
import javax.inject.Inject

class GetWordImagesByIdSemanticField @Inject constructor(
    private val wordImageRepository: WordImageRepository
){
    suspend operator fun invoke(idSemanticField: Int): List<WordImage> {
        return wordImageRepository.getWordImagesByIdSemanticField(idSemanticField).map { it.toWordImage() }
    }

}