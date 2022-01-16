package i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImplTest {

    @Test
    void localeTest() {
        String expected = "Добро пожаловать";
        String result = new LocalizationServiceImpl().locale(Country.RUSSIA);

        Assertions.assertEquals(expected, result);
    }
}
