package com.example.placebook.adapter

import android.app.Activity
import android.view.View
import com.example.placebook.databinding.ContentBookmarkInfoBinding
import com.example.placebook.ui.MapsActivity
import com.example.placebook.viewmodel.MapsViewModel
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
//import com.example.placebook.databinding.ContentBookmarkInfoBinding
// 2
class BookmarkInfoWindowAdapter(val context: Activity) :
    GoogleMap.InfoWindowAdapter {
    // 3
    private val binding =
        ContentBookmarkInfoBinding.inflate(context.layoutInflater)
    // 4
    override fun getInfoWindow(marker: Marker): View? {
// This function is required, but can return null if
// not replacing the entire info window
        return null
    }
    // 5
    override fun getInfoContents(marker: Marker): View? {
        binding.title.text = marker.title ?: ""
        binding.phone.text = marker.snippet ?: ""
        val imageView = binding.photo
        when (marker.tag) {
// 1
            is MapsActivity.PlaceInfo -> {
                imageView.setImageBitmap(
                    (marker.tag as MapsActivity.PlaceInfo).image)
            }
// 2
            is MapsViewModel.BookmarkView -> {
                val bookMarkview = marker.tag as
                        MapsViewModel.BookmarkView
                imageView.setImageBitmap(bookMarkview.getImage(context))
            }
        }
        return binding.root
    }
}