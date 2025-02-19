package com.example.tuunsavi.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tuunsavi.domain.mixtecvariant.usecase.GetMixtecVariants
import com.example.tuunsavi.ui.interaction.MixtecVariantState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class VariantSelectionViewModel @Inject constructor(
    private val getMixtecVariants: GetMixtecVariants
) : ViewModel() {
    private val _state = mutableStateOf(MixtecVariantState())
    private val _selectedVariants = MutableStateFlow<List<Int>>(emptyList())
    val state: State<MixtecVariantState> = _state
    val selectedVariants = _selectedVariants.asStateFlow()

    init {
        collectMixtecVariants()
    }

    private fun collectMixtecVariants(){
        viewModelScope.launch (Dispatchers.IO) {
            val fetchedMixtecVariants = getMixtecVariants()
            Log.d("MIXTEC VARIANTS", fetchedMixtecVariants.toString())
            withContext(Dispatchers.Main){
                _state.value = _state.value.copy(mixtecVariants = fetchedMixtecVariants )
            }
        }
    }

    fun toggleSelection(idVariant: Int) {
        val currentVariants = _selectedVariants.value.toMutableList()
        if (currentVariants.contains(idVariant)) {
            currentVariants.remove(idVariant)
            Log.d("VARIANT SELECTION", currentVariants.toString())
        } else {
            currentVariants.add(idVariant)
            Log.d("VARIANT SELECTION", currentVariants.toString())
        }
        _selectedVariants.value = currentVariants.toList()
    }
}