package guru.qa.countries.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "country")
public class CountryEntity {
  @Id
  @Column(nullable = false, length = 3)
  String id;
  @Column(nullable = false)
  String name;
}
