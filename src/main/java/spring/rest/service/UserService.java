package spring.rest.service;

import spring.rest.model.MyUser;

import java.util.List;

public interface UserService {
    /**
     * Создает нового клиента
     *
     * @param user - клиент для создания
     */
    void create(MyUser myUser);

    /**
     * Возвращает список всех имеющихся клиентов
     *
     * @return список клиентов
     */
    List<MyUser> readAll();

    /**
     * Возвращает клиента по его ID
     *
     * @param id - ID клиента
     * @return - объект клиента с заданным ID
     */
    MyUser read(Integer id);

    /**
     * Обновляет клиента с заданным ID,
     * в соответствии с переданным клиентом
     *
     * @param user - клиент в соответсвии с которым нужно обновить данные
     * @param id   - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(MyUser myUser, Integer id);

    /**
     * Удаляет клиента с заданным ID
     *
     * @param id - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    boolean delete(Integer id);
}
