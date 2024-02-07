package com.example.myapplication.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
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
    Column(modifier = Modifier.fillMaxSize()) {

        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.adminblock),
                contentDescription = null,
                modifier= Modifier
            )
        }

        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val username = remember {
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

            val isChecked = remember { mutableStateOf(false) }


            Text(
                text = "SignUp",
                fontSize = 40.sp
            )

            Spacer(modifier = Modifier.height(15.dp))

            TextField(
                value = username.value,
                onValueChange = { username.value = it },
                label = { Text("Staff College ID") }
            )

            Spacer(modifier = Modifier.height(15.dp))

            TextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(modifier = Modifier.height(15.dp))

            TextField(
                value = passwordConfirm.value,
                onValueChange = { passwordConfirm.value = it },
                label = { Text("Confirm Password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            Spacer(modifier = Modifier.height(15.dp))

            TextField(
                value = department.value,
                onValueChange = { department.value = it },
                label = { Text("Department") }
            )

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = isChecked.value,
                    onCheckedChange = { isChecked.value = it }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("I agree to the terms and conditions")
            }

            Button(
                onClick = { /* Handle sign up logic */ },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text("Sign Up")
            }

            ClickableText(
                text = AnnotatedString("Already Registered ? Login Here"),
                modifier = Modifier
                    .padding(20.dp),
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
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    val navController = rememberNavController()
    MyApplicationTheme {
        StaffSignUpContent(navController)
    }
}