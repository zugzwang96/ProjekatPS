/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.niti;

import java.util.logging.Level;
import java.util.logging.Logger;
import root.view.form.FrmKorisnikPretraga;

/**
 *
 * @author Bane
 */
public class OsveziNit extends Thread{
    FrmKorisnikPretraga frk;

    public OsveziNit(FrmKorisnikPretraga frk) {
        this.frk = frk;
    }
    
    @Override
    public void run() {
        while (true) {            
            frk.srediTabelu();

            try {
                sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(OsveziNit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
