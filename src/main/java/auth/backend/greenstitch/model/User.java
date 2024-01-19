package auth.backend.greenstitch.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity(name = "User")
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(
                name = "user_email_unique",
                columnNames = "user_email"
        )
})
@Getter
@Setter
@ToString
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            name = "user_id",
            updatable = false
    )
    private Long id;

    @Size(min = 3,max = 20 , message = "Must be between 3 and 20 character long.")
    @Column(
            name = "fullname",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String fullName;

    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            message = "Password must contain at least 8 characters," +
                    " including at least one digit, one lowercase letter," +
                    " one uppercase letter, and one special character."
    )
    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;

    @Email(message = "Enter a valid Email.")
    @Column(name = "user_email",
            columnDefinition = "TEXT"
    )
    private String email;

    public User(String fullName, String password, String email) {
        this.fullName = fullName;
        this.password = password;
        this.email = email;
    }

    public User() {
    }
}
