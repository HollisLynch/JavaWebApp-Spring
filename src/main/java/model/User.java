package model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "profile")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Column(name = "password", nullable = false, length = 70)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "birth", nullable = false)
    private String birth;

    @Column(name = "role", nullable = false, length = 50)
    private String role;

    public User(String name, String fullName, String password, String email, String birth) {
        this.name = name;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.birth = birth;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(Long id, String name, String fullName, String password, String email, String birth) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.birth = birth;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(getRole()));
        return grantedAuthorities;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birth='" + birth + '\'' +
                ", role='" + role + '\'' +
                '}';
    }



    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getBirth() {
        return birth;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
