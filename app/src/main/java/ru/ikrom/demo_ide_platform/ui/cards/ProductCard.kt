package ru.ikrom.demo_ide_platform.ui.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowRow
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
import ru.ikrom.demo_ide_platform.ui.theme.PADDING_BETWEEN_SMALL
import ru.ikrom.demo_ide_platform.ui.theme.PADDING_EXTRA_SMALL
import ru.ikrom.demo_ide_platform.ui.theme.PADDING_SMALL
import ru.ikrom.demo_ide_platform.ui.theme.PADDING_STANDARD
import ru.ikrom.demo_ide_platform.ui.theme.RADIUS_CHIP_CORNER

@Composable
fun ProductCard(
    product: ProductItem,
    onEdit: () -> Unit,
    onDelete: () -> Unit
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
            TagsGrid(product.tags)
            ProductInfo(product)
        }
    }
}

@Composable
fun ProductTitle(
    name: String,
    onEdit: () -> Unit,
    onDelete: () -> Unit
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
                modifier = Modifier
                    .size(BUTTON_MEDIUM)
                    .clickable { onEdit() }
            )
            Icon(
                painter = painterResource(R.drawable.ic_trash),
                tint = MaterialTheme.colorScheme.error,
                contentDescription = null,
                modifier = Modifier
                    .size(BUTTON_MEDIUM)
                    .clickable { onDelete() }
            )
        }

    }
}

@Composable
fun TagsGrid(tags: List<TagUI>){
    FlowRow(
        mainAxisSpacing = PADDING_BETWEEN_EXTRA_SMALL,
        crossAxisSpacing = PADDING_BETWEEN_EXTRA_SMALL
    ) {
        tags.forEach { tag ->
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

@Composable
fun ProductInfo(product: ProductItem){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(PADDING_BETWEEN_SMALL)) {
            Text(
                text = stringResource(id = R.string.in_store),
                style = MaterialTheme.typography.bodyLarge.copy(),
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )
            Text(
                text = product.amount.toString(),
                style = MaterialTheme.typography.bodyLarge.copy(),
                fontSize = 18.sp
            )
        }
        Column(verticalArrangement = Arrangement.spacedBy(PADDING_BETWEEN_SMALL)) {
            Text(
                text = stringResource(id = R.string.added_date),
                style = MaterialTheme.typography.bodyLarge.copy(),
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )
            Text(
                text = product.date.date,
                style = MaterialTheme.typography.bodyLarge.copy(),
                fontSize = 18.sp
            )
        }
    }
}