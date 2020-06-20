package Pracownik.PUczelni;

import Pracownik.Pracownik;

public class PUczelni extends Pracownik{
    private String stanowiskoPracy;

    public PUczelni(String imie, String nazwisko, int wartoscDorobku, String stanowiskoPracy){
        super(imie, nazwisko, wartoscDorobku);
        this.stanowiskoPracy = stanowiskoPracy;
    }

    public void wypiszRole(){
        super.wypiszRole();
        System.out.println("To jest Pracownik uczelni na stanowisku " + stanowiskoPracy + "\n");
    }

    public String getStanowisko(){
        return stanowiskoPracy;
    }
    
}