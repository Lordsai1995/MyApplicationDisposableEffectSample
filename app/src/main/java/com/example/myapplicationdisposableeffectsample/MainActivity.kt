package com.example.myapplicationdisposableeffectsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplicationdisposableeffectsample.ui.theme.MyApplicationDisposableEffectSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
          DisposableEffectSample()
                }
            }
        }

@Composable
fun DisposableEffectSample() {
    var showBox by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { showBox = !showBox }) {
            Text(if (showBox) "Hide Box" else "Show Box")
        }

        if (showBox) {
            BoxWithDisposableEffect()
        }
    }
}

@Composable
fun BoxWithDisposableEffect() {
    DisposableEffect(Unit) {
        println("🟢 BoxWithDisposableEffect: ENTERED composition")

        onDispose {
            println("🔴 BoxWithDisposableEffect: LEFT composition")
        }
    }

    Box(
        modifier = Modifier
            .size(150.dp)
            .background(Color.Blue)
            .padding(top = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text("I am visible", color = Color.White)
    }
}



