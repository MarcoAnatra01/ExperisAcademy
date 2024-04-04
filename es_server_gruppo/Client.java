package es_server_gruppo;

// Importazione delle classi necessarie per I/O e networking.
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// Definizione della classe Client.
public class Client {
    // Metodo main, punto di ingresso dell'applicazione client.
    public static void main(String[] args) {
        // Controlla se sono stati passati esattamente tre argomenti (IP server, porta,
        // username).
        if (args.length != 3) {
            // Se non sono presenti esattamente tre argomenti, stampa un messaggio di errore
            // e termina.
            System.err.println("Usage: java Client <server-ip> <port> <username>");
            System.exit(1);
        }

        // Estrazione degli argomenti: IP del server, porta e username.
        String serverIp = args[0]; // IP del server.
        int port = Integer.parseInt(args[1]); // Porta di connessione al server, convertita in un intero.
        String username = args[2]; // Username dell'utente.

        // Tentativo di stabilire una connessione al server e di configurare gli stream
        // di input/output.
        try (Socket socket = new Socket(serverIp, port); // Crea un socket per connettersi al server.
            Scanner userInput = new Scanner(System.in); // Scanner per leggere l'input dell'utente da console.

            // PrintWriter per inviare messaggi al server, con auto-flush attivato
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) { 

            // passa la variabile username al server (serve al server per notificare la connessione)
            out.println(username);  

            // Messaggio che indica la connessione riuscita al server.
            System.out.println("Connected to server. Start typing messages (type 'exit' to quit).");

            // Creazione e avvio di un nuovo thread per ascoltare i messaggi dal server.
            Thread serverListener = new Thread(() -> {
                try (Scanner in = new Scanner(socket.getInputStream())) { // Scanner per leggere i messaggi in entrata dal server.
                     
                    // Continua a leggere finché ci sono messaggi.
                    while (in.hasNextLine()) { 
                        String message = in.nextLine();  // messaggio ricevuto dal server 

                        if (isEncrypted(message)) {  // verifico se il messaggio ricevuto è un messaggio criptato 
                            // se è criptato, uso il metodo per decifrarlo
                            message = decryptMessage(message);
                        }
                        System.out.println(message); 
                    }
                } catch (IOException e) { // Cattura eccezioni di I/O.
                    e.printStackTrace(); // Stampa lo stack trace dell'eccezione.
                }
            });
            serverListener.start(); // Avvia il thread che ascolta i messaggi dal server.


            boolean encryptionEnabled = false;
            String message = "";
            
            // Ciclo principale per l'invio di messaggi al server.
            while (true) {
                System.out.println("\nDigita:");
                System.out.println("/enigma on, se vuoi cifrare il messaggio");
                System.out.println("/enigma off, se non vuoi cifrare");
                String input = userInput.nextLine();

                if (input.equalsIgnoreCase("/enigma on")) {
                    encryptionEnabled = true;
                    continue;
                }

                if (input.equalsIgnoreCase("/enigma off")) {
                    encryptionEnabled = false;
                    continue;
                }

                if (encryptionEnabled) {  
                    // legge il messaggio da console 
                    // cifra il messaggio e aggiunge il prefisso [ENCRYPTED] prima di inviarlo
                    message = userInput.nextLine(); 
                    message = "[ENCRYPTED] " + encryptMessage(message);
                }

                out.println(username + ": " + message);  // Invia il messaggio al server, preceduto dall'username.
                if (message.equalsIgnoreCase("exit")) { // Se il messaggio è "exit", interrompe il ciclo.
                    break;
                }
            }

        } catch (IOException e) { // Cattura eccezioni di I/O.
            e.printStackTrace(); // Stampa lo stack trace dell'eccezione.
        }
    } // chiusura main


    // metodi per cifratura/decifratura tramite EnigmaSimulator
    private static String encryptMessage(String message) {
        try {
            // istanzio EnigmaSimulator per poter usare i suoi metodi
            EnigmaSimulator enigma = new EnigmaSimulator();
            return enigma.cifraDecifra(message, true);  // true significa che il metodo cifra 
        } catch (IOException e) {
            e.printStackTrace();
        }
        // se la cifratura fallisce, ritorno il messaggio originale 
        return message; 
    }

    private static String decryptMessage(String message) {
        try {
            EnigmaSimulator enigma = new EnigmaSimulator();
            return enigma.cifraDecifra(message, false);  // false significa che il metodo decifra
        } catch (IOException e) {
            e.printStackTrace();
        }
        // se la decifratura fallisce, ritorno il messaggio originale 
        return message; 
    }

    // metodo che verifica se il messaggio e criptato verificando se inizia con [ENCRYPTED]
    private static boolean isEncrypted(String message) {
        return message.startsWith("[ENCRYPTED]");
    }
}
