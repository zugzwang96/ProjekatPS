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

    public Korisnik() {
    }

    public Korisnik(String brojLicneKarte, String imeKorisnika, String prezimeKorisnika) {
        this.brojLicneKarte = brojLicneKarte;
        this.imeKorisnika = imeKorisnika;
        this.prezimeKorisnika = prezimeKorisnika;
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

    @Override
    public String toString() {
        return imeKorisnika+" "+prezimeKorisnika;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.brojLicneKarte);
        hash = 71 * hash + Objects.hashCode(this.imeKorisnika);
        hash = 71 * hash + Objects.hashCode(this.prezimeKorisnika);
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
