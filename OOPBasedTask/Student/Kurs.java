package Student;

import java.io.Serializable;

public class Kurs implements Serializable{
    private String nazwaKursu;
    private boolean zaliczony;

    public Kurs(String nazwaKursu, boolean zaliczony){
        this.nazwaKursu = nazwaKursu;
        this.zaliczony = zaliczony;
    }

    public void kursy(){
        System.out.println("Nazwa kursu " + nazwaKursu + " zaliczony " + zaliczony);
    }
    
}