/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author kubap
 */

public class BazaUsers {
    private Connection polaczenie;
    public int istnieje;
    public BazaUsers(){
        
    }
    
    public ArrayList wyswietl(String nip_pesel){
        ArrayList<Users> klient = new ArrayList();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie = DriverManager.getConnection("jdbc:sqlserver://localhost\\KUBASERV;databaseName=hurtownia","pabhurtownia","aaaaaa");
            PreparedStatement procedura = polaczenie.prepareStatement("{call dbo.loguj(?)}");
            procedura.setString(1, nip_pesel);
            ResultSet rezultat = procedura.executeQuery();
            while(rezultat.next()){
                klient.add(new Users(
                        rezultat.getString("nip_pesel"),
                        rezultat.getString("nazwa"),
                        rezultat.getString("miasto"),
                        rezultat.getString("adres"),
                        rezultat.getString("kod_pocztowy")
                ));
            }
            polaczenie.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Błąd: "+e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        return klient;
    }
    
    public int czy_istnieje(String nip_pesel){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie = DriverManager.getConnection("jdbc:sqlserver://localhost\\KUBASERV;databaseName=hurtownia","pabhurtownia","aaaaaa");
            PreparedStatement procedura = polaczenie.prepareStatement("{call dbo.sprawdz(?)}");
            procedura.setString(1, nip_pesel);
            ResultSet rezultat = procedura.executeQuery();
            while(rezultat.next()){
                istnieje = rezultat.getInt(1);
            }
            polaczenie.close();
            return istnieje;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Błąd: "+e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
            return istnieje;
        }
    }
    
    public void edytuj(String nip_pesel, String nazwa, String miasto, String adres, String kod_pocztowy){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie = DriverManager.getConnection("jdbc:sqlserver://localhost\\KUBASERV;databaseName=hurtownia","pabhurtownia","aaaaaa");
            CallableStatement procedura = polaczenie.prepareCall("{call dbo.edytuj_usera(?,?,?,?,?)}");
            procedura.setString(1,nip_pesel);
            procedura.setString(2,nazwa);
            procedura.setString(3,miasto);
            procedura.setString(4,adres);
            procedura.setString(5,kod_pocztowy);
            procedura.execute();
            polaczenie.close();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),"Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void rejestruj(String nip_pesel, String nazwa, String miasto, String adres, String kod_pocztowy){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie = DriverManager.getConnection("jdbc:sqlserver://localhost\\KUBASERV;databaseName=hurtownia","pabhurtownia","aaaaaa");
            CallableStatement procedura = polaczenie.prepareCall("{call dbo.rejestruj(?,?,?,?,?)}");
            procedura.setString(1,nip_pesel);
            procedura.setString(2,nazwa);
            procedura.setString(3,miasto);
            procedura.setString(4,adres);
            procedura.setString(5,kod_pocztowy);
            procedura.execute();
            polaczenie.close();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),"Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
}
