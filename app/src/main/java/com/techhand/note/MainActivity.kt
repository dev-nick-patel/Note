package com.techhand.note

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techhand.note.ui.theme.NoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Greeting() {
   var visible by remember {
       mutableStateOf(true)
   }
    val density = LocalDensity.current

    AnimatedVisibility(visible = visible,
    enter = fadeIn(),
    exit = fadeOut()) {

        Box(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier
                .align(Alignment.Center)
                .animateEnterExit(
                    enter = slideInVertically(),
                    exit = slideOutVertically()
                )
                .sizeIn(minWidth = 256.dp, minHeight = 64.dp)

            )
            Text(
                text = stringResource(id = R.string.app_name).uppercase(),
                modifier = Modifier
                    .padding(all = 4.dp)
                    .align(Alignment.Center),
                style = MaterialTheme.typography.button,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NoteTheme {
        Greeting()
    }
}