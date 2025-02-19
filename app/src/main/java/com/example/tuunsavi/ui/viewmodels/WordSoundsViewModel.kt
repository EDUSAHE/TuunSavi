package com.example.tuunsavi.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.tuunsavi.domain.mixtecvariant.usecase.GetVariantsByIds
import com.example.tuunsavi.domain.mixtecword.usecase.GetWordsBySemanticFieldIdSpanishWordIdVariants
import com.example.tuunsavi.domain.spanishaudio.usecase.GetSpanishAudiosByIdSemanticField
import com.example.tuunsavi.domain.spanishword.usecase.GetSpanishWordsBySemanticField
import com.example.tuunsavi.ui.main.WordSounds
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.tuunsavi.domain.wordaudio.usecase.GetAudioBySemanticFieldIdSpanishWordIdVariants
import com.example.tuunsavi.domain.wordimage.usecase.GetWordImagesByIdSemanticField
import com.example.tuunsavi.ui.interaction.WordDataState
import com.example.tuunsavi.ui.utils.VariantData
import com.example.tuunsavi.ui.utils.WordData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.withContext


@HiltViewModel
class WordSoundsViewModel @Inject constructor(
    private val getAudioBySemanticFieldIdSpanishWordIdVariants: GetAudioBySemanticFieldIdSpanishWordIdVariants,
    private val getSpanishAudiosByIdSemanticField: GetSpanishAudiosByIdSemanticField,
    private val getWordsBySemanticFieldIdSpanishWordIdVariants: GetWordsBySemanticFieldIdSpanishWordIdVariants,
    private val getWordImagesByIdSemanticField: GetWordImagesByIdSemanticField,
    private val getVariantsByIds : GetVariantsByIds,
    private val getSpanishWordsBySemanticField: GetSpanishWordsBySemanticField,
    savedStateHandle: SavedStateHandle,
) : ViewModel()  {
    private val wordSounds = savedStateHandle.toRoute<WordSounds>()

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _wordDataState = MutableStateFlow(WordDataState())
    val wordDataState: StateFlow<WordDataState> = _wordDataState

    private val _index = MutableStateFlow(0)
    val index: StateFlow<Int> = _index.asStateFlow()

    val actualItem: StateFlow<WordData?> = combine(wordDataState, index) { wordDataState, index ->
        wordDataState.wordData.getOrNull(index)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    init {
        collectItems()
    }


    private fun collectItems(){
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.value = true
            try {
                val fetchedSpanishWords = getSpanishWordsBySemanticField(wordSounds.idSemanticField)
                val fetchedWordImages = getWordImagesByIdSemanticField(wordSounds.idSemanticField)
                val fetchedSpanishAudios = getSpanishAudiosByIdSemanticField(wordSounds.idSemanticField)
                val itemsData = mutableListOf<WordData>()
                for (i in fetchedSpanishWords.indices) {
                    val fetchedAudio = getAudioBySemanticFieldIdSpanishWordIdVariants(wordSounds.idSemanticField,fetchedSpanishWords[i].idSpanishWord,wordSounds.idsVariants)
                    val fetchedWords = getWordsBySemanticFieldIdSpanishWordIdVariants(fetchedSpanishWords[i].idSpanishWord,wordSounds.idSemanticField,wordSounds.idsVariants)
                    val fetchedVariants = getVariantsByIds(wordSounds.idsVariants)
                    val variantData = mutableListOf<VariantData>()
                    for (j in fetchedWords.indices){
                        variantData.add(
                            VariantData(
                                mixtecWord = fetchedWords[j].mixtecWord,
                                pathAudio = fetchedAudio[j].pathAudio,
                                variantName = fetchedVariants[j].variantName
                            )
                        )
                    }
                    itemsData.add(
                        WordData(
                            pathImage = fetchedWordImages[i].pathImage,
                            spanishWord = fetchedSpanishWords[i].spanishWord,
                            pathAudio = fetchedSpanishAudios[i].pathAudio,
                            variantData = variantData
                        )
                    )
                }
                Log.d("ITEMS DATA", itemsData.toString())

                withContext(Dispatchers.Main) {
                    _wordDataState.value = _wordDataState.value.copy(wordData = itemsData)
                    _isLoading.value = false // Set loading to false after success
                }
            } catch (e: Exception) {
                Log.e("WordSoundsViewModel", "Error fetching data:", e)
                _isLoading.value = false
            }
        }
    }

    fun nextItem() {
        if (index.value < wordDataState.value.wordData.size -1) {
            _index.value++
            Log.d("INDEX", index.value.toString())

        }
    }

    fun previousItem() {
        if (index.value > 0) {
            _index.value--
        }
    }
}