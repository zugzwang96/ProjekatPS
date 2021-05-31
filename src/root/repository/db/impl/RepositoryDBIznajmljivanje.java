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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import root.domain.Iznajmljivanje;
import root.domain.Korisnik;
import root.domain.Marka;
import root.domain.Trotinet;
import root.domain.Zaposleni;
import root.repository.db.DBConnectionFactory;
import root.repository.db.DBRepository;

/**
 *
 * @author Bane
 */
public class RepositoryDBIznajmljivanje implements DBRepository<Iznajmljivanje>{

    @Override
    public List<Iznajmljivanje> getAll() {
         try {
        String sql = "select i.SifraIznajmljivanja,i.DatumZaduzenja,i.DatumRazduzenja,i.BrojLicneKarte,i.BrojSasije,k.ImeKorisnika,k.PrezimeKorisnika,z.SifraZaposlenog,z.ImeZaposlenog,z.PrezimeZaposlenog,t.Cena,t.Model,m.SifraMarke,m.NazivMarke from iznajmljivanje i inner join korisnik k on (i.BrojLicneKarte = k.BrojLicneKarte) inner join trotinet t on (i.BrojSasije = t.BrojSasije) inner join marka m on (t.SifraMarke=m.SifraMarke) inner join zaposleni z on (z.SifraZaposlenog=k.SifraZaposlenog)";
        
        
        List<Iznajmljivanje> iznajmljivanja = new ArrayList<>();

        Connection connection = DBConnectionFactory.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            Iznajmljivanje i = new Iznajmljivanje();
            i.setSifraIznajmljivanja(rs.getInt("SifraIznajmljivanja"));
            Date datumZad = new Date(rs.getDate("DatumZaduzenja").getTime());
            Date datumRaz = new Date(rs.getDate("DatumRazduzenja").getTime());
            i.setDatumZaduzenja(datumZad);
            i.setDatumRazduzenja(datumRaz);
          
            Korisnik korisnik = new Korisnik();
            korisnik.setBrojLicneKarte(rs.getString("BrojLicneKarte"));
            korisnik.setImeKorisnika(rs.getString("ImeKorisnika"));
            korisnik.setPrezimeKorisnika(rs.getString("PrezimeKorisnika"));
            
            Zaposleni z = new Zaposleni();
            z.setSifra(rs.getString("SifraZaposlenog"));
            z.setIme(rs.getString("ImeZaposlenog"));
            z.setPrezime(rs.getString("PrezimeZaposlenog"));
            
            korisnik.setZaposleni(z);
            
            Trotinet t = new Trotinet();
            t.setBrojSasije(rs.getString("BrojSasije"));
            t.setCena(rs.getInt("Cena"));
            t.setModel(rs.getString("Model"));
            Marka m = new Marka();
            m.setSifraMarke(rs.getString("SifraMarke"));
            m.setNazivMarke(rs.getString("NazivMarke"));
            t.setMarka(m);
            t.setZaposleni(z);
            
            i.setKorisnik(korisnik);
            i.setTrotinet(t);
            
            iznajmljivanja.add(i);
        }
        rs.close();
        statement.close();
        
        return iznajmljivanja;
         } catch (Exception e) {
             System.out.println(e.getMessage());
             return null;
        }
    }

    @Override
    public void add(Iznajmljivanje i) throws Exception {
       try{
        String sql = "INSERT into iznajmljivanje (BrojLicneKarte,BrojSasije,DatumZaduzenja,DatumRazduzenja) VALUES (?,?,?,?)";
        
        Connection connection = DBConnectionFactory.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
        
        statement.setString(1, i.getKorisnik().getBrojLicneKarte());
        statement.setString(2, i.getTrotinet().getBrojSasije());
        statement.setTimestamp(3, new Timestamp(i.getDatumZaduzenja().getTime()));
        statement.setTimestamp(4, new Timestamp(i.getDatumRazduzenja().getTime()));
        
        
        statement.executeUpdate();
        
        statement.close();
       }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception("Nije moguce iznajmiti trotinet");
        }
    }

    @Override
    public void edit(Iznajmljivanje i) throws Exception {
        try {
            String sql="UPDATE iznajmljivanje SET "
                    + "DatumZaduzenja='"+new Timestamp(i.getDatumZaduzenja().getTime())+"', "
                    + "DatumRazduzenja='"+new Timestamp(i.getDatumRazduzenja().getTime())+"' "
                    + "WHERE SifraIznajmljivanja="+i.getSifraIznajmljivanja();
            System.out.println(sql);
            Connection connection=DBConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Greska prilikom izmene: \n"+ex.getMessage());
        }
    }
    
}
