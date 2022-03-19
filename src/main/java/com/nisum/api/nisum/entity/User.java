package com.nisum.api.nisum.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false, unique = true)
  private String email;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
  public List<Phone> phones;

  @Column(name = "created", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;

  @Column(name = "modified")
  @Temporal(TemporalType.TIMESTAMP)
  private Date modified;

  @Column(name = "last_login", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastLogin;

  @Column(nullable = false)
  private String token;

  @Column(nullable = false)
  private String isActive;

  // @Builder.Default
  // private Phone phones = new Phone();

  // public static User builder() {
  // User user = new User();
  // Phone phone = new Phone();
  // user.setPhone(phone);
  // return user;
  // }

}
