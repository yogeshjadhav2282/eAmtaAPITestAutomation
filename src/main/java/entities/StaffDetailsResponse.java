package entities;
import java.time.Instant;
import java.time.OffsetDateTime; // For handling ZonedDateTime or OffsetDateTime

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import entities.Pojo.Address;
import entities.Pojo.staffDetailsPojo;
import io.cucumber.java.eo.Se;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // Important to ignore any fields not mapped
public class StaffDetailsResponse {
    public Instant date;
    public String code;
    public String message;
    public Data data;
    public String path;
    public String requestId;
    public String version;


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        public java.util.List<StaffMember> content;
        public Page page;
    }


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class StaffMember {

        public String uuid;
        public String iamId;
        public String email;
        public String firstName;
        public String lastName;
        public String middleName;
        public String phone;
        public String gender;
        public String avatar;
        public Instant birthDate;
        public String roleType;
        public String role;
        public Address address;
        public Instant lastLogin;
        public boolean active;
        public boolean archive;
        public boolean emailVerified;
        public boolean phoneVerified;
        public String password;
        public String tenantKey;
        public boolean acceptTerms;
        public String locationId;
        public String locationName;
        public boolean currentMonthSummary;
        public String selfCheckUuid;

    }


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Page {
        public int size;
        public int number;
        public int totalElements;
        public int totalPages;

    }
}