package wolox.training.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedList;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String Username;

    @Column(nullable = false, unique = true)
    private String Name;

    @Column(nullable = false, unique = true)
    private String Birthdate;

    @Column
    @ManyToMany(cascade = {CascadeType.ALL})
    private Collection<Book> books = new LinkedList<Book>();




}
