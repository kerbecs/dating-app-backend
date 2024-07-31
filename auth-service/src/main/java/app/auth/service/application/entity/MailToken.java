package app.auth.service.application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "mail_token")
public class MailToken {
    @Id
    @Column(name = "mail_token_id", nullable = false, updatable = false, unique = true, insertable = false)
    private String id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false, unique = true)
    private User user;

    @Column(name = "generation_date", nullable = false, updatable = false)
    private LocalDateTime generationDate;
}
