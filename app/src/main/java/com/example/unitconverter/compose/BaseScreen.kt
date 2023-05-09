package com.example.unitconverter.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.unitconverter.ConvertViewModel
import com.example.unitconverter.ConverterViewModelFactory
import com.example.unitconverter.compose.converter.TopScreen
import com.example.unitconverter.compose.history.HistoryScreen

@Composable
fun BaseScreen(
    factory: ConverterViewModelFactory,
    modifier: Modifier = Modifier,
    convertViewModel: ConvertViewModel = viewModel(factory = factory)

){
  val list = convertViewModel.getConversions()
  val historyList = convertViewModel.resultList.collectAsState(initial = emptyList())

    val configuration = LocalConfiguration.current
    var isLandscape by remember { mutableStateOf(false) }

    when(configuration.orientation){
        Configuration.ORIENTATION_LANDSCAPE -> {
            isLandscape = true
            Row(modifier = modifier
                .padding(30.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround
            ) {
                TopScreen(list,
                    convertViewModel.selectedConversion,
                    convertViewModel.inputText,
                    convertViewModel.typedValue,
                    isLandscape
                ){ message1,message2 ->
                    convertViewModel.addResult(message1,message2)
                }
                Spacer(modifier = modifier.width(10.dp))
                HistoryScreen(
                    historyList,{item ->
                        convertViewModel.removeResult(item)
                    },
                    {
                        convertViewModel.clearAll()
                    }
                )

            }

        }else ->{
        isLandscape = false
        Column(modifier = modifier.padding(30.dp)) {
            TopScreen(list,
                convertViewModel.selectedConversion,
                convertViewModel.inputText,
                convertViewModel.typedValue,
                isLandscape
            ){ message1,message2 ->
                convertViewModel.addResult(message1,message2)
            }
            Spacer(modifier = modifier.height(20.dp))
            HistoryScreen(
                historyList,{item ->
                    convertViewModel.removeResult(item)
                },
                {
                    convertViewModel.clearAll()
                }
            )

        }
        }
    }
    

}