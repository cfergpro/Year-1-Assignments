public class StudentAccount extends RocketAccount {
    private Integer rewardPoints;

    public StudentAccount(Integer accountID, String name, Double balance, Integer rewardPoints) {
        super(accountID, name, balance);
        this.rewardPoints = (rewardPoints != null && rewardPoints >= 0) ? rewardPoints : 0;

    }

    public Integer getRewardPoints() {
        return this.rewardPoints != null ? this.rewardPoints : 0;
    }

    public void setRewardPoints(Integer rewardPoints) {
        this.rewardPoints = (rewardPoints != null && rewardPoints >= 0) ? rewardPoints : 0;
    }

    public void addRewardPoints(Integer points) {
        if (points != null && points > 0) {
            this.rewardPoints += points;
        }
    }

    @Override public boolean withdraw(Double amount) {
        boolean success = super.withdraw(amount);

        if (success) {
            int earned = (int) (amount / 10);
            addRewardPoints(earned);
            System.out.println("Earned: " + earned + " Total: " + getRewardPoints());
            return true;
        }

        return false;
    }

    @Override public String toString() {
        return super.toString() + "Reward points: " + getRewardPoints();
    }


}
