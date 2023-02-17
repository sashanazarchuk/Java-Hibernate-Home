package models;

import lombok.Data;

import java.io.Serializable;

@Data
public class BasketsPK implements Serializable {
    private User user;
    private Product product;
    private int count;
}
