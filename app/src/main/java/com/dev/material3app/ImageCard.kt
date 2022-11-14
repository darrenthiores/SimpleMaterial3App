package com.dev.material3app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.dev.material3app.ui.theme.Material3AppTheme
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import kotlin.random.Random

@ExperimentalMaterial3Api
@Composable
fun ImageCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        shape = MaterialTheme.shapes.large
    ) {
        Image(
            modifier = Modifier
                .clip(
                    MaterialTheme.shapes.large.copy(
                        bottomStart = CornerSize(0.dp),
                        bottomEnd = CornerSize(0.dp)
                    )
                )
                .fillMaxWidth()
                .aspectRatio(3f / 2f),
            painter = rememberAsyncImagePainter(
                model = "https://picsum.photos/seed/${Random.nextInt()}/300/200"
            ),
            contentDescription = null
        )

        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth(),
                mainAxisSpacing = 8.dp,
                mainAxisSize = SizeMode.Wrap
            ) {
                AssistChip(
                    onClick = {  },
                    colors = AssistChipDefaults.assistChipColors(
                        leadingIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.FavoriteBorder,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(text = "Mark as favorite")
                    }
                )

                AssistChip(
                    onClick = {  },
                    colors = AssistChipDefaults.assistChipColors(
                        leadingIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Share,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(text = "Share with others")
                    }
                )
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun ImageCardPreview() {
    Material3AppTheme {
        ImageCard(
            title = "Lorem Ipsum",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sapien ex, semper ut ipsum nec, efficitur fringilla odio. Ut ut nisi ut nisl mattis finibus non quis ipsum. Curabitur pharetra tincidunt lectus, vel congue arcu interdum non. Proin quis purus volutpat est ultricies posuere quis tristique nisl. Aliquam erat volutpat. Maecenas sodales ultrices lectus at accumsan. Aliquam erat dolor, mollis eu consequat at, aliquam quis lorem. Pellentesque non orci gravida, faucibus neque non, tristique erat. Nullam porttitor mi nisl, et sodales neque aliquam at. Vestibulum dapibus vel magna sed porta. Maecenas lobortis odio non quam iaculis, et lacinia justo mattis. Pellentesque ex tortor, condimentum at hendrerit eget, euismod quis ex. Phasellus at aliquam justo, et auctor mauris."
        )
    }
}