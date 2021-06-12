/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.repository.db.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import root.domain.Zaposleni;
import root.repository.db.DBConnectionFactory;
import root.repository.db.DBRepository;

/**
 *
 * @author Bane
 */
public class RepositoryDBZaposleni implements DBRepository<Zaposleni>{

    @Override
    public List<Zaposleni> getAll() {
        try {
        String sql = "select * from zaposleni";
        
        List<Zaposleni> zaposleni = new ArrayList<>();

        Connection connection = DBConnectionFactory.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            Zaposleni z = new Zaposleni();
            z.setSifra(rs.getString("SifraZaposlenog"));
            z.setIme(rs.getString("ImeZaposlenog"));
            z.setPrezime(rs.getString("PrezimeZaposlenog"));
            zaposleni.add(z);
        }
        rs.close();
        statement.close();
        
        return zaposleni;
         } catch (Exception e) {
             System.out.println(e.getMessage());
             return null;
        }
    }

    @Override
    public void add(Zaposleni parametar) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Zaposleni param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Zaposleni param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
