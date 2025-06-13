package entities.Pojo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProviderGroup {
    private String name;
    private String subdomain;
    private String phone;
    private String npi;
    private String email;
    private Address address;


}
