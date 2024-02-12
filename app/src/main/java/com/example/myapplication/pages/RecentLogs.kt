package com.example.myapplication.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun RecentLogs() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Recent Logs",
            fontSize = 40.sp,
        )
        LazyColumn() {
            for (x in 0..50) {
                item {
                    RecentCards()
                }
            }


        }
    }
}

@Composable
fun RecentCards() {
    Card(modifier = Modifier
        .padding(10.dp)
        .height(80.dp)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Lan Problem",
                    fontSize = 20.sp,
                    color = Color(0xFFF36405),
                    fontWeight = FontWeight.Bold
                )
                Text(text = "11-02-2024")
                Text(text = "9:00")
            }
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = "Floor 1")
                Text(text = "B2")
                Text(text = "158")
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview5() {
    val navController = rememberNavController()
    MyApplicationTheme {
        ProfilePg(navController)

    }
}