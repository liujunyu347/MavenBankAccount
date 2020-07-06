import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {

    @Test
    public void positive()
    {
        Account a = new Account("TestPositive");
        assertTrue(a.deposit(1) );
        assertTrue(a.deposit(10000) );
        assertTrue(a.withdraw(5) );
    }

    @Test
    public void negative()
    {
        Account a = new Account("TestNegative");
        assertTrue(a.deposit(1) );
        assertTrue(a.deposit(10000) );
        assertTrue(a.withdraw(5) );
        assertFalse(a.withdraw(50000) );
    }
}


