package com.example.myapplication.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.Purple40
import com.example.myapplication.R


@Composable
fun StaffSignup(navController: NavController) {

    StaffSignUpContent(navController)
}

@Composable
fun StaffSignUpContent(navController: NavController) {


    Column(
        modifier = Modifier.padding(top = 5.dp, start = 20.dp, end = 20.dp, bottom = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val username = remember {
            mutableStateOf("")
        }

        val cellphone = remember {
            mutableStateOf("")
        }

        val password = remember {
            mutableStateOf("")
        }

        val passwordConfirm = remember {
            mutableStateOf("")
        }

        val department = remember {
            mutableStateOf("")
        }

        Text(
            text = "SignUp",
            fontSize = 40.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = username.value,
            onValueChange = { username.value = it },
            label = { Text("Staff College ID") },
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

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = cellphone.value,
            onValueChange = { cellphone.value = it },
            label = { Text("Contact Number") },
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
                .clip(RoundedCornerShape(50.dp)),
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = passwordConfirm.value,
            onValueChange = { passwordConfirm.value = it },
            label = { Text("Confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
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
            value = department.value,
            onValueChange = { department.value = it },
            label = { Text("Department") },
            leadingIcon = {
                Icon(
                    Icons.Outlined.Info,
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
fun ScreenPreview() {
    val navController = rememberNavController()
    MyApplicationTheme {
        StaffSignUpContent(navController)
    }
}