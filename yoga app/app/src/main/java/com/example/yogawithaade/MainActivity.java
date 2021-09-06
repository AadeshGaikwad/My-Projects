package com.example.yogawithaade;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide(); //Hide action bar


        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button1 = findViewById(R.id.startyoga1);
        button2 = findViewById(R.id.startyoga2);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SecondActivity2.class);
                startActivity(intent);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.id_privacy){

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://aadeshgaikwad27.blogspot.com/2021/08/yoga-app-privacy-policy.html"));
            startActivity(intent);

            return true;
        }

        if(id == R.id.id_term){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://aadeshgaikwad27.blogspot.com/2021/08/yoga-app-terms-and-conditions.html"));
            startActivity(intent);

            return true;
        }
        if(id == R.id.rate){

            try{

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
            }
            catch (Exception ex){
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://plau.google.com/store/apps/details?id=" + getPackageName())));
            }

            return true;
        }
        if(id == R.id.more){

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/dev?id=6728209054982313870"));
            startActivity(intent);

            return true;
        }
        if(id == R.id.share){

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String sharebody = "This is best Yoga app \n Download it for free now \n" + "https://plau.google.com/store/apps/details?id=com.example.yogawithaade&hl=en";
            String sharehub = "Yoga App";
            intent.putExtra(Intent.EXTRA_SUBJECT, sharehub);
            intent.putExtra(Intent.EXTRA_TEXT, sharebody);
            startActivity(Intent.createChooser(intent, "share using"));

            return true;
        }
        return true;
    }

    public void beforeage18(View view) {

        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);


    }

    public void afterage18(View view) {

        Intent intent = new Intent(MainActivity.this, SecondActivity2.class);
        startActivity(intent);

    }

    public void food(View view) {
        Intent intent = new Intent(MainActivity.this,FoodActivity.class);
        startActivity(intent);



    }
}