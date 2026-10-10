import java.util.ArrayList;
import java.util.Iterator;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version 7.0
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stockList;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stockList = new ArrayList<>();
        addProduct(new Product(1, "egg"));
        addProduct(new Product(2, "banana"));
        addProduct(new Product(80, "milk"));
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        if(findProduct(item.getID()) == null) {
            stockList.add(item);
        }
        else {
            System.out.println("Product has same ID");
        }
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product P = findProduct(id);
        if (findProduct(id) != null) {
            P.increaseQuantity(amount);
        }
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        Iterator<Product> it = stockList.iterator();
        while(it.hasNext()){
            Product P = it.next();
            if (P.getID() == id) {
                return P;
            }
        }
        return null;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        Product P = findProduct(id);
        if (P != null) {
            return P.getQuantity();
        }
        else {
            return 0;
        }
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        Iterator<Product> it = stockList.iterator();
        while(it.hasNext()){
            Product P = it.next();
            System.out.println(P.toString());
        }   
    }
    
    public Product findProduct(String name) {
        Iterator<Product> it = stockList.iterator();
        while(it.hasNext()){
            Product P = it.next();
            if (P.getName().equals(name)) {
                return P;
            }
        }
        return null;
    }
    
    public void lowProductDetails() {
        Iterator<Product> it = stockList.iterator();
        while(it.hasNext()){
            Product P = it.next();
            if (P.getQuantity() <= 5) {
                System.out.println(P.toString());                
            }
        }
    }
}
