import java.util.ArrayList;
import java.util.HashMap;

public class BankIntegrator {
	
	private static BankIntegrator INSTANCE = null; 
	private String bankCode;
	private final String bankEndpoint = "https://samplebank.com/";
	private final String checkAction = "check";
	
	private BankIntegrator() {
		//load REST client config
	}
	
	private static Boolean checkConnection(String apiKey) {
		//check REST connection to bank
		return true;
		
	}
	
 	public static BankIntegrator getInstance(String apiKey) {
		if(INSTANCE == null && checkConnection(apiKey)) {
			
			INSTANCE = new BankIntegrator();
		}
		return INSTANCE;
	}
 	
 	public Boolean validatePin(String userId, int pin) {
 		//validate PIN number
 		return true;
 	}
 	
 	public HashMap<String,Account> getAccounts(String userId) {
 		//get account list from bank;
 		//assume it receives following account list given userId
 		
 		HashMap<String,Account> hm = new HashMap<String,Account>();
 		Account a = new Account("111","personal_checking", 100, "001", "checking");
 		Account b = new Account("222","personal_saving", 100, "001", "saving");
 		
 		hm.put("111", a);
 		hm.put("222", b);
 		
 		return hm;
 	}
 	
 	public int getBalance(String accountId) {
 		//get the balance of accountId
 		return 100;
 	}
 	
 	public Boolean doDeposit(String accountId, int amount) {
 		//deposit the amount to the account and return result
 		return true;
 	}
 	
 	public Boolean doWithdraw(String accountId, int amount) {
 		//withdraw the amount to the account and return result
 		return true;
 	}
	
}
