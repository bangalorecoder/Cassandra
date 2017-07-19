package example;

import com.datastax.driver.core.LocalDate;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Date;

/**
 * Created by SG0225323 on 9/15/2016.
 */
@Table(keyspace = "mykeyspace", name = "DataTypes")
public class DataTypes {
        @PartitionKey
        private ByteBuffer blob;
        private BigDecimal decimal;
        private BigInteger varint;
        private LocalDate date;
        private long time;
        private Date timestamp;

    @Override
    public String toString() {
        return "DataTypes{" +
                "blob=" + blob +
                ", decimal=" + decimal +
                ", varint=" + varint +
                ", date=" + date +
                ", time=" + time +
                ", timestamp=" + timestamp +
                '}';
    }



    public long getTime() { return time; }

    public void setTime(long time) {this.time = time;}

    public Date getTimestamp() { return timestamp;}

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public DataTypes() {
    }

    public LocalDate getDate() {return date; }

    public void setDate(LocalDate date) { this.date = date; }

    public ByteBuffer getBlob() {return blob; }

    public void setBlob(ByteBuffer blob) {this.blob = blob;}

    public BigDecimal getDecimal() {return decimal;}

    public void setDecimal(BigDecimal decimal) {this.decimal = decimal;}

    public BigInteger getVarint() {return varint;}

    public void setVarint(BigInteger varint) {this.varint = varint;}



}


