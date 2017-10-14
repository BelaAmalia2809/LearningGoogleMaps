package id.sch.smktelkom_mlg.learn.learninggooglemaps;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static id.sch.smktelkom_mlg.learn.learninggooglemaps.MainActivity.JUDUL;

public class PlaceMarkerActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition WONOSOBO = CameraPosition.builder()
            .target(new LatLng(-8.360576, 114.279983))
            .zoom(14)
            .bearing(0)
            .tilt(45)
            .build();
    GoogleMap m_map;
    boolean mapReady = false;
    MarkerOptions house;
    MarkerOptions masjid;
    MarkerOptions sd;
    MarkerOptions danau;
    MarkerOptions barokah;
    MarkerOptions pasar;
    MarkerOptions fahmi;

    @Override
    public Resources getResources() {
        return super.getResources();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_marker);

        Intent intent = getIntent();
        String judul = intent.getStringExtra(JUDUL);
        setTitle(judul);

        house = new MarkerOptions()
                .position(new LatLng(-8.363635, 114.271607))
                .title("Rumah Bela")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        masjid = new MarkerOptions()
                .position(new LatLng(-8.362937, 114.270640))
                .title("Masjid Jami' Al Huda")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        sd = new MarkerOptions()
                .position(new LatLng(-8.361400, 114.271129))
                .title("SDN 2 Wonosobo")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        danau = new MarkerOptions()
                .position(new LatLng(-8.364331, 114.275382))
                .title("Danau Galian")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        barokah = new MarkerOptions()
                .position(new LatLng(-8.361963, 114.268565))
                .title("Toko Barokah")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        pasar = new MarkerOptions()
                .position(new LatLng(-8.371811, 114.284501))
                .title("Pasar Wonosobo")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        fahmi = new MarkerOptions()
                .position(new LatLng(-8.360307, 114.277989))
                .title("Toko Fahmi")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        //MapsInitializer.initialize(getApplicationContext());
        mapReady = true;
        m_map = map;
        m_map.addMarker(house);
        m_map.addMarker(masjid);
        m_map.addMarker(sd);
        m_map.addMarker(danau);
        m_map.addMarker(barokah);
        m_map.addMarker(pasar);
        m_map.addMarker(fahmi);
        flyTo(WONOSOBO);
    }

    private void flyTo(CameraPosition target) {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
