package com.example.unitconverter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize


@Composable
fun ConversionMenu(list: List<Conversion>, modifier: Modifier = Modifier){

 var displayingText by remember{ mutableStateOf("Select the conversion type")}
    var textFieldSize by remember{ mutableStateOf(Size.Zero) }//To assign the dropdown the same width as textField
    var expanded by remember { mutableStateOf(false) }

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    OutlinedTextField(
        value = displayingText,
        onValueChange = {displayingText = it},
        textStyle = TextStyle(fontSize = 20.sp , fontWeight = FontWeight.Bold),
        modifier = modifier
            .fillMaxWidth()
            .onGloballyPositioned { cordinates ->
                textFieldSize = cordinates.size.toSize()
            },
        label = { Text(text = "Conversion type")},
        trailingIcon = {
          Icon(icon, contentDescription = "icon",
            modifier.clickable { expanded = !expanded })
        },
        readOnly = true

    )

}