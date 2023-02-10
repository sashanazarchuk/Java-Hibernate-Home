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
            Scanner input = new Scanner(System.in);
            System.out.println("Введіть запитання");
            String quest = input.nextLine();
            addQuestion(quest, QuestionType.RADIO_BUTTON);

            int id = 0;
            Session context = HiberContext.getSessionFactory().openSession();
            Query query = context.createQuery("FROM Question");
            List<Question> questions = query.list();
            for (Question question : questions)
                id = question.getId();

            String answer = "";
            boolean isCorrect = false;
            for (int i = 0; i < 3; i++) {
                System.out.println("Введіть відповідь");
                answer = input.nextLine();
                System.out.println("Це вірна відповідь? y/n");
                String isCorrectStr = input.nextLine();
                if (isCorrectStr == "y")
                    isCorrect = true;
                else
                    isCorrect = false;
                addQuestionItem(id, answer, isCorrect);
            }


            context.close(); // закриває підключення

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