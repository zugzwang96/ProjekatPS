/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.niti;

import java.util.logging.Level;
import java.util.logging.Logger;
import root.view.form.FrmIznajmljivanja;

/**
 *
 * @author Bane
 */
public class OsveziNitIznajmljivanje extends Thread{
    FrmIznajmljivanja fri;

    public OsveziNitIznajmljivanje(FrmIznajmljivanja fri) {
        this.fri = fri;
    }

    @Override
    public void run() {
        while (true) {            
            fri.srediTabelu();
            try {
                sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(OsveziNitIznajmljivanje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
