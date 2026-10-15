public class TestPolymorphism {
    public static void main(String[] args) {
        System.out.println("Step 1");
        RocketAccount acc1 = new StudentAccount(1001, "Alex Mercer", 250.00, 50);
        RocketAccount acc2 = new FacultyAccount(3001, "Dr. Kharel", 150.00, "EECS", 400.00);
        System.out.println("Declared: RocketAccount | Actual: StudentAccount");
        System.out.println("Declared: RocketAccount | Actual: FacultyAccount");
        System.out.println(acc1);
        System.out.println(acc2);

        System.out.println("Step 2");
        //Calling the line causes a compile error because getRewardPoints() isn't a method of RocketAccount
        if (acc1 instanceof StudentAccount) {
            StudentAccount s = (StudentAccount) acc1;
            s.addRewardPoints(25);
            System.out.println("Updated points: " + s.getRewardPoints());
        }
        if (acc1 instanceof FacultyAccount) {
            FacultyAccount f = (FacultyAccount) acc1;
            System.out.println("This print block will never run.");
        } else {
            System.out.println("[Shielded] acc1 is not a FacultyAccount.");
        }

        System.out.println("Step 3");
        Object obj1 = new RocketAccount(1001, "AlexMercer", 250.00);
        Object obj2 = new StudentAccount(1001, "Alex Mercer", 300.00, 75);
        Object obj3 = new RocketAccount(2001, "Campus Services", 500.00);
        boolean match1 = obj1.equals(obj2);
        System.out.println("obj1.equals(obj2) expected [true]: " + match1);
        boolean match2 = obj1.equals(obj3);
        System.out.println("obj1.equals(obj3) expected [false]: " + match2);

        System.out.println("Step 4");
        System.out.println("Processing transaction for Alex Mercer:");
        processAccountTransaction(acc1, 60.00);
        System.out.println("Processing transaction for Dr. Kharel:");
        processAccountTransaction(acc2, 200.00);

        System.out.println("Step 5");
        RocketAccount[] accounts = new RocketAccount[3];
        accounts[0] = new RocketAccount(2001, "Campus Services", 500.00);
        accounts[1] = new StudentAccount(1002, "Taylor Swift", 120.00, 30);
        accounts[2] = new FacultyAccount(3002, "Dr. Martinez", 80.00, "BioMed", 350.00);

        for (RocketAccount acc : accounts) {
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("Before Withdrawal -> " + acc);
            
            acc.withdraw(100.00); 
            
            System.out.println("After Withdrawal  -> " + acc);
        }
    }

    public static void processAccountTransaction(RocketAccount account, Double amount) {
        boolean success = account.withdraw(amount);
        if (success) {
            System.out.println("[Transaction Processed] New Balance: $" + account.getBalance());
        } else {
            System.out.println("[Transaction Denied]");
        }
    }
}

