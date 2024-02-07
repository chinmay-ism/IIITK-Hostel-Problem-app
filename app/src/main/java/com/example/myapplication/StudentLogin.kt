package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.Purple40

@Composable
fun LoginPage(navController: NavController) {

    Column {
        Box(modifier = Modifier.fillMaxWidth()) {
            val image = painterResource(id = R.drawable.favicon)
            Image(
                painter = image, contentDescription = null, modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 50.dp)
                    .size(130.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val username = remember {
                mutableStateOf(TextFieldValue())
            }
            val password = remember {
                mutableStateOf(TextFieldValue())
            }

            Spacer(modifier = Modifier.height(60.dp))
            Text(
                text = "Login",
                style = TextStyle(fontSize = 40.sp, fontWeight = FontWeight.Bold)
            )

            Spacer(modifier = Modifier.height(30.dp))

            TextField(
                label = { Text(text = "Username") },
                value = username.value,
                onValueChange = { username.value = it }
            )

            Spacer(modifier = Modifier.height(15.dp))

            TextField(
                label = { Text(text = "Password") },
                value = password.value,
                onValueChange = { password.value = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                Button(
                    onClick = {
                        navController.navigate("profile")
                    },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Login")
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            ClickableText(
                text = AnnotatedString("Forgot Password?"),
                onClick = { navController.navigate("forgot-password") },
                style = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Default
                )
            )

            ClickableText(
                text = AnnotatedString("Student Signup"),
                modifier = Modifier
                    .padding(20.dp),
                onClick = { navController.navigate("signup") },
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Default,
                    textDecoration = TextDecoration.Underline,
                    color = Purple40
                )
            )

            ClickableText(
                text = AnnotatedString("Staff Signup"),
                modifier = Modifier,
                onClick = { navController.navigate("staffSignup") },
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Default,
                    textDecoration = TextDecoration.Underline,
                    color = Purple40
                )
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenPreview2() {
    val navController = rememberNavController()
    LoginPage(navController = navController)
}