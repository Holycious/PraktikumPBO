/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author destini marine
 */
    public class Pegawai {
    private int idpegawai;
    private String nama;
    private String alamat;
    private String notelp;
    private String jabatan;
    private String username;
    private String password;

    public Pegawai() {
    }

    public Pegawai(int idpegawai, String nama, String alamat, String notelp, String jabatan, String username, String password) {
        this.idpegawai = idpegawai;
        this.nama = nama;
        this.alamat = alamat;
        this.notelp = notelp;
        this.jabatan = jabatan;
        this.username = username;
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }
    
    public Pegawai getById(int id) {
        Pegawai ang = new Pegawai();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pegawai " + " WHERE idpegawai = '" + id + "'");
        try {
            while (rs.next()) {
                ang = new Pegawai();
                ang.setIdpegawai(rs.getInt("idpegawai"));
                ang.setNama(rs.getString("nama"));
                ang.setAlamat(rs.getString("alamat"));
                ang.setTelepon(rs.getString("notelp"));
                ang.setJabatan(rs.getString("jabatan"));
                ang.setJabatan(rs.getString("username"));
                ang.setJabatan(rs.getString("password"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ang;
    }
    
    public ArrayList<Pegawai> getAll() {
        ArrayList<Pegawai> ListPegawai = new ArrayList();
        
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pegawai");
        
        try {
            while(rs.next()) {
                Pegawai ang = new Pegawai();
                ang.setIdpegawai(rs.getInt("idpegawai"));
                ang.setNama(rs.getString("nama"));
                ang.setAlamat(rs.getString("alamat"));
                ang.setTelepon(rs.getString("notelp"));
                ang.setJabatan(rs.getString("jabatan"));
                ang.setUsername(rs.getString("username"));
                ang.setPassword(rs.getString("password"));
                ListPegawai.add(ang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ListPegawai;
    }
    
    public ArrayList<Pegawai> search(String keyword) {
        ArrayList<Pegawai> ListPegawai = new ArrayList();
        
        String sql = "SELECT * FROM pegawai WHERE " + 
                    "nama LIKE '%" + keyword + "%' " + 
                    "OR alamat LIKE '%" + keyword + "%' " + 
                    "OR notelp LIKE '%" + keyword + "%'";
        
        ResultSet rs = DBHelper.selectQuery(sql);
        
        try {
            while(rs.next()) {
                Pegawai ang = new Pegawai();
                ang.setIdpegawai(rs.getInt("idanggota"));
                ang.setNama(rs.getString("nama"));
                ang.setAlamat(rs.getString("alamat"));
                ang.setTelepon(rs.getString("notelp"));
                ang.setJabatan(rs.getString("jabatan"));
                ang.setUsername(rs.getString("username"));
                ang.setPassword(rs.getString("password"));
                ListPegawai.add(ang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ListPegawai;
    }
    
    public void save() {
    if (getById(idpegawai).getIdpegawai() == 0) {
        // Query untuk INSERT data
        String SQL = "INSERT INTO pegawai (nama, alamat, notelp, jabatan, username, password) VALUES ("
                + "'" + this.getNama() + "', "
                + "'" + this.getAlamat() + "', "
                + "'" + this.getNoTelp() + "', "
                + "'" + this.getJabatan() + "', "
                + "'" + this.getUsername() + "', "
                + "'" + this.getPassword() + "')";
        this.idpegawai = DBHelper.insertQueryGetId(SQL);
    } else {
        // Query untuk UPDATE data
        String SQL = "UPDATE pegawai SET "
                + "nama = '" + this.getNama() + "', "
                + "alamat = '" + this.getAlamat() + "', "
                + "notelp = '" + this.getNoTelp() + "', "
                + "jabatan = '" + this.getJabatan() + "', "
                + "username = '" + this.getUsername() + "', "
                + "password = '" + this.getPassword() + "' "
                + "WHERE idpegawai = " + this.idpegawai;
        DBHelper.executeQuery(SQL);
    }
    }
    
    public void delete() {
        String SQL = "DELETE FROM pegawai WHERE idpegawai = '" + this.idpegawai + "'";
        DBHelper.executeQuery(SQL);
    }

    /**
     * @return the idpegawai;
     */
    public int getIdpegawai() {
        return idpegawai;
    }

    /**
     * @param idpegawai the idpegawai to set
     */
    public void setIdpegawai(int idpegawai) {
        this.idpegawai = idpegawai;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * @return the notelp
     */
    public String getNoTelp() {
        return notelp;
    }

    /**
     * @param notelp the notelp to set
     */
    public void setTelepon(String notelp) {
        this.notelp = notelp;
    }

    /**
     * @return the jabatan
     */
    public String getJabatan() {
        return jabatan;
    }

    /**
     * @param jabatan the jabatan to set
     */
    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
