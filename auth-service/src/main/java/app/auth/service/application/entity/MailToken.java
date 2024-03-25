package app.auth.service.application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.uuid.UuidGenerator;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.UUID;

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
