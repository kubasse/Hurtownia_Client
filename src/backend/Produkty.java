/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author kubap
 */
public class Produkty {
    private int id;
    private String nazwa;
    private double cena;
    private int ilosc;
    
    public Produkty(int id, String nazwa, double cena, int ilosc){
        this.id = id;
        this.nazwa = nazwa;
        this.cena = cena;
        this.ilosc = ilosc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
    
    
}
