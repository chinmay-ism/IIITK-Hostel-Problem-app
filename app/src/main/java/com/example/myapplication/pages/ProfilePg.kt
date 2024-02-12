package com.example.myapplication.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme


@Composable
fun ProfilePg(navController: NavController) {

    var result by remember { mutableIntStateOf(1) }

    var fltr1: ColorFilter? = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0f) })
    var fltr2: ColorFilter? = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0f) })
    var fltr3: ColorFilter? = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0f) })
    var fnt1: FontWeight? = null
    var fnt2: FontWeight? = null
    var fnt3: FontWeight? = null


    when (result) {
        1 -> {
            fltr1 = null
            fnt1 = FontWeight.Bold
        }

        2 -> {
            fltr2 = null
            fnt2 = FontWeight.Bold
        }

        3 -> {
            fltr3 = null
            fnt3 = FontWeight.Bold
        }

        else -> null
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Hello,\nChinmay Agarwal",
                lineHeight = 30.sp,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Box(modifier = Modifier) {
                Image(
                    painter = painterResource(id = R.drawable.favicon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(75.dp)
                        .align(Alignment.Center)
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clickable(onClick = { result = 1 })
            ) {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.rerport2),
                        contentDescription = null,
                        colorFilter = fltr1,
                        modifier = Modifier.size(60.dp)
                    )
                    Text(
                        text = "Raise Issue",
                        fontWeight = fnt1
                    )
                }

            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clickable(onClick = { result = 2 })
            ) {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.issue2),
                        contentDescription = null,
                        colorFilter = fltr2,
                        modifier = Modifier.size(60.dp)
                    )
                    Text(
                        text = "Recent Logs",
                        fontWeight = fnt2
                    )
                }

            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clickable(onClick = { result = 3 })
            ) {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.settings2),
                        contentDescription = null,
                        colorFilter = fltr3,
                        modifier = Modifier.size(60.dp)
                    )
                    Text(
                        text = "Settings",
                        fontWeight = fnt3
                    )
                }

            }
        }

        val item = when (result) {
            1 -> {
                TextBoxForProblemDescription()
                SubmitReportButton()
            }

            2 -> {
                RecentLogs()
            }

            3 -> UserSettings()
            else -> null
        }

    }
}

@Composable
fun UserSettings() {

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Settings",
                fontSize = 40.sp
            )
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(vertical = 10.dp)
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF36405)
                ),
            ) {
                Text(
                    text = "Change account information",
                    color = Color.White
                )
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(vertical = 10.dp)
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF36405)
                ),
            ) {
                Text(
                    text = "Change Password",
                    color = Color.White
                )
            }

            Box(modifier = Modifier.fillMaxSize()) {

                Row(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(text = "Developed by:")
                        Text(
                            text = "Chinmay Agrawal",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFF36405)
                        )
                        Text(text = "2021KUCP1096")
                    }
                    Box(
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .clip(shape = CircleShape)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.mypic),
                            contentDescription = null,
                            modifier = Modifier.size(65.dp)
                        )

                    }
                }

            }
        }
    }
}


@Composable
fun TextBoxForProblemDescription() {
    var description by remember { mutableStateOf("") }
    Text(
        text = "Report Issue",
        fontSize = 40.sp
    )

    DropDownExample(
        options = listOf("LAN not working", "Water Supply Issue", "Electricity issue"),
        label = "Select the category of problem",
        modifier = Modifier.fillMaxWidth()
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        DropDownExample(
            options = listOf("A1", "A2", "B1", "B2", "C1", "C2"),
            label = "Block",
            modifier = Modifier.width(150.dp)
        )

        DropDownExample(
            options = listOf("Ground", "1", "2", "3", "4", "5", "6"),
            label = "Floor",
            modifier = Modifier.width(150.dp)
        )
    }

    TextField(
        value = description,
        onValueChange = { description = it },
        label = { Text("Problem Description") },
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(20.dp))
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownExample(options: List<String>, label: String, modifier: Modifier) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf("") }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            modifier = modifier
                .menuAnchor()
                .clip(RoundedCornerShape(20.dp)),
            readOnly = true,
            value = selectedOptionText,
            onValueChange = {},
            label = { Text(label) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption) },
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    },
                )
            }
        }
    }
}

@Composable
fun SubmitReportButton() {
    Button(
        onClick = { /* Handle submit report logic */ },
        modifier = Modifier
            .width(IntrinsicSize.Max)
            .height(70.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFF36405)
        ),
    ) {
        Text(
            text = "Submit Report",
            fontSize = 20.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview3() {
    val navController = rememberNavController()
    MyApplicationTheme {
        ProfilePg(navController)

    }
}