
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
public class Populasi {
    
 public ArrayList<Individu>daftarIndiv = new ArrayList<Individu>();
 public ArrayList<Kota> daftarKota = new ArrayList<Kota>();   
 Kota kota;
 private int sizePopulasi = 8; 
 //Individu indiv = new Individu();
 public ArrayList<Double> arrayFitness = new ArrayList<Double>();
 int populasiAwal = 0;
 
public void makePopulasi(){    
    while(populasiAwal != 8){
        Individu indiv = new Individu();
        indiv.makeIndiv();
        if(indiv.cekJalur()==true){
            daftarIndiv.add(indiv);
            populasiAwal++;
        }else{
            makePopulasi();
        }    
    }
}

public void hitFitness(Individu i){
    double tmpFit=0;
    for(int j = 0; j<i.size();j++){
        for(int k = 1; k<i.size(); k++){
            if(i.cekJalur()==true){ //cek jalur apakah benar atau tidak
                int tmp1 = i.indiv[j];
                int tmp2 = i.indiv[k];
                if(tmp1==1 && tmp2 ==1){ 
                    //if(i.cekTetanga(i.genToKota(j), i.genToKota(k))==true){
                        int idx = i.cekIdxTetangga(i.genToKota(j), i.genToKota(k));
                        int distc = i.genToKota(j).daftarTtg.get(idx).getDistc();
                        double speed = i.genToKota(j).daftarTtg.get(idx).getSpeed();
                        if(speed > 60){
                            speed = 60; //cek apakah speed diatas 60
                        } else{
                            speed = speed;
                        }
                        tmpFit= 1/(distc/speed);
                        break;
                    //}
                }
            }
        }
    }
    arrayFitness.add(tmpFit);
}

public Individu geIndivTerbaik(){
    double tmpBest = arrayFitness.get(0);
    int tmpIdx = 0;
    for(int i = 0; i<arrayFitness.size() ; i++){
        if(tmpBest<arrayFitness.get(i));{
            tmpBest = arrayFitness.get(i);
            tmpIdx=i;
        }
    }
    return daftarIndiv.get(tmpIdx);
}


}


