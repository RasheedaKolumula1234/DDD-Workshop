import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> products = new ArrayList<>();

    public void add(Product product) {
        this.products.add(product);
    }

    public List<Product> getProducts() {
        return this.products;
    }
}
