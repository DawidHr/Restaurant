package com.dawidhr.restaurant.model;

import com.dawidhr.restaurant.dto.OrderDto;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
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
    private List<OrderItem> items;

    public Order() {
    }

    public Order(Long id, LocalDateTime creationDate, LocalDateTime updateDate, String status, long tableId, double totalPrice, List<OrderItem> items) {
        this.id = id;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.status = status;
        this.tableId = tableId;
        this.totalPrice = totalPrice;
        this.items = items;
    }

    public static Order create(OrderDto orderDto) {
        Order order = new Order();
        order.setStatus("New");
        order.setTableId(orderDto.getTableId());
        return order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public void addItem(OrderItem orderItem) {
        if(this.items == null)
            this.items = new ArrayList<>();

        this.items.add(orderItem);
        addToTotalPrice(orderItem.getPrice());
    }

    private void addToTotalPrice(double price) {
        setTotalPrice(getTotalPrice()+price);
    }
}
