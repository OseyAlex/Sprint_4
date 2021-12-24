package praktikumservices;

import java.util.logging.Logger;

public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    private static Logger log = Logger.getLogger(Account.class.getName());

    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
        if (name == null) {
            log.info("Введите значение");
            return false;
        } else if (name.length() < 3 || name.length() > 19) {
            log.info("Имя и Фамилия должны быть не менее 3 символов и не более 19");
            return false;
        } else if (name.startsWith(" ") || name.endsWith(" ")) {
            log.info("Имя не может начинаться или заканчиваться с пробелом");
            return false;
        } else if (name.chars().filter(name -> name == (int) ' ').count() != 1) {
            log.info("В имени должен быть 1 пробел");
            return false;
        }
        return true;
    }
}
