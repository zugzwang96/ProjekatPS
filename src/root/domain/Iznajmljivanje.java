/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.domain;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Bane
 */
public class Iznajmljivanje {
    private int sifraIznajmljivanja;
    private Date datumZaduzenja;
    private Date datumRazduzenja;
    private Korisnik korisnik;
    private Trotinet trotinet;

    public Iznajmljivanje() {
    }

    public Iznajmljivanje(int sifraIznajmljivanja, Date datumZaduzenja, Date datumRazduzenja, Korisnik korisnik, Trotinet trotinet) {
        this.sifraIznajmljivanja = sifraIznajmljivanja;
        this.datumZaduzenja = datumZaduzenja;
        this.datumRazduzenja = datumRazduzenja;
        this.korisnik = korisnik;
        this.trotinet = trotinet;
    }

    public int getSifraIznajmljivanja() {
        return sifraIznajmljivanja;
    }

    public void setSifraIznajmljivanja(int sifraIznajmljivanja) {
        this.sifraIznajmljivanja = sifraIznajmljivanja;
    }

    public Date getDatumZaduzenja() {
        return datumZaduzenja;
    }

    public void setDatumZaduzenja(Date datumZaduzenja) {
        this.datumZaduzenja = datumZaduzenja;
    }

    public Date getDatumRazduzenja() {
        return datumRazduzenja;
    }

    public void setDatumRazduzenja(Date datumRazduzenja) {
        this.datumRazduzenja = datumRazduzenja;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Trotinet getTrotinet() {
        return trotinet;
    }

    public void setTrotinet(Trotinet trotinet) {
        this.trotinet = trotinet;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.sifraIznajmljivanja);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Iznajmljivanje other = (Iznajmljivanje) obj;
        if (!Objects.equals(this.sifraIznajmljivanja, other.sifraIznajmljivanja)) {
            return false;
        }
        return true;
    }

    
  
    
}
