package com.cyberwalker.fashionstore.items

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cyberwalker.fashionstore.R
import com.cyberwalker.fashionstore.dump.BottomNav
import com.cyberwalker.fashionstore.ui.theme.*

@Composable
fun ItemsScreen(
    viewModel: ItemsViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onAction: (actions: ItemsScreenActions) -> Unit,
    navController: NavHostController
) {
    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            BottomNav(navController = navController)
        }
    ) { innerPadding ->
        ItemsScreenContent(modifier = Modifier.padding(innerPadding), onAction = onAction)
    }
}

@Composable
private fun ItemsScreenContent(
    modifier: Modifier,
    onAction: (actions: ItemsScreenActions) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .semantics { contentDescription = "Item Screen" }
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = CenterVertically
        ) {
            Image(modifier = Modifier
                .size(50.dp)
                .clickable {
                    onAction(ItemsScreenActions.Back)
                }
                .padding(8.dp),
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null)
            Spacer(modifier = Modifier.size(40.dp))
            Text( modifier = Modifier
                .padding(start = 80.dp),
                text = "SHOP",
                style = MaterialTheme.typography.medium_18_bold,
            )
        }

        Spacer(modifier = Modifier.size(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp)
                .defaultMinSize(minHeight = 228.dp)
        ) {
            Spacer(modifier = Modifier.size(16.dp))
            GridOfImages(onAction = onAction)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp)
                .defaultMinSize(minHeight = 228.dp)
        ) {
            Spacer(modifier = Modifier.size(16.dp))
            GridOfImages(onAction = onAction)
        }
        }
    }
