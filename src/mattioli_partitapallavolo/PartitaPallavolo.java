/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package mattioli_partitapallavolo;

/**
 *
 * @author filippo mattioli
 */
public class PartitaPallavolo {

    public static void main(String[] args) {
        Giocatore g1 = new Giocatore(1);  //no thread
        Thread t1 = new Thread(g1); //thread
        t1.setPriority(Thread.MAX_PRIORITY);
        System.out.println("id giocatore: "+g1.getIdGiocatore()+"priorità: "+t1.getPriority()+"nome: :"+t1.getName());
        
        t1.start();
        Giocatore g2 = new Giocatore(2); //no thread
        new Thread(g2, "Menco").start(); //thread
    }
}