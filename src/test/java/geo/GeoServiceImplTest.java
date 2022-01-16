package geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTest {

    @Test
    void locationByIpTest() {
        String[] ips = {"127.0.0.1", "172.0.32.11", "96.44.183.149"};
        Location[] expectedLocations = {new Location(null, null, null, 0)
                , new Location("Moscow", Country.RUSSIA, "Lenina", 15)
                , new Location("New York", Country.USA, " 10th Avenue", 32)};
        for (int i = 0; i < 3; i++) {
            Location result = new GeoServiceImpl().byIp(ips[i]);
            Assertions.assertEquals(expectedLocations[i].getCity(), result.getCity());
            Assertions.assertEquals(expectedLocations[i].getCountry(), result.getCountry());
            Assertions.assertEquals(expectedLocations[i].getStreet(), result.getStreet());
            Assertions.assertEquals(expectedLocations[i].getBuiling(), result.getBuiling());
        }
    }

    @Test
    void nullLocationByIpTest() {
        String ip = "1.1.1.1";

        Location result = new GeoServiceImpl().byIp(ip);

        Assertions.assertNull(result);
    }
}
