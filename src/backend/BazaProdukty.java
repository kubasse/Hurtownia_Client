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
public class BazaProdukty {
    private Connection polaczenie;
    public BazaProdukty(){
        
    }
    
    public ArrayList<Produkty> produkty(){
        ArrayList<Produkty> produkty = new ArrayList();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie = DriverManager.getConnection("jdbc:sqlserver://localhost\\KUBASERV;databaseName=hurtownia","pabhurtownia","aaaaaa");
            PreparedStatement procedura = polaczenie.prepareStatement("{call pokaz_produkty}");
            ResultSet rezultat = procedura.executeQuery();
            while(rezultat.next()){
                produkty.add(new Produkty(
                        rezultat.getInt("id"),
                        rezultat.getString("nazwa"),
                        rezultat.getDouble("cena"),
                        rezultat.getInt("ilosc")
                ));
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),"Błąd", JOptionPane.ERROR_MESSAGE);
        }
        return produkty;
    }
    
}
