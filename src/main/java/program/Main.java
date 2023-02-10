package program;

import enums.QuestionType;
import models.Question;
import models.QuestionItems;
import models.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HiberContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //testRole();
        try {
            //addQuestion("Як грецькою мовою називалося місто, яке заснувало колонію?", QuestionType.RADIO_BUTTON);//створюю питання
//            addQuestionItem(1, "Магістрат", false);//додаю варіанти відповідей
//            addQuestionItem(1, "Метрополія", true);
//            addQuestionItem(1, "Мусейон", false);

        } catch (Exception ex) {
            System.out.println("Виникла помилка" + ex.getMessage()); //видиться при помилці
        }
    }


    //метод для додавання питання в бд
    private static void addQuestion(String text, QuestionType type) throws SQLException {
        Session context = HiberContext.getSessionFactory().openSession();//починаю сесію
        Transaction tx = context.beginTransaction();//починаю транзакцію для фіксації змін в бд
        Question question = new Question(); //створюю об'єкт класа питання
        question.setText(text);//задаю текст питання
        question.setQuestionType(type);//записую текст питання
        context.save(question);//зберігаю зміни
        tx.commit();//додаю коміт
        context.close();//закриваю сесію
    }

    //метод для додавання варіантів відповіді до питань
    private static void addQuestionItem(int questionId, String text, boolean isTrue) throws SQLException {
        Session session = HiberContext.getSessionFactory().openSession();//починаю сесію
        Transaction tx = session.beginTransaction();//починаю транзакцію для фіксації змін в бд
        Question question = new Question();//створюю об'єкт класа питання
        question.setId(questionId);//додаю id для питання
        QuestionItems qi = new QuestionItems(question, text, isTrue); //створюю об'єкт для варіантів і правильності відповіді
        session.save(qi);// зберігаю зміни
        tx.commit();//додаю коміт
        session.close();//закриваю сесію
    }

    //тестовий метод для додавання ролей в базу і виведення ролей по списку
    private static void testRole() {
//        Scanner input = new Scanner(System.in);//створю сканнер для введення
//        System.out.println("Введіть назву ролі");
//        Role role = new Role();//створюю об'єкт ролі
//        String name = input.nextLine();//вводжу назву ролі
//        role.setName(name);//записую роль для об'єкта
//        Session context = HiberContext.getSessionFactory().openSession();//починаю сесію
//        context.save(role);//зберігаю зміни
//        System.out.println("Role id = " + role.getId());//виводжу ролі по id
//        Query query = context.createQuery("From Role");//створюю запит
//        List<Role> roles = query.list();//створюю список ролей
//        for (Role role : roles) {
//            System.out.println(role);//проходжусь циклом і виводжу список ролей
//        }
//        context.close();//закриваю сесію
    }
}