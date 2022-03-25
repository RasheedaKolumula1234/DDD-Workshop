import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest {

    @Test
    void shouldAddIpadProAndHeroInkPenToTheCart() {
        Cart cart = new Cart();
        final Product ipad_pro = new Product("1", "Ipad Pro");
        final Product hero_ink_pen = new Product("2", "Hero Ink Pen");
        cart.add(ipad_pro);
        cart.add(hero_ink_pen);
        assertEquals("Ipad Pro", cart.getProducts().get(0).getName());
        assertEquals("Hero Ink Pen", cart.getProducts().get(1).getName());
    }

}
