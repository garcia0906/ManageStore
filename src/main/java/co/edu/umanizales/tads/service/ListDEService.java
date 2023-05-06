package co.edu.umanizales.tads.service;

import co.edu.umanizales.tads.model.ListSE;
import lombok.Data;
import org.springframework.stereotype.Service;
import co.edu.umanizales.tads.model.ListDE;
@Data
@Service

public class ListDEService {

    private ListDE kids;

    public ListDEService() {
        kids = new ListDE();

    }

    public void invert(){kids.invertdoble();}
    public void getOrderBoystoStart(){kids.getOrderedPetsToStart();}
    public void getAlternateKids(){kids.getAlternatePets();}
    public void deleteKidbyAge(){kids.deletePetByAge();}
    public float averageAge(){return kids.averageAge();}
    public void GainPositionKid(){kids.gainPositionPet();}
    public void GetPostById(String id){kids.getPostById();}
    public void moveKid(char letter){kids.movePet();}




}
