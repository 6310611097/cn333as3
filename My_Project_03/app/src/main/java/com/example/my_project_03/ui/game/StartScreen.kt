package com.example.my_project_03.ui.game

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.my_project_03.R

@Composable
fun Screen(navController: NavHostController) {
    Column {
        NavBar()
        Spacer(modifier = Modifier.height(160.dp))
        Ui(navController)
    }

}

@Composable
fun NavBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(R.string.app_name), fontSize = 24.sp) },
        modifier = modifier.height(80.dp)
    )
}

@Composable
fun Ui(navController: NavHostController, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(50.dp)
    ) {
        Button(
            onClick = { navController.navigate("game1") },
            modifier = Modifier.width(250.dp)
        ) {
            Text(stringResource(R.string.game1), fontSize = 24.sp)
        }
        Button(
            onClick = { navController.navigate("game2") },
            modifier = Modifier.width(250.dp)
        ) {
            Text(stringResource(R.string.game2), fontSize = 24.sp)
        }
        Button(
            onClick = { navController.navigate("game3") },
            modifier = Modifier.width(250.dp)
        ) {
            Text(stringResource(R.string.game3), fontSize = 24.sp)
        }
    }
}