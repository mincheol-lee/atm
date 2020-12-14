import java.util.Date;

public class Transaction {
	private String type;
	private int amount;
	private Date tranAt;
	private String tranNote;
	
	private BankIntegrator bi;

	public Transaction(String type, int amount, Date tranAt, String tranNote, BankIntegrator bi ) {
		this.type = type;
		this.amount = amount;
		this.tranAt = tranAt;
		this.tranNote = tranNote;
		this.bi = bi;
	}
	
	public Transaction(String type, Date tranAt, BankIntegrator bi ) {
		this.type = type;
		this.tranAt = tranAt;
		this.bi = bi;
	}
	
	public int getBalance(String accountId) {
		return this.bi.getBalance(accountId);
	}
	
	public Boolean doDeposit(String accountId, int amount) {
		return this.bi.doDeposit(accountId, amount);
	}
	
	public Boolean doWithdraw(String accountId, int amount) {
		return this.bi.doWithdraw(accountId, amount);
	}
	
}
