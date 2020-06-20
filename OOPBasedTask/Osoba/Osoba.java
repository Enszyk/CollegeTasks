package Osoba;

import java.io.Serializable;

public abstract class Osoba implements Serializable{
    private static final long serialVersionUID = 5800051001284540616L;
    
    private String imie;
    private String nazwisko;

    public Osoba(String imie, String nazwisko){
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public void wypisz(){
        System.out.println(imie + " " + nazwisko);
    } 

    public void wypiszRole(){
        System.out.println("To jest osoba \n");
    }

    public String getNazwisko(){
        return nazwisko;
    }


    
}