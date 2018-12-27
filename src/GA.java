
import java.math.*;
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
public class GA {
    private static final double probsmutasi = 0.8;
    private static final double probscrossover = 0.8;
    public ArrayList<Integer> arrayRW = new ArrayList<Integer>();
    //Populasi p = new Populasi();
    int tmp1 = 0;
    int tmp2;
    
    public int bulat(double r){
        int decimalPlace;
        decimalPlace = (int) Math.round(r);
        return (int) r;
    }
    
    public boolean cekSama(int i,int j){
        boolean a;
        if(i==j){
            a = true;
        }else{
            a = false;
        }
        return a;
    }   
            
    public Individu mutasi(Individu indiv){
        double angka = Math.random();
        if (angka > probsmutasi ){
            Random rn = new Random();
            Random ran = new Random();
            int idxGen1 = rn.nextInt(6) + 2; //memilih gen yang akan dimutasi, 2 gen akan dimutasi
            int idxGen2;                    
            int tmp =ran.nextInt(6) + 2;
            if(cekSama(idxGen1,tmp)==false){
                idxGen2=tmp;
            }else{
                idxGen2=ran.nextInt(6) + 2;
            }     
            
            int nilaiGen1;
            int nilaiGen2;
            if(rn.nextBoolean()==true){ //menentukan nilai gen atara 1 atau 0
                nilaiGen1=1;
                nilaiGen2=0;
            }else{
                nilaiGen1=0;
                nilaiGen2=1;
            }
            indiv.indiv[idxGen1]=nilaiGen1;
            indiv.indiv[idxGen2]=nilaiGen2;
        }
        return indiv;
    }
    
    //dua titik
    public void crossover(Individu ortu1,Individu ortu2, Populasi p){
        double angka = Math.random();
        if (angka < probscrossover ){
            int titik1 = (int) (Math.random() * ortu1.size());
            int titik2 = (int) (Math.random() * ortu1.size());
            Individu child1 = new Individu();
            Individu child2 = new Individu();
            if(titik1<titik2){
                for(int i=0; i<titik1; i++){
                    child1.indiv[i]=ortu1.indiv[i];
                    child2.indiv[i]=ortu2.indiv[1];
                }
                for(int i=titik1+1; i<titik2; i++){
                    child1.indiv[i]=ortu2.indiv[i];
                    child2.indiv[i]=ortu1.indiv[i];   
                }
                for(int i=titik2+1; i<child1.size(); i++){
                    child1.indiv[i]=ortu1.indiv[i];
                    child2.indiv[i]=ortu2.indiv[1];
                }
            }else{
                for(int i=0; i<titik1; i++){
                    child1.indiv[i]=ortu2.indiv[i];
                    child2.indiv[i]=ortu1.indiv[i];
                }
                for(int i=titik1+1; i<titik2; i++){
                    child1.indiv[i]=ortu1.indiv[i];
                    child2.indiv[i]=ortu2.indiv[i];   
                }
                for(int i=titik2+1; i<child1.size(); i++){
                    child1.indiv[i]=ortu2.indiv[i];
                    child2.indiv[i]=ortu1.indiv[i];
                }
                
            }
        p.daftarIndiv.add(child1);
        p.daftarIndiv.add(child2);   
        }
    }
    
    //Milih Kandidat Terbaik di populasi
    public Individu roulleteWheel(Populasi populasi){
        double totalFit = 0;
        double b;
        int a = 0;
        
        for(int i = 0; i < populasi.daftarIndiv.size(); i++){
          populasi.hitFitness(populasi.daftarIndiv.get(i));
        }
        //return populasi.arrayFitness.get(o);
        
        for(int i = 0; i < populasi.arrayFitness.size(); i++){
            totalFit = totalFit + populasi.arrayFitness.get(i);
            tmp2 = bulat(totalFit);
        }
        //return totalFit;
        
        for(int j = 0; j < populasi.arrayFitness.size(); j++){
            b = (populasi.arrayFitness.get(j)/totalFit)*100 ;
            a = bulat(b);
            //while(tmp1 != totalFit){
                for(int i = tmp1; i<a-1; i++){
                    arrayRW.add(j);
                    tmp1 = tmp1 + a-1;
                //}
                
            }
        }
        Random ran = new Random();
        int tmp = ran.nextInt(100)+1;
        int idx = arrayRW.get(tmp);
        return populasi.daftarIndiv.get(idx);
    }
    

    
    
    public Populasi newPopulasi(Populasi p){
        double tmp1;
        Individu tmp2; 
        Populasi newpop = new Populasi();
        //p.daftarIndiv;
        for (int i = 0; i < (p.daftarIndiv.size()-1); i++) {
            for (int j = 0; j < (p.daftarIndiv.size()-i-1); j++) {
                if (p.arrayFitness.get(j) > p.arrayFitness.get(j+1)){
                   tmp1 = p.arrayFitness.get(j);
                   tmp2 = p.daftarIndiv.get(j);
                   p.arrayFitness.set(j, p.arrayFitness.get(j+1));
                   p.daftarIndiv.set(j, p.daftarIndiv.get(j+1));
                   p.arrayFitness.set(j+1, tmp1);
                   p.daftarIndiv.set(j+1, tmp2);
                }
            }
        }
        for(int k = 0; k<8; k++){
            Individu tmpIndiv;
            tmpIndiv = p.daftarIndiv.get(k);
            newpop.daftarIndiv.set(k, tmpIndiv);
            newpop.arrayFitness.set(k, p.arrayFitness.get(k));
        }
        return newpop;
    }
    
    public Populasi StartGA() {
        Populasi populasi = new Populasi();
        populasi.makePopulasi();
        
        Individu ortu1 = roulleteWheel(populasi);
        Individu ortu2 = roulleteWheel(populasi);
        Individu ortu3 = roulleteWheel(populasi);
        Individu ortu4 = roulleteWheel(populasi);
        
        crossover(ortu1, ortu2, populasi);
        crossover(ortu3, ortu4, populasi);
        
        for(int i = 9; i<populasi.daftarIndiv.size(); i++){ //anak masuk ke populasi dari idx 9
            populasi.daftarIndiv.set(i, mutasi(populasi.daftarIndiv.get(i)));
        }
        
        
        return newPopulasi(populasi);
    }
}
        
