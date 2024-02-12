package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.pages.ForgotPassword
import com.example.myapplication.pages.ProfilePg
import com.example.myapplication.pages.SignUp
import com.example.myapplication.pages.StaffSignup
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScreenMain()
                }
            }
        }
    }
}

@Composable
fun ScreenMain() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginPage(navController) }
        composable("signup") { SignUp(navController = navController)}
        composable("profile") { ProfilePg(navController = navController) }
        composable("staffSignup") { StaffSignup(navController = navController) }
        composable("forgot-password") { ForgotPassword(navController = navController)}
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    MyApplicationTheme {
        ScreenMain()

    }
}