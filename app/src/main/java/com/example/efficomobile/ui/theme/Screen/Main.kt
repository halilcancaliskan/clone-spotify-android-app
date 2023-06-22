package com.example.efficomobile.ui.theme.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.efficomobile.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun Main(navController: NavHostController) {
    val navController = rememberNavController()
    Scaffold(bottomBar = {
        NavigationBar() {
            NavigationBarItem(
                selected = true,
                onClick = { navController.navigate("Home") },
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_home_24),
                        contentDescription = "Home"
                    )
                },
                label = { Text(text = "Home") })
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate("Search") },
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_search_24),
                        contentDescription = "Search"
                    )
                },
                label = { Text(text = "Search") })
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate("Library") },
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_view_headline_24),
                        contentDescription = "Library"
                    )
                },
                label = { Text(text = "Library") })


        }


    }) {
        val genre = listOf("Musique", "Podcast", "Vidéo", "Radio", "Live")

        NavHost(
            navController = navController,
            startDestination = "Home",
            modifier = Modifier
                .padding(it)
                .background(Color.Yellow)
        )
        {
            composable("Home") {
                Home()
            }
            composable("Search") {
                Search()
            }
            composable("Library") {
                Library()

            }
        }
        /*Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
                .background(Color.Black)
        ) {
            LazyRow(modifier = Modifier.fillMaxWidth()) {
            for (g in genre) {

                    items(1) {
                        FilterChip(
                            selected = false,
                            onClick = { /*TODO*/ },
                            label = { Text(
                                text = "$g",
                                color = Color.White
                            ) },
                            modifier = Modifier
                                .padding(5.dp)
                        )
                    }
                }
            }


            val imageUrls = listOf(
                "https://d1csarkz8obe9u.cloudfront.net/posterpreviews/white-and-blue-rock-music-album-cover-design-template-669d6b733ca7b8e20734de8eea1e67ea_screen.jpg?ts=1561485914",
                "https://d2n9ha3hrkss16.cloudfront.net/uploads/stage/stage_image/21198/optimized_large_thumb_stage.jpg"
            )

            Row(
                modifier = Modifier.heightIn(max = 100.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                for (i in 0 until imageUrls.size) {
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 12.dp, vertical = 5.dp)
                            .clickable { }
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(imageUrls[i])
                                    .build(),
                                contentDescription = "Poursuivre l'écoute",
                                modifier = Modifier.weight(.3f),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                text = "Poursuivre l'écoute",
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .weight(.7f)
                                    .padding(10.dp)
                            )
                        }
                    }
                }
            }

            val imageUrls2 = listOf(
                "https://d1csarkz8obe9u.cloudfront.net/posterpreviews/160db2f2cc6eaef1ad40cb4f5f43cffd_screen.jpg?ts=1561422695",
                "https://archive.smashing.media/assets/344dbf88-fdf9-42bb-adb4-46f01eedd629/e2f9aa74-7587-4a30-b0c0-4df61d7ac308/43.jpg"
            )

            Row(
                modifier = Modifier.heightIn(max = 100.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                for (i in 0 until imageUrls2.size) {
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 12.dp, vertical = 5.dp)
                            .clickable { }
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(imageUrls2[i])
                                    .build(),
                                contentDescription = "Poursuivre l'écoute",
                                modifier = Modifier.weight(.3f),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                text = "Poursuivre l'écoute",
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .weight(.7f)
                                    .padding(10.dp)
                            )
                        }
                    }
                }
            }
            val imageUrls3 = listOf(
                "https://static.fnac-static.com/multimedia/Images/FR/NR/1e/d0/9b/10211358/1540-1/tsp20180625100036/Lithopedion.jpg",
                "https://m.media-amazon.com/images/I/71dFTmV2jgL._SL1440_.jpg"
            )

            Row(
                modifier = Modifier.heightIn(max = 100.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                for (i in 0 until imageUrls3.size) {
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 12.dp, vertical = 5.dp)
                            .clickable { }
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(imageUrls3[i])
                                    .build(),
                                contentDescription = "Poursuivre l'écoute",
                                modifier = Modifier.weight(.3f),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                text = "Poursuivre l'écoute",
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .weight(.7f)
                                    .padding(10.dp)
                            )
                        }
                    }
                }
            }

            Text(text = "Conçu spécialement pour vous", fontSize = 20.sp, color = Color.White)

            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(1) {
                    Image(
                        painter = painterResource(id = R.drawable.pnl),
                        contentDescription = stringResource(id = R.string.app_name),
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(5.dp)
                            .size(150.dp)
                    )
                }
                items(1) {
                    val imageModifier = Modifier
                        .border(BorderStroke(1.dp, Color.Black))
                        .background(Color.Yellow)
                    Image(
                        painter = painterResource(id = R.drawable.mexico),
                        contentDescription = stringResource(id = R.string.app_name),
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(5.dp)
                            .size(150.dp)
                    )
                }
                items(1) {
                    val imageModifier = Modifier
                        .border(BorderStroke(1.dp, Color.Black))
                        .background(Color.Yellow)
                    Image(
                        painter = painterResource(id = R.drawable.naps),
                        contentDescription = stringResource(id = R.string.app_name),
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(5.dp)
                            .size(150.dp)
                    )
                }
            }

            Text(text = "Albums populaires", fontSize = 20.sp, color = Color.White)

            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(1) {
                    Image(
                        painter = painterResource(id = R.drawable.sagopaka),
                        contentDescription = stringResource(id = R.string.app_name),
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(5.dp)
                            .size(150.dp)
                    )
                }
                items(1) {
                    val imageModifier = Modifier
                        .border(BorderStroke(1.dp, Color.Black))
                        .background(Color.Yellow)
                    Image(
                        painter = painterResource(id = R.drawable.sagopa),
                        contentDescription = stringResource(id = R.string.app_name),
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(5.dp)
                            .size(150.dp)
                    )
                }
                items(1) {
                    val imageModifier = Modifier
                        .border(BorderStroke(1.dp, Color.Black))
                        .background(Color.Yellow)
                    Image(
                        painter = painterResource(id = R.drawable.sago),
                        contentDescription = stringResource(id = R.string.app_name),
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(5.dp)
                            .size(150.dp)
                    )
                }
            }
        }*/
    }
}