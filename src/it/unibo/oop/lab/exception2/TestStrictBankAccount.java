package it.unibo.oop.lab.exception2;

import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	BankAccount b1 = new StrictBankAccount(1, 10_000d, 10);
    	BankAccount b2 = new StrictBankAccount(2, 10_000d, 10);
    	AccountHolder marioRossi = new AccountHolder("Mario", "Rossi", 1);
    	AccountHolder luigiBianchi = new AccountHolder("Luigi", "Bianchi", 2);
    	
    	try {
			b1.withdraw(marioRossi.getUserID(), 5_000d);
			b1.withdraw(marioRossi.getUserID(), 20_000d);
		} catch (NotEnoughFoundsException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
    	
    	try {
			b2.deposit(3, 500);
		} catch (WrongAccountHolderException e) {
			// TODO Auto-generated catch block
			e.getMessage();	
		}
    	
    	for (int i = 1 ; i <= 5; i++) {
    		b2.depositFromATM(luigiBianchi.getUserID(), 500);
    	}
    	
    	try {
			b2.depositFromATM(luigiBianchi.getUserID(), 500);
		} catch (TransactionOverQuotaException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
    	
    	
    	


    }
}
