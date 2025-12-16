import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Inventory {
    private double balance = 0.0;
    private int itemsProcessed = 0;
    private List<Item> processingQueue;

    public Inventory() {
        processingQueue = new ArrayList<>();
    }
    public void addItem(Item Item) {
        processingQueue.add(Item);
    }
    public Item retrieveItem() {
        itemsProcessed++;
        if (!processingQueue.isEmpty()) {
            return processingQueue.remove(0);
        }
        return null;
    }
    public void incrementBalance(double amount) {
        balance += amount;
    }
    public double retrieveBalance() {
        return balance;
    }
    public int getQueueSize() {
        return processingQueue.size();
    }
    public int getItemsProcessed() {
        return itemsProcessed;
    }
}

