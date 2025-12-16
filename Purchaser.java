public class Purchaser extends Thread{
    private static int nextId = 1;
    private int id;
    private int itemsProcessed;
    private int itemsToProcess;
    private Inventory queue;
    private Item item;

    Purchaser(Inventory queue, Item item, int itemsToProcess) {
        this.id = nextId++;
        this.itemsProcessed = 0;
        this.queue = queue;
        this.item = item;
        this.itemsToProcess = itemsToProcess;
    }

    @Override
    public void run() {
        for (int i = 0; i < itemsToProcess; i++ ) {
            queue.addItem(item);
            itemsProcessed++;
        }
        System.out.println("Purchaser " + id + " purchased " + itemsProcessed + " '" + item + "'." );
    }
}
