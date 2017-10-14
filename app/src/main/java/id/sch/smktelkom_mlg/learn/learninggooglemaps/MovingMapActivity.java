package id.sch.smktelkom_mlg.learn.learninggooglemaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import static id.sch.smktelkom_mlg.learn.learninggooglemaps.MainActivity.JUDUL;

public class MovingMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition WATUGONG = CameraPosition.builder()
            .target(new LatLng(-8.363501, 114.287522))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition GLADAG = CameraPosition.builder()
            .target(new LatLng(-8.333941, 114.283923))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition SRONO = CameraPosition.builder()
            .target(new LatLng(-8.401844, 114.263802))
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();
    GoogleMap m_map;
    boolean mapReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moving_map);

        Intent intent = getIntent();
        String judul = intent.getStringExtra(JUDUL);
        setTitle(judul);

        Button btnWatugong = (Button) findViewById(R.id.btnWatugong);
        btnWatugong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(WATUGONG);
            }
        });

        Button btnGladag = (Button) findViewById(R.id.btnGladag);
        btnGladag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(GLADAG);
            }
        });

        Button btnSrono = (Button) findViewById(R.id.btnSrono);
        btnSrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(SRONO);
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void flyTo(CameraPosition target) {
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        m_map = map;
        m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        flyTo(WATUGONG);
    }
}
