package ru.dag.gosservice.model

import android.graphics.drawable.Drawable

data class Model (
    var bestPlaces: ArrayList<BestPlaces>,
    var category: ArrayList<Category>
        )

data class BestPlaces(
    var image: Drawable?,
    var title: String,
    var address: String,
    var category: String,
    var likes: Int
)

data class Category(
    var image: Drawable?,
    var name: String,
    var id: Int
)
