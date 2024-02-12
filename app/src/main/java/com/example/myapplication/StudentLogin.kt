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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginPage(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.admblk_night),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .blur(8.dp),
        )
    }

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
            modifier = Modifier.padding(20.dp),
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
                color = Color.White,
                style = TextStyle(fontSize = 40.sp, fontWeight = FontWeight.Bold)
            )

            Spacer(modifier = Modifier.height(30.dp))

            TextField(
                label = { Text(text = "Username") },
                value = username.value,
                onValueChange = { username.value = it },
                leadingIcon = {
                    Icon(
                        Icons.Outlined.AccountCircle,
                        contentDescription = null
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .clip(RoundedCornerShape(50.dp))

            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                label = { Text(text = "Password") },
                value = password.value,
                onValueChange = { password.value = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation(),
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Lock,
                        contentDescription = null
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .clip(RoundedCornerShape(50.dp))
            )
            Spacer(modifier = Modifier.height(10.dp))

            ClickableText(
                text = AnnotatedString("Forgot Password?"),
                onClick = { navController.navigate("forgot-password") },
                
                style = TextStyle(
                    textDecoration = TextDecoration.Underline,
                    fontSize = 17.sp,
                    color = Color.White
                )
            )

            Spacer(modifier = Modifier.height(100.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        navController.navigate("profile")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF36405)
                    ),
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(80.dp),
                    shape = CircleShape,
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Arrow Icon",
                        tint = Color.White
                    )
                }
            }
        }
        Box(modifier = Modifier.fillMaxSize()) {
            ClickableText(
                text = AnnotatedString("Don't have an account? Create one"),
                modifier = Modifier
                    .padding(20.dp)
                    .align(Alignment.BottomCenter),
                onClick = { navController.navigate("signup") },
                style = TextStyle(
                    textDecoration = TextDecoration.Underline,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Default,
                    color = Color.White
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