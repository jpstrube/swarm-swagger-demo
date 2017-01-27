package net.struwi.swarmswaggerdemo;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jstrube
 */
@Singleton
@Startup
public class PersistenceHelper {

    private static EntityManagerFactory factory;

    @PostConstruct
    private void setUp() {
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.ogm.datastore.host", "localhost");
        properties.put("hibernate.ogm.datastore.port", "27017");
        properties.put("hibernate.ogm.datastore.database", "demo");
        factory = Persistence.createEntityManagerFactory("pu", properties);
    }

}
