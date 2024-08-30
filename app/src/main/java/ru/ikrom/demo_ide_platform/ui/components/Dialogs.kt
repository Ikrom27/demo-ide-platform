package ru.ikrom.demo_ide_platform.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import ru.ikrom.demo_ide_platform.R
import ru.ikrom.demo_ide_platform.ui.theme.ICON_MEDIUM
import ru.ikrom.demo_ide_platform.ui.theme.PADDING_BETWEEN_LARGE
import ru.ikrom.demo_ide_platform.ui.theme.PADDING_BETWEEN_MEDIUM
import ru.ikrom.demo_ide_platform.ui.theme.PADDING_LARGE
import ru.ikrom.demo_ide_platform.ui.theme.RADIUS_DIALOG_CORNER

@Composable
fun AppDialog(
    onDismiss: () -> Unit,
    content: @Composable () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismiss) {
        Card(
            shape = RoundedCornerShape(RADIUS_DIALOG_CORNER)
        ){
            content()
        }
    }
}


@Composable
fun DeleteDialog(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    AppDialog(onDismiss = onDismiss) {
        Column(
            verticalArrangement = Arrangement.spacedBy(PADDING_BETWEEN_LARGE),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(PADDING_LARGE))
        {
            Icon(
                painter = painterResource(id = R.drawable.ic_dangerous),
                contentDescription = null,
                tint = Color.DarkGray,
                modifier = Modifier.size(ICON_MEDIUM))
            Text(
                text = stringResource(id = R.string.delete_product),
                style = MaterialTheme.typography.bodyLarge.copy(),
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
            )
            Text(
                text = stringResource(id = R.string.delete_text),
                style = MaterialTheme.typography.bodyLarge.copy(),
                color = Color.DarkGray,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
            )
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth())
            {
                IconButton(onClick = onDismiss) {
                    Text(
                        text = stringResource(id = R.string.no),
                        style = MaterialTheme.typography.bodyLarge.copy(),
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
                IconButton(onClick = onConfirm) {
                    Text(
                        text = stringResource(id = R.string.yes),
                        style = MaterialTheme.typography.bodyLarge.copy(),
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}


@Composable
fun AmountChangeDialog(
    amount: Int,
    onConfirm: (Int) -> Unit,
    onDismiss: () -> Unit,
) {
    var currentAmount by remember {
        mutableIntStateOf(amount)
    }
    AppDialog(onDismiss = onDismiss) {
        Column(
            verticalArrangement = Arrangement.spacedBy(PADDING_BETWEEN_LARGE),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(PADDING_LARGE))
        {
            Icon(
                painter = painterResource(id = R.drawable.ic_gear),
                contentDescription = null,
                tint = Color.DarkGray,
                modifier = Modifier.size(ICON_MEDIUM))
            Text(
                text = stringResource(id = R.string.product_amount),
                style = MaterialTheme.typography.bodyLarge.copy(),
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(PADDING_BETWEEN_MEDIUM),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(onClick = {
                    if(currentAmount>0) currentAmount--
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_minus),
                        tint = MaterialTheme.colorScheme.primary,
                        contentDescription = null)
                }
                Text(
                    text = currentAmount.toString(),
                    style = MaterialTheme.typography.bodyLarge.copy(),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                )
                IconButton(onClick = {
                    currentAmount++
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_plus),
                        tint = MaterialTheme.colorScheme.primary,
                        contentDescription = null)
                }
            }

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth())
            {
                Text(
                    text = stringResource(id = R.string.dismiss),
                    style = MaterialTheme.typography.bodyLarge.copy(),
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    modifier = Modifier.clickable { onDismiss() }
                )
                Spacer(modifier = Modifier.width(PADDING_BETWEEN_MEDIUM))
                Text(
                    text = stringResource(id = R.string.confirm),
                    style = MaterialTheme.typography.bodyLarge.copy(),
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    modifier = Modifier.clickable { onConfirm(currentAmount) }
                )
            }
        }
    }
}