package Zad2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {

    private String nazwaPliku;

    public FileHandler(String plik) {
        this.nazwaPliku = plik;
    }

    public static void main(String[] args) {
        FileHandler zapis = new FileHandler("plik.txt");
        ArrayList<Point_1D> points = new ArrayList<Point_1D>();
        points.add(new Point_1D(1));
        points.add(new Point_2D(2, 3));
        points.add(new Point_3D(4, 5, 6));
        points.add(new Point_3D(4, 5, 6));
        zapis.savePoints(points);

        ArrayList<Point_1D> loadedPoints = zapis.readPoints("plik.txt");
        for (Point_1D point : loadedPoints) {
            System.out.println(point.toString());
        }

    }

    public void savePoints(ArrayList<Point_1D> punkty) {
        FileWriter plik;
        try {
            plik = new FileWriter(nazwaPliku);
            for (Point_1D point : punkty) {
                plik.write(point.toString() + "\n");
            }
            plik.close();
        } catch (IOException e) {
            System.out.println("Nie można otworzyć:" + nazwaPliku);
        }
    }

    public ArrayList<Point_1D> readPoints(String plikWczytu) {
        ArrayList<Point_1D> points = new ArrayList<Point_1D>();
        try (BufferedReader br = new BufferedReader(new FileReader(plikWczytu))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] n = line.split(" ");
                if (n.length == 3) {
                    points.add(new Point_3D(Integer.valueOf(n[0]), Integer.valueOf(n[1]), Integer.valueOf(n[2])));
                } else if (n.length == 2) {
                    points.add(new Point_2D(Integer.valueOf(n[0]), Integer.valueOf(n[1])));
                } else 
                    points.add(new Point_1D(Integer.valueOf(n[0])));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return points;
    }

}
