package com.app.mascotas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public final static String EXTRA_NOMBRE = "com.app.mascotas";
    public final static int OPINION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setComponents();
    }

    private void setComponents() {
        Button show_pet_button = findViewById(R.id.show_pet_button);
        TextView page_link = findViewById(R.id.page_link);

        show_pet_button.setOnClickListener(this);
        page_link.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.show_pet_button:
                Intent intent = new Intent(this, Mostrador.class);
                intent.putExtra(EXTRA_NOMBRE, "doggo.jpg");

                startActivityForResult(intent, OPINION_REQUEST_CODE);
                break;
            case R.id.page_link:
                Uri webpage = Uri.parse("http://cursos.javanianos.com");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

                PackageManager packageManager = getPackageManager();
                List activities = packageManager.queryIntentActivities(webIntent, 0);

                if(activities.size() > 0)
                    startActivity(webIntent);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView opinion_text = findViewById(R.id.opinion_text);

        if(requestCode == OPINION_REQUEST_CODE)
            if(resultCode == RESULT_OK)
                opinion_text.setText(data.getStringExtra("opinion"));
    }
}