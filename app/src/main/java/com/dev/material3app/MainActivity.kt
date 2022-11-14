package com.dev.material3app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.material3app.ui.theme.Material3AppTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme {
                MainApp()
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun MainApp() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            SmallTopAppBar(
                title = {
                    Text(text = "Material 3")
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {  }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues
        ) {
            items(20) {
                ImageCard(
                    modifier = Modifier
                        .padding(16.dp),
                    title = "Lorem Ipsum",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sapien ex, semper ut ipsum nec, efficitur fringilla odio. Ut ut nisi ut nisl mattis finibus non quis ipsum. Curabitur pharetra tincidunt lectus, vel congue arcu interdum non. Proin quis purus volutpat est ultricies posuere quis tristique nisl. Aliquam erat volutpat. Maecenas sodales ultrices lectus at accumsan. Aliquam erat dolor, mollis eu consequat at, aliquam quis lorem. Pellentesque non orci gravida, faucibus neque non, tristique erat. Nullam porttitor mi nisl, et sodales neque aliquam at. Vestibulum dapibus vel magna sed porta. Maecenas lobortis odio non quam iaculis, et lacinia justo mattis. Pellentesque ex tortor, condimentum at hendrerit eget, euismod quis ex. Phasellus at aliquam justo, et auctor mauris."
                )
            }
        }
    }
}