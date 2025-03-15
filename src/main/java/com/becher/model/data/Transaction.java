package com.becher.model.data;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Transaction extends BaseDao {

    private String description;
    private String recipient;
    private String sender;
    private BigDecimal amount;
    private LocalDate date;

    @ManyToOne
    private Category category;

    public Transaction() {}

    public Transaction(Long id, String description, String recipient, String sender, BigDecimal amount, LocalDate date, Category category) {
        this.setId(id);
        this.description = description;
        this.recipient = recipient;
        this.sender = sender;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
