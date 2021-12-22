package praktikumservices;

public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
        try {
            if (name.length() < 3 || name.length() > 19) {
                throw new Exception("Имя и Фамилия должны быть не менее 3 символов и не более 19");
            } else if (name.startsWith(" ") || name.endsWith(" ")) {
                throw new Exception("Имя не может начинаться или заканчиваться с пробелом");
            } else if (name.chars().filter(name -> name == (int) ' ').count() != 1) {
                throw new Exception("В имени должен быть 1 пробел");
            }
            return true;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
