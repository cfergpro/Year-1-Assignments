public class RocketCard{

    private int rocketid; String name; double balance; static int totalCardsCreated = 0;

    public RocketCard() {
        this.rocketid = 0;
        this.name = "Unknown";
        this.balance = 0.0;
    }

    public RocketCard(int rocketid, String name, double initialBalance) {
        this.rocketid = rocketid;
        this.name = name;

        if (initialBalance >= 0) {
            this.balance = initialBalance;
        }
        else {
            this.balance = 0.0;
        }

        totalCardsCreated++;
    }

    public int getRocketId() {
        return  rocketid;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public static int getTotalCardsCreated() {
        return totalCardsCreated;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
        else {
            System.out.println("[Error] Deposit must be positive.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("[Error] Withdrawal must be positive.");
            return false;
        }
        else if (amount > balance) {
            System.out.println("[Declined] Insufficient funds for " + name + ". Balance: $" + balance);
            return false;
        }
        else {
            balance -= amount;
            return true;
        }
    }

    public void printSummary() {
        System.out.printf("Rocket ID: %d | Holder: %s | Balance: $%f%n", rocketid, name, balance);
    }
}
