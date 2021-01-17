package co.pablobastidasv.products.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "transactions")
public class Transaction extends PanacheEntityBase {

  private static final Logger log = LoggerFactory.getLogger(Transaction.class);

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "product_id")
  public Product product;
  @NotNull
  public Integer quantity;
  @Enumerated(STRING)
  public Type type;

  @PostPersist
  public void postPersist() {
    log.debug("updating product");
    Product product = Product.findById(this.product.id);
    product.quantity = type.operation.process(product, quantity);
  }

  public enum Type {
    WITHDRAW((p, t) -> p.quantity - t),
    ENTRY((p, t) -> p.quantity + t);

    private final TransactionOperation operation;

    Type(TransactionOperation operation) {
      this.operation = operation;
    }

    public TransactionOperation operation() {
      return operation;
    }
  }

  @FunctionalInterface
  public interface TransactionOperation {
    Integer process(Product product, Integer transactionQuantity);
  }
}
