/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.domain;

/**
 *
 * @author Bane
 */
public class Marka {
    private String sifraMarke;
    private String nazivMarke;

    public Marka() {
    }

    public Marka(String sifraMarke, String nazivMarke) {
        this.sifraMarke = sifraMarke;
        this.nazivMarke = nazivMarke;
    }

    public String getNazivMarke() {
        return nazivMarke;
    }

    public void setNazivMarke(String nazivMarke) {
        this.nazivMarke = nazivMarke;
    }

    public String getSifraMarke() {
        return sifraMarke;
    }

    public void setSifraMarke(String sifraMarke) {
        this.sifraMarke = sifraMarke;
    }

    @Override
    public String toString() {
        return nazivMarke;
    }
    
    
}
