package com.omni.composecamp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
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
                    BusinessCardHeader("Omneya Osman", "Senior Android Developer")
                }
            }
        }
    }
}

@Composable
fun BusinessCardHeader(name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF073042)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3F),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentScale = ContentScale.Fit,
                contentDescription = "developer image",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.Black)
            )
            Text(
                text = "$name!",
                modifier = modifier.padding(8.dp), fontSize = 24.sp
            )

            Text(
                text = "$title!",
                modifier = modifier.padding(8.dp)
            )
        }
        BusinessCardDetails(Modifier.weight(2F))

    }
}

@Composable
fun BusinessCardDetails(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {

        BusinessCardContactRow("+20 01212990036", Icons.Filled.Call)
        BusinessCardContactRow("@AndroidDev", Icons.Filled.Share)
        BusinessCardContactRow("engomneya.osman@gmail.com", Icons.Filled.Email)
    }

}

@Composable
private fun BusinessCardContactRow(detail: String, imageVector: ImageVector) {
    Row(Modifier.fillMaxWidth()) {
        Icon(imageVector, contentDescription = "", tint = Color(0xFF3ddc84))
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSize))
        Text(text = detail, textAlign = TextAlign.Center)
    }
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposeCampTheme {
        BusinessCardHeader("Omneya Osman", "Senior Android Developer")
    }
}