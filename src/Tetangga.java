/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author okaaryanata
 */
public class Tetangga {
    private String nama;
    private int distc;
    private double speed;

    public Tetangga(String nama, int distc, double speed) {
        this.nama = nama;
        this.distc = distc;
        this.speed = speed;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getDistc() {
        return distc;
    }

    public void setDistc(int distc) {
        this.distc = distc;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    
}
