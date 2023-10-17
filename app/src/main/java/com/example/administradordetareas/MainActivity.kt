package com.example.administradordetareas

import android.os.Bundle
import android.provider.Settings.System.getString
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.administradordetareas.ui.theme.AdministradorDeTareasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdministradorDeTareasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    TaskManageImage(title = getString(R.string.TitleTask),
                        texto = getString(R.string.TextTask))
                }
            }
        }
    }
}
@Composable
fun TaskManageImage(title: String, texto: String, modifier: Modifier = Modifier)
{
    val image = painterResource(id = R.drawable.ic_task_completed)
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()

    ) {
       Image(painter = image,
           contentDescription = null,
           contentScale = ContentScale.None,
           modifier = Modifier.fillMaxWidth()
       )
        TaskManage(
            title = title,
            texto = texto
        )
    }
}

@Composable
fun TaskManage(title: String, texto: String, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 24.dp, end = 8.dp)
        )
        Text(text = texto,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
@Preview(showBackground = true)
@Composable
fun TakManagePreview() {
    AdministradorDeTareasTheme {
        TaskManageImage(title = "All tasks completed", texto = "Nice work!")
    }
}