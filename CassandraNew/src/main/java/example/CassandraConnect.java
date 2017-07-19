package example;

/**
 * Created by SG0225323 on 9/7/2016.
 */
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;


public class CassandraConnect {

    private static Cluster cluster;
    private static Session session;

    public static Cluster connect(String node){

        return Cluster.builder().addContactPoint(node).build();
    }

    public static void main(String s[]){
        cluster = connect("localhost");
        session = cluster.connect();

//	session.execute("CREATE KEYSPACE CREW1 with REPLICATION = "
//				+ "{'class' :'SimpleStrategy','replication_factor':1};");

        session.execute("USE CREW");
        session.execute("Create table IF NOT EXISTS CREW1.CREWALL(\n" +
                "\t CREW_ID 					int,\n" +
                "\t CREW_ADDRESS_ID 			int,\n" +
                "\t ADDRESS_TYPE_ID            int,\n" +
                "\t COUNTRY_ID	            int,\n" +
                "\t CITY		            varchar,\n" +
                "\t COUNTRY_NAME	            varchar,\n" +
                "\t DATE_RANGE_AWARE	            int,\n" +
                "\t EFFECTIVE_DATE	            timestamp,\n" +
                "\t EXPIRY_DATE	            timestamp,\n" +
                "\t EMAIL_ADDRESS	            varchar,\n" +
                "\t FIRST_NAME	            varchar,\n" +
                "\t LAST_NAME	            varchar,\n" +
                "\t ADDRESS	            varchar,\n" +
                "\t SEX	            varchar,\n" +
                "\t PROVINCE	            varchar,\n" +
                "\t STAFF_NUMBER	            varchar,\n" +
                "\t TYPE_NAME	            varchar,\n" +
                "\t TWO_LETTER_COUNTRY_CODE	            int,\n" +
                "\t TRI_LETTER_COUNTRY_CODE	            int,\n"
                + "\t primary key (CREW_ID)\n"
                +
                ");");

        session.execute("insert into CREW1.CREWALL"
                + "(CREW_ID, CREW_ADDRESS_ID, ADDRESS_TYPE_ID ,COUNTRY_ID ,ADDRESS, CITY,COUNTRY_NAME,EFFECTIVE_DATE,EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, PROVINCE, SEX,STAFF_NUMBER, TYPE_NAME)"
                + "VALUES(1916,4388435,1410,1334, '262,08,561,,Boon Lay Drive,', 'SIN', 'SINGAPORE',NULL,'Jiaxian_Low@Singaporeair.com.sg','JIA XIAN',	'LOW',NULL,'M','00243731','Home');");

        session.execute("insert into CREW1.CREWALL"
                + "(CREW_ID, CREW_ADDRESS_ID, ADDRESS_TYPE_ID ,COUNTRY_ID ,ADDRESS, CITY,COUNTRY_NAME,EFFECTIVE_DATE,EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, PROVINCE, SEX,STAFF_NUMBER, TYPE_NAME)"
                + "VALUES(1911,4388346,1410,1334, '127,08,395,,Pasir Ris Street 11,', 'SIN', 'SINGAPORE',NULL,'Eleanor_Wong@Singaporeair.com.sg','YU HUI ELEANOR','WONG',NULL,'F','00243726','Home');");

        session.execute("insert into CREW1.CREWALL"
                + "(CREW_ID, CREW_ADDRESS_ID, ADDRESS_TYPE_ID ,COUNTRY_ID ,ADDRESS, CITY,COUNTRY_NAME,EFFECTIVE_DATE,EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, PROVINCE, SEX,STAFF_NUMBER, TYPE_NAME)"
                + "VALUES(1910,4388148,1410,1334, '315,08,99,,Bukit Batok St 32,', 'SIN', 'SINGAPORE',NULL,'Goh_JunLong@Singaporeair.com.sg','JUN LONG','GOH',NULL,'M','00244352','Home');");

        session.execute("insert into CREW1.CREWALL"
                + "(CREW_ID, CREW_ADDRESS_ID, ADDRESS_TYPE_ID ,COUNTRY_ID ,ADDRESS, CITY,COUNTRY_NAME,EFFECTIVE_DATE,EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, PROVINCE, SEX,STAFF_NUMBER, TYPE_NAME)"
                + "VALUES(1891,4387993,1410,1334, '301,15,557,,Clementi Avenue 4,', 'SIN', 'SINGAPORE',NULL,'Nur_Syahidah@Singaporeair.com.sg','BINTE AMIN','NUR SYAHIDAH',NULL,'F','00242084','Home');");

        session.execute("insert into CREW1.CREWALL"
                + "(CREW_ID, CREW_ADDRESS_ID, ADDRESS_TYPE_ID ,COUNTRY_ID ,ADDRESS, CITY,COUNTRY_NAME,EFFECTIVE_DATE,EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, PROVINCE, SEX,STAFF_NUMBER, TYPE_NAME)"
                + "VALUES(1868,4387587,1410,1334, 'BLK 128D PUNGGOL FIELDWALK 14-319', 'SIN', 'SINGAPORE',NULL,NULL,'CHEW BIXIA','GWENDOLIN',NULL,'F','FL000184','Home');");


        System.out.println(session.execute("select * from CREW1.CREWALL"));
        //System.out.println(session.execute("SELECT DISTINCT CREW_ID FROM  from CREW.CREWALL"));
        System.out.println(session.execute("select  COUNT(*) from CREW1.CREWALL"));

        session.close();
        cluster.close();




    }
}
