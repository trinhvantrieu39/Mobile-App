package com.example.dailyselfie;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 37;
    public static final int DELETE_CODE = 9;
    public static final int RESULT_DELETE_CODE = 9;
    private List<Image> imageList = new ArrayList<Image>();
    private List<String> NameList;
    private ImageView hinh;
    private ListView listview;
    private ListViewAdapter listViewAdapter;
    private ImageSaver imagesaver;
    private String FILE_NAME = "Name.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //ImageView logo = (ImageView) findViewById(R.id.logo);
        hinh = (ImageView) findViewById(R.id.imageView);
        ImageButton btCam = (ImageButton) findViewById(R.id.btCamera);
        listview = findViewById(R.id.listview);

        imageList = new ArrayList<Image>();
        imagesaver = new ImageSaver(MainActivity.this);
        NameList  = new ArrayList<String>();

        Start();

        btCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCamera();

            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Image image = (Image) listViewAdapter.getItem(i);
                OpenImage(image);
                System.out.println("gia tri i: "+i);

            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        AlarmNotification();
        //Saving();
    }


    protected void AlarmNotification(){
        Intent resultIntent = new Intent(this, ReminderBroadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, resultIntent, 0);
    //
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        long timeAtButtonClick = System.currentTimeMillis();
        long timeAlarm = 1000 * 10;
        alarmManager.set(AlarmManager.RTC_WAKEUP,timeAtButtonClick + timeAlarm, pendingIntent);
    }

    private void onCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Intent chooser = Intent.createChooser(takePictureIntent, "Chọn App để gọi");
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(chooser, REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK){

            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");

            //format name of image
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String nameImage = sdf.format(new Date());


            NameList.add(nameImage);
            imageList.add(new Image(bitmap, nameImage));

            //luu ten image vua chup
            saveName(nameImage);

            // luu hinh anh vua chup
            ToSave(nameImage, bitmap);



            //listview.invalidate();
            //listViewAdapter.notifyDataSetChanged();
            setListView();
        }

        if(requestCode == DELETE_CODE && resultCode == Activity.RESULT_OK){
            if(data == null){
                return;
            }
            String s = data.getStringExtra("deleteID");

            Delete(s);
        }
    }

    protected void Delete(String name){
        //remove item in list
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            imageList.removeIf(n -> (n.getName().equals(name)));
        }
        //imageList.remove(imageList.);
        // delete file
        new ImageSaver(this).deleteFile();

        //remove name
        NameList.remove(name);
        //delete file name
        deleteFile(FILE_NAME);

        //save file again
        for (int j=0 ; j<imageList.size(); j++){
            ToSave(imageList.get(j).getName(),imageList.get(j).getBitmap());
        }
        //save name again
        for(int j = 0;j < NameList.size(); j++){
            saveName(NameList.get(j));
        }

        listViewAdapter.notifyDataSetChanged();

    }
    protected void Start(){
        loadName();

        if (NameList.size() > 0){
//            imageList = new ArrayList<Image>();
            for(int i=0; i< NameList.size(); i++){
                Bitmap bitmap = ToLoad(NameList.get(i));
                String name = NameList.get(i);

                Image image = new Image(bitmap, name);
                imageList.add(image);
            }
            setListView();
        }

    }

    protected void ToSave(String name, Bitmap bitmap){
        new ImageSaver(this).
                setFileName(name).save(bitmap);
    }
//    protected void Saving(){
//        for (int i= 0;i < imageList.size();i++){
//            ToSave(imageList.get(i).getName(), imageList.get(i).getBitmap());
//
//        }
//        saveName();
//    }
    protected Bitmap ToLoad(String name){
        Bitmap bitmap = new ImageSaver(this).
                setFileName(name).
                load();
        return bitmap;
    }

//    protected void ToDelete(){

//
//
//    }

    protected void setListView(){

        listViewAdapter = new ListViewAdapter(this,imageList);
        listview.setAdapter(listViewAdapter);
    }

    private void saveName(String name) {

        FileOutputStream outputStream = null;
        try {
            outputStream = openFileOutput(FILE_NAME, Context.MODE_APPEND);

            String content = name+ "\n";
            outputStream.write(content.getBytes());

            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadName() {

        try {
            if (NameList.size() != 0){
                NameList.removeAll(NameList);
                NameList = new ArrayList<String>();
            }

            FileInputStream in = this.openFileInput(FILE_NAME);
            //FileInputStream in = new FileInputStream(FILE_NAME);

            BufferedReader br= new BufferedReader(new InputStreamReader(in));

            StringBuffer buffer = new StringBuffer();
            String line = null;


            while((line= br.readLine())!= null)  {
                NameList.add(line);
            }


        } catch (Exception e) {
            //Toast.makeText(this,"Error:"+ e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
    //delete file Name



    protected void OpenImage(Image image){
        Intent intent = new Intent(this, ImageShow.class);
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        image.getBitmap().compress(Bitmap.CompressFormat.PNG, 100, bs);
        intent.putExtra("byteArray", bs.toByteArray());
        intent.putExtra("name", image.getName());

        //startActivity(intent);
        startActivityForResult(intent, DELETE_CODE);
    }

}