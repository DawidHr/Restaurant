package com.dawidhr.restaurant.model;

import com.dawidhr.restaurant.dto.OrderDto;
import jakarta.persistence.*;
import lombok.*;
import org.aspectj.weaver.ast.Or;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name="update_date")
    private LocalDateTime updateDate;
    private String status;
    private long tableId;
    private double totalPrice;

    @OneToMany
    private List<OrderItem> items = new ArrayList<>();


    public static Order create(OrderDto orderDto) {
        return Order.builder()
                .status("New")
                .tableId(orderDto.getTableId())
                .build();
    }

    public void addItem(OrderItem orderItem) {
        if (this.items == null)
            this.items = new ArrayList<>();

        this.items.add(orderItem);
        addToTotalPrice(orderItem.getPrice());
    }

    private void addToTotalPrice(double price) {
        setTotalPrice(getTotalPrice()+price);
    }
}
