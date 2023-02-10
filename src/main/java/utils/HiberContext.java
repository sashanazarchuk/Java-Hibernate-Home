package utils;

import models.Question;
import models.QuestionItems;
import models.Role;
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
            //реєструємо сервіс на основі нашого конфігу
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            //створюємо контекст до БД
            sessionFactory = configuration.buildSessionFactory(builder.build());
        }
        return sessionFactory;
    }
}
