
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Edwin
 */
public class Main {
    
    public static void  main(String[] args){
        // share distribution
        ShamirScheme S = new ShamirScheme(5, 2, 4, 4);
        S.doShamirScheme();
        S.printShares();
        
        //share verification
        FeldmanVSS F = new FeldmanVSS(11, 3);
//        ArrayList<Long> polCoeff = new ArrayList<>();
        Scanner reader = new Scanner(System.in);
        
        System.out.println("ID partisipan: ");
        long pid = reader.nextLong();
        
        System.out.println("share yang diterima : ");
        long share = reader.nextLong();
        
//        System.out.println("Commitments: ");
//        System.out.print("Enter secret: ");
//        long x = reader.nextLong();
//        polCoeff.add(x);
//        for(int i=0; i<S.polCoeff.size(); i++){
//            System.out.print("Enter coefficient-"+i+": ");
//            x = reader.nextLong();
//            polCoeff.add(x);
//        }
        F.setCommitments(S.M, S.polCoeff);
        String result = F.verifyShare(pid, share); 
        System.out.println("hasil verifikasi: "+result);
    }
}

