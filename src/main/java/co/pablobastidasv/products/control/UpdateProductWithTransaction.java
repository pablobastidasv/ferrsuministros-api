package co.pablobastidasv.products.control;

import co.pablobastidasv.products.entity.Product;
import co.pablobastidasv.products.entity.Transaction;

import javax.transaction.Transactional;

public class UpdateProductWithTransaction {

  @Transactional
  public void execute(TransactionUpdatedEvent event){
    Product product = Product.findById(event.productId);

    product.quantity = event.operation.process(product, event.transactionQuantity);

    product.flush();
  }

  public static class TransactionUpdatedEvent {
    public final int productId;
    public final int transactionQuantity;
    public final Transaction.TransactionOperation operation;

    public TransactionUpdatedEvent(int productId, int transactionQuantity, Transaction.TransactionOperation operation) {
      this.productId = productId;
      this.transactionQuantity = transactionQuantity;
      this.operation = operation;
    }
  }

}
