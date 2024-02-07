package com.example.myapplication.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.LightGray
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
    var showTextBox by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
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
        var isReportClicked by remember { mutableStateOf(false) }
        LazyRow(
            modifier = Modifier
                .padding(vertical = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            item {
                DashboardCard(
                    title = "Report",
                    iconResId = R.drawable.rerport2,
                    onClick = { showTextBox = true }
                )
            }

            item {
                DashboardCard(
                    title = "Previous Issue",
                    iconResId = R.drawable.issue2,
                    onClick = { showTextBox = false }
                )
            }

            item {
                DashboardCard(
                    title = "Settings",
                    iconResId = R.drawable.settings2,
                    onClick = { /* Add any settings logic here */ }
                )
            }
        }

        // Conditionally display the TextBoxForProblemDescription
        if (showTextBox) {
            TextBoxForProblemDescription()
            SubmitReportButton()
        }
    }
}

@Composable
fun TextBoxForProblemDescription() {
    var description by remember { mutableStateOf("") }
    Text(
        text = "Report Issue",
        fontSize = 30.sp
    )

    DropDownExample()
    TextField(
        value = description,
        onValueChange = { description = it },
        label = { Text("Problem Description") },
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp) // Adjust the height as needed
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownExample() {
    val options = listOf("LAN not working", "Water Supply Issue", "Electricity issue")
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            readOnly = true,
            value = selectedOptionText,
            onValueChange = {},
            label = { Text("Choose One of Option") },
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
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(text = "Submit Report")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardCard(title: String, iconResId: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(5.dp)
            .width(160.dp)
            .height(120.dp),
        border = BorderStroke(3.dp, color = LightGray),
        shape = RoundedCornerShape(8.dp),
        onClick = onClick,

        ) {
        val image = painterResource(id = iconResId)
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.size(60.dp)
            )

            Text(
                text = title,
                modifier = Modifier.padding(top = 10.dp)
            )

        }

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