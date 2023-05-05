package com.omni.composecamp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
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
                LemonadeImagesAndText()
            }
        }
    }
}

@Preview
@Composable
fun LemonadeApp() {
    LemonadeImagesAndText()
}

data class Lemonade(var step: Int, @DrawableRes  var imageResource: Int, @StringRes var title: Int)

@Composable
fun LemonadeImagesAndText(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
) {

    var phase by remember {
        mutableStateOf(1)
    }

    var squeezeCount by remember {
        mutableStateOf(0)
    }


    var lemonadePhase :Lemonade = when (phase) {
        1 -> Lemonade(phase, R.drawable.lemon_tree, R.string.tap_the_lemonade)
        2 -> Lemonade(phase, R.drawable.lemon_squeeze, R.string.keep_tapping)
        3 -> Lemonade(phase, R.drawable.lemon_drink, R.string.glass_of_lemonade)
        else -> {
            Lemonade(phase, R.drawable.lemon_restart, R.string.empty_glass)
        }
    }


    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = stringResource(id = lemonadePhase.title) , fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = lemonadePhase.imageResource),
            contentDescription = "tree",
            Modifier
                .wrapContentSize(Alignment.Center)
                .border(
                    BorderStroke(1.dp, colorResource(id = R.color.blue))
                )
                .clickable {
                    if (phase < 4) {
                        if (phase == 1) squeezeCount = (2..4).random()
                        if (phase == 2 && squeezeCount != 0) {
                            squeezeCount--
                            return@clickable
                        }
                        phase++
                    } else
                        phase = 1
                }
        )

    }


}