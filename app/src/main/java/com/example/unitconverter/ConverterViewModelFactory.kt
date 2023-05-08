package com.example.unitconverter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.unitconverter.data.ConverterRepository

class ConverterViewModelFactory(private val repository: ConverterRepository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ConvertViewModel(repository) as T
    }
}