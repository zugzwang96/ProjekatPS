/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.repository.db.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import root.domain.Marka;
import root.repository.db.DBConnectionFactory;
import root.repository.db.DBRepository;

/**
 *
 * @author Bane
 */
public class RepositoryDBMarka implements DBRepository<Marka>{

    @Override
    public List<Marka> getAll() {
        try {
        String sql = "select * from marka";
        
        List<Marka> marke = new ArrayList<>();

        Connection connection = DBConnectionFactory.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            Marka m = new Marka();
            m.setSifraMarke(rs.getString("SifraMarke"));
            m.setNazivMarke(rs.getString("NazivMarke"));
            marke.add(m);
        }
        rs.close();
        statement.close();
        
        return marke;
         } catch (Exception e) {
             System.out.println(e.getMessage());
             return null;
        }
    }

    @Override
    public void add(Marka parametar) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Marka parametar) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
