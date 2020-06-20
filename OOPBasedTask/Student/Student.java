package Student;
import java.util.ArrayList;

import Osoba.Osoba;

public class Student extends Osoba{
    private int nrIndeksu;
    private ArrayList<Kurs> Kursy = new ArrayList<Kurs>();

    public Student(String imie, String nazwisko, int nrIndeksu){
        super(imie, nazwisko);
        this.nrIndeksu = nrIndeksu;
    }

    public void wypiszRole(){
        System.out.println("To jest Student o numerze indeksu " + nrIndeksu + "\n");
    }

    public int getNrIndeksu(){
        return nrIndeksu;
    }

    public void kursy(String kurs, boolean zaliczony){
        Kursy.add(new Kurs(kurs, zaliczony));
    }

    public void wypiszKursy(){
        for (Kurs k : Kursy)
            k.kursy();
    }
    
}