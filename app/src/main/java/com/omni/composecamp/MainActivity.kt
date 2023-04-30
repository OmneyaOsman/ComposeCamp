package com.omni.composecamp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.omni.composecamp.ui.theme.ComposeCampTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCampTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeInfo()
                }
            }
        }
    }
}


@Composable
fun ComposeInfo() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                stringResource(id = R.string.first_title),
                stringResource(id = R.string.first_description), Color.Green, Modifier.weight(1f)
            )
            ComposableInfoCard(
                stringResource(id = R.string.third_title),
                stringResource(id = R.string.third_description), Color.Yellow, Modifier.weight(1f)
            )
        }

        Row(Modifier.weight(1f)) {

            ComposableInfoCard(
                stringResource(id = R.string.second_title),
                stringResource(id = R.string.second_description), Color.Cyan, Modifier.weight(1f)
            )
            ComposableInfoCard(
                stringResource(id = R.string.fourth_title),
                stringResource(id = R.string.fourth_description),
                Color.LightGray,
                Modifier.weight(1f)
            )
        }
    }

}

@Composable
fun ComposableInfoCard(
    name: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = name,
            modifier = Modifier.padding(bottom = 16.dp), fontWeight = FontWeight.Bold,
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify,
        )
    }

}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposeCampTheme {
        ComposeInfo()
    }
}