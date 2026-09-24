public class TestRocketCard {
    public static void main(String[] args) {
        RocketCard Card1 = new RocketCard(1001, "Alex Mercer", 250.00);
        RocketCard Card2 = new RocketCard(1002, "Brenda Vance", 120.50);
        RocketCard Card3 = new RocketCard(1003, "Charles Diaz", 45.00);

        Card1.printSummary();
        Card2.printSummary();
        Card3.printSummary();

        Card1.deposit(75.00);
        Card2.withdraw(40.00);
        Card3.withdraw(100.00);

        System.out.println("Rocket Cards Created: " + RocketCard.getTotalCardsCreated());

        Card1.printSummary();
        Card2.printSummary();
        Card3.printSummary();
    }
}
