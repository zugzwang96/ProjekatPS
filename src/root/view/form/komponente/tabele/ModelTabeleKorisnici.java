/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.view.form.komponente.tabele;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import root.domain.Korisnik;

/**
 *
 * @author Bane
 */
public class ModelTabeleKorisnici extends AbstractTableModel{
    private List<Korisnik> korisnici;

    public ModelTabeleKorisnici(List<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public List<Korisnik> getKorisnici() {
        return korisnici;
    }
    
    
    @Override
    public int getRowCount() {
        if(korisnici==null) return 0;
        return korisnici.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Korisnik korisnik = korisnici.get(rowIndex);
            switch(columnIndex){
                case 0: return korisnik.getBrojLicneKarte();
                case 1: return korisnik.getImeKorisnika();
                case 2: return korisnik.getPrezimeKorisnika();
                    default:
                        return "n/a";
            }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
                case 0: return "Broj licne karte";
                case 1: return "Ime";
                case 2: return "Prezime";
                    default:
                        return "n/a";
            }
    }

    public Korisnik dajIzabranogKorisnika(int red) {
        return korisnici.get(red);
      
    }

    
}
