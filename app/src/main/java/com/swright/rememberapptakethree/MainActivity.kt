package com.swright.rememberapptakethree

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.swright.rememberapptakethree.ui.theme.RememberTakeThreeAppTheme
import com.swright.rememberapptakethree.viewmodels.RememberViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RememberTakeThreeAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    RememberApp()
                }
            }
        }
    }
}