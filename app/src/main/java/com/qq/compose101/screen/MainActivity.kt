package com.qq.compose101.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qq.compose101.ui.theme.Compose101Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose101Theme {
                ComposeApp101()
            }
        }
    }
}

@Composable
private fun ComposeApp101(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World", "Compose")
) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Greetings()
    }
}

@Composable
fun Greetings(modifier: Modifier = Modifier, names: List<String> = List(1000) { "$it" }) {
    LazyColumn(modifier = modifier.padding(4.dp)) {
        items(names) { name ->
            Greeting(name)
        }
    }
}

@Composable
fun Greeting(name: String) {
    var expanded by remember { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if (expanded) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ), label = ""
    )
    Row(Modifier.padding(24.dp)) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)
        ) {
            Text(
                text = "Hello",
            )
            Text(text = "$name!")
        }
        ElevatedButton(onClick = { expanded = !expanded }) {
            Text(if (expanded) "Show less" else "Show more")
        }
    }


}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    Compose101Theme {
        Greeting("Android")
    }
}

