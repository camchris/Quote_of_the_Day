package com.example.quoteoftheday

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quoteoftheday.ui.theme.QuoteOfTheDayTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuoteOfTheDayTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RandomQuote(
                        modifier = Modifier
                            .padding(innerPadding) // Applies the inner padding provided by Scaffold
                            .padding(20.dp)
                    )
                }

            }
        }
    }
}

@Composable
fun RandomQuote(modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val quotes = listOf(
            "It matters not what someone is born, but what they grow to be.",
            "You must let go of the illusion of control.",
            "Yesterday is history, tomorrow is a mystery, but today is a gift. That is why it is called the present.",
            "An acorn can only become the mighty oak, not a cherry tree. You must let her grow into what she will be.",
            "One often meets his destiny on the road he takes to avoid it.",
            "If you only do what you can do, you will never be more than you are now.",
            "Your mind is like this water, my friend. When it is agitated, it becomes difficult to see. But if you allow it to settle, the answer becomes clear.",
            "Nothing is impossible.",
            "Patience reveals the master plan.",
            "The journey of a thousand miles begins with one step.",
            "The wise man is often more powerful than the strong man.",
            "Simplicity is the ultimate sophistication.",
            "The only thing that matter is what you choose to be now.",
            "When life gives you lemons, make pear juice and blow everyone's mind.",
            "Who you are will always be a part of what you become.",
            "Every step leaves a footprint. No matter how small.",
            "Worrying doesn't make the broth boil any faster.",
            "Sometimes the greatest dishes come from the most unlikely ingredients."

        )
        var current by remember { mutableStateOf(quotes.random()) }
        Text(
            text = current,
            modifier = modifier,
            style = TextStyle(
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                color = Color(1, 29, 5),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        )
        Button(
            onClick = {
            current = quotes.random()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(1, 29, 5), // Background color of the button
                contentColor = Color.White // Color of the button text
            ),

        ) {
            Text(
                text = "New Quote",
                style = TextStyle(
                    fontFamily = FontFamily.Serif,
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuoteOfTheDayTheme {
        RandomQuote()
    }
}