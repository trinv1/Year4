package ie.atu.sw;

import java.security.Key;

//Explanation 3
//Runner now only depends on this interface and can work with any of the ciphers
//without changing client code, implementing loose coupling, improving flexibility and adhering to DIP

/*
 * USE:
 * Defines common methods all cyphers share
 */

public interface Cypherable {

	byte[] encrypt(byte[] plainText) throws Throwable;

	byte[] decrypt(byte[] cypherText) throws Throwable;

	byte[] encrypt(byte[] plainText, Key key) throws Throwable;

	byte[] decrypt(byte[] cypherText, Key key) throws Throwable;

}