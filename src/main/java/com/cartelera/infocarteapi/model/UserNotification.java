package com.cartelera.infocarteapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "users_notifications")
public class UserNotification {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "notification_id", nullable = false)
  private Notification notification;

  private Boolean read;

  @PrePersist
  void preInsert() {
    if (this.read == null)
      this.read = false;
  }

}
