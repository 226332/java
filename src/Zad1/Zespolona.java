package Zad1;

public class Zespolona {
    public int im;
    public int re;

    public Zespolona(int im, int re) {
        this.im = im;
        this.re = re;
    }

    public Zespolona() {
        this.im = 0;
        this.re = 0;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

    public int modul() {
        return (int) java.lang.Math.sqrt((im * im) + (re * re));
    }

    public void sprzerzenie() {
        System.out.format("Sprzerzenie im: %d re: %d\n", this.im, -this.re);
    }

    public void dodawanie(Zespolona z) {
        this.im += z.im;
        this.re += z.re;
    }

    public void odejmowanie(Zespolona z) {
        this.im -= z.im;
        this.re -= z.re;
    }

    public void mnozenie(Zespolona z) {
        this.im = re * im;
        this.re = (re * re) - (im * im);
    }

    public void wyswietlanie() {
        System.out.format("im: %d re: %d\n", this.im, this.re);
    }

}
