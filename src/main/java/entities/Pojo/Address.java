package entities.Pojo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    private String line1 ;
    private String line2 ;
    private String city  ;
    private String state ;
    private String country ;
    private String zipcode ;


}
