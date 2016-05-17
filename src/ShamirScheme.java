
import java.util.ArrayList;
import javafx.util.Pair;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Edwin
 */
public class ShamirScheme {
    long q; // prime number q as modulus
    ArrayList<Long> polCoeff; // polynom coefficient
    long M; // message represented as number M
    long w; // number of participant
    long t; // number of min. participant to construct M
    ArrayList<Long> xVal; // x value for every participant
    ArrayList <Pair<Long, Long>> shares;
    
    public ShamirScheme(long q, long M, long w, long t){
        this.q = q;
        this.M = M;
        this.w = w;
        this.t = t;
        polCoeff = new ArrayList<>();
        xVal = new ArrayList<>();
        shares = new ArrayList<>();
    }
    
    public void generatePolCoeff(){
//        for(long i=0; i<t-1; i++){
//            polCoeff.add((long)(Math.random()*(q-1)));
//        }
        polCoeff.add((long)3);
        polCoeff.add((long)3);
    }
    
    public void generateXVal(){
        for(long i=0; i<w; i++){
            xVal.add(i+1);
        }
    }
    
    public long countShare(long x){
        long res = 0;
        res += M;
        for(int i=0; i<polCoeff.size(); i++){
            res += (polCoeff.get(i)* (long)Math.pow(x, i+1));
        }
        res %= q;
        return res;
    }
    
    public void generateShares(){
        for(int i=0; i<w; i++){
           shares.add(new Pair(xVal.get(i),countShare(xVal.get(i))));
        }
    }
    
    // do full steps of Shamir Scheme to generate shares
    public void doShamirScheme(){
        generatePolCoeff();
        generateXVal();
        generateShares();
    }
    
    public void printShares(){
        System.out.print("S(X)= "+M+" + ");
        for(int i=0; i<polCoeff.size(); i++){
            System.out.print(polCoeff.get(i)+"X"+(i+1)+" + ");
        }
        System.out.println("");
        for(int i=0; i<shares.size(); i++){
            System.out.println("Share-"+ (i+1) + " : (" + shares.get(i).getKey() + " , " + shares.get(i).getValue() + " )");
        }
    }
}
