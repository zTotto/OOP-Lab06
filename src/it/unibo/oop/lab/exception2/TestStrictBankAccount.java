package it.unibo.oop.lab.exception2;

import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * JUnit test to test {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

	/**
	 * Used to test Exceptions on {@link StrictBankAccount}.
	 */
	@Test
	public void testBankOperations() {
		/*
		 * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a scelta,
		 * con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
		 * 
		 * 2) Effetture un numero di operazioni a piacere per verificare che le
		 * eccezioni create vengano lanciate soltanto quando opportuno, cioè in presenza
		 * di un id utente errato, oppure al superamento del numero di operazioni ATM
		 * gratuite.
		 */

		final AccountHolder MarioRossi = new AccountHolder("Mario", "Rossi", 1);
		final AccountHolder LuigiBianchi = new AccountHolder("Luigi", "Bianchi", 2);

		final BankAccount MaRo = new StrictBankAccount(1, 10000, 10);
		final BankAccount LuBi = new StrictBankAccount(2, 10000, 10);

		try {
			MaRo.withdraw(2, 5000);
			fail();
		} catch (WrongAccountHolderException e) {

		}

		try {
			MaRo.withdraw(1, 15000);
			fail();
		} catch (NotEnoughFundsException e) {

		}
		System.out.println("Mario Rossi's balance: " + MaRo.getBalance());

		try {
			for (int i = 0; i <= 10; i++) {
				LuBi.depositFromATM(2, 1000);
			}
			fail();
		} catch (TransactionsOverQuotaException e) {

		}
		
		System.out.println("Luigi Bianchi's balance: " + LuBi.getBalance());
	}
}
