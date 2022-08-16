package ru.java.hibernate;

import org.hibernate.Session;
import ru.java.hibernate.entity.User;

public class Main {
    public static void main(String[] args) {
        // Получаем SessionFactory и создаем сессию
      Session session = HibernateUtil.getSessionFactory().openSession();

        //открываем транзакцию
        session.getTransaction().begin();

        User user = new User();
        user.setEmail("vadik2@gmail.com");
        user.setUsername("Vadik2");
        user.setPassword("qaz123wsx");
        //id автоматом

        session.save(user); // фиксируем изменение в объекте

        session.getTransaction().commit(); // сохраняем изм (транзакция завершается)

      session.close(); //зак сессию (транзакцию)
      HibernateUtil.shutdown(); //закрываем Session Factory
    }
}
// остановились на добавление
//добавление новой записи
//диалект запроса для postgres