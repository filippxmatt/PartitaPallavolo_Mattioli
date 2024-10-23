/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mattioli_partitapallavolo;

/**
 *  
 * @author filippo mattioli
 */
public class Giocatore implements Runnable{
    private int IdGiocatore;
    private int nPassaggi;
    
      public Giocatore(int IdGiocatore){
          this.IdGiocatore = IdGiocatore;
          this.nPassaggi = 0;
      }
   
      
    public int getIdGiocatore(){
        return this.IdGiocatore;
    }
    
    
    public void run() {
        
  while(true){
      nPassaggi++;
      System.out.println("id giocatore: "+IdGiocatore+" numero passaggi: "+nPassaggi + "\n");
      Thread.currentThread().yield();
      
  }
}  
}  