package auth.backend.greenstitch.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "User")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(name = "user_email_unique", columnNames = "email")
})
public class User {

    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    @Column(
            name = "user_id",
            updatable = false
    )
    private Long Id;

    @Size(min = 3,max = 20 , message = "Must be between 3 and 20 character long.")
    @Column(
            name = "fullname",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String fullName;

    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            message = "Password must contain at least 8 characters, including at least one digit, one lowercase letter, one uppercase letter, and one special character."
    )
    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;

    @Email(message = "Enter a valid Email.")
    @Column(
            name = "email",
            columnDefinition = "TEXT"
    )
    private String email;
}
