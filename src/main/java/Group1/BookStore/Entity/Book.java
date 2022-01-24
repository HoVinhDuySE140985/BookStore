package Group1.BookStore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Book implements Serializable {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id_nfc;
 private String name;
 private String image;
 private String description;
 private String Status;
 private Date publish_year;
 private String publish_company;
 private String author;
 private Double price;

 @JsonIgnore
 @ManyToOne(fetch = FetchType.EAGER)
 @JoinColumn(name = "category_ID")
 private Category category;

 @ManyToMany
 @JoinTable(name = "Rental_Detail",
         joinColumns = @JoinColumn(name = "retal_id"),
         inverseJoinColumns = @JoinColumn(name = "book_id"))
 private Collection<Rental> rentals;

}
