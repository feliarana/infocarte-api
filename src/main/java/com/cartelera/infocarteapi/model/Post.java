package com.cartelera.infocarteapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String title;

  private Date created_at;

  private Date updated_at;

  @Column
  private Boolean comments_enabled;

  @PrePersist
  protected void onCreate() {
    created_at = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    updated_at = new Date();
  }

  @ManyToOne
  @JoinColumn(name="billboard_id", nullable=false)
  private Billboard billboard;

  @ManyToOne
  @JoinColumn(name="user_id", nullable=false)
  private User user;

  @OneToMany(mappedBy = "user")
  private List<Comment> comments = new ArrayList<Comment>();
}
