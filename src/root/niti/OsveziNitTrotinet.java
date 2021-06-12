/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.niti;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import root.view.form.FrmTrotinetiPretraga;

/**
 *
 * @author Bane
 */
public class OsveziNitTrotinet extends Thread{
    FrmTrotinetiPretraga frt;

    public OsveziNitTrotinet(FrmTrotinetiPretraga frt) {
        this.frt = frt;
    }

    @Override
    public void run() {
        while (true) {            
            frt.srediTabelu();
            try {
                sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(OsveziNitIznajmljivanje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
