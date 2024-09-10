package pl.zabrze.zs10.galeria4a;

import java.util.ArrayList;

public class Obraz {
    private int idObrazka;
    private String opis;
    private ArrayList<Double> oceny;

    public Obraz(int idObrazka, String opis) {
        this.idObrazka = idObrazka;
        this.opis = opis;
        oceny = new ArrayList<>();

    }

    public void ocen(double ocena){
        oceny.add(ocena);
    }

    public int getIdObrazka() {
        return idObrazka;
    }

    public String getOpis() {
        return opis;
    }

    public double sredniaOcen(){
        if(oceny.size()>0) {
            double srednia = 0;
            for (Double ocena : oceny) {
                srednia = srednia + ocena;
            }
            srednia = srednia / oceny.size();
            return srednia;
        }
        return 0;
    }

}
