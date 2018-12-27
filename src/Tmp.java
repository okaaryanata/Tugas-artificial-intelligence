
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
public class Tmp {
    {
        Individu i = new Individu();
        i.makeIndiv();
        i.getIndiv();
        System.out.println(i.toString());
        Populasi p = new Populasi();
        Kota S = new Kota("S", 1, 6);
        Kota A = new Kota("A", 4, 10);
        Kota B = new Kota("B", 4, 6);
        Kota C = new Kota("C", 4, 2);
        Kota D = new Kota("D", 16, 10);
        Kota E = new Kota("E", 16, 6);
        Kota F = new Kota("F", 16, 2);
        Kota G = new Kota("G", 19, 6);
        
        S.addTetangga("A", 6, 90);
        S.addTetangga("B", 14, 70);
        S.addTetangga("C", 10, 60);
        A.addTetangga("B", 4, 40);
        A.addTetangga("D", 16, 40);
        //A.addTetangga("S", 6, 90);
        B.addTetangga("A", 4, 40);
        B.addTetangga("C", 4, 80);
        B.addTetangga("E", 15, 60);
        //B.addTetangga("S", 14, 70);
        C.addTetangga("B", 4, 80);
        C.addTetangga("F", 12, 40);
        //C.addTetangga("S", 10, 60);
        D.addTetangga("G", 9, 70);
        D.addTetangga("E", 4, 120);
        //D.addTetangga("A", 16, 40);
        E.addTetangga("G", 9, 80);
        E.addTetangga("F", 4, 70);
        E.addTetangga("D", 4, 120);
        //E.addTetangga("B", 15, 60);
        F.addTetangga("E", 4, 70);
        //F.addTetangga("C", 12, 40);
        F.addTetangga("G", 6, 40);
        
        //Populasi p = new Populasi();
        p.daftarKota.add(S);
        p.daftarKota.add(A);
        p.daftarKota.add(C);
        System.out.println(p.daftarKota.get(0).daftarTtg.get(0).getNama()+" INI");
        
        
        
        
        //System.out.println(p.daftarIndiv.get(0).genToKota(0).daftarTtg.get(0).getNama());
        
        
        //String A  ;
        System.out.println(p.daftarKota.get(1).getNama());
        Random rn = new Random();
        int name = rn.nextInt(100);
        Random ran = new Random();
        int name1 = rn.nextInt(6) + 2;
        int name2 = rn.nextInt(6) + 2;
        System.out.println(name+" "+name1+" "+name2);
                
        Populasi pop = new Populasi();
        p.makePopulasi();
        
        double angka = Math.random();
        System.out.println(angka);
        
        for(int bla=0;bla<2;bla++){
            System.out.println("1");
        }
        Individu ortu1 = new Individu();
        Individu ortu2 = new Individu();
        int gen1 = (int) (Math.random() * ortu1.size()+1);
        int gen2 = (int) (Math.random() * ortu2.size()+1);
        System.out.println(gen1+" "+gen2);
        //Individu indiv= new Individu();
        //System.out.println(indiv.size());
        
        System.out.println("DOWN");
        
        //cek jalur bermasalah
        Individu indiv = new Individu();
        indiv.makeIndiv();
        indiv.cekJalur();
        System.out.println(indiv.cekJalur());
            
        
    System.out.println(indiv.toString());
        
        
        System.out.println("UP GAN");
        
        System.out.println(indiv.cekTetanga(S, D));
        System.out.println(indiv.cekIdxTetangga(S, D));
        
        
        
        // test genToKota
        Kota testKota;
        testKota = indiv.genToKota(0);
        
        System.out.println();
        }
}
