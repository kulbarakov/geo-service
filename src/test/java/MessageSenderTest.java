import geo.GeoServiceMock;
import i18n.LocalizationServiceMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderTest {

    @ParameterizedTest
    @ValueSource(strings = {"Добро пожаловать", "Welcome"})
    void MessageSendTest(String argument) {
        GeoServiceMock geoService = new GeoServiceMock();

//        GeoService geoService = Mockito.mock(GeoService.class);
//        Mockito.when(geoService.byIp(Mockito.<String>any()))
//                .thenReturn(new Location(null, Country.RUSSIA, null, 0));

        LocalizationServiceMock localizationService = new LocalizationServiceMock();

//        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
//        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, argument);
        String expected = messageSender.send(headers);

        Assertions.assertEquals(expected, argument);
    }

//    @Test
//    void engMessageSendTest() {
//        geo.GeoServiceMock geoService = new geo.GeoServiceMock();
//        geoService.setValue(new Location(null, Country.USA, null, 0));
////        GeoService geoService = Mockito.mock(GeoService.class);
////        Mockito.when(geoService.byIp(Mockito.<String>any()))
////                .thenReturn(new Location(null, Country.USA, null, 0));
//
//        i18n.LocalizationServiceMock localizationService = new i18n.LocalizationServiceMock();
//        localizationService.setValue("Welcome");
////        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
////        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");
//
//        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
//        String message = "Welcome";
//        Map<String, String> headers = new HashMap<String, String>();
//        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "any USA ip");
//        String expected = messageSender.send(headers);
//
//        Assertions.assertEquals(expected, message);
//    }
}
