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
public class BazaZamowienia {
    private Connection polaczenie;
    public int blad;
    public BazaZamowienia(){
    
    }
    
    public void nowe_zamowienie(String nip_pesel, int id_produktu, int ilosc){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie = DriverManager.getConnection("jdbc:sqlserver://localhost\\KUBASERV;databaseName=hurtownia","pabhurtownia","aaaaaa");
            PreparedStatement procedura = polaczenie.prepareStatement("{call dbo.zloz_zamowienie(?,?,?)}");
            procedura.setString(1,nip_pesel);
            procedura.setInt(2,id_produktu);
            procedura.setInt(3,ilosc);
            ResultSet rezultat = procedura.executeQuery();
            while(rezultat.next()){
                blad = rezultat.getInt(1);
            }
            polaczenie.close();
            if(blad == 0){
                JOptionPane.showMessageDialog(null, "Za duża ilość! Sprawdź w produktach dostępną ilość przed złożeniem zamówienia!", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),"Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList odczyt(String nipPesel) {
        ArrayList<Zamowienia> zamowienia = new ArrayList();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie = DriverManager.getConnection("jdbc:sqlserver://localhost\\KUBASERV;databaseName=hurtownia","pabhurtownia","aaaaaa");
            PreparedStatement ps = polaczenie.prepareStatement("{call dbo.pokaz_zamowienia(?)}");
            ps.setString(1, nipPesel);
            ResultSet rezultat = ps.executeQuery();
            while(rezultat.next()){
                zamowienia.add(new Zamowienia(
                        rezultat.getInt("id"),
                        rezultat.getString("nip_pesel"),
                        rezultat.getInt("product_id"),
                        rezultat.getInt("ilosc"),
                        rezultat.getDouble("cena"),
                        rezultat.getString("dzien"),
                        rezultat.getString("status_zamowienia")
                ));
            }
            polaczenie.close();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),"Błąd",
                    JOptionPane.ERROR_MESSAGE);
        }
        return zamowienia;
    }
}
