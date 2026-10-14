public class RocketAccount {
    private Integer accountID; private String name; private Double balance;

    public RocketAccount() {
        this(0, "Unknown", 0.0);
    }

    public RocketAccount(Integer accountID, String name, Double balance) {
        if (accountID != null) {
            this.accountID = accountID;
        }
        else {
            this.accountID = 0;
        }

        if (name != null) {
            this.name = name;
        }
        else {
            this.name = "Unknown";
        }

        if (balance != null) {
            this.balance = balance;
        }
        else {
            this.balance = 0.0;
        }        
    }

    public Integer getAccountID() {
        if (this.accountID != null) {
            return this.accountID;
        }
        else {
            return 0;
        }
    }

    public String getName() {
        if (this.name != null) {
            return this.name;
        }
        else {
            return "Unknown";
        }
    }

    public Double getBalance() {
        if (this.balance != null) {
            return this.balance;
        }
        else {
            return 0.0;
        }   
    }

    public void setAccountID(Integer accountID) {
        if (accountID != null) {
            this.accountID = accountID;
        }
        else {
            this.accountID = 0;
        }
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
        else {
            this.name = "Unknown";
        }
    }

    public void setBalance(Double balance) {
        if (balance != null) {
            this.balance = balance;
        }
        else {
            this.balance = 0.0;
        }
    }

    public void deposit(Double amount) {
        if (amount != null && amount > 0) {
            this.balance += amount;
        }
        else {
            System.out.println("[Error] Deposit must be positive.");
        }
    }

    public boolean withdraw(Double amount) {
        if (amount == null || amount <= 0) {
            System.out.println("[Error] Withdrawal must be positive.");
            return false;
        }
        else if (amount > balance) {
            System.out.println("[Declined] Insufficient funds for " + this.name + ". Balance: $" + this.balance);
            return false;
        }
        else {
            this.balance -= amount;
            return true;
        }
    }

    public final String getAccountCategory() {
        return "GENERAL_ROCKET";
    }

    @Override public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RocketAccount)) {
            return false;
        }
        RocketAccount other = (RocketAccount) obj;
        return this.accountID != null && this.accountID.equals(other.accountID);
    }

    @Override public String toString() {
        return "Rocket ID: " + accountID + " |Name: " + String.format("%-15s", name) + " | Balance: $" + String.format("%7.2f", balance);
    }
}
