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
public class Zamowienia {
    private int id;
    private String nip_pesel;
    private int product_id;
    private int ilosc;
    private double cena;
    private String dzien;
    private String status_zamowienia;
    
    public Zamowienia(int id, String nip_pesel, int product_id, int ilosc, double cena, String dzien, String status_zamowienia){
        this.id = id;
        this.nip_pesel = nip_pesel;
        this.product_id = product_id;
        this.ilosc = ilosc;
        this.cena = cena;
        this.dzien = dzien;
        this.status_zamowienia = status_zamowienia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNip_pesel() {
        return nip_pesel;
    }

    public void setNip_pesel(String nip_pesel) {
        this.nip_pesel = nip_pesel;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getDzien() {
        return dzien;
    }

    public void setDzien(String dzien) {
        this.dzien = dzien;
    }

    public String getStatus_zamowienia() {
        return status_zamowienia;
    }

    public void setStatus_zamowienia(String status_zamowienia) {
        this.status_zamowienia = status_zamowienia;
    }
    
    
}
