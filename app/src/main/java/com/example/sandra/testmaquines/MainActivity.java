package com.example.sandra.testmaquines;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.firebase.client.Firebase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Firebase clientRef;
    Firebase ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Firebase.setAndroidContext(getBaseContext());
        ref = new Firebase("https://testgimmapp.firebaseio.com/");
        clientRef = ref.child("Maquines");
        Maquina maquina = new Maquina();
        maquina.setId("001");
        maquina.setNom("Máquina de remo");
        maquina.setDescripcio("Una máquina de remo, que también es conocida como remo de interiores o un ergómetro es una máquina de ejercicio que simula el remar en un bote. " +
                "Las máquinas de remo le dan un entrenamiento a todos los grupos musculares principales, " +
                "proveen un gran ejercicio cardiovascular y utilizan un patrón de bajo impacto que suaviza el movimiento de remo para evitar lesiones. ");
        maquina.setDataInstalacio("02/03/2016");


        ArrayList<Step> steps = new ArrayList();

        Step step1 = new Step();
        step1.setnStep(1);
        step1.setDescripcio("La resistencia, que normalmente se ajusta en una manija de la máquina, determina cuánta energía necesitas emplear en cada repetición. De forma ideal, lo que quieres es ajustar la resistencia lo suficientemente alta para que puedas mantener un movimiento de remo rápido y suave por un periodo de tiempo prolongado. El ajustarlo muy alto puede resultar en una lesión o fatiga muscular. ");
        step1.setFoto("http://pad2.whstatic.com/images/thumb/2/2e/Work-out-Using-a-Rowing-Machine-Step-1.jpg/728px-Work-out-Using-a-Rowing-Machine-Step-1.jpg");
        step1.setAnotacio("Ajusta el nivel de Resistencia de la máquina de remo.");
        steps.add(step1);

        Step step2 = new Step();
        step2.setnStep(2);
        step2.setDescripcio("Para comenzar, coloca tus pies en el apoyo para pies, ajustándolos con las correas. Siéntate en el asiento y agarra la manija usando un apretón con las manos hacia abajo, teniendo cuidado de mantener tus codos cerca de tu cuerpo. ");
        step2.setFoto("http://pad3.whstatic.com/images/thumb/a/a1/Work-out-Using-a-Rowing-Machine-Step-2.jpg/728px-Work-out-Using-a-Rowing-Machine-Step-2.jpg");
        step2.setAnotacio("Acomódate en la máquina de remo.");
        steps.add(step2);

        Step step3 = new Step();
        step3.setnStep(3);
        step3.setDescripcio("La posición inicial de cada repetición se llama la posición de agarre. Extiende tus brazos hacia adelante, manteniéndolos derechos y con un ligero ángulo hacia abajo hacia el eje principal. Inclínate hacia adelante ligeramente y deslízate para adelante en el asiento mientras doblas las rodillas hasta que tus espinillas estén casi verticales. ");
        step3.setFoto("http://pad3.whstatic.com/images/thumb/7/74/Work-out-Using-a-Rowing-Machine-Step-3.jpg/728px-Work-out-Using-a-Rowing-Machine-Step-3.jpg");
        step3.setAnotacio("Colócate en la posición de \"agarre\".");
        steps.add(step3);

        Step step4 = new Step();
        step4.setnStep(4);
        step4.setDescripcio("Comienza a empujar contra las secciones de los pies, usando tus piernas para darle fuerza a la repetición. Mantén tus brazos y espalda rectas mientras extiendes las piernas. Cuando tus piernas estén totalmente extendidas, termina de darle fuerza a la repetición jalando la manija hacia tu abdomen mientras te inclinas ligeramente hacia atrás. ");
        step4.setFoto("http://pad3.whstatic.com/images/thumb/9/9b/Work-out-Using-a-Rowing-Machine-Step-4.jpg/728px-Work-out-Using-a-Rowing-Machine-Step-4.jpg");
        step4.setAnotacio("Ejecuta la posición de \"empuje\".");
        steps.add(step4);

        Step step5 = new Step();
        step5.setnStep(5);
        step5.setDescripcio("Cuando termines de darle fuerza a cada repetición, tus piernas deben estar totalmente extendidas. Debes estar inclinado ligeramente hacia atrás por la cadera. Tus brazos superiores deben estar a tus lados cerca, con los codos doblados y la manija contra tu abdomen.  ");
        step5.setFoto("http://pad2.whstatic.com/images/thumb/0/0d/Work-out-Using-a-Rowing-Machine-Step-5.jpg/728px-Work-out-Using-a-Rowing-Machine-Step-5.jpg");
        step5.setAnotacio("Procede a realizar la posición \"final\".");
        steps.add(step5);

        Step step6 = new Step();
        step6.setnStep(6);
        step6.setDescripcio("Comienza este paso al extender tus brazos hacia adelante mientras regresa hacia la base de la máquina, inclinando la parte superior de tu cuerpo ligeramente hacia adelante en el proceso. Comienza a deslizarte hacia adelante en el asiento mientras doblas las rodillas. Al final de la posición de recuperación, debes regresar a la posición de agarre. Desde esta posición, debes repetir todo el proceso de nuevo, manteniendo un ritmo de movimiento suave durante todas las repeticiones. ");
        step6.setFoto("http://pad1.whstatic.com/images/thumb/7/7d/Work-out-Using-a-Rowing-Machine-Step-6.jpg/728px-Work-out-Using-a-Rowing-Machine-Step-6.jpg");
        step6.setAnotacio("Termina con la posición de \"recuperación\". ");
        steps.add(step6);

        maquina.setSteps(steps);

        Firebase client = clientRef.push();
        client.setValue(maquina);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
