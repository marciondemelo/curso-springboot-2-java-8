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

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Order() {
    }

    public Order(Instant moment, OrderStatus orderStatus, User client) {
        this.moment = moment;
        this.orderStatus = orderStatus.getCode();
        this.client = client;
    }
}
