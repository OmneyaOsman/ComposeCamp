package com.omni.composecamp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.omni.composecamp.ui.theme.ComposeCampTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCampTheme {
                MyApp(Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World", "Compose")
) {
    Column(modifier = modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting(name = name)
        }
    }
}

@Composable
private fun Greeting(name: String) {

    var isExpanded by remember {
        mutableStateOf(false)
    }
    val extraPadding = if(isExpanded) 48.dp else 1.dp
    val surfaceColor by animateColorAsState(if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary)

    Surface(
        color = surfaceColor,

        modifier = Modifier
            .animateContentSize()
            .padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1F).padding(bottom = extraPadding), horizontalAlignment = Alignment.Start
            ) {
                Text(text = "Hello, ")
                Text(text = name)
            }
            ElevatedButton(onClick = { isExpanded = !isExpanded }, modifier = Modifier.weight(1F)) {
                Text(text = if(isExpanded)"Show less" else "Show more")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposeCampTheme {
        MyApp()
    }
}