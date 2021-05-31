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
public class Trotinet {
    private String brojSasije;
    private String model;
    private int cena;
    private Zaposleni zaposleni;
    private Marka marka;

    public Trotinet() {
    }

    public Trotinet(String brojSasije, String model, int cena, Zaposleni zaposleni, Marka marka) {
        this.brojSasije = brojSasije;
        this.model = model;
        this.cena = cena;
        this.zaposleni = zaposleni;
        this.marka = marka;
    }

    public String getBrojSasije() {
        return brojSasije;
    }

    public void setBrojSasije(String brojSasije) {
        this.brojSasije = brojSasije;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Marka getMarka() {
        return marka;
    }

    public void setMarka(Marka marka) {
        this.marka = marka;
    }

    @Override
    public String toString() {
        return marka.getNazivMarke()+":"+model;
    }

  
    
    

   
}
