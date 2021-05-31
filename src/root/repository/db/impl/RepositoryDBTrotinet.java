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
import root.domain.Trotinet;
import root.domain.Zaposleni;
import root.repository.db.DBConnectionFactory;
import root.repository.db.DBRepository;

/**
 *
 * @author Bane
 */
public class RepositoryDBTrotinet implements DBRepository<Trotinet>{

    @Override
    public List<Trotinet> getAll() {
         try {
        String sql = "select t.BrojSasije,t.Model,t.Cena,z.SifraZaposlenog,z.ImeZaposlenog,z.PrezimeZaposlenog,m.SifraMarke,m.NazivMarke from trotinet t inner join zaposleni z on (t.SifraZaposlenog = z.SifraZaposlenog) inner join marka m on (t.SifraMarke=m.SifraMarke)";
        
        List<Trotinet> trotineti = new ArrayList<>();

        Connection connection = DBConnectionFactory.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            Trotinet t = new Trotinet();
            t.setBrojSasije(rs.getString("BrojSasije"));
            t.setModel(rs.getString("Model"));
            t.setCena(rs.getInt("Cena"));
            Zaposleni zaposlen = new Zaposleni();
            zaposlen.setSifra(rs.getString("SifraZaposlenog"));
            zaposlen.setIme(rs.getString("ImeZaposlenog"));
            zaposlen.setPrezime(rs.getString("PrezimeZaposlenog"));
            t.setZaposleni(zaposlen);
            Marka m = new Marka();
            m.setSifraMarke(rs.getString("SifraMarke"));
            m.setNazivMarke(rs.getString("NazivMarke"));
            t.setMarka(m);
            trotineti.add(t);
        }
        rs.close();
        statement.close();
        
        return trotineti;
         } catch (Exception e) {
             System.out.println(e.getMessage());
             return null;
        }
    }

    @Override
    public void add(Trotinet parametar) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Trotinet parametar) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
