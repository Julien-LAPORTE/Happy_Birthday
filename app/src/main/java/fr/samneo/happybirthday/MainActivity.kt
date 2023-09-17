package fr.samneo.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.samneo.happybirthday.ui.theme.HappyBirthdayTheme

const val USER_NAME = "Sam"
const val SENDER_NAME = "Emma"
const val GREETING_TEXT_FONT_SIZE = 80
const val SIGNATURE_TEXT_FONT_SIZE = 28

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    BirthdayCard()
                }
            }
        }
    }
}

@Composable
fun BirthdayCard() {
    Box {
        GreetingImage()
        GreetingText(
            message = stringResource(R.string.happy_birthday_text, USER_NAME),
            from = SENDER_NAME,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
    //GreetingText(message = "Comment tu vas ?", from ="Julien", modifier )
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {

    Column(
        verticalArrangement = Arrangement.Center, modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = message,
            //Line size matches font size +10%
            lineHeight = (GREETING_TEXT_FONT_SIZE + (GREETING_TEXT_FONT_SIZE * 0.1)).sp,
            fontSize = GREETING_TEXT_FONT_SIZE.sp,
            textAlign = TextAlign.Center,
        )
        val offset = Offset(5.0f, 10.0f)
        Text(
            text = stringResource(R.string.signature_text, from),
            fontSize = SIGNATURE_TEXT_FONT_SIZE.sp,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            style = TextStyle(
                shadow = Shadow(color = Color.Blue, offset = offset, blurRadius = 3f)
            )
        )
    }
}

@Composable
fun GreetingImage() {
    val image = painterResource(id = R.drawable.androidparty)
    Image(
        painter = image, contentDescription = null, contentScale = ContentScale.Crop, alpha = 0.5f
    )
}

@Preview(showBackground = false)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        BirthdayCard()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingTextPreview() {
    HappyBirthdayTheme {
        GreetingText(stringResource(R.string.happy_birthday_text, USER_NAME), SENDER_NAME)
    }
}

@Preview(showBackground = false)
@Composable
fun GreetingImagePreview() {
    HappyBirthdayTheme {
        GreetingImage()
    }
}