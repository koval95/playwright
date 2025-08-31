package utils;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@UtilityClass
public class Utils {

    public String getRandomCityName() throws IOException, URISyntaxException {
        Path filePath = getResourcePath("miasta.txt");
        List<String> cities = Files.readAllLines(filePath)
                .stream()
                .filter(line -> !line.isBlank())
                .toList();
        return cities.get(new Random().nextInt(cities.size()));
    }

    private Path getResourcePath(String resourceName) throws URISyntaxException, IOException {
        URL resource = Utils.class.getClassLoader().getResource(resourceName);
        if (resource == null) {
            throw new IOException("Resource not found" + resourceName);
        }
        return Paths.get(resource.toURI());
    }

}
