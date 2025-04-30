package com.example.amphibiansapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.amphibiansapp.model.Amphibian
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun AmphibianCard(amphibian: Amphibian) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "${amphibian.name} - ${amphibian.type}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = rememberAsyncImagePainter(amphibian.imgSrc),
                contentDescription = amphibian.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = amphibian.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AmphibianCardPreview() {
    AmphibianCard(
        amphibian = Amphibian(
            name = "Salamander",
            type = "Caudata",
            description = "Preview of a salamander with image.",
            imgSrc = "https://developer.android.com/static/courses/pathways/android-basics-compose-unit-4-pathway-1/images/frog.png"
        )
    )
}
