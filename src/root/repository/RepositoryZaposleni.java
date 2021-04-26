/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.repository;

import java.util.ArrayList;
import java.util.List;
import root.domain.Zaposleni;

/**
 *
 * @author Bane
 */
public class RepositoryZaposleni {
    private final List<Zaposleni> zaposleni;


    public RepositoryZaposleni() {
        this.zaposleni = new ArrayList<>();
        zaposleni.add(new Zaposleni("Admin", "Admin", "admin"));
        zaposleni.add(new Zaposleni("Milos", "Milosevic", "123"));
        zaposleni.add(new Zaposleni("Janko", "Jankovic", "a1b2"));
    }

    public List<Zaposleni> getZaposleni() {
        return zaposleni;
    }
    
    
    
}
