package id.sch.smktelkom_mlg.learn.learninggooglemaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String JUDUL = "judul";
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doIntent1();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doIntent2();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doIntent3();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doIntent4();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doIntent5();
            }
        });
    }

    private void doIntent1() {
        Intent intent = new Intent(this, MapTypeActivity.class);
        String judul = "Map Type";
        intent.putExtra(JUDUL, judul);
        startActivity(intent);
    }

    private void doIntent2() {
        Intent intent = new Intent(this, MovingMapActivity.class);
        String judul = "Moving Map";
        intent.putExtra(JUDUL, judul);
        startActivity(intent);
    }

    private void doIntent3() {
        Intent intent = new Intent(this, PlaceMarkerActivity.class);
        String judul = "Place Markers";
        intent.putExtra(JUDUL, judul);
        startActivity(intent);
    }

    private void doIntent4() {
        Intent intent = new Intent(this, CircleActivity.class);
        String judul = "Circle in Map";
        intent.putExtra(JUDUL, judul);
        startActivity(intent);
    }

    private void doIntent5() {
        Intent intent = new Intent(this, StreetViewActivity.class);
        String judul = "Street View";
        intent.putExtra(JUDUL, judul);
        startActivity(intent);
    }
}
