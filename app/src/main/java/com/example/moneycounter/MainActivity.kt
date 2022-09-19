package com.example.moneycounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moneycounter.ui.theme.MoneyCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoneyCounterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MoneyCounter()
                }
            }
        }
    }
}


@Composable
fun MoneyCounter(){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        var count by remember {
            mutableStateOf(0)
        }
        Text(text = "$$count", style = TextStyle( fontSize = 40.sp, fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.height(150.dp))
        TapButton(count){
            value -> count = value + 10
        }
        Spacer(modifier = Modifier.height(50.dp))
        if( count >= 100 ){
            Text(text = "You've lots of money!")
        }
        
    }
}

@Composable
fun TapButton(count: Int, UpdateCount: (Int) -> Unit){
    Card( modifier = Modifier
        .height(150.dp)
        .width(150.dp)
        .clickable { UpdateCount(count) },
        shape = CircleShape,
        elevation = 20.dp) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = "Tap", style = TextStyle( fontSize = 30.sp))
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MoneyCounterTheme {
        MoneyCounter()
    }
}