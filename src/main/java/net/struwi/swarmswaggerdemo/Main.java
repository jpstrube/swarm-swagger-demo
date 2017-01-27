package net.struwi.swarmswaggerdemo;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

public class Main {

    public static void main(String[] args) throws Exception {
        Swarm swarm = new Swarm();
        swarm.start();
        ClassLoader cl = Main.class.getClassLoader();
        JAXRSArchive archive = ShrinkWrap.create(JAXRSArchive.class, "swarm-demo.war")
                .addAsWebInfResource(new ClassLoaderAsset("beans.xml", cl), "beans.xml")
                .addAsWebInfResource(new ClassLoaderAsset("META-INF/persistence.xml", cl), "classes/META-INF/persistence.xml")
                .addPackages(true, "net.struwi.swarmswaggerdemo")
                .addAllDependencies();
        swarm.deploy(archive);
    }

}
