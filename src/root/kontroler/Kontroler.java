/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.kontroler;

import java.util.List;
import root.domain.Korisnik;
import root.domain.Zaposleni;
import root.repository.Repository;
import root.repository.RepositoryKorisnik;
import root.repository.RepositoryZaposleni;
import root.repository.db.impl.RepositoryDBKorisnik;
import root.repository.db.impl.RepositoryDBZaposleni;

/**
 *
 * @author Bane
 */
public class Kontroler {
    private final Repository<Zaposleni> repositoryZaposleni;
    private final Repository<Korisnik> repositoryKorisnik;
    
    private static Kontroler kontroler;

    private Kontroler() {
        this.repositoryZaposleni = new RepositoryDBZaposleni();
        this.repositoryKorisnik = new RepositoryDBKorisnik();
    }
    public static Kontroler getInstance() {
        if(kontroler==null) kontroler= new Kontroler();
        return kontroler;
    }
    
    public Zaposleni login(String lozinka) throws Exception{
        List<Zaposleni> zaposleni = repositoryZaposleni.getAll();
        for (Zaposleni z : zaposleni) {
            if(z.getSifra().equals(lozinka))
                return z;
        }
        throw new Exception("Korisnik sa tom sifrom ne postoji!");
    }
    
    public void dodajKorisnika(Korisnik k) throws Exception{
        repositoryKorisnik.add(k);
    }
    
    public List<Korisnik> vratiSveKorisnike(){
    return repositoryKorisnik.getAll();
    }
}
