
public class TestBlockchain {
	public static void main(String args[]) {
		
		Blockchain bitCoin = new Blockchain();
		
		Block a = new Block("0x200", new java.util.Date(), "<transactions>");
		Block b = new Block("0x200", new java.util.Date(), "<transactions>");
		Block c = new Block("0x200", new java.util.Date(), "<transactions>");
		
		bitCoin.addBlock(a);
		bitCoin.addBlock(b);
		bitCoin.addBlock(c);
		
		//bitCoin.getLatestBlock().setPreviousHash("ABCDEFG");
		
		bitCoin.displayChain();
		
		bitCoin.isValid();

	}
}
