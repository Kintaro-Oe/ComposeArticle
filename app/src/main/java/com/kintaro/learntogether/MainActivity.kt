package com.kintaro.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kintaro.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnTogetherTheme {
                Surface(
                    modifier = Modifier
                    .fillMaxSize()
                    .safeDrawingPadding(),
//                    .windowInsetsPadding(WindowInsets.safeDrawing)
//                    .windowInsetsPadding(WindowInsets.statusBars)
//                    .windowInsetsPadding(WindowInsets.displayCutout)
//                    .windowInsetsPadding(WindowInsets.systemBars)
                    color = MaterialTheme.colorScheme.background
                ) {
                   LearnTogetherApp()
                }
            }
        }
    }
}

@Composable
fun LearnTogetherApp() {
    LearnTogetherCard(
        title = stringResource(R.string.title),
        summary = stringResource(R.string.summary),
        subjectBody = stringResource(R.string.subject_body),
        imagePainter = painterResource(R.drawable.bg_compose_background),
    )
}

@Composable
private fun LearnTogetherCard(
    title: String,
    summary: String,
    subjectBody: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            alignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = title,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )

        Text(
            text = summary,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )

        Text(
            text = subjectBody,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LearnTogetherPreview() {
    LearnTogetherTheme {
        LearnTogetherApp()
    }
}