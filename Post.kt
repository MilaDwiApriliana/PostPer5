package com.mila141.posttestpemrogrammobile5.model

import android.net.Uri

data class Post(
    val username: String,
    val caption: String,
    val imageUri: Uri? = null,
    val imageResId: Int? = null
)
