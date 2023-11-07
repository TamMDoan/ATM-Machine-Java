import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTests {

    @Test
    public void testAccountDefaultConstructor(){
        Account account = new Account();

        assertNotNull(account);
    }

    @Test
    public void testAccountConstructor2(){
        int customerNumber = 123;
        int pinNumber = 1111;
        Account account = new Account(customerNumber, pinNumber);

        assertEquals(customerNumber, account.getCustomerNumber());
        assertEquals(pinNumber, account.getPinNumber());
    }

    @Test
    public void testAccountConstructor3(){
        int customerNumber = 123;
        int pinNumber = 1111;
        double checkingBalance = 100000.00;
        double savingBalance = 12345.67;

        Account account = new Account(customerNumber, pinNumber, checkingBalance, savingBalance);

        assertEquals(customerNumber, account.getCustomerNumber());
        assertEquals(pinNumber, account.getPinNumber());
        // guess delta is how many decimal places?
        assertEquals(checkingBalance, account.getCheckingBalance(),2);
        assertEquals(savingBalance, account.getSavingBalance(),2);

    }

    @Test
    public void testSetCustomerNumber(){
        int customerNumber = 123;
        Account account = new Account();
        account.setCustomerNumber(123);

        int actual = account.getCustomerNumber();

        assertEquals(customerNumber, actual);
    }

    @Test
    public void testSetPinNumber(){
        int pinNumber = 1234;
        Account account = new Account();
        account.setPinNumber(pinNumber);

        int actual = account.getPinNumber();

        assertEquals(pinNumber, actual);

    }


}
