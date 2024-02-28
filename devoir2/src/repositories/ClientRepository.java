package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Client;

public class ClientRepository extends Database{
    private final  String SQL_SELECT_ALL="select * from client" ;
    private final  String SQL_INSERT="INSERT INTO client (nomClient) VALUES (?)";
     public void insertClient(Client client){
        openConnexion();
        try {
            initPreparedStatement(SQL_INSERT);
            statement.setInt(1, client.getId());
            statement.setString(2, client.getNomComplet());
            statement.setString(3, client.getTelephone());
            statement.setString(3, client.getEmail());
            int nbreLigne=executeUpdate();
           closeConnexion();
         } catch (SQLException e) {
          e.printStackTrace();
         }
    }
    public List<Client> getAllClient(){
         List<Client> client=new ArrayList<>();
       try {
           openConnexion();
           initPreparedStatement(SQL_SELECT_ALL);
           ResultSet rs= executeSelect();
             while (rs.next()) {
                 Client cl=new Client();
                 cl.setId(rs.getInt("id_cl"));
                 cl.setNomComplet(rs.getString("nomComplet_cl"));
                 cl.setEmail(rs.getString("email_cl"));
                 cl.setTelephone(rs.getString("tel_cl"));
                client.add(cl);
             }
             rs.close();
           closeConnexion();
        }
       catch (SQLException e) {
        System.out.println("Erreur de Connexion a la BD");
      }
        return  client;
    }
   
}
