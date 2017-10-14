package id.sch.smktelkom_mlg.learn.learninggooglemaps;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

import static id.sch.smktelkom_mlg.learn.learninggooglemaps.MainActivity.JUDUL;

public class CircleActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition WONOSOBO = CameraPosition.builder()
            .target(new LatLng(-8.360720, 114.274881))
            .zoom(15)
            .bearing(0)
            .tilt(45)
            .build();
    LatLng varloc = new LatLng(-8.363931, 114.271311);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        Intent intent = getIntent();
        String judul = intent.getStringExtra(JUDUL);
        setTitle(judul);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.moveCamera(CameraUpdateFactory.newCameraPosition(WONOSOBO));
        map.addCircle(new CircleOptions()
                .center(varloc)
                .radius(200)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(64, 0, 255, 0)));

    }
}
