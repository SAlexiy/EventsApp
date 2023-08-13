package com.team4event.eventsapp.ui.fragments.map

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.team4event.eventsapp.MainApplication.Companion.appContext
import com.team4event.eventsapp.R
import ru.dgis.sdk.DGis
import ru.dgis.sdk.coordinates.GeoPoint
import ru.dgis.sdk.geometry.Elevation
import ru.dgis.sdk.geometry.GeoPointWithElevation
import ru.dgis.sdk.map.CameraPosition
import ru.dgis.sdk.map.MapObjectManager
import ru.dgis.sdk.map.MapView
import ru.dgis.sdk.map.Marker
import ru.dgis.sdk.map.MarkerOptions
import ru.dgis.sdk.map.MyLocationDirectionBehaviour
import ru.dgis.sdk.map.MyLocationMapObjectSource
import ru.dgis.sdk.map.Zoom
import ru.dgis.sdk.map.createSmoothMyLocationController
import ru.dgis.sdk.map.imageFromResource

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

            val camera = map.camera
            camera.position = CameraPosition(
                point = GeoPoint(56.826621, 60.612521),
                zoom = Zoom(14f)
            )
            val mapObjectManager = MapObjectManager(map)

            val icon = imageFromResource(sdkContext, R.drawable.baseline_fmd_good_24)


            val marker = Marker(
                MarkerOptions(
                    position = GeoPointWithElevation(
                        latitude = 56.826621,
                        longitude = 60.612521
                    ),
                    icon = icon,
                    text = "Хакатон"
                )
            )

            mapObjectManager.addObject(marker)


            val source = MyLocationMapObjectSource(
                sdkContext,
                MyLocationDirectionBehaviour.FOLLOW_SATELLITE_HEADING,
                createSmoothMyLocationController()
            )
            map.addSource(source)
        }

    }



}