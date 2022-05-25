package com.portugal1576.weatherportugaltest.screen

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.portugal1576.weatherportugaltest.MainActivity
import com.portugal1576.weatherportugaltest.MainViewModel

@Composable
fun Start(name: String, context: MainActivity) {

    val mainViewModel: MainViewModel =
        viewModel(factory = MainViewModel.MainViewModelFactory(context.applicationContext as Application))

    val temp_c = remember {
        mutableStateOf("Unknown")
    }
    val temp_f = remember {
        mutableStateOf("Unknown")
    }

    mainViewModel.getData(name, context, temp_c, temp_f)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp)
            .clickable {
                       //Detail(name, context)
            },
        elevation = 6.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween


        ) {

            Text(
                text = name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

//            Image(imageVector = , contentDescription = )
            Text(
                text = temp_f.value + "℉",
                fontSize = 24.sp,
                color = Color.Green
            )

            Text(
                text = temp_c.value + "℃",
                fontSize = 24.sp,
                color = Color.Red
            )
        }
    }
}