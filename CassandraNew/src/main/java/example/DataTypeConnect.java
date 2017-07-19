package example;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.LocalDate;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;

/**
 * Created by SG0225323 on 9/15/2016.
 */
public class DataTypeConnect {

    private static final Logger LOG = LoggerFactory.getLogger(CassandraApp.class);

    private static Cluster cluster;
    private static Session session;

    public static void main(String[] args) {
        try {
            cluster = Cluster.builder().addContactPoint("localhost").withPort(9042).build();

            session = cluster.connect();
            final Metadata metadata = cluster.getMetadata();
            System.out.print(metadata.getClusterName());

            System.out.print(metadata.getKeyspaces());
            System.out.printf("Connected to cluster: %s\n", metadata.getClusterName());


            System.out.printf("Connected to cluster: %s\n", metadata.getClusterName());
            session.execute("use mykeyspace");

            System.out.println("DataTypes");

            session.execute("Create table IF NOT EXISTS mykeyspace.DataTypes(\n" +
                    "\t blob					blob,\n" +
                    "\t decimal	            decimal,\n" +
                    "\t varint		            varint,\n"+
                    "\t date		            date,\n"
                    +"\t time		            time,\n"
                    +"\t timestamp		            timestamp,\n"
                    + "\t primary key (blob)\n"
                    +
                       ");");
            MappingManager manager = new MappingManager(session);
            Mapper<DataTypes> mapper = manager.mapper(DataTypes.class);

            DataTypes D= new DataTypes();
            D.setBlob(ByteBuffer.allocateDirect(10213));
            D.setDecimal(BigDecimal.valueOf(102.23));
            D.setVarint(BigInteger.valueOf((long) 12203491090000.000));
            D.setDate(LocalDate.fromDaysSinceEpoch(12082016));
            D.setTime((long) 12.06);
          //  D.setTimestamp(2011203);

            mapper.save(D);


            cluster.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}