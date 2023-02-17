package utils;

import models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HiberContext {
    private static SessionFactory sessionFactory; //контекст підключення до бд

    public HiberContext() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            //читаємо конфігурацію
            Configuration configuration = new Configuration().configure();
            //добавляємо анотацію для класів
            configuration.addAnnotatedClass(Role.class);
            configuration.addAnnotatedClass(Question.class);
            configuration.addAnnotatedClass(QuestionItems.class);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(UserRole.class);
            configuration.addAnnotatedClass(Category.class);
            configuration.addAnnotatedClass(Product.class);
            configuration.addAnnotatedClass(ProductImage.class);
            configuration.addAnnotatedClass(Baskets.class);
            configuration.addAnnotatedClass(OrderStatus.class);
            configuration.addAnnotatedClass(Order.class);
            configuration.addAnnotatedClass(OrderItem.class);
            configuration.addAnnotatedClass(FilterValue.class);
            configuration.addAnnotatedClass(FilterName.class);
            configuration.addAnnotatedClass(FilterNameGroup.class);
            configuration.addAnnotatedClass(Filter.class);
            //реєструємо сервіс на основі нашого конфігу
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            //створюємо контекст до БД
            sessionFactory = configuration.buildSessionFactory(builder.build());
        }
        return sessionFactory;
    }
}
