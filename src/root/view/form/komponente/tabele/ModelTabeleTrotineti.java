/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.view.form.komponente.tabele;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import root.domain.Trotinet;

/**
 *
 * @author Bane
 */
public class ModelTabeleTrotineti extends AbstractTableModel{
    private List<Trotinet> trotineti;

    public ModelTabeleTrotineti(List<Trotinet> trotineti) {
        this.trotineti = trotineti;
    }

    public List<Trotinet> getTrotineti() {
        return trotineti;
    }
    @Override
    public int getRowCount() {
        if(trotineti==null) return 0;
        return trotineti.size();
    }

    @Override
    public int getColumnCount() {
      return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Trotinet trotinet = trotineti.get(rowIndex);
            switch(columnIndex){
                case 0: return trotinet.getBrojSasije();
                case 1: return trotinet.getCena();
                case 2: return trotinet.getModel();
                case 3: return trotinet.getMarka().getNazivMarke();
                    default:
                        return "n/a";
            }
    }
    
        @Override
    public String getColumnName(int column) {
        switch(column){
                case 0: return "Broj sasije";
                case 1: return "Cena po danu";
                case 2: return "Model";
                case 3: return "Marka";
                    default:
                        return "n/a";
            }
    }

    public Trotinet dajIzabraniTrotinet(int red) {
        return trotineti.get(red);
      
    }
    
}
