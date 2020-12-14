import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {


	@Test
	void testValidatePin() {
		User u = new User("apikey_123","001");
		assertTrue("test validatePin", u.validatePin(123));
	}

	@Test
	void testGetAccounts() {
		User u = new User("apikey_123","001");
		u.validatePin(123);
		HashMap<String,Account> hm = u.getAccounts();	
		assertEquals("001", hm.get("111").getAccountHolderId().toString(), "test getAccount");
	}

	@Test
	void testGetBalance() {
		User u = new User("apikey_123","001");
 		HashMap<String,Account> hm = new HashMap<String,Account>();
 		Account a = new Account("111","personal_checking", 100, "001", "checking");
 		Account b = new Account("222","personal_saving", 100, "001", "saving");
 		hm.put("111", a);
 		hm.put("222", b);
 		u.setAccounts(hm);
 		
		assertEquals(100, u.getBalance("111"), "test getBalance");
	}

	@Test
	void testDoDeposit() {
		User u = new User("apikey_123","001");
 		HashMap<String,Account> hm = new HashMap<String,Account>();
 		Account a = new Account("111","personal_checking", 100, "001", "checking");
 		Account b = new Account("222","personal_saving", 100, "001", "saving");
 		hm.put("111", a);
 		hm.put("222", b);
 		u.setAccounts(hm);
 		
		assertEquals(100, u.getBalance("111"), "test doDeposit");
	}

	@Test
	void testDoWithdraw() {
		User u = new User("apikey_123","001");
 		HashMap<String,Account> hm = new HashMap<String,Account>();
 		Account a = new Account("111","personal_checking", 100, "001", "checking");
 		Account b = new Account("222","personal_saving", 100, "001", "saving");
 		hm.put("111", a);
 		hm.put("222", b);
 		u.setAccounts(hm);
 		
		assertEquals(100, u.getBalance("111"), "test doWithdraw");
	}

}
