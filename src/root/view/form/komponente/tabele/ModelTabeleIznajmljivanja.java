/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.view.form.komponente.tabele;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import root.domain.Iznajmljivanje;
import root.view.form.FrmIznajmljivanja;


/**
 *
 * @author Bane
 */
public class ModelTabeleIznajmljivanja extends AbstractTableModel{

    private List<Iznajmljivanje> iznajmljivanja;


    public ModelTabeleIznajmljivanja(List<Iznajmljivanje> iznajmljivanja) {
        this.iznajmljivanja = iznajmljivanja;

    }

    public List<Iznajmljivanje> getIznajmljivanja() {
        return iznajmljivanja;
    }

  
    
    
    @Override
    public int getRowCount() {
        if(iznajmljivanja==null) return 0;
        return iznajmljivanja.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Iznajmljivanje i = iznajmljivanja.get(rowIndex);
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy.MM.dd");
        FrmIznajmljivanja fri = new FrmIznajmljivanja();
            switch(columnIndex){
                case 0: return i.getKorisnik().getBrojLicneKarte();
                case 1: return i.getKorisnik().getImeKorisnika();
                case 2: return i.getKorisnik().getPrezimeKorisnika();
                case 3: return i.getTrotinet().getMarka().getNazivMarke();
                case 4: return i.getTrotinet().getModel();
                case 5: return sdf.format(i.getDatumZaduzenja());
                case 6: return sdf.format(i.getDatumRazduzenja());
                case 7: return (fri.dajBrojDana(i.getDatumZaduzenja(), i.getDatumRazduzenja()))*i.getTrotinet().getCena();
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
                case 3: return "Marka";
                case 4: return "Model";
                case 5: return "Datum zaduzenja";
                case 6: return "Datum razduzenja";
                case 7: return "Ukupna cena iznajmljivanja";
                    default:
                        return "n/a";
            }
    }

    public Iznajmljivanje dajIzabranoIznajmljivanje(int red) {
        return iznajmljivanja.get(red);
      
    }
    
}
