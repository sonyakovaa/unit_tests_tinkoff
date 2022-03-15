package ru.tinkoff.fintech;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class PasswordValidatorTest {

    @Test
    public void emptyPasswordTest() { // тест с пустым паролем
        String result = "Password must be less than 15 and more than 8 characters in length";
        String actualResult = new PasswordValidator().validatePassword("");
        Assertions.assertEquals(result, actualResult);
    }

    @Test
    public void spaceInPassword14() { // тест на 14 пробелов в пароле
        String result = "Password must have atleast one uppercase character";
        String actualResult = new PasswordValidator().validatePassword("              ");
        Assertions.assertEquals(result, actualResult);
    }

    @Test
    public void password16Characters() { // соблюдены все условия, проверка по граничному зн-ю 16
        String result = "Password must be less than 15 and more than 8 characters in length";
        String actualResult = new PasswordValidator().validatePassword("Xc21.fhrtgh@1455");
        Assertions.assertEquals(result, actualResult);
    }

    @Test
    public void password15Characters() { // соблюдены все условия, проверка по граничному зн-ю 15
        String result = "password is valid";
        String actualResult = new PasswordValidator().validatePassword("Xc21.fhrtgh@145");
        Assertions.assertEquals(result, actualResult);
    }

    @Test
    public void password14Characters() { // соблюдены все условия, проверка по граничному зн-ю 14
        String result = "password is valid";
        String actualResult = new PasswordValidator().validatePassword("Xc21.fhrtgh@15");
        Assertions.assertEquals(result, actualResult);
    }

    @Test
    public void password12Characters() { // соблюдены все условия, проверка по зн-ю 12
        String result = "password is valid";
        String actualResult = new PasswordValidator().validatePassword("Xc45.ghuyR@4");
        Assertions.assertEquals(result, actualResult);
    }

    @Test
    public void password7Characters() { // соблюдены все условия, проверка по граничному зн-ю 7
        String result = "Password must be less than 15 and more than 8 characters in length";
        String actualResult = new PasswordValidator().validatePassword("Xc21.@1");
        Assertions.assertEquals(result, actualResult);
    }

    @Test
    public void password8Characters() { // соблюдены все условия, проверка по граничному зн-ю 8
        String result = "password is valid";
        String actualResult = new PasswordValidator().validatePassword("Xc21.@1x");
        Assertions.assertEquals(result, actualResult);
    }

    @Test
    public void password9Characters() { // соблюдены все условия, проверка по граничному зн-ю 9
        String result = "password is valid";
        String actualResult = new PasswordValidator().validatePassword("Xc21.@1x3");
        Assertions.assertEquals(result, actualResult);
    }

    @Test
    public void noUpperCase() { // в пароле отсутствует заглавная буква
        String result = "Password must have atleast one uppercase character";
        String actualResult = new PasswordValidator().validatePassword("cc21.@1bt");
        Assertions.assertEquals(result, actualResult);
    }

    @Test
    public void noLowercase() { // в пароле отсутствует строчная буква
        String result = "Password must have atleast one lowercase character";
        String actualResult = new PasswordValidator().validatePassword("PP21.@1BT");
        Assertions.assertEquals(result, actualResult);
    }

    @Test
    public void noNumber() { // в пароле отсутствует цифра
        String result = "Password must have atleast one number";
        String actualResult = new PasswordValidator().validatePassword("BTyhvgh@jgy.");
        Assertions.assertEquals(result, actualResult);
    }

    @Test
    public void noSpecialCharacter() { // в пароле нет специального символа
        String result = "Password must have atleast one special character among @#$%";
        String actualResult = new PasswordValidator().validatePassword("BTyhvghjgy5");
        Assertions.assertEquals(result, actualResult);
    }

    @Test
    public void checkCyrillic() { // проверка на кириллицу
        String result = "Password must have atleast one uppercase character";
        String actualResult = new PasswordValidator().validatePassword("роЕрмо.5");
        Assertions.assertEquals(result, actualResult);
    }



}