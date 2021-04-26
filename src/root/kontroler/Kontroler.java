/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.kontroler;

import java.util.List;
import root.domain.Korisnik;
import root.domain.Zaposleni;
import root.repository.RepositoryKorisnik;
import root.repository.RepositoryZaposleni;

/**
 *
 * @author Bane
 */
public class Kontroler {
    private final RepositoryZaposleni repositoryZaposleni;
    private final RepositoryKorisnik repositoryKorisnik;
    
    private static Kontroler kontroler;

    private Kontroler() {
        this.repositoryZaposleni = new RepositoryZaposleni();
        this.repositoryKorisnik = new RepositoryKorisnik();
    }
    public static Kontroler getInstance() {
        if(kontroler==null) kontroler= new Kontroler();
        return kontroler;
    }
    
    public Zaposleni login(String lozinka) throws Exception{
        List<Zaposleni> zaposleni = repositoryZaposleni.getZaposleni();
        for (Zaposleni z : zaposleni) {
            if(z.getSifra().equals(lozinka))
                return z;
        }
        throw new Exception("Korisnik sa tom sifrom ne postoji!");
    }
    
    public void dodajKorisnika(Korisnik k){
        repositoryKorisnik.dodaj(k);
    }
    
    public List<Korisnik> vratiSveKorisnike(){
    return repositoryKorisnik.getKorisnici();
    }
}
