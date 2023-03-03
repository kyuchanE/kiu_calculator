package kiu.dev.my_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.databinding.DataBindingUtil
import kiu.dev.my_calculator.data.AppVersion
import kiu.dev.my_calculator.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            TextCreate()
            Column {
                NewStory()
                TextCreate()
            }
        }
    }

    @Preview
    @Composable
    private fun TextCreate() {
        Text(text = "Hello Compose World", color = Color.White)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    private fun NewStory() {
        MaterialTheme {
            val typography = MaterialTheme.typography
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier
                        .height(180.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "A day wandering through the sandhills " +
                            "in Shark Fin Cove, and a few of the " +
                            "sights I saw",
                    color = Color.White,
                    style = typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Davenport, California",
                    color = Color.White,
                    style = typography.bodySmall
                )
                Text(
                    text = "December 2018",
                    color = Color.White,
                    style = typography.bodySmall
                )

                Spacer(modifier = Modifier.height(16.dp))

                val clicks = remember { mutableStateOf(0) }
                Button(
                    onClick = { ++clicks.value }
                ) {
                    Text(text = "Click here!")
                }

                Text(text = "Clicked ${clicks.value} times", color = Color.White)

                Spacer(modifier = Modifier.height(16.dp))
                val text = remember { mutableStateOf("Jetpack Compose") }

                OutlinedTextField(
                    value = text.value,
                    onValueChange = { text.value = it },
                    textStyle = TextStyle(color = Color.White)
                )
                TextData(input = text.value)
            }
        }
    }

    @Composable
    private fun TextData(input: String) {
        Log.d("@@@@@", "@@@@@ TextData input : $input")
        val rememberedInput = remember { mutableStateOf(input) }.apply {
            value = input
        }
        Text(text = " rememberedInput : ${rememberedInput.value}", color = Color.White)
    }


}