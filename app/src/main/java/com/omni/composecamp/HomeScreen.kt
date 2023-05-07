package com.omni.composecamp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    //1-Search bar
    //2-lazy row
    //3-horizontal grid
    Column(modifier , horizontalAlignment = Alignment.CenterHorizontally) {
       SearchBar()
        AlignYourBodyRow()
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }
    TextField(value = text, onValueChange = { newText -> text = newText },
        modifier
            .fillMaxWidth()
            .heightIn(56.dp), leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "search icon"
            )
        }, colors = TextFieldDefaults.textFieldColors(
            MaterialTheme.colorScheme.surface
        ), placeholder = { Text(text = "Search") })

}

@Composable
fun AlignYourBodyRow(modifier: Modifier = Modifier) {
    LazyRow(
        modifier, horizontalArrangement = Arrangement.spacedBy(8.dp)
        , contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(SimpleData.alignYourBodyData) { item ->
            AlignYourBodyItem(
                drawable = item.drawable,
                text = item.text
            )
        }
    }
}

@Composable
fun AlignYourBodyItem(
    @DrawableRes drawable: Int,
    @StringRes text: Int, modifier: Modifier = Modifier
) {
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape),
            painter = painterResource(drawable),
            contentDescription = "image"
        )
        Text(
            text = stringResource(id = text),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }

}

@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int, modifier: Modifier = Modifier
) {

    Surface(modifier = modifier, shape = MaterialTheme.shapes.small) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.width(192.dp)) {
            Image(
                painterResource(id = drawable),
                contentDescription = stringResource(id = text),
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
            )
            Text(
                text = stringResource(id = text), style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}


