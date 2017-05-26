package edu.hneu.kpp.labdao.hibernatedao.hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "worker")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique =true, nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name= "orderDate")
    private Date orderDate;

    @Column(name= "orderNumber")
    private int orderNumber;

    @Column(name= "holidayType")
    private String holidayType;

    @Column(name= "position")
    private String position;

    @Column(name= "tableNumber")
    private int tableNumber;

    @Column(name= "department")
    private String department;

    @Column(name= "startHoliday")
    private Date startHoliday;

    @Column(name= "endHoliday")
    private Date endHoliday;


    public Worker() {
    }

    public Worker(String name, String position, String department, Date startHoliday, Date endHoliday) {
        this.name = name;
        this.position = position;
        this.department = department;
        this.startHoliday = startHoliday;
        this.endHoliday = endHoliday;
    }

    public Worker(String name) {
        this.name = name;
    }

    public Worker(String name, Date orderDate, int orderNumber, String holidayType, String position, int tableNumber, String department, Date startHoliday, Date endHoliday) {
        this.name = name;
        this.orderDate = orderDate;
        this.orderNumber = orderNumber;
        this.holidayType = holidayType;
        this.position = position;
        this.tableNumber = tableNumber;
        this.department = department;
        this.startHoliday = startHoliday;
        this.endHoliday = endHoliday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getHolidayType() {
        return holidayType;
    }

    public void setHolidayType(String holidayType) {
        this.holidayType = holidayType;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getStartHoliday() {
        return startHoliday;
    }

    public void setStartHoliday(Date startHoliday) {
        this.startHoliday = startHoliday;
    }

    public Date getEndHoliday() {
        return endHoliday;
    }

    public void setEndHoliday(Date endHoliday) {
        this.endHoliday = endHoliday;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orderDate=" + orderDate +
                ", orderNumber=" + orderNumber +
                ", holidayType='" + holidayType + '\'' +
                ", position='" + position + '\'' +
                ", tableNumber=" + tableNumber +
                ", department='" + department + '\'' +
                ", startHoliday=" + startHoliday +
                ", endHoliday=" + endHoliday +
                '}';
    }
}
