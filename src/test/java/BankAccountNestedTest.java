import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class BankAccountNestedTest {
    @Test
    @DisplayName("Withdraw 500 successfully")
    void withdraw() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 00 successfully")
    void deposit() {
        BankAccount bankAccount = new BankAccount(400, 0);
        bankAccount.deposit(500);
        assertEquals(900, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Withdraw will become negative")
    void testWithdrawNotStuckAtZero() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(800);
        assertNotEquals(0, bankAccount.getBalance());

    }

    @Test
    @DisplayName("Test activation account after creation")
    void testActive() {
        BankAccount bankAccount = new BankAccount(500, 0);
        assumingThat(bankAccount==null, ()-> assertTrue(bankAccount.isActive()));
    }

    @Test
    @DisplayName("Test set holder name")
    void testHolderNameSet() {
        BankAccount bankAccount = new BankAccount(500, 0);
        bankAccount.setHolderName("Hayk");
        assertNotNull(bankAccount.getHolderName());
    }

    @Test
    @DisplayName("Test that we can't withdraw below minimum")
    void testNoWithdrawBelowMinimum() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertThrows(RuntimeException.class, () -> bankAccount.withdraw(2000));

    }

    @Test
    @DisplayName("asdfghjkl")
    void testNoWithdrawAndDepositWithoutException() {
        BankAccount bankAccount = new BankAccount(500, -1000);

        assertAll(() -> bankAccount.deposit(200), () -> bankAccount.withdraw(450));

    }

    @Test
    void tesDepositTimeout() {
        BankAccount bankAccount = new BankAccount(400, 0);
        assertTimeout(Duration.ofNanos(10), ()-> bankAccount.deposit(200));

    }

    @Nested
    class WhenBalanceEqualsZero{

        @Test
        void testWithdrawMinimumBalanceIs0(){

            BankAccount bankAccount = new BankAccount(0, 0);
            assertThrows(RuntimeException.class, ()-> bankAccount.withdraw(500));
        }

        @Test
        void testWithdrawMinimumBalanceIsNegative1000(){
            BankAccount bankAccount = new BankAccount(0, -1000);
            bankAccount.withdraw(500);
            assertEquals(-500, bankAccount.getBalance());

        }
    }
}
