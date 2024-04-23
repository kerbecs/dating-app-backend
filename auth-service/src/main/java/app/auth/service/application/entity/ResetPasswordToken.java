package app.auth.service.application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "reset_password_token")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResetPasswordToken {
    @Id
    @Column(name = "reset_pass_token_id")
    private String id;
    @Column(name = "generation_date")
    private LocalDateTime generationDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
