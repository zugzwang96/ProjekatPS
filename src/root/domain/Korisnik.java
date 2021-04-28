/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.domain;

import java.util.Objects;

/**
 *
 * @author Bane
 */
public class Korisnik {
    String brojLicneKarte;
    String imeKorisnika;
    String prezimeKorisnika;
    private Zaposleni zaposleni;

    public Korisnik() {
    }

    public Korisnik(String brojLicneKarte, String imeKorisnika, String prezimeKorisnika, Zaposleni zaposleni) {
        this.brojLicneKarte = brojLicneKarte;
        this.imeKorisnika = imeKorisnika;
        this.prezimeKorisnika = prezimeKorisnika;
        this.zaposleni = zaposleni;
    }

   

    public String getBrojLicneKarte() {
        return brojLicneKarte;
    }

    public void setBrojLicneKarte(String brojLicneKarte) {
        this.brojLicneKarte = brojLicneKarte;
    }

    public String getImeKorisnika() {
        return imeKorisnika;
    }

    public void setImeKorisnika(String imeKorisnika) {
        this.imeKorisnika = imeKorisnika;
    }

    public String getPrezimeKorisnika() {
        return prezimeKorisnika;
    }

    public void setPrezimeKorisnika(String prezimeKorisnika) {
        this.prezimeKorisnika = prezimeKorisnika;
    }
      public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }
    

    @Override
    public String toString() {
        return imeKorisnika+" "+prezimeKorisnika;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.brojLicneKarte);
        hash = 59 * hash + Objects.hashCode(this.imeKorisnika);
        hash = 59 * hash + Objects.hashCode(this.prezimeKorisnika);
        hash = 59 * hash + Objects.hashCode(this.zaposleni);
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
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.brojLicneKarte, other.brojLicneKarte)) {
            return false;
        }
        return true;
    }

   

  
    
}
