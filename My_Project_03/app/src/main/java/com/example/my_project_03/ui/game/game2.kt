package com.example.my_project_03.ui.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.my_project_03.R
import kotlin.random.Random
import com.example.my_project_03.ui.theme.*

@Composable
fun ran_choice(choices: List<String>,ans: String): MutableList<String>{
    var quizChioce: MutableList<String> = mutableListOf("","","","")
    var ans_no = Random.nextInt(0,4)
    var index: Int
    var ans_num: MutableList<Int> = mutableListOf(choices.indexOf(ans),0,0,0)
    quizChioce.set(ans_no,ans)
    for (i in 1..3) {
        while (true) {
            index = Random.nextInt(0, 10)
            if (index !in ans_num) {
                break
            }
        }
        ans_num.set(i, index)
        while (true) {
            ans_no = Random.nextInt(0, 4)
            if (quizChioce[ans_no] == "") {
                break
            }
        }
        quizChioce.set(ans_no,choices[index])
    }

    return quizChioce
}


@Composable
fun Game2(navController:NavHostController){
    Column {
        NavBar2(navController = navController)
        Quiz_Game()
    }


}

@Composable
fun NavBar2(navController: NavHostController, modifier: Modifier = Modifier) {
    TopAppBar(
        title = { Text(stringResource(R.string.game2), fontSize = 24.sp) },
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
fun Quiz_Game(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "quiz",
    ) {
        composable(route = "quiz") {
            quiz_load(Random.nextInt(0,10),navController)
        }
    }
}

@Composable
fun quiz_load(quiz_no: Int, navController: NavHostController){
    var current : quiz = Quizs[quiz_no]
    Column (
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Quiz",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = current.question,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        ran_choice(current.choices,current.ans).forEach { choice ->
            Button(
                onClick = {  navController.navigate("quiz")  }
            ) {
                Text(
                    text = choice,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}