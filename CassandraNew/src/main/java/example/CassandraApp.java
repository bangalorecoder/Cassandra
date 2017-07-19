package example;

/**
 * Created by Amit Kumar on 9/6/2016.
 */

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CassandraApp {

    private static final Logger LOG = LoggerFactory.getLogger(CassandraApp.class);

    private static Cluster cluster;
    private static Session session;

    public static void main(String[] args) {
    try {
        cluster = Cluster.builder().addContactPoint("localhost").withPort(9042).build();


//        cluster = Cluster.builder()
//                .addContactPoint("localhost")
//                .withProtocolVersion(ProtocolVersion.V3)
//                .build();

        session = cluster.connect();
        final Metadata metadata = cluster.getMetadata();
        System.out.print( metadata.getClusterName());

        System.out.print(metadata.getKeyspaces());
        System.out.printf("Connected to cluster: %s\n",  metadata.getClusterName());
//        session.execute("CREATE KEYSPACE CREW with REPLICATION = "
//                + "{'class' :'SimpleStrategy','replication_factor':1};");



        System.out.printf("Connected to cluster: %s\n",  metadata.getClusterName());
        session.execute("use CREW");

        System.out.println("Here");

        session.execute("Create table IF NOT EXISTS CREW.CREWALL(\n" +
                "\t CREW_ID 					float,\n" +
                "\t COUNTRY_ID	            float,\n" +
                "\t CITY		            varchar,\n" +
                "\t COUNTRY_NAME	            varchar,\n" +
                "\t EMAIL_ADDRESS	            varchar,\n" +
                "\t FIRST_NAME	            varchar,\n" +
                "\t LAST_NAME	            varchar,\n" +
                "\t ADDRESS	            varchar,\n" +
                "\t SEX	            varchar,\n" +
                "\t PROVINCE	            varchar,\n" +
                "\t STAFF_NUMBER	            float,\n" +
                "\t TYPE_NAME	            varchar,\n"
                + "\t primary key (CREW_ID)\n"
                +
                ");");
        MappingManager manager= new MappingManager(session);
        Mapper<crewall> mapper = manager.mapper(crewall.class);

        System.out.println("Here");



        crewall c= new crewall();
        c.setCREW_ID(1013);
        c.setFIRST_NAME("Artika");
        c.setEMAIL_ADDRESS("artika128@gamil.com");
        c.setCOUNTRY_ID(121);
        c.setSEX("F");
        c.setSTAFF_NUMBER(123456789);
        c.setLAST_NAME("shukla");

        mapper.save(c);

        crewall c1= new crewall();
        c1.setCREW_ID(1012);
        c1.setFIRST_NAME("john");
        c1.setEMAIL_ADDRESS("jhonxyz@gamil.com");
        c1.setCOUNTRY_ID(122);
        c1.setSEX("F");
        c1.setSTAFF_NUMBER(12345679);
        c1.setLAST_NAME("xyz");

        mapper.save(c1);

        //mapper.delete(c);
        

        cluster.close();
    }
    catch (Exception e) {
        e.printStackTrace();
    }
    }
}