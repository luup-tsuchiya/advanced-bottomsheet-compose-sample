package com.example.advanced_bottomsheet_compose_sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.advanced_bottomsheet_compose_sample.ui.theme.AdvancedbottomsheetcomposesampleTheme
import io.morfly.compose.bottomsheet.material3.BottomSheetScaffold
import io.morfly.compose.bottomsheet.material3.rememberBottomSheetScaffoldState
import io.morfly.compose.bottomsheet.material3.rememberBottomSheetState

class MainActivity : ComponentActivity() {

    enum class SheetValue {
        Collapsed,
        PartiallyExpanded,
        Expanded,
    }

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AdvancedbottomsheetcomposesampleTheme {

                val sheetState = rememberBottomSheetState(
                    initialValue = SheetValue.PartiallyExpanded,
                    defineValues = {
                        SheetValue.Collapsed at height(100.dp)
                        SheetValue.PartiallyExpanded at offset(percent = 60)
                        SheetValue.Expanded at contentHeight
                    },
                )

                val scaffoldState = rememberBottomSheetScaffoldState(sheetState)

                BottomSheetScaffold(
                    scaffoldState = scaffoldState,
                    sheetContent = {
                        Box(modifier = Modifier.fillMaxSize())
                    },
                    sheetContainerColor = Color.White,
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center,
                    ) {
                        Greeting("Android", Modifier.padding(16.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AdvancedbottomsheetcomposesampleTheme {
        Greeting("Android")
    }
}
