package decryptme;

import java.util.HashMap;

public class CipherDB {

	private static CipherDB cdb = new CipherDB();
	
	public static CipherDB getInstance () {
		return cdb;
	}
	
	
	private HashMap<String, String> ciphers;
	
	
	private CipherDB() {
		ciphers = new HashMap<String, String>();
	}
	
	/**
	 * 
	 * @param plaintext
	 * @param cipher
	 * @return true if successful, false otherwise
	 */
	public boolean addCipher(String plaintext, String cipher) {
		return ciphers.put(plaintext, cipher) != null;
	}
	
	/**
	 * 
	 * @param plaintext
	 * @return assigned cipher if found, otherwise empty string
	 */
	public String getCipher(String plaintext) {
		String c = ciphers.get(plaintext);
		return (c != null) ? c : "";
	}
	
	/**
	 * 
	 * @param p plaintext to remove from dataset
	 * @return true if p was in the dataset, or false if it wasn't
	 */
	public boolean removeCipher(String p) {
		return ciphers.remove(p) != null;
	}
	


}
