package com.example.tuunsavi.ui.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tuunsavi.domain.semanticfield.usecase.GetSemanticFields
import com.example.tuunsavi.ui.interaction.SemanticFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SemanticFieldSelectionViewModel @Inject constructor(
    private val getSemanticFields: GetSemanticFields
) : ViewModel() {
    private val _state = mutableStateOf(SemanticFieldState())
    val state: State<SemanticFieldState> = _state

    init {
        collectSemanticFields()
    }

    private fun collectSemanticFields() {
        viewModelScope.launch(Dispatchers.IO) {
            val fetchedSemanticFields = getSemanticFields()
            withContext(Dispatchers.Main) {
                _state.value = _state.value.copy(semanticFields = fetchedSemanticFields)
            }
        }
    }
}