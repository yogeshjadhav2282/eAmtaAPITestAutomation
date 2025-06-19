package entities.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    private String line1 ;
    private String line2 ;
    private String city  ;
    private String state ;
    private String country ;
    private String zipcode ;

}
