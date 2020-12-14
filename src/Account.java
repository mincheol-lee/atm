import java.util.ArrayList;
import java.util.Date;

public class Account {
	private String accountId;
	private String accountNickName;
	private int balance;
	private String accountHolderId;
	private String type;
	private ArrayList<Transaction> transactions;
	
	private final String DEPOSIT = "deposit";
	private final String WITHDRAW = "withdraw";
	private final String BALANCE = "balance";

	
	
	public Account(String accountId, String accountNickName, int balance, String accountHolderId, String type) {
		this.accountId = accountId;
		this.accountNickName = accountNickName;
		this.balance = balance;
		this.accountHolderId = accountHolderId;
		this.type = type;
		this.transactions = new ArrayList<Transaction>();
	}
	
	public int getBalance(BankIntegrator bi) {
		Transaction t = new Transaction(BALANCE, new Date(System.currentTimeMillis()), bi);
		this.balance = t.getBalance(this.accountId);
		transactions.add(t);

		return this.balance;
	}
	
	public int doDeposit(int amount, String note, BankIntegrator bi) {
		Transaction t = new Transaction(DEPOSIT, amount, new Date(System.currentTimeMillis()), note, bi);
		if(t.doDeposit(this.accountId, amount)) {
			this.balance = getBalance(bi);
			transactions.add(t);
		}
		return this.balance;
	}
	
	public int doWithdraw(int amount, String note, BankIntegrator bi) {
		Transaction t = new Transaction(WITHDRAW, amount, new Date(System.currentTimeMillis()), note, bi);
		if(t.doWithdraw(this.accountId, amount)) {
			this.balance = getBalance(bi);
			transactions.add(t);
		}
		return this.balance;
	}
	
	public String getAccountHolderId() {
		return this.accountHolderId;
	}
}
