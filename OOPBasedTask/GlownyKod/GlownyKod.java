package GlownyKod;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import Osoba.Osoba;
import Pracownik.Pracownik;
import Pracownik.PNaukowoDydaktyczny.PNaukowoDydaktyczny;
import Pracownik.PUczelni.PUczelni;
import Student.Student;

public class GlownyKod {

    public static void wypiszWszystkieOsoby(ArrayList<Osoba> Osoby){

        for (Osoba os : Osoby){
            os.wypisz();
            os.wypiszRole();
        }
    }

    public static void wypiszSzukaneNazwisko(ArrayList<Osoba> Osoby, String szukaneNazwisko){

        for (Osoba os : Osoby){
            if (os.getNazwisko().equals(szukaneNazwisko)){
                os.wypisz();
                os.wypiszRole();
            }
        }
    }

    public static void wypiszSzukanyIndeks(ArrayList<Osoba> Osoby, int szukanyIndeks){
        for (Osoba os : Osoby){
            if (os instanceof Student)
                if (((Student)os).getNrIndeksu() == szukanyIndeks){
                    os.wypisz();
                    os.wypiszRole();
                }
        }
    }

    public static void wypiszPoDorobku(ArrayList<Osoba> Osoby, int wartoscDorobku){
        for (Osoba os : Osoby){
            if (os instanceof Pracownik)
                if (((Pracownik)os).getDorobek() > wartoscDorobku){
                    os.wypisz();
                    os.wypiszRole();
                }
        }
    }

    public static void wypiszPoStanowisku(ArrayList<Osoba> Osoby, String stanowisko){
        for (Osoba os : Osoby){
            if (os instanceof PUczelni)
                if (((PUczelni)os).getStanowisko().equals(stanowisko)){
                    os.wypisz();
                    os.wypiszRole();
                }
        }
    }

    public static void clearEkran(){
        for (int i = 0; i < 4; i++)
            System.out.println(" \n");
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ArrayList<Osoba> Osoby = new ArrayList<Osoba>();
        Scanner scan = new Scanner(System.in);

        Osoby.add(new Student("Szymon", "Nowak", 253647));
        ((Student)(Osoby.get(0))).kursy("Matematyka", true);
        ((Student)(Osoby.get(0))).kursy("Matematyka12", false);
        ((Student)(Osoby.get(0))).kursy("Matematyka344", true);
        // ((Student)(Osoby.get(0))).wypiszKursy();
        Osoby.add(new PNaukowoDydaktyczny("Jan", "Janowski", 3500));

        // Osoby.add(new PUczelni("Grzegorz", "Grzegowski", 4500, "Administracyjny"));
        // Osoby.add(new PUczelni("Zygmunt", "Mąslak", 3300, "Porządkowy"));
        // Osoby.add(new Student("Jerzy", "Nowak", 258394));

        // Student st1 = new Student("Norbert", "Masny", 253634);
       
       
        // wypiszWszystkieOsoby(Osoby);
        // wypiszSzukaneNazwisko(Osoby, "Nowak");
        // wypiszSzukanyIndeks(Osoby, 253647);
        // wypiszPoDorobku(Osoby, 3600);
        // wypiszPoStanowisku(Osoby, "Administracyjny");


        while (true){
            
            boolean warunek = true;

            while (warunek){

                System.out.println(" \nPodaj co chcesz zrobic\n");
                System.out.println("1 - wypisz wszytsko, 2 - wypisz po nazwisku, 3 - wypisz po indeksie, 4 - wypisz po dorobku, 5 - wypisz po stanowisku, 6 - zapis do pliku, 7 - odczytaj, 8 - wypisz kursy, 9 - dodaj nowa osobe");
                int wybor2 = scan.nextInt();
                
                switch (wybor2){
                    case 1:
                        clearEkran();
                        wypiszWszystkieOsoby(Osoby);
                        clearEkran();
                        break;
                    case 2:
                        System.out.println("Podaj nazwisko");
                        String szukaneNazwisko = scan.next();
                        clearEkran();
                        wypiszSzukaneNazwisko(Osoby, szukaneNazwisko);
                        clearEkran();
                        break;
                    case 3:
                        System.out.println("Podaj numer indeksu");
                        int szukanyIndeks = scan.nextInt();
                        clearEkran();
                        wypiszSzukanyIndeks(Osoby, szukanyIndeks);
                        clearEkran();
                        break;
                    case 4:
                        System.out.println("Podaj dorobek");
                        int szukanyDorobek = scan.nextInt();
                        clearEkran();
                        wypiszPoDorobku(Osoby, szukanyDorobek);
                        clearEkran();
                        break;
                    case 5:
                        System.out.println("Podaj stanowisko");
                        String stanowisko = scan.next();
                        clearEkran();
                        wypiszPoStanowisku(Osoby, stanowisko);
                        clearEkran();
                        break;
                    case 6:
                        try (ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream("Osoby.txt"))){
                            for (Osoba os : Osoby)
                                so.writeObject(os);
                        } catch (IOException e){
                            e.printStackTrace();
                        }
                        break;
                    case 7:
                        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("Osoby.txt"))){
                            while (true){
                            Object obj = is.readObject();
                            Osoby.add((Osoba) obj);
                            }
                            
                        } catch (IOException | ClassNotFoundException e){
                            //e.printStackTrace();
                        }
                        break;
                    case 8:
                        clearEkran();
                        for (Osoba os : Osoby)
                            if (os instanceof Student){
                                os.wypisz();
                                os.wypiszRole();
                                ((Student)os).wypiszKursy();
                                System.out.print("\n");
                            }
                        clearEkran();
                        break;   
                    case 9:
                        warunek = false;
                        break;
                }
            }

            clearEkran();
            System.out.println("Podaj imie");
            String imie = scan.next();
            System.out.println("Podaj nazwisko");
            String nazwisko = scan.next();
            System.out.println("1 - Pracownik uczelni, 2 - Pracownik naukowy, 3 - Student");
            int wybor = scan.nextInt();

            switch(wybor){
                case 1:
                    System.out.println("Podaj wartosc dorobku");
                    int wartoscDorobku = scan.nextInt();
                    System.out.println("Podaj stanowisko pracy");
                    String stanowisko = scan.next();
                    Osoby.add(new PUczelni(imie, nazwisko, wartoscDorobku, stanowisko));
                    break;

                case 2:
                    System.out.println("Podaj wartosc dorobku");
                    int wartoscDorobku2 = scan.nextInt();
                    Osoby.add(new PNaukowoDydaktyczny(imie, nazwisko, wartoscDorobku2));
                    break;

                case 3:

                    System.out.println("Podaj numer indeksu");
                    int nrIndeksu = scan.nextInt();
                    Osoby.add(new Student(imie, nazwisko, nrIndeksu));

                    System.out.println("Ile kursow");
                    int ile = scan.nextInt();
                    for (int i = 0; i < ile; i++){

                    System.out.println("Podaj nazwe kursu");
                    String nazwaKursu = scan.next();
                    System.out.println("Czy zalioczny t/f");
                    boolean zaliczony = scan.nextBoolean();
                    Student student = (Student)Osoby.get(Osoby.size()-1);
                    student.kursy(nazwaKursu, zaliczony);

                    }
                
                    break;

                default:
                    break;
            }
        }
    }
}