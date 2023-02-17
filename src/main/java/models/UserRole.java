package models;

import lombok.Data;

import javax.persistence.*;

@Data//дозволяє застосувати getter i setter
@Entity//представляє таблицю в бд
@Table(name = "tbl_user_roles")// назва таблиці для бд
@IdClass(UserRolePK.class)// звязує ключі з класом
public class UserRole {
    @Id// первинний ключ(Primary key)
    @ManyToOne//зв'язок багато до одного
    @JoinColumn(name="user_id", nullable = false)//з'єднання колонок
    private User user;
    @Id// первинний ключ(Primary key)
    @ManyToOne//зв'язок багато до одного
    @JoinColumn(name="role_id", nullable = false)
    private Role role;
}
