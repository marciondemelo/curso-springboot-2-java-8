package com.mm.curso.entiities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mm.curso.entiities.pk.OrderItemPK;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@Getter
@Setter
@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

    @JsonIgnore
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;
    private Double price;

    public Product getProduct() {
        return id.getProduct();
    }

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        this.quantity = quantity;
        this.price = price;
        this.id.setOrder(order);
        this.id.setProduct(product);
    }
}
