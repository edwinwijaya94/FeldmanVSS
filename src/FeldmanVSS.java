
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Edwin
 */
public class FeldmanVSS {
    long p; // prime number p as modulus where q|p-1, q is modulus of the polynomial function to generate shares
    long g; // generator g as base
    ArrayList<Long> commitments; // commitments g^polCoeff;
    
    public FeldmanVSS(long p, long g){
        this.p = p;
        this.g = g;
        this.commitments = new ArrayList<>();
    }
    
    public void setCommitments(ArrayList<Long> polCoeff){
        for(int i=0; i<polCoeff.size(); i++){
            this.commitments.add((long)Math.pow(g, polCoeff.get(i)));
        }
    }
    
    public boolean verifyShare(long s){
        long shareRes = ((long) Math.pow(g, s)) % p;
        
        long commitmentsRes = 1;
        for(int i=0; i<this.commitments.size(); i++){
            commitmentsRes *= (long) Math.pow(commitments.get(i), Math.pow(s, i));
        }
        commitmentsRes %= p;
        System.out.println("shareRes="+shareRes);
        System.out.println("comRes="+commitmentsRes);
        return (shareRes == commitmentsRes);
    }
    
}
