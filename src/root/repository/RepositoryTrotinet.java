/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.repository;

import java.util.ArrayList;
import java.util.List;
import root.domain.Korisnik;
import root.domain.Trotinet;

/**
 *
 * @author Bane
 */
public class RepositoryTrotinet {
    private List<Trotinet> trotineti;

    public RepositoryTrotinet() {
        this.trotineti = new ArrayList<>();
    }
    
    public void dodaj(Trotinet trotinet){
        trotineti.add(trotinet);
    }

    public List<Trotinet> getTrotineti() {
        return trotineti;
    }
    
        public void delete(Trotinet trotinet) throws Exception {
        int index = trotineti.indexOf(trotinet);
        if(index>=0){
             trotineti.remove(index);
        }else{
            throw new Exception("Greska: Trotinet ne postoji!");
        }
       
    }
    
}
