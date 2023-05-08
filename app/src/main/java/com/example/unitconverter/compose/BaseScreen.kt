package com.example.unitconverter.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unitconverter.ConvertViewModel
import com.example.unitconverter.ConverterViewModelFactory

@Composable
fun BaseScreen(
    factory: ConverterViewModelFactory,
    modifier: Modifier = Modifier,
    convertViewModel: ConvertViewModel = viewModel(factory = factory)

){
  val list = convertViewModel.getConversions()
    Column(modifier = modifier.padding(30.dp)) {
        TopScreen(list){ message1,message2 ->
            convertViewModel.addResult(message1,message2)
        }
        Spacer(modifier = modifier.height(20.dp))
        HistoryScreen()
        
    }
}