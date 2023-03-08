package com.cyberwalker.fashionstore.items

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {

    var uiState by mutableStateOf(ItemsUiState())
        private set

}

data class ItemsUiState(
    val loadComplete: Boolean = false
)