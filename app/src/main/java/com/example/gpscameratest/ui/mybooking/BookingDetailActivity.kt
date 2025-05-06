package com.example.gpscameratest.ui.mybooking

import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.doOnLayout
import com.example.gpscameratest.R
import com.example.gpscameratest.databinding.ActivityBookingDetailBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.moneytracker.moneymanager.moneywallet.activity.base.BaseActivity

class BookingDetailActivity : BaseActivity<ActivityBookingDetailBinding>(), OnMapReadyCallback {

    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap

    private val MAPVIEW_BUNDLE_KEY = "MapViewBundleKey"

    override fun getViewBinding(): ActivityBookingDetailBinding {
        return ActivityBookingDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var mapViewBundle: Bundle? = null
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY)
        }

        mapView = findViewById(R.id.mapView)
        mapView.onCreate(mapViewBundle)
        mapView.getMapAsync(this)
    }

    override fun setupViews() {
        super.setupViews()

        val code = "06158310-5427-471d-af1f-bd9029b"

        binding.qrImageView.doOnLayout {
            val width = it.width
            val height = it.height

            try {
                val barcodeEncoder = BarcodeEncoder()
                val bitmap: Bitmap =
                    barcodeEncoder.encodeBitmap(code, BarcodeFormat.CODE_128, width, height)
                binding.qrImageView.setImageBitmap(bitmap)
            } catch (e: WriterException) {
                e.printStackTrace()
            }
        }

    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map

        // Set marker location (e.g., Hanoi)
        val location = LatLng(21.0278, 105.8342)
        googleMap.addMarker(MarkerOptions().position(location).title("Địa điểm của bạn"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 14f))
    }

    // Lifecycle methods for managing MapView's lifecycle
    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()
    }

    override fun onPause() {
        binding.mapView.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        binding.mapView.onDestroy()
        super.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // Save MapView state
        val mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY) ?: Bundle()
        outState.putBundle(MAPVIEW_BUNDLE_KEY, mapViewBundle)
        binding.mapView.onSaveInstanceState(mapViewBundle)
    }
}
