package Pracownik;
import Osoba.Osoba;

public abstract class Pracownik extends Osoba{
    private int wartoscDorobku;

    public Pracownik(String imie, String nazwisko, int wartoscDorobku){
        super(imie, nazwisko);
        this.wartoscDorobku = wartoscDorobku;
    }

    public void wypiszRole(){
        System.out.println("To jest Pracownik, o wartosci dorobku " + wartoscDorobku);
    }

    public int getDorobek(){
        return wartoscDorobku;
    }
    
}