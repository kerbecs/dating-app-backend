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
@Table(name = "banned_user")
public class BannedUser {
    @Id
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @Column(name = "reason", nullable = false)
    private String reason;

    @Column(name = "ban_date", nullable = false, updatable = false)
    private LocalDateTime banDate;
}
