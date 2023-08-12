package com.team4event.eventsapp.ui.screens.map

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.team4event.eventsapp.MainApplication.Companion.appContext
import com.team4event.eventsapp.R
import ru.dgis.sdk.DGis
import ru.dgis.sdk.coordinates.GeoPoint
import ru.dgis.sdk.map.CameraPosition
import ru.dgis.sdk.map.MapOptions
import ru.dgis.sdk.map.MapView
import ru.dgis.sdk.map.Zoom

class MapFragment : Fragment() {

    companion object {
        fun newInstance() = MapFragment()
    }

    private lateinit var viewModel: MapViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sdkContext = DGis.initialize(appContext = appContext)

        val mapView = view.findViewById<MapView>(R.id.mapView)!!
        lifecycle.addObserver(mapView)

        mapView.mapOptions

        mapView.getMapAsync { map ->
            // Действия с картой

            val camera = map.camera
            camera.position = CameraPosition(
                point = GeoPoint(56.826621, 60.612521),
                zoom = Zoom(14f)
            )
        }

    }



}