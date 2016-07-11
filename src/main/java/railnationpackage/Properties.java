package railnationpackage;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.*;

@Resource.Classpath("config.properties")

public class Properties {

    public Properties() {
        PropertyLoader.populate(this);
    }

    @Property("url")
    private String url;

    public String getUrl() {
        return url;
    }

    @Property("driver_patch")
    private String driverPatch;

    public String getDriverPatch() {
        return driverPatch;
    }
}

