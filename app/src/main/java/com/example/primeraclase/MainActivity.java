package com.example.primeraclase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btEnviar (View view){

        TextView txtNombre;
        txtNombre = (TextView) findViewById(R.id.txtUse);
        String Usuario = txtNombre.getText().toString();

        TextView txtClave;
        txtClave = (TextView) findViewById(R.id.txtClave);
        String Clave = txtClave.getText().toString();

        //mostrar mensaje
        //Toast.makeText(this.getApplicationContext(),Usuario+ " "+Clave, Toast.LENGTH_LONG).show();

        Intent intent = new Intent(MainActivity.this, Actividad3.class);
        Bundle b = new Bundle();
        b.putString("Usuario", Usuario); b.putString("Clave", Clave);
        intent.putExtras(b);
        startActivity(intent);
    }
}
