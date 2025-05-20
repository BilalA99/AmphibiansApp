package com.example.amphibiansapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.amphibiansapp.model.Amphibian
import com.example.amphibiansapp.repository.AmphibianRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class AmphibianUiState {
    data class Success(val amphibians: List<Amphibian>) : AmphibianUiState()
    object Loading : AmphibianUiState()
    data class Error(val message: String) : AmphibianUiState()
}

class AmphibianViewModel : ViewModel() {
    private val repository = AmphibianRepository()
    
    private val _uiState = MutableStateFlow<AmphibianUiState>(AmphibianUiState.Loading)
    val uiState: StateFlow<AmphibianUiState> = _uiState.asStateFlow()
    
    init {
        getAmphibians()
    }
    
    private fun getAmphibians() {
        viewModelScope.launch {
            _uiState.value = AmphibianUiState.Loading
            try {
                val amphibians = repository.getAmphibians()
                _uiState.value = AmphibianUiState.Success(amphibians)
            } catch (e: Exception) {
                _uiState.value = AmphibianUiState.Error(e.message ?: "Unknown error occurred")
            }
        }
    }
} 