package com.pdrarth.calculadoradenotas;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    //Primeiro eu crio um metodo privado, referente a aquele tipo feito no app
    private EditText nota1, nota2, nota3, nota4, numerdefaltas;
    private Button btcalcular;
    private TextView txtresultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //aqui em baixo eu chamo ele usando primeiro (find)-> R.id."id dele"
        nota1 = findViewById(R.id.Nota1);
        nota2 = findViewById(R.id.Nota2);
        nota3 = findViewById(R.id.Nota3);
        nota4 = findViewById(R.id.Nota4);
        numerdefaltas = findViewById(R.id.faltas);
        btcalcular = findViewById(R.id.Calcular);
        txtresultado = findViewById(R.id.txt_Resultado);


        //Fazer o botao "ouvir" cliques, o botao poder ter um evento
        btcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aqui eu chamo o metodo e passo converto ele para int.
                int n1 = Integer.parseInt(nota1.getText().toString());
                int n2 = Integer.parseInt(nota2.getText().toString());
                int n3 = Integer.parseInt(nota3.getText().toString());
                int n4 = Integer.parseInt(nota4.getText().toString());
                int faltas = Integer.parseInt(numerdefaltas.getText().toString());
                int media = n1 + n2 + n3 + n4 / 4;

                if(media>100){
                    //aqui agora eu chamo o metodo resultado e coloco uma cor nele
                    txtresultado.setText("Sua nota nao pode ser superior a 100");
                    txtresultado.setTextColor(getColor(R.color.FireBrick));
                }
                if (faltas > 20 && media <= 30 && media >= 30) {
                    txtresultado.setText("Voce foi reprovado pois tem " + faltas + " \n o maximo eh 20");
                    txtresultado.setTextColor(getColor(R.color.FireBrick));
                } else if (media < 30) {
                    txtresultado.setText("Voce foi reprovado pois tem " + media + "\n pontos e para conseguir final a \n media tem que ser maior do que 30");
                    txtresultado.setTextColor(getColor(R.color.FireBrick));
                } else if (media > 30 && media < 60) {
                    int provafinal = 120 - media;
                    txtresultado.setText("Voce tem direito a final e  \n precisar tirar nela " + provafinal);
                    txtresultado.setTextColor(getColor(R.color.Yellow));
                } else if (media >= 60 && media <= 100) {
                    txtresultado.setText("Voce foi aprovado com a nota  " + media);
                    txtresultado.setTextColor(getColor(R.color.Chartreuse));
                }
            }
        });

    }
}