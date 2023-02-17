package models;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRolePK implements Serializable {//таблиця, яка об'єднує користувачів і ролі
    private User user;
    private Role role;
}
