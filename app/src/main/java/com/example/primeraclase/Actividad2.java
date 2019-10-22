package com.example.primeraclase;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;

public class Actividad2 extends AppCompatActivity implements Asynchtask {

    private TextView txtSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        txtSaludo = (TextView)findViewById(R.id.lblMensaje);
        txtSaludo.setMovementMethod(new ScrollingMovementMethod());
        txtSaludo.setVisibility(View.INVISIBLE);
        Bundle bundle = this.getIntent().getExtras();
        txtSaludo.setText("Usuario: " + bundle.getString("Usuario")+"  Clave: " + bundle.getString("Clave"));

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService("https://api.androidhive.info/contacts/", datos, Actividad2.this, Actividad2.this);
        //WebService ws = new WebService("http://revistas.uteq.edu.ec/ws/login.php?usr=cristian&pass=cristian", datos, Actividad2.this, Actividad2.this);
        //bundle.getString("Usuario")
        //WebService ws = new WebService("http://revistas.uteq.edu.ec/ws/login.php?usr="+bundle.getString("Usuario")+"&pass="+bundle.getString("Clave")+"", datos, Actividad2.this, Actividad2.this);
        ws.execute("");
    }


    @Override
    public void processFinish(String result) throws JSONException {
        txtSaludo.setText(result);
        Log.i("processFinish",result);
        txtSaludo.setText("Ws".toString());
    }
}
