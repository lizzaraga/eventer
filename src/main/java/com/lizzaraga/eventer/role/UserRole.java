package com.lizzaraga.eventer.role;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity(name = "UserRole")
@Table(name = "tbl_user_role", uniqueConstraints = {
        @UniqueConstraint(
                name = "userrole_role_unique",
                columnNames = "role"
        )
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {

    @Id
    @SequenceGenerator(name = "role_sequence", sequenceName = "role_sequence")
    @GeneratedValue(generator = "role_sequence", strategy = GenerationType.SEQUENCE)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    private String role;

    @CreationTimestamp
    protected LocalDateTime createdAt;

    @UpdateTimestamp
    protected LocalDateTime updateAt;
}
