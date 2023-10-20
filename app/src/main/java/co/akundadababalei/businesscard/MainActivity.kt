package co.akundadababalei.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.akundadababalei.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println(savedInstanceState?.size());
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(R.color.primary)
                ) {
                    BusinessCard(
                        Modifier
                            .fillMaxSize()
                            .padding(20.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier, verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier)
        `Jumbo-tron`()
        Details(/*Modifier.align(alignment = Alignment.CenterHorizontally)*/)
    }
}

@Composable
private fun `Jumbo-tron`(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier = Modifier
                .background(color = colorResource(R.color.black))
                .size(100.dp),
        ) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = null,
            )
        }
        Text("Paul Anukem", fontSize = 26.sp, fontWeight = FontWeight.W300)
        Text("Cross-Platform Full-Stack Developer", fontSize = 14.sp)
    }
}

@Composable
private fun Details(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.wrapContentWidth()
    ) {
        DetailTile(icon = Icons.Rounded.Phone, detail = "+233 55 237 7556")
        Spacer(modifier = Modifier.height(16.dp))
        DetailTile(icon = Icons.Rounded.Share, detail = "https://g.dev/paulanukem")
        Spacer(modifier = Modifier.height(16.dp))
        DetailTile(icon = Icons.Rounded.Email, detail = "paulagams12@gmail.com")
    }
}

@Composable
fun DetailTile(modifier: Modifier = Modifier, icon: ImageVector, detail: String) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
    ) {
        Icon(icon, contentDescription = null)
        Spacer(modifier = Modifier.width(16.dp))
        Text(detail, textAlign = TextAlign.Justify)
    }
}


@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFFB39DDB)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard(
            Modifier
                .fillMaxSize()
                .padding(20.dp),
        );
    }
}