package ie.atu.sw;

//Explanation 4
//Keeping cipher creation to CypherFactory, seperates concerns and makes the code more flexible.
//Runner just calls getInstance, so new ciphers can be changed or added without editig client code.
//This adheres to SRP as CypherFactory has 1 responsibility 
//And OCP as Runner doesnt need to be modified when new cipher type is added, only factory is extended

/*
 * USE: 
 * Decides which subclass to return
 */

public class CypherFactory {
	private static CypherFactory cf = new CypherFactory();
	
	private CypherFactory() {
		
	}
	
	public static CypherFactory getInstance() {
		return cf;
	}
	
	public Cypherable getCypher(CypherType type) throws Throwable{ 
		
		return switch(type) {
			case DES -> new SymmetricCypher("DES", 56, "DES/ECB/PKCS5Padding");
			case TripleDES -> new SymmetricCypher("DESede", 168, "DESede/ECB/PKCS5Padding");
			case RSA -> new RSACypher();
			default -> new SymmetricCypher("AES", 128, "AES/ECB/PKCS5Padding");
		};
		
	}

}
