/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.kontroler;

import java.util.List;
import root.domain.Iznajmljivanje;
import root.domain.Korisnik;
import root.domain.Marka;
import root.domain.Trotinet;
import root.domain.Zaposleni;
import root.repository.Repository;
import root.repository.RepositoryKorisnik;
import root.repository.RepositoryZaposleni;
import root.repository.db.DBRepository;
import root.repository.db.impl.RepositoryDBIznajmljivanje;
import root.repository.db.impl.RepositoryDBKorisnik;
import root.repository.db.impl.RepositoryDBMarka;
import root.repository.db.impl.RepositoryDBTrotinet;
import root.repository.db.impl.RepositoryDBZaposleni;

/**
 *
 * @author Bane
 */
public class Kontroler {
    private final Repository<Zaposleni> repositoryZaposleni;
    private final Repository<Korisnik> repositoryKorisnik;
    private final Repository<Trotinet> repositoryTrotinet;
    private final Repository<Iznajmljivanje> repositoryIznajmljivanje;
    private final Repository<Marka> repositoryMarka;
    
    private static Kontroler kontroler;

    private Kontroler() {
        this.repositoryZaposleni = new RepositoryDBZaposleni();
        this.repositoryKorisnik = new RepositoryDBKorisnik();
        this.repositoryTrotinet = new RepositoryDBTrotinet();
        this.repositoryIznajmljivanje =  new RepositoryDBIznajmljivanje();
        this.repositoryMarka =  new RepositoryDBMarka();
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
               ((DBRepository)repositoryKorisnik).connect();
        try{
            repositoryKorisnik.add(k);
            ((DBRepository)repositoryKorisnik).commit();
        }catch(Exception e){
            e.printStackTrace();
            ((DBRepository)repositoryKorisnik).rollback();
            throw e;
        }finally{
            ((DBRepository)repositoryKorisnik).disconnect();
        }
    }
    
    public void izmeniKorisnika(Korisnik k) throws Exception {
        ((DBRepository)repositoryKorisnik).connect();
        try{
            ((DBRepository)repositoryKorisnik).edit(k);
            ((DBRepository)repositoryKorisnik).commit();
        }catch(Exception e){
            e.printStackTrace();
            ((DBRepository)repositoryKorisnik).rollback();
            throw e;
        }finally{
            ((DBRepository)repositoryKorisnik).disconnect();
        }
    }
    
    public List<Korisnik> vratiSveKorisnike(){
        return repositoryKorisnik.getAll();
    }
    
    public List<Trotinet> vratiSveTrotinete(){
        return repositoryTrotinet.getAll();
    }
    
    public List<Iznajmljivanje> vratiSvaIznajmljivanja(){
        return repositoryIznajmljivanje.getAll();
    }
    
    public List<Marka> vratiSveMarke(){
        return repositoryMarka.getAll();
    }

    public void dodajIznajmljivanje(Iznajmljivanje i) throws Exception {
        ((DBRepository)repositoryKorisnik).connect();
        try{
            repositoryIznajmljivanje.add(i);
            ((DBRepository)repositoryIznajmljivanje).commit();
        }catch(Exception e){
            e.printStackTrace();
            ((DBRepository)repositoryIznajmljivanje).rollback();
            throw e;
        }finally{
            ((DBRepository)repositoryIznajmljivanje).disconnect();
        }
    }

    public void izmeniIznjamljivanje(Iznajmljivanje i) throws Exception{
        ((DBRepository)repositoryIznajmljivanje).connect();
        try{
            ((DBRepository)repositoryIznajmljivanje).edit(i);
            ((DBRepository)repositoryIznajmljivanje).commit();
        }catch(Exception e){
            e.printStackTrace();
            ((DBRepository)repositoryIznajmljivanje).rollback();
            throw e;
        }finally{
            ((DBRepository)repositoryIznajmljivanje).disconnect();
        }
    }
}
