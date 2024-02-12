package com.example.myapplication.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.Purple40


@Composable
fun SignUp(navController: NavController) {
    SignUpContent(navController)
}

@Composable
fun SignUpContent(navController: NavController) {
    var x by remember { mutableIntStateOf(1) }

    var clr1 = Color(0xFFF36405)
    var clr2 = Color(0xFFF36405)

    val button1 = when (x) {
        1 -> {
            clr1 = Color(0xFFB22D00)
            clr2 = Color(0xFFF36405)
        }

        else -> {
            clr1 = Color(0xFFF36405)
            clr2 = Color(0xFFB22D00)
        }

    }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.adminblock),
                contentDescription = null,
                modifier = Modifier
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 40.dp, end = 40.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { x = 1 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = clr1,
                ),
                modifier = Modifier
                    .height(60.dp)
                    .weight(1f)
            ) {
                Text(
                    text = "Student",
                    fontSize = 20.sp
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Button(
                onClick = { x = 2 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = clr2,
                ),
                modifier = Modifier
                    .height(60.dp)
                    .weight(1f)
            ) {
                Text(
                    text = "Admin",
                    fontSize = 20.sp
                )
            }
        }

        if (x == 1) {
            StudentSignup(navController)
        } else {
            StaffSignup(navController)
        }
    }
}

@Composable
fun StudentSignup(navController: NavController) {

    Column(
        modifier = Modifier.padding(top = 5.dp, start = 20.dp, end = 20.dp, bottom = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val username = remember {
            mutableStateOf("")
        }

        val password = remember {
            mutableStateOf("")
        }

        val cellphone = remember {
            mutableStateOf("")
        }

        val roomNumber = remember {
            mutableStateOf("")
        }

        val confirmPassword = remember {
            mutableStateOf("")
        }


        Text(
            text = "SignUp",
            fontSize = 40.sp,
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            label = { Text(text = "Student College ID") },
            value = username.value,
            onValueChange = { username.value = it },
            leadingIcon = {
                Icon(
                    Icons.Outlined.AccountCircle,
                    contentDescription = null,
                )
            },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .clip(RoundedCornerShape(50.dp))

        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = cellphone.value,
            onValueChange = { cellphone.value = it },
            label = { Text("Contact Number") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            leadingIcon = {
                Icon(
                    Icons.Outlined.Call,
                    contentDescription = null
                )
            },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .clip(RoundedCornerShape(50.dp))
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
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

        TextField(
            value = confirmPassword.value,
            onValueChange = { confirmPassword.value = it },
            label = { Text("Confirm Password") },
            leadingIcon = {
                Icon(
                    Icons.Outlined.Check,
                    contentDescription = null
                )
            },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .clip(RoundedCornerShape(50.dp))
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = roomNumber.value,
            onValueChange = { roomNumber.value = it },
            label = { Text("Room") },
            leadingIcon = {
                Icon(
                    Icons.Outlined.Home,
                    contentDescription = null
                )
            },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .clip(RoundedCornerShape(50.dp))
        )

        Button(
            modifier = Modifier
                .padding(20.dp)
                .size(70.dp),
            shape = CircleShape,
            onClick = {
                navController.navigate("login")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF36405)
            ),
        ) {
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Arrow Icon",
                tint = Color.White,
            )
        }

        ClickableText(
            text = AnnotatedString("Already Registered ? Login Here"),
            modifier = Modifier,
            onClick = { navController.navigate("login") },
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Default,
                textDecoration = TextDecoration.Underline,
                color = Purple40
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenPreview2() {
    val navController = rememberNavController()
    MyApplicationTheme {
        SignUpContent(navController)
    }
}