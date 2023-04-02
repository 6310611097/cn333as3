package com.example.my_project_03.ui.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.my_project_03.R
import kotlin.random.Random


var comp = ""



@Composable
fun Game1(navController: NavHostController, modifier: Modifier = Modifier){
    var myRandomInt by remember {
        mutableStateOf(Random.nextInt(1,101))
    }

    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){
        NavBar1(navController)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Try to guess the number in my head")
        Text(text = "Between 1-100!")
        Spacer(modifier = Modifier.height(160.dp))
        val num = EditNumberField()
        Spacer(modifier = Modifier.height(160.dp))
        Compare(num = num, rand = myRandomInt)
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { myRandomInt = Random.nextInt(1,101) }) {
            Text(text = "Play again")
        }
    }
}

@Composable
fun NavBar1(navController: NavHostController, modifier: Modifier = Modifier) {
    TopAppBar(
        title = { Text(stringResource(R.string.game1), fontSize = 24.sp) },
        modifier = modifier.height(80.dp),
        navigationIcon = {
            IconButton(onClick = { navController.navigate("start") }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        }
    )
}


@Composable
fun EditNumberField(): Int{
    var Input by remember { mutableStateOf("") }
    TextField(
        value = Input,
        onValueChange = {Input = it},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        label = {
            Text(
                text = "Enter your guess here!",
                modifier = Modifier.fillMaxWidth()
            )
        }
    )
    return Input.toIntOrNull() ?: 0
}

@Composable
fun Compare(num: Int, rand: Int){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        if (num > rand){
            comp = "Hint: It's lower!"
        } else if (num < rand){
            comp = "Hint: It's higher!"
        } else {
            comp = "Good job!"
        }
        Text(text = comp)
    }
}