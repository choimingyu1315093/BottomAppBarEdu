package com.example.bottomappbaredu

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.bottomappbaredu.ui.theme.BottomAppBarEduTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BottomAppBarEduTheme {
                Scaffold (
                    bottomBar = {
                        BasicBottomAppBar()
                    },
                    modifier = Modifier
                        .fillMaxSize(),
                ){ innerPadding ->
                    Column (
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ){

                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BasicBottomAppBar(modifier: Modifier = Modifier){
    val context = LocalContext.current

    var isShow by remember { mutableStateOf(false) }
    if(isShow){
        BasicDropdownMenu()
    }

    BottomAppBar(
        actions = {
            IconButton(
                onClick = {
                    Toast.makeText(context, "Home", Toast.LENGTH_SHORT).show()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home Icon"
                )
            }
            IconButton(
                onClick = {
                    Toast.makeText(context, "Search", Toast.LENGTH_SHORT).show()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            }
        },
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = Color.White,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    isShow = !isShow
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Icon",
                    tint = Color.White
                )
            }
        }
    )
}

@Composable
fun BasicDropdownMenu(modifier: Modifier = Modifier){
    val items = listOf("사진 추가", "비디오 추가")

    var expanded by remember { mutableStateOf(true) }

    Column (
        modifier = modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.BottomEnd)
    ){
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            },
            modifier = modifier
                .width(140.dp)
                .background(Color.White)
        ) {
            items.forEachIndexed { index, text ->
                DropdownMenuItem(
                    onClick = {
                        expanded = false
                    },
                    text = {
                        Text(
                            text = text
                        )
                    }
                )
            }
        }
    }
}
