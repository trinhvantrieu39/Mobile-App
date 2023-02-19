package com.example.moderartui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private static final String URL = "https://www.moma.org";
    private DialogFragment mDialog;
    private SeekBar mSeekBar;
    SurfaceView box1;
    SurfaceView box2;
    SurfaceView box3;
    SurfaceView box4;
    SurfaceView box5;
    boolean b1 = true;
    boolean b2 = true;
    boolean b3 = true;
    boolean b4 = true;
    boolean b5 = true;
    private int[] box1Color = {137, 104, 205};
    private int[] box2Color = {139, 26, 26};
    private int[] box3Color = {255,255,255};
    private int[] box4Color = {238, 106,167};
    private int[] box5Color = {58, 95, 205};
    private int vSeekBar = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SurfaceView box1 = (SurfaceView) findViewById(R.id.box1);
        final SurfaceView box2 = (SurfaceView) findViewById(R.id.box2);
        final SurfaceView box3 = (SurfaceView) findViewById(R.id.box3);
        final SurfaceView box4 = (SurfaceView) findViewById(R.id.box4);
        final SurfaceView box5 = (SurfaceView) findViewById(R.id.box5);

        mSeekBar = (SeekBar)findViewById(R.id.seekbar);
        mSeekBar.setOnSeekBarChangeListener(this);

        box1.setBackgroundColor(Color.rgb(box1Color[0], box1Color[1], box1Color[2]));
        box2.setBackgroundColor(Color.rgb(box2Color[0], box2Color[1], box2Color[2]));
        box3.setBackgroundColor(Color.rgb(box3Color[0], box3Color[1], box3Color[2]));
        box4.setBackgroundColor(Color.rgb(box4Color[0], box4Color[1], box4Color[2]));
        box5.setBackgroundColor(Color.rgb(box5Color[0], box5Color[1], box5Color[2]));

        box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1 = true;
                b2 = false;
                b3 = false;
                b4 = false;
                b5 = false;
                Toast.makeText(MainActivity.this, "Picked box 1", Toast.LENGTH_SHORT).show();
            }
        });
        box2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1 = false;
                b2 = true;
                b3 = false;
                b4 = false;
                b5 = false;
                Toast.makeText(MainActivity.this, "Picked box 2", Toast.LENGTH_SHORT).show();
            }
        });
        box3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "White screen can not be changed", Toast.LENGTH_SHORT).show();
            }
        });
        box4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1 = false;
                b2 = false;
                b3 = false;
                b4 = true;
                b5 = false;
                Toast.makeText(MainActivity.this, "Picked box 4", Toast.LENGTH_SHORT).show();
            }
        });
        box5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1 = false;
                b2 = false;
                b3 = false;
                b4 = false;
                b5 = true;
                Toast.makeText(MainActivity.this, "Picked box 5", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        box1 = (SurfaceView) findViewById(R.id.box1);
        box2 = (SurfaceView) findViewById(R.id.box2);
        box3 = (SurfaceView) findViewById(R.id.box3);
        box4 = (SurfaceView) findViewById(R.id.box4);
        box5 = (SurfaceView) findViewById(R.id.box5);
        int tmpValue = 1;

        //box1.setBackgroundColor(Color.argb(255, 255-progress, progress, 255-progress));
        if(b1) {
            box1.setBackgroundColor(Color.argb(255, 137 + progress % 255, progress, 205 - progress % 255));
        }
        if(b2) {
            box2.setBackgroundColor(Color.argb(255, 139 + progress % 255, 26 + progress, progress % 255));
        }
        if (b4) {
            box4.setBackgroundColor(Color.argb(255, 238 - progress % 255, 106 + progress % 255, 167 - progress % 255));
        }
        if (b5) {
            box5.setBackgroundColor(Color.argb(255, progress % 255, 95 + progress % 255, 205));
        }


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_more_info) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            //Initialize and format dialog
            //
            TextView dialog_title = new TextView(this);
            dialog_title.setText("Inspired by the works of artists such as \n Piet Mondrian and Ben Nicholson.");
            dialog_title.setGravity(Gravity.CENTER_HORIZONTAL);
            dialog_title.setPadding(10,30,10,30);
            dialog_title.setTextSize(16);

            builder.setCustomTitle(dialog_title);

            String message = "Click below to learn more";

            builder.setMessage(message);

            builder.setPositiveButton("Not Now", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User cancelled the dialog
                }
            });
            builder.setNegativeButton("Visit MOMA", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User clicked Visit MOMA button
                    launchWebpage();
                    Intent momaIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                    startActivity(momaIntent);
                }
            });

            AlertDialog dialog = builder.show();
        }

        if (id == R.id.refresh){
            b1 = true;
            b2 = true;
            b3 = true;
            b4 = true;
            b5 = true;
            Toast.makeText(MainActivity.this, "All boxes back to the beginning", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }

    private void launchWebpage() {
        // launch browser to MOMA home page
        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));

        if (webIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(webIntent);
        }
    }
}