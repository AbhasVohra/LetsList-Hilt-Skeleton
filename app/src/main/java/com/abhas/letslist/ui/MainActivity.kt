package com.abhas.letslist.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.abhas.letslist.category.model.Category
import com.abhas.letslist.category.viewmodel.CategoryViewModel
import com.abhas.letslist.ui.theme.LetsListTheme
import com.abhas.letslist.ui.theme.Typography
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LetsListTheme {
                // A surface container using the 'background' color from the theme

                CategoriesList()
            }
        }
    }
}

@Composable
fun CategoriesList(categoryViewModel: CategoryViewModel = hiltViewModel()) {
    val list by remember { categoryViewModel.categoriesList }
    LazyColumn {
        items(list) {
            CategoriesScreenItem(category = it)
        }
    }
}

@Composable
fun CategoriesScreenItem(category: Category) {
    var resize = false
    Card(elevation = 4.dp, backgroundColor = MaterialTheme.colors.background) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(12.dp)
        ) {
            AsyncImage(
                model = category.strCategoryThumb,
                contentDescription = "${category.strCategory}",
                modifier = Modifier
                    .size(80.dp)
                    .border(
                        border = BorderStroke(
                            4.dp,
                            Brush.linearGradient(listOf(Color.Magenta, Color.Yellow))
                        ),
                    )
                    .align(CenterVertically),
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp)
            ) {
                Text(
                    text = "${category.strCategory}",
                    style = Typography.h4,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .clickable { resize = !resize },
                )
                Text(
                    text = "${category.strCategoryDescription}",
                    style = Typography.body1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 4
                )
            }
        }
    }
}