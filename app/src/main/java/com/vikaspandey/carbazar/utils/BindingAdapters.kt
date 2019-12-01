package com.vikaspandey.carbazar.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.vikaspandey.carbazar.R

@BindingAdapter("app:image_res")
fun setImageUrl(view: ImageView, imageres: String?) {
    if (imageres!!.contains(Constants.FROM_RES_FOLDER)) {
        view.setImageResource(        view.resources!!.getIdentifier(
            imageres.substringAfter(Constants.FROM_RES_FOLDER,"1_1"),"drawable",
            view.context.packageName))
    }
}

@BindingAdapter("app:visibility")
fun setVisibility(view: View, bool: Boolean) {
    view.visibility = if (bool) View.VISIBLE else View.INVISIBLE
}


