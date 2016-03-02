package lorena.myapplication4;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by Lorena on 12/12/2015.
 */
public class DialogoFrutas extends DialogFragment{
    static ArrayList<String> froitas=new ArrayList<String>();

    AlertDialog.Builder venta;
   static String[] matriz;
    static boolean[] opcionmarcada;
  static String opcionmostrar="";


    public Dialog onCreateDialog(Bundle SavedInstance ) {

            venta = new AlertDialog.Builder(getActivity());
                venta.setIcon(android.R.drawable.ic_dialog_info);
                venta.setTitle("Escolle unha das seguintes froitas");
                matriz= MainActivity.listarfrutas();
                opcionmarcada=MainActivity.listarbooleans();
            venta.setMultiChoiceItems(matriz, opcionmarcada, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    if (isChecked) {
                        Toast.makeText(getActivity(), "Seleccionaches " + matriz[which], Toast.LENGTH_SHORT).show();


                    } else
                        Toast.makeText(getActivity(), "Deseleccionaches " + matriz[which], Toast.LENGTH_SHORT).show();


                }
            });

        venta.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Premeches 'Aceptar'", 1).show();
                for (int i = 0; i < opcionmarcada.length; i++) {
                    if (opcionmarcada[i]) opcionmostrar = opcionmostrar + matriz[i] + " ";
                    MainActivity.booleanos.set(i, opcionmarcada[i]);

                }
                MainActivity.mostrartexto.setText("  " + opcionmostrar);

               froitas=new ArrayList<String>();
                froitas.add(opcionmostrar);

                dismiss();
            }
        });
        venta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Premeches 'Cancelar'", 1).show();
                opcionmostrar = "";
                MainActivity.mostrartexto.setText(opcionmostrar);

                dismiss();
            }
        });

        return venta.create();
    }
                    }



