package co.pablobastidasv.products.boundary.rest;

import co.pablobastidasv.products.entity.Product;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(path = "products")
public interface ProductResource extends PanacheEntityResource<Product, Long> {


}
