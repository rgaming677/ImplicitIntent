package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnDialpad, btnContact, btnCamera, btnGalery, btnBrowser;
    EditText etHp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDialpad = findViewById(R.id.btnDialpat);
        btnContact = findViewById(R.id.btnContact);
        btnCamera = findViewById(R.id.btnCamera);
        btnGalery = findViewById(R.id.btnGalery);
        btnBrowser = findViewById(R.id.btnBrowser);
        etHp = findViewById(R.id.etHp);

        btnDialpad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etHp.getText().toString().isEmpty()) {
                    Intent a = new Intent();
                    a.setAction(Intent.ACTION_DIAL);
                    startActivity(a);
                } else {
                    Intent b = new Intent();
                    b.setAction(Intent.ACTION_DIAL);
                    b.setData(Uri.parse("tel:" + etHp.getText()));
                    startActivity(b);
                }
            }
        });
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent();
                c.setAction(Intent.ACTION_VIEW);
                c.setData(Uri.parse("content://contacts/people/"));
                startActivity(c);
            }
        });
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent();
                d.setAction(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
                startActivity(d);
            }
        });
        btnGalery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent();
                e.setAction(Intent.ACTION_VIEW);
                e.setData(Uri.parse("content://media/external/image/media/"));
                startActivity(e);
            }
        });
        btnBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent f = new Intent();
                f.setAction(Intent.ACTION_VIEW);
                f.setData(Uri.parse("https://amikom.ac.id/"));
                startActivity(Intent.createChooser(f, "title"));
            }
        });
    }
}