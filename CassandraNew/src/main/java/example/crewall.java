package example;

import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

/**
 * Created by SG0225323 on 9/6/2016.
 */

@Table(keyspace = "CREW", name = "crewall")
public class crewall {

    @PartitionKey
    private float CREW_ID;

    private float STAFF_NUMBER;

    private String FIRST_NAME;

    private String LAST_NAME;

    private String SEX;

    private String EMAIL_ADDRESS;

    private float COUNTRY_ID;


//    public Crew() {
//    }
//
//    public Crew(Integer STAFF_NUMBER, Integer CREW_ID, String FIRST_NAME, String LAST_NAME, Integer COUNTRY_ID, String EMAIL_ADDRESS, String SEX) {
//        this.STAFF_NUMBER = STAFF_NUMBER;
//        this.CREW_ID = CREW_ID;
//        this.FIRST_NAME = FIRST_NAME;
//        this.LAST_NAME = LAST_NAME;
//        this.COUNTRY_ID = COUNTRY_ID;
//        this.EMAIL_ADDRESS = EMAIL_ADDRESS;
//        this.SEX = SEX;
//    }

    public float getCREW_ID() {
        return CREW_ID;
    }

    public void setCREW_ID(float CREW_ID) {
        this.CREW_ID = CREW_ID;
    }

    public float getSTAFF_NUMBER() {
        return STAFF_NUMBER;
    }

    public void setSTAFF_NUMBER(float STAFF_NUMBER) {
        this.STAFF_NUMBER = STAFF_NUMBER;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getSEX() {
        return SEX;
    }

    public void setSEX(String SEX) {
        this.SEX = SEX;
    }

    public String getEMAIL_ADDRESS() {
        return EMAIL_ADDRESS;
    }

    public void setEMAIL_ADDRESS(String EMAIL_ADDRESS) {
        this.EMAIL_ADDRESS = EMAIL_ADDRESS;
    }

    public float getCOUNTRY_ID() {
        return COUNTRY_ID;
    }

    public void setCOUNTRY_ID(float COUNTRY_ID) {
        this.COUNTRY_ID = COUNTRY_ID;
    }

    @Override
    public String toString() {
        return "Crew{" +
                "CREW_ID=" + CREW_ID +
                ", STAFF_NUMBER=" + STAFF_NUMBER +
                ", FIRST_NAME='" + FIRST_NAME + '\'' +
                ", LAST_NAME='" + LAST_NAME + '\'' +
                ", SEX='" + SEX + '\'' +
                ", EMAIL_ADDRESS='" + EMAIL_ADDRESS + '\'' +
                ", COUNTRY_ID=" + COUNTRY_ID +
                '}';
    }



}
