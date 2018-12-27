
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author okaaryanata
 */  
public class Individu {
    private int panjangIndividu=8;
    public int[] indiv = new int[panjangIndividu];
    //private double[] indivFit = new double[panjangIndividu];
    private ArrayList<Integer> gen = new ArrayList<Integer>();
    private ArrayList<Kota> daftarKota = new ArrayList<Kota>();
    private double fitness=0;
    Random ran = new Random();
    private int tmp;
    Kota kota;
    Populasi pop;
    int awal = 0;
    
    
    public int size() {
        return indiv.length;
    }
    
    public void addIndiv(int idx,int i){
        indiv[idx]=i;
    }
    
    
    public void makeIndiv() {
        addIndiv(0, 1);
        addIndiv(7, 1);
        //for (int i=1; i < size()-1; i++) {
        //rand abc
        for (int i=1; i < 3; i++) {
            //int tmp = ran.nextInt(6) + 2;
            if(ran.nextBoolean()==true){
                tmp=1;
            }else{
                tmp=0;
            }
            addIndiv(i, tmp);
        }    
        if(indiv[3]==1){
            addIndiv(4, 0);
            addIndiv(5, 0);
            addIndiv(6, 1);
        }else if(indiv[2]==1){
            addIndiv(4, 0);
            addIndiv(5, 1);
            addIndiv(6, 1);
        }else{
            for (int i=1; i < 3; i++) {
            //int tmp = ran.nextInt(6) + 2;
            if(ran.nextBoolean()==true){
                tmp=1;
            }else{
                tmp=0;
            }
            addIndiv(i+3, tmp);
        }
    }
    }//kromosom binner = indeks 0=S;1=A;2=B;3=C;4=D;5=E;6=F;7=G
    
    public void getIndiv(){
        int tmp = 3;
        for (int i=0; i < size(); i++) {
            System.out.print(indiv[i]) ;
            }
        System.out.println("");
        }
    
    public Kota genToKota(int idx){
        Kota kota = null;
        switch(idx){
            case 0 :
                kota = new Kota("S", 1, 6);
                kota.addTetangga("A", 6, 90);
                kota.addTetangga("B", 14, 70);
                kota.addTetangga("C", 10, 60);
                break;
            case 1 :
                kota = new Kota("A", 4, 10);
                kota.addTetangga("B", 4, 40);
                kota.addTetangga("D", 16, 40);
                //kota.addTetangga("S", 6, 90);
                break;
            case 2 :
                kota = new Kota("B", 4, 6);
                kota.addTetangga("A", 4, 40);
                kota.addTetangga("C", 4, 80);
                kota.addTetangga("E", 15, 60);
                //kota.addTetangga("S", 14, 70);
                break;
            case 3 :
                kota = new Kota("C", 4, 2);
                kota.addTetangga("B", 4, 80);
                kota.addTetangga("F", 12, 40);
                //kota.addTetangga("S", 10, 60);
                break;
            case 4 :
                kota = new Kota("D", 16, 10);
                kota.addTetangga("G", 9, 70);
                kota.addTetangga("E", 4, 120);
                //kota.addTetangga("A", 16, 40);
                break;
            case 5 :
                kota = new Kota("E", 16, 6);
                kota.addTetangga("G", 9, 80);
                kota.addTetangga("F", 4, 70);
                kota.addTetangga("D", 4, 120);
                //kota.addTetangga("B", 15, 60);
                break;
            case 6 :
                kota = new Kota("F", 16, 2);
                kota.addTetangga("E", 4, 70);
                //kota.addTetangga("C", 12, 40);
                kota.addTetangga("G", 6, 40);
                break;
            case 7 :
                kota = new Kota("G", 19, 6);
                break;
        }
        return kota;
    }
    
    public boolean cekJalur(){
        boolean a = false ;
        for (int i=0; i<indiv.length;i++){
            for(int j=1; j<indiv.length;j++){
                int tmpGen1 = indiv[i];
                int tmpGen2 = indiv[j];
                if(tmpGen1==1 && tmpGen2==1){
                        a = cekTetanga(genToKota(i), genToKota(j));
                        break;
                    }    
                }break;            
            }//break;
        return a;
    }
    
    @Override
    public String toString() {
        String indivString ="";
        for (int i = 0; i <size(); i++){
            indivString += indiv[i];
        }
        return indivString;
    }

    public int getPanjangIndividu() {
        return panjangIndividu;
    }

    public void setPanjangIndividu(int panjangIndividu) {
        this.panjangIndividu = panjangIndividu;
    }

    public void setIndiv(int[] indiv) {
        this.indiv = indiv;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }
    
    public boolean cekTetanga(Kota a, Kota b){
        boolean tmpBol = false;
        for(int i=0; i<a.daftarTtg.size(); i++){
            if(a.daftarTtg.get(i).getNama()==b.getNama()){
                tmpBol = true; 
            }
        }
        return tmpBol;
    }
    
    public int cekIdxTetangga(Kota a, Kota b){
        int x = 0;
        for(int i=0; i<a.daftarTtg.size(); i++){
            if(a.daftarTtg.get(i).getNama()==b.getNama()){
                x = i; 
            }
        }
        return x;
    }
}
