Scopo del Progetto
Il progetto simula una partita di pallavolo virtuale tra due giocatori, implementati come thread. Ogni giocatore esegue passaggi infiniti, incrementando un contatore di passaggi ad ogni ciclo. Lo scopo è dimostrare l'uso dei thread in Java per simulare attività parallele con priorità differenti.

Classi Principali

1. Giocatore
   - Questa classe rappresenta un giocatore della partita di pallavolo. Ogni giocatore è un thread e può eseguire una serie di passaggi infiniti.
   - Attributi:
     - 'IdGiocatore': ID univoco per ogni giocatore.
     - 'nPassaggi': Contatore dei passaggi effettuati dal giocatore.
   
   - 'Metodo: 'run()'
     Il metodo 'run()' rappresenta il comportamento che verrà eseguito quando il thread del giocatore viene avviato. In un ciclo infinito, il numero di passaggi viene incrementato e stampato. L'uso di 'Thread.yield()' permette di dare la possibilità ad altri thread di eseguire.
     ```java
     public void run() {
         while(true) {
             nPassaggi++;
             System.out.println("id giocatore: " + IdGiocatore + " numero passaggi: " + nPassaggi);
             Thread.currentThread().yield();
         }
     }
     ```

2. PartitaPallavolo
   - Questa classe contiene il metodo `main` del progetto. Qui vengono inizializzati i giocatori e i thread che li rappresentano.
   
   - Metodo: 'main()'
     Il metodo 'main()' crea due istanze della classe 'Giocatore' e le avvia come thread. Viene impostata la priorità massima per il primo giocatore ('g1'), mentre per il secondo ('g2') viene dato un nome personalizzato al thread.
     ```java
     public static void main(String[] args) {
         Giocatore g1 = new Giocatore(1);  // Crea il giocatore 1
         Thread t1 = new Thread(g1);       // Crea il thread per il giocatore 1
         t1.setPriority(Thread.MAX_PRIORITY); // Imposta priorità massima
         System.out.println("id giocatore: " + g1.getIdGiocatore() + 
                            " priorità: " + t1.getPriority() + 
                            " nome: " + t1.getName());
         
         t1.start(); // Avvia il thread del giocatore 1
         
         Giocatore g2 = new Giocatore(2);  // Crea il giocatore 2
         new Thread(g2, "Menco").start();  // Avvia il thread del giocatore 2 con un nome personalizzato
     }
     ```

Librerie Utilizzate
Il progetto utilizza le librerie standard di Java:
- 'java.lang.Thread': utilizzata per creare e gestire i thread.

Scenari Alternativi e Gestione degli Errori
- Il metodo 'run()' esegue un ciclo infinito che continua a incrementare il numero di passaggi. Se uno dei thread viene interrotto, potrebbe terminare l'esecuzione.
- Il progetto non implementa alcuna gestione avanzata degli errori o scenari specifici di interruzione, poiché l'obiettivo principale è dimostrare l'esecuzione concorrente tra thread con priorità differenziate.

Commento sull'Esecuzione
Durante l'esecuzione:
1. Viene creato il primo giocatore ('g1') e assegnata una priorità massima al suo thread.
2. Successivamente, viene creato un secondo giocatore ('g2'), il cui thread ha un nome personalizzato ("Menco").
3. I thread dei giocatori iniziano ad eseguire simultaneamente, stampando il numero di passaggi che ciascun giocatore effettua in tempo reale.

L'esecuzione termina solo se il programma viene interrotto manualmente poiché i thread sono configurati per eseguire in loop infinito.
