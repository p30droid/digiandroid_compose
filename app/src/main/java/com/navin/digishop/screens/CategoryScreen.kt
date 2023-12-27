package com.navin.digishop.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.navin.digishop.viewModel.CategoryViewModel


@Composable
fun CategoryScreen(navController: NavController , viewModel: CategoryViewModel = hiltViewModel()) {
    Column {


        val categoryViewModel = viewModel.categories.value.data


        if(viewModel.categories.value.loading==true) {

            CircularProgressIndicator()
        }
        else {


            LazyColumn() {
                items(items = categoryViewModel!!.categories) {

                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)) {
                        AsyncImage(model = "${it.icon}", contentDescription = null)
                        Text(text = "${it.title}")
                    }

                }
            }


        }


    }
}