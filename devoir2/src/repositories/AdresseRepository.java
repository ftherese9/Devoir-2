package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Adresse;


public class AdresseRepository extends Database{
     private final  String SQL_SELECT_ALL="select * from adresse" ;
    private final  String SQL_INSERT="INSERT INTO adresse (idAdresse) VALUES (?)";
     public void insertClient(Adresse adresse){
        openConnexion();
        try {
            initPreparedStatement(SQL_INSERT);
            statement.setInt(1, adresse.getId());
            statement.setString(2, adresse.getVille());
            statement.setString(3, adresse.getQuartier());
            statement.setString(3, adresse.getNumVilla());
            int nbreLigne=executeUpdate();
           closeConnexion();
         } catch (SQLException e) {
          e.printStackTrace();
         }
    }
    public List<Adresse> getAllAdresses(){
         List<Adresse> adresse=new ArrayList<>();
       try {
           openConnexion();
           initPreparedStatement(SQL_SELECT_ALL);
           ResultSet rs= executeSelect();
             while (rs.next()) {
                 Adresse ad=new Adresse();
                 ad.setId(rs.getInt("id_ad"));
                 ad.setVille(rs.getString("ville_ad"));
                 ad.setQuartier(rs.getString("quartier_ad"));
                 ad.setNumVilla(rs.getString("numVilla_ad"));                
                adresse.add(ad);
             }
             rs.close();
           closeConnexion();
        }
       catch (SQLException e) {
        System.out.println("Erreur de Connexion a la BD");
      }
        return  adresse;
    }
}
