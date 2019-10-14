package com.app.mascotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Mostrador extends AppCompatActivity implements View.OnClickListener{

    TextView tv;
    RadioGroup radio_group;
    RadioButton current_radio;
    Button send_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrador);
        setComponents();
    }

    private void setComponents()
    {

        tv = findViewById(R.id.tv);
        send_button = findViewById(R.id.send_button);
        radio_group = findViewById(R.id.opinion_group);

        String nombre = getIntent().getExtras().getString(MainActivity.EXTRA_NOMBRE);
        tv.setText(nombre);
        send_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent databack = new Intent();
        current_radio = findViewById(radio_group.getCheckedRadioButtonId());

        String opinion = current_radio.getText().toString();
        databack.putExtra("opinion", opinion);
        setResult(RESULT_OK, databack);
        finish();
    }
}
