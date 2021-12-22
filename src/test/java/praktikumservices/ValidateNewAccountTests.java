package praktikumservices;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ValidateNewAccountTests {
    private final String name;
    private final boolean expectingResult;

    public ValidateNewAccountTests(String name, boolean result) {
        this.name = name;
        this.expectingResult = result;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Джонни", false},
                {"Джонни Депп", true},
                {"Джонни ", false},
                {" Джонни", false},
                {"Джонни Депп Викторович", false},
                {"Джонни Депп Депп", false},
                {null, false}
        };
    }

    @Test
    @DisplayName("Проверка метода валидации имени")
    public void checkNewAccount() throws Exception {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals("Метод checkNameToEmboss работает неверно", expectingResult, actual);
    }
}
