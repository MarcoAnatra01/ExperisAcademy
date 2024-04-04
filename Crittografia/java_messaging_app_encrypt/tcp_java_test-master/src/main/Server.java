// Dichiarazione del pacchetto in cui si trova la classe.
package src.main;

// Importazione delle classi necessarie per l'input/output e la gestione delle connessioni di rete.
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Definizione della classe Server.
public class Server {
    // Costante che definisce la porta su cui il server ascolta le connessioni.
    private static final int PORT = 8000;
    // Insieme di writer per inviare messaggi ai client connessi.
    private static Set<PrintWriter> clientWriters = new HashSet<>();

    // Metodo principale di esecuzione del server.
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            // Stampa a console dell'avvio del server sulla porta specificata.
            System.out.println("Server avviato sulla porta " + PORT);
            while (true) {
                // Accetta connessioni in entrata e avvia un nuovo thread per gestire ciascun client.
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Classe interna privata che gestisce le connessioni dei client.
    private static class ClientHandler extends Thread {
        // Socket del client connesso.
        private Socket clientSocket;
        // Writer per inviare messaggi al client.
        private PrintWriter out;
        // Username del client, inizializzato dopo la ricezione del messaggio di connessione.
        private String username;

        // Costruttore che inizializza il socket del client.
        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // Scanner per leggere i messaggi in arrivo dal client.
                Scanner in = new Scanner(clientSocket.getInputStream());
                // Inizializzazione del writer per inviare messaggi al client.
                out = new PrintWriter(clientSocket.getOutputStream(), true);

                while (true) {
                    // Lettura del messaggio in arrivo.
                    String message = in.nextLine();
                    // Gestione dei messaggi speciali per connessione e disconnessione.
                    if (message.startsWith("[+1]")) {
                        // Estrazione dell'username e aggiunta del writer all'insieme dei client connessi.
                        username = message.substring(4);
                        clientWriters.add(out);
                        // Broadcast della notifica di connessione.
                        broadcast_connect(username, clientSocket.getInetAddress().getHostAddress(), clientWriters.size());
                        continue;
                    } else if (message.startsWith("[-1]")) {
                        // Estrazione dell'username per la notifica di disconnessione.
                        username = message.substring(4);
                        // Broadcast della notifica di disconnessione.
                        broadcast_disconnect(username, clientWriters.size() - 1); // Si presume la rimozione dopo il broadcast.
                        break;
                    } else if (message.equalsIgnoreCase("exit")) {
                        // Interruzione del ciclo in caso di messaggio "exit".
                        break;
                    }
                    // Broadcast del messaggio a tutti i client connessi.
                    broadcast(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
                
            } finally {
                // Rimozione del writer dall'insieme dei client connessi e chiusura del socket.
                if (out != null) {
                    clientWriters.remove(out);
                }
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    broadcast_disconnect(this.username, clientWriters.size() - 1);
                }
            }
        }

        // Metodo per inviare un messaggio a tutti i client connessi.
        private void broadcast(String message) {
            for (PrintWriter writer : clientWriters) {
                writer.println(message);
            }
        }

        // Metodo per inviare una notifica di connessione a tutti i client connessi.
        private void broadcast_connect(String username, String ip, int active_hosts) {
            for (PrintWriter writer : clientWriters) {
                writer.println("[+]" + username  + " si è connesso dall'ip " + ip + ", gli host attualmente connessi sono " + active_hosts);
            }
        }

        // Metodo per inviare una notifica di disconnessione a tutti i client connessi.
        private void broadcast_disconnect(String username, int active_hosts) {
            for (PrintWriter writer : clientWriters) {
                writer.println("[-]" + username + " si è disconnesso, gli host attualmente connessi sono " + active_hosts);
            }
        }

    }
}
