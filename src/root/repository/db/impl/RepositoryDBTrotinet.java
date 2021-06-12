/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.repository.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public void add(Trotinet trotinet) throws Exception {
        try{
        String sql = "INSERT into trotinet VALUES (?,?,?,?,?)";
        
        Connection connection = DBConnectionFactory.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, trotinet.getBrojSasije());
        statement.setString(2, trotinet.getModel());
        statement.setInt(3, trotinet.getCena());
        statement.setString(4, trotinet.getZaposleni().getSifra());
        statement.setString(5, trotinet.getMarka().getSifraMarke());
        
        statement.executeUpdate();
        statement.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception("Nije moguce dodati trotinet");
        }
    }

    @Override
    public void edit(Trotinet trotinet) throws Exception {
        try {
            String sql="UPDATE trotinet SET "
                    + "Model='"+trotinet.getModel()+"', "
                    + "Cena='"+trotinet.getCena()+"',"
                    + "SifraZaposlenog='"+trotinet.getZaposleni().getSifra()+"',"
                    + "SifraMarke='"+trotinet.getMarka().getSifraMarke()+"' "
                    + "WHERE BrojSasije="+trotinet.getBrojSasije();
            System.out.println(sql);
            Connection connection=DBConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Greskaa prilikom izmene korisnika: \n"+ex.getMessage());
        }
    }

    @Override
    public void delete(Trotinet t) throws Exception {
                try {
            String sql="DELETE FROM trotinet WHERE BrojSasije="+t.getBrojSasije();
            System.out.println(sql);
            Connection connection=DBConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Greska prilikom brisanja trotineta: \n"+ex.getMessage());
        }
        
    }
    
}
