import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setup() {
        account = new BankAccount(100.0);
    }

    @Test
    public void testDepositIncreasesBalance() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance());
    }

    @Test
    public void testWithdrawDecreasesBalance() {
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance());
    }

    @Test
    public void testWithdrawWithInsufficientFundsThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(200.0));
    }

    @Test
    public void testNegativeDepositThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10.0));
    }

    @Test
    public void testNegativeWithdrawThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-5.0));
    }
}
