
public class CryptoManager {
	// this is the lower bound of the ascii range
	private static final char LOWER_BOUND = ' ';
	// this is the upper bound of the ascii range
	private static final char UPPER_BOUND = '_';
	// Range diffrence between the upper and lower
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII
	 * codes according to the LOWER_BOUND and UPPER_BOUND characters
	 * 
	 * @param plainText
	 *            a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any
	 *         character is outside
	 */
	public static boolean stringInBounds(String plainText) {
		// check if all the char in the string is in the bound and if it isn't then
		// returns false else true
		for (int i = 0; i < plainText.length(); i++) {

			if (!(plainText.charAt(i) >= LOWER_BOUND && plainText.charAt(i) <= UPPER_BOUND)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher. The integer key specifies
	 * an offset and each character in plainText is replaced by the character
	 * \"offset\" away from it
	 * 
	 * @param plainText
	 *            an uppercase string to be encrypted.
	 * @param key
	 *            an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		String result = "";
		for (int i = 0; i < plainText.length(); i++) {
			char ch = plainText.charAt(i);
			// add the key to char value
			ch = (char) (ch + key);
			// removes the range from the ch if it is not in range
			while (ch > UPPER_BOUND) {
				ch = (char) (ch - UPPER_BOUND + LOWER_BOUND - 1);
			}
			result += ch;
		}

		return result;
	}
	//

	/**
	 * Encrypts a string according the Bellaso Cipher. Each character in plainText
	 * is offset according to the ASCII value of the corresponding character in
	 * bellasoStr, which is repeated to correspond to the length of plainText
	 * 
	 * @param plainText
	 *            an uppercase string to be encrypted.
	 * @param bellasoStr
	 *            an uppercase string that specifies the offsets, character by
	 *            character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String result = "";
		// encrpts each char and adds it to create a bellaso encrpytion
		for (int i = 0; i < plainText.length(); i++) {
			result += encryptCaesar("" + plainText.charAt(i), (bellasoStr.charAt(i % bellasoStr.length())));
		}
		return result;
	}

	/**
	 * Decrypts a string according to the Caesar Cipher. The integer key specifies
	 * an offset and each character in encryptedText is replaced by the character
	 * \"offset\" characters before it. This is the inverse of the encryptCaesar
	 * method.
	 * 
	 * @param encryptedText
	 *            an encrypted string to be decrypted.
	 * @param key
	 *            an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {

		String result = "";
		// removes the key and removes the range range till in bounds
		for (int i = 0; i < encryptedText.length(); i++) {
			char ch = encryptedText.charAt(i);
			ch = (char) (ch - key);
			while (ch > UPPER_BOUND) {
				ch = (char) (ch - RANGE);

			}

			result += ch;
		}

		return result;
	}

	/**
	 * Decrypts a string according the Bellaso Cipher. Each character in
	 * encryptedText is replaced by the character corresponding to the character in
	 * bellasoStr, which is repeated to correspond to the length of plainText. This
	 * is the inverse of the encryptBellaso method.
	 * 
	 * @param encryptedText
	 *            an uppercase string to be encrypted.
	 * @param bellasoStr
	 *            an uppercase string that specifies the offsets, character by
	 *            character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {

		String result = "";
		for (int i = 0; i < encryptedText.length(); i++) {
			char ch = encryptedText.charAt(i);
			// ch = (char)((ch - bellasoStr.charAt(i%bellasoStr.length())+RANGE)
			// removes the key and removes range till in bounds
			ch = (char) ((ch - bellasoStr.charAt(i % bellasoStr.length()) + RANGE) % RANGE + RANGE);
			while (ch > UPPER_BOUND) {
				ch = (char) (ch - RANGE);

			}

			result += ch;
		}

		return result;
	}
}
