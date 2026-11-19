package ie.atu.sw;

import java.security.KeyPair;

/*
 * USE:
 * Actual implementation of encryption algorithms 
 */

import java.security.KeyPairGenerator;

import javax.crypto.Cipher;

public class RSACypher extends AbstractCypher {
	private KeyPair keyRing;		
	
	//Explanation 1
	//KeyPairGenerator - Declared inside constructor so its scope is only
	//at method level, making it a dependancy
	
	//keyRing - Its lifetimes bound to RSACypher object making it instance level scope
	
	//cypher - Its lifetimes bound to RSACypher object making it instance level scope
	
	public RSACypher() throws Throwable { //note to self - getInstance is a singleton
 		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(2048);
		keyRing = keyGen.generateKeyPair();
		super.setCypher(Cipher.getInstance("RSA/ECB/PKCS1Padding"));
	}

	@Override
	public byte[] encrypt(byte[] plainText) throws Throwable {
		return super.encrypt(plainText, keyRing.getPublic());
	}

	@Override
	public byte[] decrypt(byte[] cypherText) throws Throwable {
		return super.decrypt(cypherText, keyRing.getPrivate());

	}
}
