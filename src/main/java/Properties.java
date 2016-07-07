import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;

@Resource.Classpath("config.properties")

public class Properties {

    public Properties() {
        PropertyLoader.populate(this);
    }

    @Property("URL")
    private String URL;

    public String getUrl() {
        return URL;
    }

    @Property("DRIVER_PATCH")
    private String DRIVER_PATCH;

    public String getDRIVER_PATCH() {
        return DRIVER_PATCH;
    }
}

