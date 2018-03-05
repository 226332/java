package Zad2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Zapisownik {

    private String nazwaPliku;

    public Zapisownik(String plik) {
        this.nazwaPliku = plik;
    }

    public static void main(String[] args) {
        Zapisownik zapis = new Zapisownik("plik.txt");
        ArrayList<Punkt_1D> punkciki = new ArrayList<Punkt_1D>();
        punkciki.add(new Punkt_1D(1));
        punkciki.add(new Punkt_2D(2, 3));
        punkciki.add(new Punkt_3D(4, 5, 6));
        punkciki.add(new Punkt_3D(4, 5, 6));
        zapis.zapiszPunkty(punkciki);

        ArrayList<Punkt_1D> wczytane = zapis.wczytajPunkty("plik.txt");
        for (Punkt_1D punkt : wczytane) {
            System.out.println(punkt.toString());
        }

    }

    public void zapiszPunkty(ArrayList<Punkt_1D> punkty) {
        FileWriter plik;
        try {
            plik = new FileWriter(nazwaPliku);
            for (Punkt_1D punkt : punkty) {
                plik.write(punkt.toString() + "\n");
            }
            plik.close();
        } catch (IOException e) {
            System.out.println("Nie można otworzyć:" + nazwaPliku);
        }
    }

    public ArrayList<Punkt_1D> wczytajPunkty(String plikWczytu) {
        ArrayList<Punkt_1D> punkty = new ArrayList<Punkt_1D>();
        try (BufferedReader br = new BufferedReader(new FileReader(plikWczytu))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] n = line.split(" ");
                if (n.length == 3) {
                    punkty.add(new Punkt_3D(Integer.valueOf(n[0]), Integer.valueOf(n[1]), Integer.valueOf(n[2])));
                } else if (n.length == 2) {
                    punkty.add(new Punkt_2D(Integer.valueOf(n[0]), Integer.valueOf(n[1])));
                } else 
                    punkty.add(new Punkt_1D(Integer.valueOf(n[0])));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return punkty;
    }

}
