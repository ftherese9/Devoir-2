package services;

import java.util.List;

import entities.Adresse;

import repositories.AdresseRepository;


public class AdresseService {
    private AdresseRepository adresseRepository= new AdresseRepository();
    

     public void ajouterAdresse(Adresse adresse){
        adresseRepository.insertClient(adresse);
    }
    public List<Adresse> listerAdresses(){
       return adresseRepository.getAllAdresses();
    }
}
