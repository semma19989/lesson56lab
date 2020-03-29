package kg.attractor.lesson56lab.model;

import kg.attractor.lesson56lab.util.Generator;
import kg.attractor.lesson56lab.util.SecurityConfig;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Document(collection = "users")
@Data
@Builder
public class User implements UserDetails{
    @Id
    private String id;
    private String name;
    private String mail;
    private String pass;

    public static User addUser(){
        return builder()
                .name(Generator.makeName())
                .mail(Generator.makeEmail())
                .pass(SecurityConfig.encoder().encode(Generator.makePassword()))
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("FULL"));
    }

    @Override
    public String getPassword() {
        return this.pass;
    }

    public void setPassword(String password) {
        this.pass = SecurityConfig.encoder().encode(password);
    }

    @Override
    public String getUsername() {
        return getMail();
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
}
