package Server;


public abstract class ServerClient {

	private final String key = "cn5120!?";  // key for encryption/decryption
	private final String host = "localhost";
	private final int portNumber = 5000;
	private Algorithm alg = new Algorithm();

	/**
	 * Encrypt a message using homemade ECB
	 *
	 * @param m the message to be encrypted
	 * @return encrypted String
	 */
	protected String encryptMessage(String m) {
		int[] temp = alg.ECB(m, key, false);
		return alg.convertToString(temp);
	}

	/**
	 * Decrypt a message using homemade ECB
	 *
	 * @param m the message to be decrypted
	 * @return decrypted String
	 */
	protected String decryptMessage(String m) {
		int[] temp = alg.ECB(m, key, true);
		return alg.convertToString(temp);
	}

	// getter methods here..
	protected int getPortNumber() {
		return portNumber;
	}

	protected String getHost() {
		return host;
	}

}
