package com.mm.curso.entiities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mm.curso.entiities.pk.OrderItemPK;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    public Product getProduct() {
        return id.getProduct();
    }

    public Double getSubTotal(){
        return price * quantity;
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
