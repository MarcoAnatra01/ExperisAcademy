// Dichiarazione del pacchetto in cui si trova la classe.
package src.main;

// Importazioni delle classi necessarie dal Java SDK e dal package del progetto.
import src.main.service.CryptoUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

// Definizione della classe Client.
public class Client {
    // Variabile statica per memorizzare la chiave condivisa recuperata dal file di configurazione.
    private static String sharedSecret = getPSK("app.properties");

    // Metodo principale di esecuzione del client.
    public static void main(String[] args) {
        // Verifica se sono stati passati tre argomenti al programma.
        if (args.length != 3) {
            // Stampa un errore e termina se il numero di argomenti non è corretto.
            System.err.println("Usage: java Client <server-ip> <port> <username>");
            System.exit(1);
        }

        // Assegnazione dei valori degli argomenti a variabili locali.
        String serverIp = args[0];
        int port = Integer.parseInt(args[1]);
        String username = args[2];

        // Tentativo di stabilire una connessione al server e inizializzazione delle risorse.
        try (Socket socket = new Socket(serverIp, port);
                Scanner userInput = new Scanner(System.in);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            // Invio di un messaggio non criptato al server per notificare la connessione.
            out.println("[+1]" + username);

            // Messaggio all'utente che la connessione è stata stabilita.
            System.out.println("Connected to server. Start typing messages (type 'exit' to quit).");

            // Avvio di un nuovo thread per ascoltare i messaggi dal server.
            Thread serverListener = new Thread(() -> {
                try (Scanner in = new Scanner(socket.getInputStream())) {
                    // Ciclo di ascolto per i messaggi in arrivo dal server.
                    while (in.hasNextLine()) {
                        String message = in.nextLine();
                        // Gestione dei messaggi speciali non criptati dal server.
                        if (message.startsWith("[+]") || message.startsWith("[-]") || message.startsWith("[!]")) {
                            System.out.println(message);
                        } else {
                            // Tentativo di decriptare i messaggi criptati in arrivo.
                            try {
                                String decryptedMessage = CryptoUtils.decrypt(message, sharedSecret);
                                System.out.println(decryptedMessage);
                            } catch (Exception e) {
                                // Gestione degli errori in caso di fallimento della decriptazione.
                                System.out.println("Ricevuto messaggio non decriptabile");
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            // Avvio del thread di ascolto.
            serverListener.start();

            // Ciclo per leggere e inviare messaggi dall'utente al server.
            while (true) {
                String message = userInput.nextLine();
                // Verifica se l'utente vuole terminare la connessione.
                if (message.equalsIgnoreCase("exit")) {
                    // Invio di un messaggio non criptato per notificare la disconnessione.
                    out.println("[-1]" + username);
                    break;
                }
                // Criptazione e invio del messaggio all'utente.
                try {
                    String encryptedMessage = CryptoUtils.encrypt(username + ": " + message, sharedSecret);
                    out.println(encryptedMessage);
                } catch (Exception e) {
                    // Gestione degli errori di criptazione.
                    System.err.println("Errore nella crittografia del messaggio: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metodo per recuperare la chiave condivisa dal file di configurazione.
    private static String getPSK(String filename) {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(filename)) {
            // Caricamento delle proprietà dal file.
            prop.load(fis);
            // Restituzione del valore della chiave condivisa.
            return prop.getProperty("sharedSecret");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
