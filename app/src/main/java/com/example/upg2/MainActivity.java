package com.example.upg2;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    Button btn;


    Button btn_d;

    FloatingActionButton fl;

    TextView number1,number2,operateur,solution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn_open_activity);


        btn_d = findViewById(R.id.btn_chois);
        fl = findViewById(R.id.floatingActionButton);

        number1 = findViewById(R.id.textView_premier_entre);
        number2 = findViewById(R.id.textView_dexiem_nombre);
        operateur = findViewById(R.id.textView_operateur);
        solution = findViewById(R.id.textView_solution);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent openSecond = new Intent(MainActivity.this, SecondActivity.class);
//                String message = text.getText().toString();
//                openSecond.putExtra("EXTRA_MESSAGE", message);
//                startActivity(openSecond);

                Toast.makeText(MainActivity.this,
                        "you clicked",
                        Toast.LENGTH_SHORT).show();



            }
        });


        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent openSecond = new Intent(MainActivity.this, SecondActivity.class);


                startActivity(openSecond);

            }
        });

        btn_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Toast.makeText(MainActivity.this, "open", Toast.LENGTH_SHORT).show();
                openDialog();
            }
        });

//        vide tout les champ
        tbnc();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

//    function to create an alert dialog
    void openDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("voulez navigue ???");
        builder.setMessage("Allez sur la page Suivante ?");
        builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });
        builder.create().show();
    }


//    function to put an listen on click action to the button
    public void caluculatrice(View view) {

        switch (view.getId()){
            case R.id.btn_1:
                entreNumber(1);

                break;

            case R.id.btn_2:
                entreNumber(2);
                break;

            case R.id.btn_3:
                entreNumber(3);
                break;

            case R.id.btn_4:
                entreNumber(4);

                break;
            case R.id.btn_5:
                entreNumber(5);

                break;

            case R.id.btn_6:
                entreNumber(6);

                break;
            case R.id.btn_7:
                entreNumber(7);

                break;

            case R.id.btn_8:
                entreNumber(8);

                break;
            case R.id.btn_9:
                entreNumber(9);

                break;

            case R.id.btn_zero:
                entreNumber(0);

                break;


            case R.id.btn_soustraction:
                setOperateur("-");

                break;

            case R.id.btn_plus:
                setOperateur("+");

                break;

            case R.id.btn_c:
                tbnc();
                break;

            case R.id.btn_part:

                break;

            case R.id.btn_prcent:

                break;

            case R.id.btn_produit:
                setOperateur("*");

                break;

            case R.id.btn_div:
                setOperateur("/");

                break;

            case R.id.btn_egal:
                solution();


                break;

            case R.id.btn_symbol:

                break;

            case R.id.btn_virgule:

                if (operateur.getText().toString()!="" && number1.getText().toString()!=""){
                    number2.setText(number2.getText().toString()+".");
                }else{
                    number1.setText(number1.getText().toString()+".");
                }

                break;

        }

    }

    public void tbnc(){
        number1.setText("");
        number2.setText("");
        operateur.setText("");
        solution.setText("");
    }

    public void entreNumber(int nombre){

        if (operateur.getText().toString()!="" && number1.getText().toString()!=""){
            number2.setText(number2.getText().toString()+nombre);
        }else{
            number1.setText(number1.getText().toString()+nombre);
        }
    }

    public void setOperateur(String oper){
        operateur.setText("");
        operateur.setText(oper);

    }

    public void solution(){
        int nub1 = Integer.valueOf((String) number1.getText());
        int nub2 = Integer.valueOf((String) number2.getText());
        String op = operateur.getText().toString().trim();

        switch (op){
            case "/":
                float sol = nub1 / nub2;
                solution.setText(String.valueOf(sol));
                break;
            case "*":
                float sol1 = nub1 * nub2;
                solution.setText(String.valueOf(sol1));
                break;
            case "+":
                float sol2 = nub1 + nub2;
                solution.setText(String.valueOf(sol2));
                break;
            case "-":
                float sol3 = nub1 - nub2;
                solution.setText(String.valueOf(sol3));
                break;
            default:

                break;
        }


    }





}