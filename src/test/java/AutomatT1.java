import org.junit.jupiter.api.Test;
import utils.Utils;

import java.io.IOException;
import java.net.URISyntaxException;

public class AutomatT1 extends BaseTest {

    @Test
    public void checkTemperature() throws IOException, URISyntaxException {
        String city = Utils.getRandomCityName();
        homePage.chooseCity(city);
        System.out.printf("Temperatura w mieście %s wynosi: %s", city, homePage.getCityTemperature());
    }

}