@Composable
private fun GridOfImages(onAction: (actions: ItemsScreenActions) -> Unit) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Column {
            Box(
                Modifier
                    .size(150.dp, 150.dp)
                    .background(color = cardColorYellow, shape = RoundedCornerShape(16.dp))
                    .clip(shape = RoundedCornerShape(16.dp))
                    .clickable { onAction(ItemsScreenActions.Details) }
            ) {
                Image(
                    modifier = Modifier
                        .size(92.dp, 144.dp)
                        .align(Alignment.BottomCenter),
                    painter = painterResource(id = R.drawable.img_1),
                    contentDescription = null
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 8.dp, top = 8.dp)
                        .clickable { }
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            Row {
                Text(text = "Jhc T-Shirt", style = MaterialTheme.typography.small_caption2)
                Spacer(modifier = Modifier.size(24.dp))
                Text(text = "₹989", style = MaterialTheme.typography.small_caption2)
            }
            Spacer(modifier = Modifier.size(24.dp))
            Box(
                Modifier
                    .size(150.dp, 150.dp)
                    .background(color = cardColorPeach, shape = RoundedCornerShape(16.dp))
                    .clip(shape = RoundedCornerShape(16.dp))
                    .clickable { onAction(ItemsScreenActions.Details) }
            ) {
                Image(
                    modifier = Modifier
                        .size(112.dp, 170.dp)
                        .align(Alignment.BottomCenter),
                    painter = painterResource(id = R.drawable.img_3),
                    contentDescription = null
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 8.dp, top = 8.dp)
                        .clickable { }
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            Row {
                Text(text = "Lkm T-Shirt", style = MaterialTheme.typography.small_caption2)
                Spacer(modifier = Modifier.size(24.dp))
                Text(text = "₹674", style = MaterialTheme.typography.small_caption2)
            }
            Box(
                Modifier
                    .size(150.dp, 150.dp)
                    .background(color = cardColorBlue, shape = RoundedCornerShape(16.dp))
                    .clip(shape = RoundedCornerShape(16.dp))
                    .clickable { onAction(ItemsScreenActions.Back) }
            ) {
                Image(
                    modifier = Modifier
                        .size(112.dp, 170.dp)
                        .align(Alignment.BottomCenter),
                    painter = painterResource(id = R.drawable.img_2),
                    contentDescription = null
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 8.dp, top = 8.dp)
                        .clickable { }
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            Row {
                Text(text = "Sbm T-Shirt", style = MaterialTheme.typography.small_caption2)
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = "₹1189", style = MaterialTheme.typography.small_caption2)
            }
            Spacer(modifier = Modifier.size(24.dp))
            Box(
                Modifier
                    .size(150.dp, 150.dp)
                    .background(color = cardColorGreen, shape = RoundedCornerShape(16.dp))
                    .clip(shape = RoundedCornerShape(16.dp))
                    .clickable { onAction(ItemsScreenActions.Details) }
            ) {
                Image(
                    modifier = Modifier
                        .size(112.dp, 170.dp)
                        .align(Alignment.BottomCenter),
                    painter = painterResource(id = R.drawable.img_4),
                    contentDescription = null
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 8.dp, top = 8.dp)
                        .clickable { }
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            Row {
                Text(text = "Nkr T-Shirt", style = MaterialTheme.typography.small_caption2)
                Spacer(modifier = Modifier.size(24.dp))
                Text(text = "₹1589", style = MaterialTheme.typography.small_caption2)
            }
            Box(
                Modifier
                    .size(150.dp, 150.dp)
                    .background(color = cardColorBlue, shape = RoundedCornerShape(16.dp))
                    .clip(shape = RoundedCornerShape(16.dp))
                    .clickable { onAction(ItemsScreenActions.Details) }
            ) {
                Image(
                    modifier = Modifier
                        .size(112.dp, 170.dp)
                        .align(Alignment.BottomCenter),
                    painter = painterResource(id = R.drawable.img_2),
                    contentDescription = null
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 8.dp, top = 8.dp)
                        .clickable { }
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            Row {
                Text(text = "Sbm T-Shirt", style = MaterialTheme.typography.small_caption2)
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = "₹1189", style = MaterialTheme.typography.small_caption2)
            }
            Spacer(modifier = Modifier.size(24.dp))
            Box(
                Modifier
                    .size(150.dp, 150.dp)
                    .background(color = cardColorGreen, shape = RoundedCornerShape(16.dp))
                    .clip(shape = RoundedCornerShape(16.dp))
                    .clickable { onAction(ItemsScreenActions.Details) }
            ) {
                Image(
                    modifier = Modifier
                        .size(112.dp, 170.dp)
                        .align(Alignment.BottomCenter),
                    painter = painterResource(id = R.drawable.img_4),
                    contentDescription = null
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 8.dp, top = 8.dp)
                        .clickable { }
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            Row {
                Text(text = "Nkr T-Shirt", style = MaterialTheme.typography.small_caption2)
                Spacer(modifier = Modifier.size(24.dp))
                Text(text = "₹1589", style = MaterialTheme.typography.small_caption2)
            }
        }
        Spacer(modifier = Modifier.size(24.dp))

        Column {
            Box(
                Modifier
                    .size(150.dp, 150.dp)
                    .background(color = cardColorBlue, shape = RoundedCornerShape(16.dp))
                    .clip(shape = RoundedCornerShape(16.dp))
                    .clickable { onAction(ItemsScreenActions.Details) }
            ) {
                Image(
                    modifier = Modifier
                        .size(112.dp, 170.dp)
                        .align(Alignment.BottomCenter),
                    painter = painterResource(id = R.drawable.img_2),
                    contentDescription = null
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 8.dp, top = 8.dp)
                        .clickable { }
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            Row {
                Text(text = "Sbm T-Shirt", style = MaterialTheme.typography.small_caption2)
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = "₹1189", style = MaterialTheme.typography.small_caption2)
            }
            Spacer(modifier = Modifier.size(24.dp))
            Box(
                Modifier
                    .size(150.dp, 150.dp)
                    .background(color = cardColorGreen, shape = RoundedCornerShape(16.dp))
                    .clip(shape = RoundedCornerShape(16.dp))
                    .clickable { onAction(ItemsScreenActions.Details) }
            ) {
                Image(
                    modifier = Modifier
                        .size(112.dp, 170.dp)
                        .align(Alignment.BottomCenter),
                    painter = painterResource(id = R.drawable.img_4),
                    contentDescription = null
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 8.dp, top = 8.dp)
                        .clickable { }
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            Row {
                Text(text = "Nkr T-Shirt", style = MaterialTheme.typography.small_caption2)
                Spacer(modifier = Modifier.size(24.dp))
                Text(text = "₹1589", style = MaterialTheme.typography.small_caption2)
            }
            Box(
                Modifier
                    .size(150.dp, 150.dp)
                    .background(color = cardColorYellow, shape = RoundedCornerShape(16.dp))
                    .clip(shape = RoundedCornerShape(16.dp))
                    .clickable { onAction(ItemsScreenActions.Details) }
            ) {
                Image(
                    modifier = Modifier
                        .size(92.dp, 144.dp)
                        .align(Alignment.BottomCenter),
                    painter = painterResource(id = R.drawable.img_1),
                    contentDescription = null
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 8.dp, top = 8.dp)
                        .clickable { }
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            Row {
                Text(text = "Jhc T-Shirt", style = MaterialTheme.typography.small_caption2)
                Spacer(modifier = Modifier.size(24.dp))
                Text(text = "₹989", style = MaterialTheme.typography.small_caption2)
            }
            Spacer(modifier = Modifier.size(24.dp))
            Box(
                Modifier
                    .size(150.dp, 150.dp)
                    .background(color = cardColorPeach, shape = RoundedCornerShape(16.dp))
                    .clip(shape = RoundedCornerShape(16.dp))
                    .clickable { onAction(ItemsScreenActions.Details) }
            ) {
                Image(
                    modifier = Modifier
                        .size(112.dp, 170.dp)
                        .align(Alignment.BottomCenter),
                    painter = painterResource(id = R.drawable.img_3),
                    contentDescription = null
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 8.dp, top = 8.dp)
                        .clickable { }
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            Row {
                Text(text = "Lkm T-Shirt", style = MaterialTheme.typography.small_caption2)
                Spacer(modifier = Modifier.size(24.dp))
                Text(text = "₹674", style = MaterialTheme.typography.small_caption2)
            }
            Box(
                Modifier
                    .size(150.dp, 150.dp)
                    .background(color = cardColorBlue, shape = RoundedCornerShape(16.dp))
                    .clip(shape = RoundedCornerShape(16.dp))
                    .clickable { onAction(ItemsScreenActions.Details) }
            ) {
                Image(
                    modifier = Modifier
                        .size(112.dp, 170.dp)
                        .align(Alignment.BottomCenter),
                    painter = painterResource(id = R.drawable.img_2),
                    contentDescription = null
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 8.dp, top = 8.dp)
                        .clickable { }
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            Row {
                Text(text = "Sbm T-Shirt", style = MaterialTheme.typography.small_caption2)
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = "₹1189", style = MaterialTheme.typography.small_caption2)
            }
            Spacer(modifier = Modifier.size(24.dp))
            Box(
                Modifier
                    .size(150.dp, 150.dp)
                    .background(color = cardColorGreen, shape = RoundedCornerShape(16.dp))
                    .clip(shape = RoundedCornerShape(16.dp))
                    .clickable { onAction(ItemsScreenActions.Details) }
            ) {
                Image(
                    modifier = Modifier
                        .size(112.dp, 170.dp)
                        .align(Alignment.BottomCenter),
                    painter = painterResource(id = R.drawable.img_4),
                    contentDescription = null
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 8.dp, top = 8.dp)
                        .clickable { }
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            Row {
                Text(text = "Nkr T-Shirt", style = MaterialTheme.typography.small_caption2)
                Spacer(modifier = Modifier.size(24.dp))
                Text(text = "₹1589", style = MaterialTheme.typography.small_caption2)
            }
        }
    }

}


sealed class ItemsScreenActions {
    object Back : ItemsScreenActions()

    object Details : ItemsScreenActions()
}