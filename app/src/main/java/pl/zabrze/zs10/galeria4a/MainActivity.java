package pl.zabrze.zs10.galeria4a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RatingBar ratingBarSrednia;
    RatingBar ratingBarUzytkownika;
    ImageView imageView;
    Button buttonWstecz;
    Button buttonDalej;
    Button buttonOcen;
    TextView textViewOpis;
    ArrayList<Obraz> obrazy;
    int aktualnyIndeksObrazu = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBarSrednia = findViewById(R.id.ratingBar);
        ratingBarUzytkownika = findViewById(R.id.ratingBar2);
        imageView = findViewById(R.id.imageView);
        buttonWstecz = findViewById(R.id.button);
        buttonDalej = findViewById(R.id.button2);
        buttonOcen = findViewById(R.id.button3);
        textViewOpis = findViewById(R.id.textView);
        obrazy = new ArrayList<>();
        obrazy.add(new Obraz(R.drawable.k2,"Szczyt K2"));
        obrazy.add(new Obraz(R.drawable.anna, "Szczyt Anna Purna"));
        obrazy.add(new Obraz(R.drawable.mont, "Szczy Mont Everest"));
        buttonDalej.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ratingBarUzytkownika.setRating(0);
                        aktualnyIndeksObrazu++;
                        if(aktualnyIndeksObrazu == obrazy.size()){
                            aktualnyIndeksObrazu = 0;
                        }
                        wyswietlObraz(aktualnyIndeksObrazu);
                    }
                }
        );
        buttonOcen.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        float ocena = ratingBarUzytkownika.getRating();
                        obrazy.get(aktualnyIndeksObrazu).ocen(ocena);
                        wyswietlObraz(aktualnyIndeksObrazu);
                        ratingBarUzytkownika.setRating(0);
                    }
                }
        );

    }

    private void wyswietlObraz(int x){
        imageView.setImageResource(obrazy.get(x).getIdObrazka());
        ratingBarSrednia.setRating((float) obrazy.get(x).sredniaOcen());
        textViewOpis.setText(obrazy.get(x).getOpis());
    }

}