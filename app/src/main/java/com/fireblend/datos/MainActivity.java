package com.fireblend.datos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.nombre)
    EditText nombre;
    @BindView(R.id.correo)
    EditText correo;
    @BindView(R.id.edad)
    SeekBar edad;
    @BindView(R.id.textoEdad)
    TextView textoEdad;
    @BindView(R.id.rbEl)
    RadioButton radioButtonEl;
    @BindView(R.id.rbElla)
    RadioButton radioButtonElla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setup();
    }

    private void setup(){
        edad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textoEdad.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }


    @OnClick(R.id.botonMostrar)
    public void mostrar(){
        //Recuperar los valores de nombre, edad y correo

        //Crear un intent para abrir la pantalla de detalles

        //Agregarle al intent los valores recuperados

        //Llamar a startActivity() con ese intent
        boolean paso=true;
        if(nombre.getText().length()<=0){
            Toast toast =
            Toast.makeText(MainActivity.this, "Digite un Nombre",
                    Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP|Gravity.LEFT,0,0);
            toast.show();
            paso=false;
            return;
        }
        if(correo.getText().length()<=0){
            Toast toast =
                    Toast.makeText(MainActivity.this, "Digite un Correo",
                            Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP|Gravity.LEFT,0,0);
            toast.show();
            paso=false;
            return;
        }
        if(edad.getProgress()<=0){
            Toast toast =
                    Toast.makeText(MainActivity.this, "Escoja la edad",
                            Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP|Gravity.LEFT,0,0);
            toast.show();
            paso=false;
            return;
        }
        String pronombre="";
        if (radioButtonEl.isChecked()==false && radioButtonElla.isChecked()==false){
            Toast toast =
                    Toast.makeText(MainActivity.this, "Escoja Pronombre",
                            Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP|Gravity.LEFT,0,0);
            toast.show();
            paso=false;
            return;

        }
        if (radioButtonEl.isChecked()==true) {
            //Es Hombre
            pronombre="El";
        } else
        if (radioButtonElla.isChecked()==true) {
            //Es Mujer
            pronombre="Ella";
        }
        if(paso) {
            Intent intent = new Intent(MainActivity.this, SegundoActivity.class);
            intent.putExtra("nombre",nombre.getText().toString());
            intent.putExtra("edad",edad.getProgress());
            intent.putExtra("correo",correo.getText().toString());
            intent.putExtra("pronombre",pronombre);
            startActivity(intent);
        }
    }


}
