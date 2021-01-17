package co.pablobastidasv.products.boundary.rest;

import co.pablobastidasv.products.entity.Product;
import co.pablobastidasv.products.entity.Transaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
@Tag("integration")
public class ProductResourceIT {

  @Inject
  ProductResource productResource;

  @Test
  @DisplayName("Create a product")
  @Transactional
  void createAProduct() {
    Product p = new Product();
    p.name = "Fancy Name";
    p.quantity = 10;

    productResource.add(p);

    Transaction t = new Transaction();
    t.product = p;
    t.type = Transaction.Type.ENTRY;
    t.quantity = 15;

    t.persist();

    Product p2 = Product.findById(p.id);

    assertEquals(25, p2.quantity);
  }
}
