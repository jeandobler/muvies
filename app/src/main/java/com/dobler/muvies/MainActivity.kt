package com.dobler.muvies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.dobler.designsystem.theme.MuviesTheme
import com.dobler.designsystem.ui.MyBottomBarWithTwoItems
import com.dobler.domain.Navigation
import com.dobler.mylist.MyList
import com.dobler.search.Search


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var navigation by rememberSaveable { mutableStateOf(Navigation.SEARCH) }

            MuviesTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { MyBottomBarWithTwoItems { navigation = it } }
                ) { innerPadding ->
                    when (navigation) {

                        Navigation.SEARCH -> Search(
                            name = "Buscar seu filme favorito",
                            modifier = Modifier.padding(innerPadding)
                        )

                        Navigation.MYLIST -> MyList(
                            name = "Minha Lista",
                            modifier = Modifier.padding(innerPadding)
                        )


                    }
                }
            }
        }
    }

}

