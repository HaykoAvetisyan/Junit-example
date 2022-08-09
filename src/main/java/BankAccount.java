import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    private double balance;
    private double minimumBalance;

    private boolean isActive = true;

    private String holderName;

    public BankAccount(double balance, double minimumBalance) {
        this.balance = balance;
        this.minimumBalance = minimumBalance;
    }

    public double withdraw(double amount){
        if (balance-amount>minimumBalance){
            balance-=amount;
            return amount;
        }else {
            throw new RuntimeException();
        }
    }

    public double deposit(double amount){

        return balance+=amount;
    }


}
