public class Main {
    public static void main(String[] args) throws InterruptedException {
        Toy toy = new Toy();
        User user = new User(toy);

        Thread toyThread = new Thread(null, toy::switchOn, "Toy");
        Thread userThread = new Thread(null, user::switchOff, "User");

        userThread.start();
        toyThread.start();

        if (userThread.isInterrupted()) {
            toyThread.interrupt();
            System.out.println("Game over, toy wins:)");
        }
    }
}
