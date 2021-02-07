package tn.isg.mppsi.plantsStoreMgt.Entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name ="users",
        uniqueConstraints = {@UniqueConstraint(columnNames="userName"),
                @UniqueConstraint(columnNames="email")}
)
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    @Size(max=30)
    private String userName;
    @NotBlank
    @Size(max=120)
    private String password;
    @NotBlank
    @Size(max=50)
    @Email
    private String email;
}
