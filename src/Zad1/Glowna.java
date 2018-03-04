package Zad1;

public class Glowna {
    public static void main(String[] args) {
        Zespolona x = new Zespolona(3, 4);
        Zespolona[] zespolone = new Zespolona[10];

        for (int i = 0; i < zespolone.length; i++) {
            zespolone[i] = new Zespolona();
            zespolone[i].re = (int) (Math.random() * 10);
            zespolone[i].im = (int) (Math.random() * 10);
            zespolone[i].sprzerzenie();
        }
        System.out.println("Modul x wynosi: " + String.valueOf(x.modul()));
        x.wyswietlanie();
        x.dodawanie(zespolone[2]);
        x.wyswietlanie();
        x.odejmowanie(zespolone[2]);
        x.wyswietlanie();
        x.mnozenie(zespolone[2]);
        x.wyswietlanie();
    }
}
