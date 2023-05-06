package com.omni.composecamp

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.ElevatedButton
//import androidx.compose.material.icons.filled.ExpandLess
//import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
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
    modifier: Modifier = Modifier
) {
    var shouldShowOnBoardingScreen by rememberSaveable {
        mutableStateOf(true)
    }
    if (shouldShowOnBoardingScreen)
        OnBoardingScreen(onClick = {
            shouldShowOnBoardingScreen = false
        })
    else
        HomeScreen(modifier)
}

@Composable
private fun HomeScreen(
    modifier: Modifier = Modifier,
    names: List<String> = List(1000) { "$it" }
) {
    Column(modifier = modifier.padding(vertical = 4.dp)) {
        LazyColumn {
            items(names) { name ->
                Greeting(name = name)
            }
        }
    }
}

@Composable
private fun Greeting(name: String) {

    var isExpanded by remember {
        mutableStateOf(false)
    }
    val extraPadding by animateDpAsState(
        if (isExpanded) 48.dp else 0.dp, animationSpec = SpringSpec(
            dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow
        )
    )


//    val surfaceColor by animateColorAsState(if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary)

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
//            .animateContentSize()
            .padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1F)
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp)),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "Hello, ")
                Text(
                    text = name,
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.ExtraBold)
                )
                Text(
                    text = "Layout basics: Learn about the building blocks for a straightforward app UI Material Components and layouts: Learn about Material components and layouts in Compose.ConstraintLayout: Learn how to use ConstraintLayout in your Compose UI.",
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1
                )
            }
            IconButton(onClick = {isExpanded = !isExpanded} ){
                Icon(imageVector =if(isExpanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore, contentDescription ="icon" )
            }
//            ElevatedButton(onClick = { isExpanded = !isExpanded }) {
//                Text(text = if (isExpanded) "Show less" else "Show more")
//            }
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "Dark"
)
@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    ComposeCampTheme {
        HomeScreen()
    }
}


@Preview
@Composable
fun MyAppPreview() {
    ComposeCampTheme {
        MyApp(Modifier.fillMaxSize())
    }
}