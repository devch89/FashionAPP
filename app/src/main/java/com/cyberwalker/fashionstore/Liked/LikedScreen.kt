package com.cyberwalker.fashionstore.Liked

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cyberwalker.fashionstore.dump.BottomNav
import com.cyberwalker.fashionstore.ui.theme.medium_18
import com.google.firebase.crashlytics.FirebaseCrashlytics
import kotlinx.coroutines.launch

@Composable
fun LikedScreen(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onAction: (actions: LikedScreenActions) -> Unit,
    scrollState: ScrollState = rememberScrollState(),
    navController: NavHostController
) {

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            BottomNav(navController = navController)
        }
    ) { innerPadding ->
        LikedScreenContent(modifier = Modifier
            .padding(innerPadding)
            .scrollable(state = scrollState, orientation = Orientation.Vertical),
            onAction = onAction)
        crashTest(modifier = Modifier
            .padding(innerPadding)
        )
    }


}

@Composable
private fun LikedScreenContent(
    modifier: Modifier,
    onAction: (actions: LikedScreenActions) -> Unit,
) {
    Column(
        modifier = modifier
            .padding(horizontal = 40.dp)
            .fillMaxHeight()
            .semantics { contentDescription = "Liked Screen" }
            .verticalScroll(rememberScrollState())
    ) {
        Text(text = "Liked", style = MaterialTheme.typography.medium_18, modifier = Modifier)
    }
}
@Composable
private fun crashTest(
    modifier: Modifier

){
    FirebaseCrashlytics.getInstance().recordException(
        RuntimeException("Crash Test")
    )
    Row(modifier = modifier
        .padding(horizontal = 40.dp)
    ) {

        Button(
            onClick = {
                throw RuntimeException("For Firebase!")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 30.dp, end = 30.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Black, contentColor = Color.White
            ),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(text = "Crash", color = Color.White, modifier = Modifier.padding(7.dp))
        }

    }
}

sealed class LikedScreenActions {
    object LoadLiked : LikedScreenActions()
}