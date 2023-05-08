package com.example.unitconverter

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    convertViewModel: ConvertViewModel = viewModel()

){
  val list = convertViewModel.getConversions()
}