import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

public class Block {
	private String version;
	private Date Timestamp;
	private String hash;
	private String previousHash;
	private String data;
	
	public Block(String version, Date Timestamp, String data) {
		this.version = version;
		this.Timestamp = Timestamp;
		this.hash = computeHash();
		//this.previousHash = null;
		this.data = data;
	}
	public String computeHash() {
		//https://www.freeformatter.com/sha256-generator.html#sha256-explained	
		String dataToHash = "" + this.version + this.Timestamp + this.previousHash + this.data;
		
		MessageDigest digest;
		String encoded = null;
		
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(dataToHash.getBytes(StandardCharsets.UTF_8));
			encoded = Base64.getEncoder().encodeToString(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		this.hash = encoded;
		return encoded;
			
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Date getTimeStamp() {
		return Timestamp;
	}
	public void setTimeStamp(Date Timestamp) {
		this.Timestamp = Timestamp;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getPreviousHash() {
		return previousHash;
	}
	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}
