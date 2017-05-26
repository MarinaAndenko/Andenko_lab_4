package edu.hneu.kpp.koval.model;

import edu.hneu.kpp.labdao.hibernatedao.hibernate.model.Worker;

import java.util.Date;

public class WorkerModel {

    private int id;
    private String name;
    private Date orderDate;
    private int orderNumber;
    private String holidayType;
    private String position;
    private int tableNumber;
    private String department;
    private Date startHoliday;
    private Date endHoliday;

    public WorkerModel(Worker worker) {
        this.id = worker.getId();
        this.name = worker.getName();
        this.orderDate = worker.getOrderDate();
        this.holidayType = worker.getHolidayType();
        this.position = worker.getPosition();
        this.tableNumber = worker.getTableNumber();
        this.department = worker.getDepartment();
        this.startHoliday = worker.getStartHoliday();
        this.endHoliday = worker.getEndHoliday();
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
}