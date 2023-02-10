package models;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

//Lombok.Data автоматично дозволяє застосовувати getter i setter
@Data //дозволяє застосувати getter i setter для класа Role
@Entity//представляє таблицю в бд
@Table(name = "tbl_roles") // назва таблиці для бд
public class Role {
    @Id// первинний ключ(Primary key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // авто інкремент по ключу, коли додається новий запис
    private int id;

    @Column(length = 255, nullable = false) // колонка для name довжина 255 і не може бути нуль
    private String name;

}
