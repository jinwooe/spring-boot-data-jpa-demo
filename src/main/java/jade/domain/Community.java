package jade.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Community {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String description;
  @ManyToMany(mappedBy = "communities")
  @JsonBackReference
  private List<Member> members;

  public Community(String name, String description) {
    this.name = name;
    this.description = description;
  }
}
