package encryption;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import encryption.Encrypter;

public class EncrypterTest {

	@Test
	public void encDesTest() { 
		String enId = Encrypter.encode("ndap");
		String desId = Encrypter.decode(enId);

		assertEquals("rhwqKQT5Cs01jRPewupjYA==", enId);
		assertEquals("ndap", desId);
	}
}
