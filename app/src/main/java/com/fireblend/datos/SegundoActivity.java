package com.fireblend.datos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SegundoActivity extends AppCompatActivity {

    @BindView(R.id.nombre)
    TextView nombre;
    @BindView(R.id.correo)
    TextView correo;
    @BindView(R.id.edad)
    TextView edad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        ButterKnife.bind(this);

        Intent intent=getIntent();
        nombre.setText(intent.getStringExtra("nombre"));
        correo.setText(intent.getStringExtra("correo"));
        Integer intEdad=intent.getIntExtra("edad",0);
        edad.setText(Integer.toString(intEdad));
    }

    @OnClick(R.id.botonAtras)
    public void mostrar(){

        Intent intent=new Intent(SegundoActivity.this,MainActivity.class);
        startActivity(intent);
    }



}
