import java.util.List;
import java.util.Scanner;

import entities.Adresse;
import entities.Client;
import services.AdresseService;
import services.ClientService;

public class App {
    public static void main(String[] args) throws Exception {
        int choix;
        Scanner sc=new Scanner(System.in);
        ClientService clientService=new ClientService();
        AdresseService adresseService=new AdresseService();
        do {
            System.out.println("1-Ajouter un client");
            System.out.println("2-Lister les clients"); 
            System.out.println("3-Ajouter une adresse et lui associer un client"); 
            System.out.println("4-Lister les adresses en affichant le nom du client");           
            System.out.println("5-Quitter"); 
             choix=sc.nextInt();
             sc.nextLine();
            switch (choix) {
                case 1:
                     System.out.println("Entrer l'id du client");
                     int id=sc.nextLine(); 
                     System.out.println("Entrer le nom complet du client");
                     String nom=sc.nextLine();  
                     System.out.println("Entrer le telephone du client");
                     String tel=sc.nextLine();   
                     System.out.println("Entrer l'email du client");
                     String email=sc.nextLine();
                     Client cl=new Client();
                      cl.setId(id);
                      cl.setNomComplet(nom);
                      cl.setEmail(email);
                      cl.setTelephone(tel);
                     clientService.creerClient(cl);                   
                    break;
                case 2:
                List<Client> client= clientService.listerClient();
                for (Client cl : client) {
                    System.out.println("ID: "+cl.getId());
                    System.out.println("Nom Complet: "+cl.getNomComplet());
                    System.out.println("Telephone: "+cl.getTelephone());
                    System.out.println("Email: "+cl.getEmail());
                }
               
                break;
                case 3:
                    System.out.println("Entrer l'id de l'adresse");
                    
                    System.out.println("Entrer la ville ");
                    String ville=sc.nextLine();  
                    System.out.println("Entrer le quartier");
                    String quartier=sc.nextLine();   
                    System.out.println("Entrer le numero de la villa");
                    String numVilla=sc.nextLine();
                    Adresse ad=new Adresse();
                    ad.setId(id);
                    ad.setVille(ville);
                    ad.setQuartier(quartier);
                    ad.setNumVilla(numVilla);
                    adresseService.ajouterAdresse(ad);  
                break;

                case 4:
                List<Adresse> adresse= adresseService.listerAdresses();
                for (Adresse ad : adresse) {
                    System.out.println("ID: "+cl.getId());
                    System.out.println("Ville: "+cl.getVille());
                    System.out.println("Quartier: "+cl.getQuartier());
                    System.out.println("Numero Villa: "+cl.getNumVilla());
                }
                break;
                
            }

        }while(choix!=5);

        
    }
}
