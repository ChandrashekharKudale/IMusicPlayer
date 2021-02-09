package com.bg.imusicplayer.data.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions


@BindingAdapter("image")
fun loadLottieAnim(animationView: LottieAnimationView, label: String) {

  //  animationView.setRepeatCount(0)

    animationView.setAnimation("gramophone_two.json")
    animationView.playAnimation()
    animationView.setRepeatCount(LottieDrawable.INFINITE)


}


@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(view.context).load(url).into(view)
    }

}
@BindingAdapter("roundImage")
fun loadRoundedImage(view: ImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(50))
        val requestOptionsCache = RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
        Glide.with(view.context).load(url).apply(requestOptions).apply(requestOptionsCache).into(view)
    }



}







