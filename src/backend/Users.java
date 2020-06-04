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
public class Users {
    private String nip_pesel;
    private String nazwa;
    private String miasto;
    private String adres;
    private String kod_pocztowy;
    
    public Users(String nip_pesel, String nazwa, String miasto, String adres, String kod_pocztowy) {
        this.nip_pesel = nip_pesel;
        this.nazwa = nazwa;
        this.miasto = miasto;
        this.adres = adres;
        this.kod_pocztowy = kod_pocztowy;
    }

    public String getNip_pesel() {
        return nip_pesel;
    }

    public void setNip_pesel(String nip_pesel) {
        this.nip_pesel = nip_pesel;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }
    
}
