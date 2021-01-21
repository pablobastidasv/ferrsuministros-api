package co.pablobastidasv.products.boundary.rest;

import co.pablobastidasv.products.entity.Product;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(paged = false)
public interface ProductsResource extends PanacheEntityResource<Product, Long> {

}
