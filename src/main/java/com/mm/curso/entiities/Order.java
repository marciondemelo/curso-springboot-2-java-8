package com.mm.curso.entiities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mm.curso.entiities.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;
    private Integer orderStatus;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @Getter
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Order() {
    }

    public Order(Instant moment, OrderStatus orderStatus, User client) {
        this.moment = moment;
        this.orderStatus = orderStatus.getCode();
        this.client = client;
    }
}
