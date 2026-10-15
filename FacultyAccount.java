public class FacultyAccount extends RocketAccount {
    private String department; private Double researchAllowance;

    public FacultyAccount(Integer accountID, String name, Double balance, String department, Double researchAllowance) {
        super(accountID, name, balance);
        this.department = (department != null) ? department : "General";
        this.researchAllowance = (researchAllowance != null && researchAllowance >= 0.0) ? researchAllowance : 0.0;
    }

    public String getDepartment() {
        return this.department != null ? this.department : "General";
    }

    public void setDepartment(String department) {
        this.department = (department != null) ? department : "General";
    }

    public Double getResearchAllowance() {
        return this.researchAllowance != null ? this.researchAllowance : 0.0;
    }

    public void setResearchAllowance(Double researchAllowance) {
        this.researchAllowance = (researchAllowance != null && researchAllowance >= 0.0) ? researchAllowance : 0.0;
    }

    public void grantResearchStipend(Double stipend) {
        if (stipend != null && stipend > 0.0) {
            this.researchAllowance += stipend;
        }
    }

    @Override public boolean withdraw(Double amount) {
        if (amount == null || amount <= 0) {
            System.out.println("[Error] Withdrawal must be positive.");
            return false;
        }
        if (amount <= getBalance()) {
            return super.withdraw(amount);
        }
        else if (getBalance() + getResearchAllowance() >= amount) {
            double deficit = amount - getBalance();
            setBalance(0.0);
            this.researchAllowance -= deficit;
            
            System.out.println("[Faculty Perk] Covered $" + String.format("%.2f", deficit) + " deficit using " + getDepartment() + " research allowance! Remaining allowance: $" + String.format("%.2f", getResearchAllowance()));
            return true;
        }
        else {
            System.out.println("[Declined] Total funds (Balance + Research Allowance: $" + String.format("%.2f", (getBalance() + getResearchAllowance())) + ") insufficient for " + getName() + ".");
            return false;
        }
    }

    @Override public String toString() {
        return super.toString() + " | Department: " + String.format("%-6s", getDepartment()) + " | Research Allowance: $" + String.format("%7.2f", getResearchAllowance());
    }
}
