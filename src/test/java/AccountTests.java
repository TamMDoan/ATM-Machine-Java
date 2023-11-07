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

    @Test
    public void testCalcCheckingWithdraw(){
        int customerNumber = 123;
        int pinNumber = 1111;
        double checkingBalance = 100000.00;
        double savingBalance = 12345.67;
        double withdraw = 536.29;
        double expected = checkingBalance - withdraw;
        Account account = new Account(customerNumber, pinNumber, checkingBalance, savingBalance);

        double actual = account.calcCheckingWithdraw(withdraw);

        assertEquals(expected, actual, 2);
    }

    @Test
    public void testCalcSavingWithdraw(){
        int customerNumber = 123;
        int pinNumber = 1111;
        double checkingBalance = 100000.00;
        double savingBalance = 12345.67;
        double withdraw = 536.29;
        double expected = savingBalance - withdraw;
        Account account = new Account(customerNumber, pinNumber, checkingBalance, savingBalance);

        double actual = account.calcSavingWithdraw(withdraw);

        assertEquals(expected, actual, 2);
    }

    @Test
    public void testCalcCheckingDeposit(){
        int customerNumber = 123;
        int pinNumber = 1111;
        double checkingBalance = 100000.00;
        double savingBalance = 12345.67;
        double deposit = 536.29;
        double expected = checkingBalance + deposit;
        Account account = new Account(customerNumber, pinNumber, checkingBalance, savingBalance);

        double actual = account.calcCheckingDeposit(deposit);

        assertEquals(expected, actual, 2);
    }

    @Test
    public void testCalcSavingDeposit(){
        int customerNumber = 123;
        int pinNumber = 1111;
        double checkingBalance = 100000.00;
        double savingBalance = 12345.67;
        double deposit = 536.29;
        double expected = savingBalance + deposit;
        Account account = new Account(customerNumber, pinNumber, checkingBalance, savingBalance);

        double actual = account.calcSavingDeposit(deposit);

        assertEquals(expected, actual, 2);
    }

    @Test
    public void testCalcCheckTransfer(){
        int customerNumber = 123;
        int pinNumber = 1111;
        double checkingBalance = 100000.00;
        double savingBalance = 12345.67;
        double transfer = 536.29;
        double expected = savingBalance + transfer;
        Account account = new Account(customerNumber, pinNumber, checkingBalance, savingBalance);

        account.calcCheckTransfer(transfer);

        assertEquals(expected, account.getSavingBalance(), 2);
        assertEquals(checkingBalance - transfer, account.getCheckingBalance(), 2);
    }

    @Test
    public void testCalcSavingTransfer(){
        int customerNumber = 123;
        int pinNumber = 1111;
        double checkingBalance = 100000.00;
        double savingBalance = 12345.67;
        double transfer = 536.29;
        double expected = checkingBalance + transfer;
        Account account = new Account(customerNumber, pinNumber, checkingBalance, savingBalance);

        account.calcSavingTransfer(transfer);

        assertEquals(expected, account.getCheckingBalance(), 2);
        assertEquals(savingBalance - transfer, account.getSavingBalance(), 2);
    }

}
