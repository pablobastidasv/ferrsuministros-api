package co.pablobastidasv.products.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Product extends PanacheEntityBase {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;

  @NotBlank
  public String name;
  @NotNull
  public Integer quantity;

}
