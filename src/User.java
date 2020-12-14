import java.util.ArrayList;
import java.util.HashMap;

public class User {
	private String firstName;
	private String lastName;
	private String userId;
	private Boolean valid;
	private HashMap<String, Account> accounts;
	private BankIntegrator bi;
	
	public User(String apiKey, String userId) {
		this.bi = BankIntegrator.getInstance(apiKey);
		this.userId = userId;
	}
	
	public Boolean validatePin(int pin) {
		if(bi != null) {
			return this.valid = bi.validatePin(this.userId, pin);
		}
		return false;
	}
	
	public HashMap<String,Account> getAccounts() {
		if(valid) {
			return this.accounts = bi.getAccounts(this.userId);
		}
		return null;
	}
	
	public int getBalance(String accountId) {
		return this.accounts.get(accountId).getBalance(this.bi);
	}
	
	public synchronized int doDeposit(String accountId, int amount, String note) {
		return this.accounts.get(accountId).doDeposit(amount, note, this.bi);
	}
	
	public synchronized int doWithdraw(String accountId, int amount, String note) {
		return this.accounts.get(accountId).doWithdraw(amount, note, this.bi);
	}
	
	public void setAccounts(HashMap<String, Account> hm) {
		this.accounts = hm;
	}
}
