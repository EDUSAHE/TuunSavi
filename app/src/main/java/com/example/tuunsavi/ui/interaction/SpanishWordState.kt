package com.example.tuunsavi.ui.interaction

import com.example.tuunsavi.domain.spanishword.model.SpanishWord

data class SpanishWordState(
    var spanishWords: List<SpanishWord> = emptyList(),
)
