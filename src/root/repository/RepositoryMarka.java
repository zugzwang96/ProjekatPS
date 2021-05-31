/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.repository;

import java.util.ArrayList;
import java.util.List;
import root.domain.Marka;


/**
 *
 * @author Bane
 */
public class RepositoryMarka {
    private List<Marka> marke;

    public RepositoryMarka() {
        marke = new ArrayList<>();
    }
    
    public void dodaj(Marka marka){
        marke.add(marka);
    }

    public List<Marka> getMarke() {
        return marke;
    }
    
}
