package ru.ikrom.demo_ide_platform.ui.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.ikrom.demo_ide_platform.ui.items.ProductItem
import ru.ikrom.demo_ide_platform.ui.items.TagUI
import ru.ikrom.demo_ide_platform.ui.theme.CARD_ELEVATION
import ru.ikrom.demo_ide_platform.ui.theme.CardColor
import ru.ikrom.demo_ide_platform.ui.theme.PADDING_BETWEEN_EXTRA_SMALL
import ru.ikrom.demo_ide_platform.ui.theme.PADDING_BETWEEN_SMALL
import ru.ikrom.demo_ide_platform.ui.theme.PADDING_EXTRA_SMALL
import ru.ikrom.demo_ide_platform.ui.theme.PADDING_SMALL
import ru.ikrom.demo_ide_platform.ui.theme.PADDING_STANDARD
import ru.ikrom.demo_ide_platform.ui.theme.RADIUS_CHIP_CORNER

@Composable
fun ProductCard(product: ProductItem){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = CardColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = CARD_ELEVATION
        ),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(PADDING_BETWEEN_SMALL),
            modifier = Modifier.padding(PADDING_STANDARD)) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.bodyLarge.copy(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
            TagList(product.tags)

        }
    }
}

@Composable
fun TagList(tags: List<TagUI>){
    LazyRow(horizontalArrangement = Arrangement.spacedBy(PADDING_BETWEEN_EXTRA_SMALL)) {
        items(tags){ tag ->
            Chip(text = tag.text)
        }
    }
}

@Composable
fun Chip(text: String) {
    Card(
        border = BorderStroke(1.dp, Color.Gray),
        colors = CardDefaults.cardColors(
            containerColor = CardColor
        ),
        shape = RoundedCornerShape(RADIUS_CHIP_CORNER)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(horizontal = PADDING_SMALL, vertical = PADDING_EXTRA_SMALL),
        )
    }
}