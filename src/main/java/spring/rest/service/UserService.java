package spring.rest.service;

import spring.rest.model.User;

import java.util.List;

public interface UserService {
    /**
     * Создает нового клиента
     *
     * @param user - клиент для создания
     */
    void create(User user);

    /**
     * Возвращает список всех имеющихся клиентов
     *
     * @return список клиентов
     */
    List<User> readAll();

    /**
     * Возвращает клиента по его ID
     *
     * @param id - ID клиента
     * @return - объект клиента с заданным ID
     */
    User read(Integer id);

    /**
     * Обновляет клиента с заданным ID,
     * в соответствии с переданным клиентом
     *
     * @param user - клиент в соответсвии с которым нужно обновить данные
     * @param id   - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(User user, Integer id);

    /**
     * Удаляет клиента с заданным ID
     *
     * @param id - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    boolean delete(Integer id);
}
