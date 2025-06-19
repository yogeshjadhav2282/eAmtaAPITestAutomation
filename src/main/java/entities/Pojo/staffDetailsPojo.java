package entities.Pojo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class staffDetailsPojo {

    private String uuid;
    private String email;
    private String firstName;
    private String lastName;
    private String middleName;
    private String gender;
    private String phone;
    private String roleType;
    private String role;
    private Address address;


}
