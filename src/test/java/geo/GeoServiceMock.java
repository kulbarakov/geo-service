package geo;

import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;

public class GeoServiceMock implements GeoService {

    @Override
    public Location byIp(String ip) {
        if (ip.equals("Добро пожаловать")) {
            return new Location(null, Country.RUSSIA, null, 0);
        } else if (ip.equals("Welcome")) {
            return new Location(null, Country.USA, null,  0);
        } else return null;
    }

    @Override
    public Location byCoordinates(double latitude, double longitude) {
        return null;
    }
}
