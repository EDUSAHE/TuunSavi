package com.example.tuunsavi.ui.main

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tuunsavi.ui.viewmodels.VariantSelectionViewModel
import com.example.tuunsavi.ui.views.SemanticFieldSelectionScreen
import com.example.tuunsavi.ui.views.VariantSelectionScreen
import com.example.tuunsavi.ui.views.WordSoundsScreen
import kotlinx.serialization.Serializable


@Serializable
object VariantSelection

@Serializable
object SemanticFieldSelection

@Serializable
data class WordSounds(val idsVariants: List<Int>, val idSemanticField: Int)

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val variantSelectionViewModel : VariantSelectionViewModel = hiltViewModel()
    val listIdsVariants = remember { mutableStateListOf<Int>() }
    NavHost(
        navController = navController,
        startDestination = VariantSelection
    ) {
        composable<VariantSelection> {
            VariantSelectionScreen(variantSelectionViewModel) {
                 idsVariants -> navController.navigate(SemanticFieldSelection)
                 listIdsVariants.clear()
                 listIdsVariants.addAll(idsVariants)
                Log.d("LIST IDS VARIANTS", listIdsVariants.toString())
            }
        }



        composable<SemanticFieldSelection> {
            SemanticFieldSelectionScreen{
                idSemanticField -> navController.navigate(WordSounds(idsVariants = listIdsVariants.toList(), idSemanticField = idSemanticField))
            }
        }

        composable<WordSounds> {
            WordSoundsScreen()
        }
    }
}