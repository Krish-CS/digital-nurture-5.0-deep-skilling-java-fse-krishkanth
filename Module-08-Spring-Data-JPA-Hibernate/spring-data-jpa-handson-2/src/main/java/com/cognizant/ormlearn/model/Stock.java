package com.cognizant.ormlearn.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
@Entity
@Table(name="stock")
public class Stock {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="st_id") private int id;
    @Column(name="st_code") private String code;
    @Column(name="st_date") private Date date;
    @Column(name="st_open") private BigDecimal open;
    @Column(name="st_close") private BigDecimal close;
    @Column(name="st_volume") private Long volume;
    public Stock() {}
    public String getCode() { return code; }
    public Date getDate() { return date; }
    public BigDecimal getOpen() { return open; }
    public BigDecimal getClose() { return close; }
    public Long getVolume() { return volume; }
    @Override
    public String toString() { return "Stock [" + code + ", " + date + ", " + open + ", " + close + ", " + volume + "]"; }
}