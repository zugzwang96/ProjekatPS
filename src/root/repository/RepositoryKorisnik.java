/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.repository;

import java.util.ArrayList;
import java.util.List;
import root.domain.Korisnik;

/**
 *
 * @author Bane
 */
public class RepositoryKorisnik {
    private List<Korisnik> korisnici;

    public RepositoryKorisnik() {
        korisnici = new ArrayList<>();
    }
    
    public void dodaj(Korisnik korisnik){
        korisnici.add(korisnik);
    }

    public List<Korisnik> getKorisnici() {
        return korisnici;
    }
    
    
}
