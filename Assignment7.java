import java.util.Scanner;

public class Assignment7 {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Item Tshirt = new Item();
        Tshirt.description = "T-shirt";
        Tshirt.cost = 6.50;

        Item Sweater = new Item();
        Sweater.description = "Sweater";
        Sweater.cost = 8.50;

        Item Sweatpants = new Item();
        Sweatpants.description = "Sweatpants";
        Sweatpants.cost = 10.00;

        Item Skirt = new Item();
        Skirt.description = "Skirt";
        Skirt.cost = 25.50;

        Item Dress = new Item();
        Dress.description = "Dress";
        Dress.cost = 15.50;

        Scanner sc = new Scanner(System.in);

        Item[] items = {Tshirt, Sweater, Sweatpants, Skirt, Dress};

        Purchaser[] purchasers = new Purchaser[5];

        System.out.println("[Order Queue Simulator] ");

        for (int i = 0; i < items.length; i++) {
            System.out.print("Purchase how many " + items[i].description + " at $" + items[i].cost + "? " );
            int quantity = sc.nextInt();

            purchasers[i] = new Purchaser(inventory, items[i], quantity);
        }

        sc.nextLine();
        System.out.println("Purchasers created. Press 'enter' to start purchases...");
        sc.nextLine();

        System.out.println("Purchases have started working...");

        for (Purchaser purchaser : purchasers) {
            purchaser.start();
        }

        for (Purchaser purchaser : purchasers) {
            try {
                purchaser.join();
            } catch (InterruptedException e) {
                System.out.println("A thread was interrupted.");
            }
        }
        System.out.println("Purchasers are done working. A total of " + inventory.getQueueSize() + " items are awaiting processing. \n");

        System.out.print("Create how many processors? ");
        int amount = sc.nextInt();

        Processor[] processors = new Processor[amount];

        for (int i = 0; i < amount; i++) {
            processors[i] = new Processor(inventory);
        }

        sc.nextLine();
        System.out.println("Order Processors created. Press 'enter' to start processing orders...");
        sc.nextLine();

        System.out.println("Processors are now working...");

        for (Processor processor : processors) {
            processor.start();
        }

        for (Processor processor : processors) {
            try {
                processor.join();
            } catch (InterruptedException e) {
                System.out.println("A thread was interrupted.");
            }
        }
        System.out.println("All OrderProcessors are done processing orders. \n");
        System.out.println(inventory.getItemsProcessed() + " items were processed for a total of $" + inventory.retrieveBalance());
        System.out.println("Simulation complete.");
    }
    }