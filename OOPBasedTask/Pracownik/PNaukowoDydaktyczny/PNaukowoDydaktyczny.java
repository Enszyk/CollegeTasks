package Pracownik.PNaukowoDydaktyczny;

import Pracownik.Pracownik;

public class PNaukowoDydaktyczny extends Pracownik{

    public PNaukowoDydaktyczny(String imie, String nazwisko, int wartoscDorobku){
        super(imie, nazwisko, wartoscDorobku);
    }

    public void wypiszRole(){
        super.wypiszRole();
        System.out.println("To jest Pracownik dydaktyczny \n");
    }
}