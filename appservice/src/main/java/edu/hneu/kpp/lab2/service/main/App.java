package edu.hneu.kpp.lab2.service.main;

import edu.hneu.kpp.lab2.service.WorkerService;
import edu.hneu.kpp.labdao.hibernatedao.hibernate.model.Worker;

import java.util.List;

public class App {

    public static void main(String[] args) {

        WorkerService workerService = new WorkerService();
        //Book book1 = new Book(1, "The Brothers Karamazov", "Fyodor Dostoevsky");
        Worker book1 = new Worker();
        book1.setName("Fyodor Dostoevsky");

        //		Book book2 = new Book(2, "War and Peace", "Leo Tolstoy");
        Worker book2 = new Worker();
        book2.setName("Leo Tolstoy");

        //		Book book3 = new Book(3, "Pride and Prejudice", "Jane Austen");
        Worker book3 = new Worker();
        book3.setName("Jane Austen");

        System.out.println("*** Persist - start ***");
        workerService.persist(book1);
        workerService.persist(book2);
        workerService.persist(book3);
        List<Worker> books1 = workerService.findAll();
        System.out.println("Books Persisted are :");
        for (Worker b : books1) {
            System.out.println("-" + b.toString());
        }
        System.out.println("*** Persist - end ***");
        System.out.println("*** Update - start ***");
        book1.setName("The Idiot");
        workerService.update(book1);
        System.out.println("Book Updated is =>" + workerService.findById(book1.getId()).toString());
        System.out.println("*** Update - end ***");
        System.out.println("*** Find - start ***");
        Integer id1 = book1.getId();
        Worker another = workerService.findById(id1);
        System.out.println("Book found with id " + id1 + " is =>" + another.toString());
        System.out.println("*** Find - end ***");
        System.out.println("*** Delete - start ***");
        Integer id3 = book3.getId();
        workerService.delete(id3);
        System.out.println("Deleted book with id " + id3 + ".");
        System.out.println("Now all books are " + workerService.findAll().size() + ".");
        System.out.println("*** Delete - end ***");
        System.out.println("*** FindAll - start ***");
        List<Worker> books2 = workerService.findAll();
        System.out.println("Books found are :");
        for (Worker b : books2) {
            System.out.println("-" + b.toString());
        }
        System.out.println("*** FindAll - end ***");
        //System.out.println("*** DeleteAll - start ***");
        //bookService.deleteAll();
        System.out.println("Books found are now " + workerService.findAll().size());
        System.out.println("*** DeleteAll - end ***");
        System.exit(0);
    }
}