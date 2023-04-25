package com.example.efficomobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.efficomobile.ui.theme.EfficomobileTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EfficomobileTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(topBar = {
                    TopAppBar(title = { Text(text = "Efficom") }, actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_home_24),
                                contentDescription = "History"
                            )
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_view_headline_24),
                                contentDescription = "Settings"
                            )
                        }
                    })
                }, bottomBar = {
                    NavigationBar() {
                        NavigationBarItem(selected = true, onClick = { /*TODO*/ }, icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_home_24),
                                contentDescription = "Home"
                            )
                        }, label = { Text(text = "Home") })
                        NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_search_24),
                                contentDescription = "Search"
                            )
                        }, label = { Text(text = "Search") })
                        NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_view_headline_24),
                                contentDescription = "Library"
                            )
                        }, label = { Text(text = "Library") })


                    }


                }) {
                    Column(modifier = Modifier.padding(it).verticalScroll(rememberScrollState())) {
                        LazyRow(modifier = Modifier.fillMaxWidth()) {
                            items(10) {
                                FilterChip(selected = false,
                                    onClick = { /*TODO*/ },
                                    label = { Text(text = "Chip $it") },
                                    modifier = Modifier.padding(5.dp)
                                )
                            }
                        }
                        for(i in 1..3) {
                            Row(
                                modifier = Modifier.heightIn(max = 100.dp),
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                for(i in 1..2) {
                                    Card(
                                        modifier = Modifier
                                            .weight(1f)
                                            .padding(horizontal = 12.dp, vertical = 5.dp)
                                            .clickable { },

                                        ) {
                                        Row(
                                            modifier = Modifier.fillMaxSize(),
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.Start
                                        ) {
                                            AsyncImage(
                                                model = ImageRequest.Builder(LocalContext.current)
                                                    .data("https://images.unsplash.com/photo-1598875706250-21faaf804361?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1000&q=80")
                                                    .build(),
                                                contentDescription = "Dog",
                                                modifier = Modifier.weight(.3f),
                                                contentScale = ContentScale.Crop
                                            )
                                            Text(
                                                text = "Dog",
                                                textAlign = TextAlign.Center,
                                                modifier = Modifier
                                                    .weight(.7f)
                                                    .padding(10.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EfficomobileTheme {
        Greeting("Android")
    }
}