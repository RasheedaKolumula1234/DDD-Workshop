import com.shopping.app.domain.model.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CartTest {

    @Test
    void shouldAddIpadProToTheCart() {
        Cart cart = new Cart("1234");
        final Product ipad_pro = new Product("Ipad Pro", new Price(BigDecimal.valueOf(100L), Currency.getInstance("INR")));
        CartItem cartItem = new CartItem(ipad_pro, 1);
        cart.add(cartItem);
        assertEquals("Ipad Pro", cart.getCartItems().get(0).getProduct().getName());
    }

    @Test
    void shouldAddHeroInkPenToTheCart() {
        Cart cart = new Cart("321434");
        final Product hero_ink_pen = new Product("Hero Ink Pen", new Price(BigDecimal.valueOf(100L), Currency.getInstance("INR")));
        CartItem cartItem = new CartItem(hero_ink_pen, 1);
        cart.add(cartItem);
        assertEquals("Hero Ink Pen", cart.getCartItems().get(0).getProduct().getName());
    }

    @Test
    void shouldAdd2GMCricketBatsToTheCart() {
        Cart cart = new Cart("213124");
        final Product gm_cricket_bat = new Product("GM Cricket Bat", new Price(BigDecimal.valueOf(100L), Currency.getInstance("INR")));
        CartItem cartItem = new CartItem(gm_cricket_bat, 2);
        cart.add(cartItem);
        assertEquals(2, cart.getCartItems().get(0).getQuantity());
        assertEquals("GM Cricket Bat", cart.getCartItems().get(0).getProduct().getName());
    }

    @Test
    void shouldRemoveIpadProFromTheCart() {
        Cart cart = new Cart("32423");
        final Product ipad_pro = new Product("Ipad Pro", new Price(BigDecimal.valueOf(100L), Currency.getInstance("INR")));
        CartItem cartItem = new CartItem(ipad_pro, 1);
        cart.add(cartItem);
        cart.remove(cartItem);
        assertTrue(cart.getCartItems().isEmpty());
    }

    @Test
    void shouldKnowWhatProductWasRemovedFromCart() {
        Cart cart = new Cart("34234325");
        final Product ipad_pro = new Product("Ipad Pro", new Price(BigDecimal.valueOf(100L), Currency.getInstance("INR")));
        final Product gm_cricket_bat = new Product("GM Cricket Bat", new Price(BigDecimal.valueOf(100L), Currency.getInstance("INR")));
        CartItem cartItem1 = new CartItem(ipad_pro, 1);
        CartItem cartItem2 = new CartItem(gm_cricket_bat, 1);
        cart.add(cartItem1);
        cart.add(cartItem2);
        cart.remove(cartItem1);
        assertEquals(List.of("Ipad Pro"), cart.getCartItemsRemoved());
    }

    @Test
    void shouldDifferentiateCartsEvenIfTheyHaveSameItemsInThem() {
        Cart cart1 = new Cart("34234325");
        Cart cart2 = new Cart("21312434");

        final Product ipad_pro = new Product("Ipad Pro", new Price(BigDecimal.valueOf(100L), Currency.getInstance("INR")));
        CartItem cartItem = new CartItem(ipad_pro, 1);

        cart1.add(cartItem);
        cart2.add(cartItem);
    }

    @Test
    void shouldBeAbleToSeePriceOfTheProductBeforeAddingToTheCart() {
        final Product ipad_pro = new Product("Ipad Pro", new Price(BigDecimal.valueOf(100L), Currency.getInstance("INR")));
        CartItem cartItem = new CartItem(ipad_pro, 1);
    }

    @Test
    void shouldCheckoutCart() {
        Cart cart = new Cart("34234325");

        final Product ipad_pro = new Product("Ipad Pro", new Price(BigDecimal.valueOf(100L), Currency.getInstance("INR")));
        CartItem cartItem = new CartItem(ipad_pro, 1);

        cart.add(cartItem);

        final Order order = cart.checkout();
        assertEquals(List.of(ipad_pro), order.getProducts());
        assertTrue(cart.isCheckedOut());
    }
}
