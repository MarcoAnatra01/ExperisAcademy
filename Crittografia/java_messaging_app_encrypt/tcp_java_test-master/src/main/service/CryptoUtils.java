// Dichiarazione del pacchetto in cui si trova la classe.
package src.main.service;

// Importazione delle classi necessarie per la crittografia.
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

// Definizione della classe pubblica CryptoUtils.
public class CryptoUtils {
    // Metodo statico per criptare una stringa con una chiave fornita.
    public static String encrypt(String data, String key) throws Exception {
        // Generazione della specifica della chiave crittografica dalla chiave fornita.
        SecretKeySpec keySpec = getKey(key);
        // Creazione dell'istanza del cifratore per l'algoritmo AES.
        Cipher cipher = Cipher.getInstance("AES");
        // Inizializzazione del cifratore per la modalità di criptazione.
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        // Criptazione dei dati e conversione in array di byte.
        byte[] encrypted = cipher.doFinal(data.getBytes());
        // Codifica dei dati criptati in una stringa Base64 per la trasmissione.
        return Base64.getEncoder().encodeToString(encrypted);
    }

    // Metodo ausiliario privato per generare una SecretKeySpec dalla chiave fornita.
    public static SecretKeySpec getKey(String myKey) throws Exception {
        byte[] key;
        MessageDigest sha = null;
        // Conversione della chiave in array di byte utilizzando la codifica UTF-8.
        key = myKey.getBytes("UTF-8");
        // Creazione di un digest SHA-256 dalla chiave.
        sha = MessageDigest.getInstance("SHA-256");
        key = sha.digest(key);
        // Ridimensionamento dell'array di byte per adattarsi a AES-128.
        key = Arrays.copyOf(key, 16);
        // Creazione di una nuova SecretKeySpec per AES utilizzando l'array di byte ridimensionato.
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        return secretKeySpec;
    }

    // Metodo statico per decriptare una stringa criptata con una chiave fornita.
    public static String decrypt(String encryptedData, String key) throws Exception {
        // Generazione della specifica della chiave crittografica dalla chiave fornita.
        SecretKeySpec keySpec = getKey(key);
        // Creazione dell'istanza del cifratore per l'algoritmo AES.
        Cipher cipher = Cipher.getInstance("AES");
        // Inizializzazione del cifratore per la modalità di decriptazione.
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        // Decriptazione dei dati dalla loro forma Base64 e ritorno alla forma originale.
        byte[] original = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(original);
    }
}
