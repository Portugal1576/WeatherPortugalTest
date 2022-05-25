package com.portugal1576.weatherportugaltest

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.portugal1576.weatherportugaltest.screen.Start
import com.portugal1576.weatherportugaltest.ui.theme.WeatherPortugalTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            WeatherPortugalTestTheme {
                val context = LocalContext.current
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                        .padding(top = 20.dp),
                    color = MaterialTheme.colors.background
                ) {

                    val navController = rememberNavController()


                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                    ) {
                        Start("Lisbon", context as MainActivity)
                        Start("Madrid", context as MainActivity)
                        Start("Paris", context as MainActivity)
                        Start("Berlin", context as MainActivity)
                        Start("Copenhagen", context as MainActivity)
                        Start("Rome", context as MainActivity)
                        Start("London", context as MainActivity)
                        Start("Dublin", context as MainActivity)
                        Start("Prague", context as MainActivity)
                        Start("Vienna", context as MainActivity)

                    }
                }
            }
        }
    }
}


