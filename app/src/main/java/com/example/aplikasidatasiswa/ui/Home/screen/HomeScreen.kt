package com.example.aplikasidatasiswa.ui.Home.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aplikasidatasiswa.PenyediaViewModel
import com.example.aplikasidatasiswa.TopAppBarKontak
import com.example.aplikasidatasiswa.navigasi.DestinasiNavigasi
import com.example.aplikasidatasiswa.ui.Home.ViewModel.HomeViewModel
import com.example.aplikasidatasiswa.ui.Home.ViewModel.KontakUIState

object DestinasiHome : DestinasiNavigasi {
    override val route = "home"
    override val titleRes = "Kontak"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToItemEntry: () -> Unit,
    modifier: Modifier = Modifier,
    onDetailClick: (Int) -> Unit = {},
    viewModel: HomeViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBarKontak(
                title = DestinasiHome.titleRes,
                canNavigateBack = false,
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToItemEntry,
                shape = MaterialTheme.shapes.medium,
                modifier = modifier.padding(18.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Kontak"
                )
            }
        },
    ) {innerpadding ->

        HomeStatus(
            kontakUIState = viewModel.kontakUIState,
            retryAction = {
                viewModel.getKontak()
            },
            modifier =  Modifier.padding(innerpadding),

            onDetailClick = onDetailClick,
            onDeleteClick = {
                viewModel.deleteKontak(it.id)
                viewModel.getKontak()
            }
        )
    }
}