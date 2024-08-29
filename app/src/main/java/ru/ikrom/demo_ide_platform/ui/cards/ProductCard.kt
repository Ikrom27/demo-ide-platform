package ru.ikrom.demo_ide_platform.ui.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.ikrom.demo_ide_platform.R
import ru.ikrom.demo_ide_platform.ui.items.ProductItem
import ru.ikrom.demo_ide_platform.ui.items.TagUI
import ru.ikrom.demo_ide_platform.ui.theme.BUTTON_MEDIUM
import ru.ikrom.demo_ide_platform.ui.theme.CARD_ELEVATION
import ru.ikrom.demo_ide_platform.ui.theme.CardColor
import ru.ikrom.demo_ide_platform.ui.theme.EditColor
import ru.ikrom.demo_ide_platform.ui.theme.PADDING_BETWEEN_EXTRA_SMALL
import ru.ikrom.demo_ide_platform.ui.theme.PADDING_BETWEEN_MEDIUM
import ru.ikrom.demo_ide_platform.ui.theme.PADDING_BETWEEN_MEDIUM_PLUS
import ru.ikrom.demo_ide_platform.ui.theme.PADDING_EXTRA_SMALL
import ru.ikrom.demo_ide_platform.ui.theme.PADDING_SMALL
import ru.ikrom.demo_ide_platform.ui.theme.PADDING_STANDARD
import ru.ikrom.demo_ide_platform.ui.theme.RADIUS_CHIP_CORNER

@Composable
fun ProductCard(
    product: ProductItem,
    onEdit: (String) -> Unit,
    onDelete: (String) -> Unit
){
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
            verticalArrangement = Arrangement.spacedBy(PADDING_BETWEEN_MEDIUM),
            modifier = Modifier.padding(PADDING_STANDARD)) {

            ProductTitle(product.name, onEdit, onDelete)
            TagList(product.tags)

        }
    }
}

@Composable
fun ProductTitle(
    name: String,
    onEdit: (String) -> Unit,
    onDelete: (String) -> Unit
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.bodyLarge.copy(),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Row(horizontalArrangement = Arrangement.spacedBy(PADDING_BETWEEN_MEDIUM_PLUS)) {
            Icon(
                painter = painterResource(R.drawable.ic_edit),
                tint = EditColor,
                contentDescription = null,
                modifier = Modifier.size(BUTTON_MEDIUM).clickable { onEdit(name) }
            )
            Icon(
                painter = painterResource(R.drawable.ic_trash),
                tint = MaterialTheme.colorScheme.error,
                contentDescription = null,
                modifier = Modifier.size(BUTTON_MEDIUM).clickable { onDelete(name) }
            )
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