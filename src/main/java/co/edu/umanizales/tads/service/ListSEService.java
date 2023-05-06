package co.edu.umanizales.tads.service;

import co.edu.umanizales.tads.model.Kid;
import co.edu.umanizales.tads.model.ListSE;
import co.edu.umanizales.tads.model.Node;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class ListSEService {
    private ListSE kids;

    public ListSEService() {
        kids = new ListSE();

    }

   public void invert(){kids.invert();}
    public void getOrderBoystoStart(){kids.getorderBoysToStart();}
    public void getAlternateKids(){kids.getAlternateKids();}
    public void deleteKidbyAge(){kids.deleteKidbyAge();}
    public float averageAge(){return kids.averageAge();}
    public void GainPositionKid(){kids.GainPositionKid();}
    public void GetPostById(String id){kids.GetPostById();}
    public void moveKid(char letter){kids.moveKid();}


}
