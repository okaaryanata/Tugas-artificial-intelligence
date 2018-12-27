
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i = 0;
        Individu indi = null;
        Populasi pop = null;
        GA ga = new GA();
        while(i !=50){
            pop = ga.StartGA();
            indi = pop.geIndivTerbaik();
            i++;
        }
        System.out.println("Individu terbaik");
        System.out.println(indi.toString());
        System.out.println("Nilai Fitness");
        System.out.println(pop.arrayFitness.get(0));
        
       
    }
    
}
