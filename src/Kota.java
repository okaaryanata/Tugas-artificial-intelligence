
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author okaaryanata
 */
public class Kota {
    private String nama; 
    private int x;
    private int y;
    public ArrayList<Tetangga> daftarTtg = new ArrayList<Tetangga>();
    public ArrayList<Kota> daftarKota = new ArrayList<Kota>();

//    Kota() {
//    
//    }
    
    public void addTetangga(String nama, int distc, double speed){
        Tetangga t = new Tetangga(nama,distc, speed);
        daftarTtg.add(t);
    }
    
    
    public Kota(String nama, int x, int y) {
        this.nama = nama;
        this.x = x;
        this.y = y;
    }
    
    public void addKota(Kota kota){
        daftarKota.add(kota);
    }
    
    public Kota getKota(int index){
        return daftarKota.get(index);
    }
   
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    
    
    
}
