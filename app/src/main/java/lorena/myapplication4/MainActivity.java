package lorena.myapplication4;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    Button btnfrutas;
    static TextView mostrartexto;
    static ArrayList<String> frutas = new ArrayList<String>();
    private DialogoFrutas dialogofrutas;
    static ArrayList<Boolean> booleanos = new ArrayList<Boolean>();
    static String[] matriz;
    static boolean[] opcionmarcada;
    Button btnspinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mostrartexto = (TextView) findViewById(R.id.mostrarfrutas);
        btnfrutas = (Button) findViewById(R.id.btnfrutas);
        dialogofrutas = new DialogoFrutas();
        engadirelementos();
        engadirbooleanos();
        btnspinner=(Button)findViewById(R.id.btnspin);
        btnspinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,SpinFrutas.class);
                startActivity(i);
            }
        });

        btnfrutas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                dialogofrutas.show(fm, "Lista Frutas");
            }
        });
    }

    public void engadirelementos() {
        frutas.add("platano");
        frutas.add("manzanas");
        frutas.add("pera");
        frutas.add("naranxas");
        frutas.add("uvas");
    }

    public void engadirbooleanos() {
        booleanos.add(false);
        booleanos.add(true);
        booleanos.add(true);
        booleanos.add(false);
        booleanos.add(false);
    }

    public static String[] listarfrutas() {
        matriz = new String[frutas.size()];
        for (int i = 0; i < frutas.size(); i++) {
            String listafrutas = frutas.get(i);
            matriz[i] = listafrutas;
        }
        return matriz;
    }

    public static boolean[] listarbooleans() {
        opcionmarcada = new boolean[frutas.size()];
        for (int i = 0; i < booleanos.size(); i++) {
            boolean listbooleanos = booleanos.get(i);
            opcionmarcada[i] = listbooleanos;
        }
        return opcionmarcada;
    }
}





