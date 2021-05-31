/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.repository;

import java.util.ArrayList;
import java.util.List;
import root.domain.Iznajmljivanje;


/**
 *
 * @author Bane
 */
public class RepositoryIznajmljivanje {
    private List<Iznajmljivanje> iznajmljivanja;

    public RepositoryIznajmljivanje() {
        this.iznajmljivanja = new ArrayList<>();
    }
    
    public void dodaj(Iznajmljivanje iznajmljivanje){
        iznajmljivanja.add(iznajmljivanje);
    }

    public List<Iznajmljivanje> getIznajmljivanja() {
        return iznajmljivanja;
    }
}
