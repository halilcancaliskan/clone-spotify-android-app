package com.example.efficomobile.ui.theme.Screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.ui.unit.dp
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
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.efficomobile.MainActivity
import com.example.efficomobile.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_profile),
                                contentDescription = "Icône de profil"
                            )
                        }
                        Text(text = "Rechercher")
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_photo),
                            contentDescription = "zoom"
                        )
                    }
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_plus),
                            contentDescription = "plus"
                        )
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar() {
                NavigationBarItem(
                    selected = true,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_home_24),
                            contentDescription = "Home"
                        )
                    },
                    label = { Text(text = "Home") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_search_24),
                            contentDescription = "Search"
                        )
                    },
                    label = { Text(text = "Search") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_view_headline_24),
                            contentDescription = "Library"
                        )
                    },
                    label = { Text(text = "Library") }
                )
            }
        }
    ) {
        var searchQuery = remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
                .background(Color.Black)
        ) {
            TextField(
                value = searchQuery.value,
                onValueChange = { searchQuery.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start // Aligner les autres éléments à gauche
            ) {
                Text(text = "Parcourir tout", color = Color.White)
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.End // Aligner l'icône "lister" à droite
                ) {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_trier),
                            contentDescription = "Mode de la liste",
                            tint = Color.White
                        )
                    }
                }
            }

            Column(modifier = Modifier) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(2) { index ->
                        Box(
                            modifier = Modifier
                                .size(width = 186.dp, height = 100.dp)
                                .padding(8.dp)
                                .background(Color.Red)
                        ) {
                            Text(
                                text = "Texte sur fond rouge",
                                color = Color.White,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                }
            }

            Column(modifier = Modifier) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(2) { index ->
                        Box(
                            modifier = Modifier
                                .size(width = 186.dp, height = 100.dp)
                                .padding(8.dp)
                                .background(Color.Yellow)
                        ) {
                            Text(
                                text = "Texte sur fond jaune",
                                color = Color.Black,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                }
            }
            Column(modifier = Modifier) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(2) { index ->
                        Box(
                            modifier = Modifier
                                .size(width = 186.dp, height = 100.dp)
                                .padding(8.dp)
                                .background(Color.Blue)
                        ) {
                            Text(
                                text = "Texte sur fond bleu",
                                color = Color.White,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                }
            }

            Column(modifier = Modifier) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(2) { index ->
                        Box(
                            modifier = Modifier
                                .size(width = 186.dp, height = 100.dp)
                                .padding(8.dp)
                                .background(Color.Green)
                        ) {
                            Text(
                                text = "Texte sur fond vert",
                                color = Color.White,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue)
                    .padding(8.dp)
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(1) { index ->
                        Row(modifier = Modifier.fillMaxWidth()) {
                            // Image
                            Image(
                                painter = rememberImagePainter(
                                    data = "https://m.media-amazon.com/images/I/71dFTmV2jgL._SL1440_.jpg",
                                    builder = {
                                        crossfade(true)
                                    }
                                ),
                                contentDescription = "Poursuivre l'écoute",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(width = 55.dp, height = 55.dp)
                            )

                            // Text
                            Column(
                                modifier = Modifier.padding(start = 8.dp)
                            ) {
                                Text(
                                    text = "PNL - Deux frères",
                                    color = Color.White,
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = "Dans la légende",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Center
                                )
                            }

                            IconButton(onClick = { }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_fav),
                                    contentDescription = "Favoris",
                                    tint = Color.White
                                )
                            }
                            IconButton(onClick = { }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_prev),
                                    contentDescription = "Précédent",
                                    tint = Color.White
                                )
                            }
                            IconButton(onClick = { }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_pause),
                                    contentDescription = "Pause",
                                    tint = Color.White
                                )
                            }

                            IconButton(onClick = { }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_next),
                                    contentDescription = "Suivant",
                                    tint = Color.White
                                )
                            }

                        }
                    }
                }
            }


        }
    }
}



