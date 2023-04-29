package com.omni.composecamp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    BirthDayGreetingWithText(
                        stringResource(R.string.happy_birthday_sam),
                        stringResource(R.string.from_omneya)
                    )
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.androidparty),
            contentDescription = "Birthday card image",
            contentScale = ContentScale.Crop
        )
        BirthDayGreetingWithText(message, from)
    }
}

//modifier.fillMaxSize().
//This will set the height and width of the column layout to the maximum available height and width.
@Composable
fun BirthDayGreetingWithText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message,
            fontSize = 36.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = from,
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 16.dp)
        )

    }
}

@Preview(showSystemUi = true, name = "Birthday Preview")
@Composable
fun BirthdayCardPreview() {
    ComposeCampTheme {
        BirthdayGreetingWithImage("Happy Birthday Sam!", "- from Omneya")
    }
}