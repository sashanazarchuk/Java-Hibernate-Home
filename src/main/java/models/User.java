package models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data//дозволяє застосувати getter i setter
@Entity//представляє таблицю в бд
@Table(name = "tbl_users")// назва таблиці для бд
public class User {
    @Id// первинний ключ(Primary key)
    @GeneratedValue(strategy = GenerationType.IDENTITY)// авто інкремент по ключу, коли додається новий запис
    private int id;
    @Column(length = 100, nullable = false)
    private String firstName;// колонка для firstname довжина 100 і не може бути нуль
    @Column(length = 100, nullable = false)
    private String lastName;// колонка для lastname довжина 100 і не може бути нуль
    @Column(length = 200, nullable = false)
    private String email;// колонка для email довжина 200 і не може бути нуль
    @Column(length = 20, nullable = false)
    private String phone;// колонка для phone довжина 20 і не може бути нуль
    @Column(length = 200, nullable = false)
    private String password;// колонка для password довжина 100 і не може бути нуль

    @OneToMany(mappedBy = "user")//зв'язок один до багатьох
    private List<UserRole> userRoles;//список ролей користувачів

    @OneToMany(mappedBy = "user")
    private List<Baskets> baskets;

    public User() {
        userRoles = new ArrayList<>();
        baskets = new ArrayList<>();
    }

    public User(String firstName, String lastName, String email, String phone, String password) {
        super();//виклик конструктора за замовчуванням
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
}
