package i18n;

import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;

public class LocalizationServiceMock implements LocalizationService {

    @Override
    public String locale(Country country) {
        if (country.equals(Country.RUSSIA))
            return "Добро пожаловать";
        else if (country.equals(Country.USA))
            return "Welcome";
        else return null;
    }
}
