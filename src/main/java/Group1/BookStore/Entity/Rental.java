package Group1.BookStore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rental implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateBorrow;
    private Date dateReturn;

    @JsonIgnore
    @OneToOne (fetch =  FetchType.EAGER)
    @JoinColumn(name = "student_ID")
    private Student students;

    @ManyToMany(mappedBy = "rentals")
    private Collection<Book> books;
}
