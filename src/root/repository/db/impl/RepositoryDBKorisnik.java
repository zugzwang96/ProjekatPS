/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.repository.db.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import root.domain.Korisnik;
import root.domain.Zaposleni;
import root.repository.db.DBConnectionFactory;
import root.repository.db.DBRepository;

/**
 *
 * @author Bane
 */
public class RepositoryDBKorisnik implements DBRepository<Korisnik>{

    @Override
    public List<Korisnik> getAll() {
        try {
        String sql = "select k.BrojLicneKarte,k.ImeKorisnika,k.PrezimeKorisnika,z.SifraZaposlenog,z.ImeZaposlenog,z.PrezimeZaposlenog from korisnik k inner join zaposleni z on (k.SifraZaposlenog = z.SifraZaposlenog)";
        
        List<Korisnik> korisnici = new ArrayList<>();

        Connection connection = DBConnectionFactory.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            Korisnik k = new Korisnik();
            k.setBrojLicneKarte(rs.getString("BrojLicneKarte"));
            k.setImeKorisnika(rs.getString("ImeKorisnika"));
            k.setPrezimeKorisnika(rs.getString("PrezimeKorisnika"));
            Zaposleni ulogovaniZaposleni = new Zaposleni();
            ulogovaniZaposleni.setSifra(rs.getString("SifraZaposlenog"));
            ulogovaniZaposleni.setIme(rs.getString("ImeZaposlenog"));
            ulogovaniZaposleni.setPrezime(rs.getString("PrezimeZaposlenog"));
            k.setZaposleni(ulogovaniZaposleni);
            korisnici.add(k);
        }
        rs.close();
        statement.close();
        
        return korisnici;
         } catch (Exception e) {
             System.out.println(e.getMessage());
             return null;
        }
    }

    @Override
    public void add(Korisnik korisnik) throws Exception {
        try{
        String sql = "INSERT into korisnik VALUES (?,?,?,?)";
        
        Connection connection = DBConnectionFactory.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, korisnik.getBrojLicneKarte());
        statement.setString(2, korisnik.getImeKorisnika());
        statement.setString(3, korisnik.getPrezimeKorisnika());
        statement.setString(4, korisnik.getZaposleni().getSifra());
        
        statement.executeUpdate();
        statement.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception("Nije moguce dodati korisnika");
        }
        
    }

    @Override
    public void edit(Korisnik korisnik) throws Exception {
        try {
            String sql="UPDATE korisnik SET "
                    + "ImeKorisnika='"+korisnik.getImeKorisnika()+"', "
                    + "PrezimeKorisnika='"+korisnik.getPrezimeKorisnika()+"',"
                    + "SifraZaposlenog='"+korisnik.getZaposleni().getSifra()+"' "
                    + "WHERE BrojLicneKarte="+korisnik.getBrojLicneKarte();
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
    
}
