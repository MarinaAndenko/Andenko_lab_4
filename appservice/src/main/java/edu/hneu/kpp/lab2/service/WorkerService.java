package edu.hneu.kpp.lab2.service;

import edu.hneu.kpp.labdao.hibernatedao.hibernate.dao.WorkerDao;
import edu.hneu.kpp.labdao.hibernatedao.hibernate.model.Worker;

import java.util.List;

public class WorkerService {

    private static WorkerDao workerDao;

    public WorkerService() {
        workerDao = new WorkerDao();
    }

    public void persist(Worker entity) {
        workerDao.persist(entity);
    }

    public void update(Worker entity) {
        workerDao.update(entity);
    }

    public Worker findById(int id) {
        Worker worker = workerDao.findById(id);
        return worker;
    }

    public void delete(int id) {
        Worker worker = workerDao.findById(id);
        workerDao.delete(worker);
    }

    public List<Worker> findAll() {
        List<Worker> workers = workerDao.findAll();
        return workers;
    }

    public WorkerDao workerDao() {
        return workerDao;
    }
}
