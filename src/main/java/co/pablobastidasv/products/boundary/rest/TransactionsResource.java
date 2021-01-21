package co.pablobastidasv.products.boundary.rest;

import co.pablobastidasv.products.entity.Transaction;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.ResourceProperties;
import io.quarkus.security.Authenticated;

@ResourceProperties
public interface TransactionsResource extends PanacheEntityResource<Transaction, Long> {
}
