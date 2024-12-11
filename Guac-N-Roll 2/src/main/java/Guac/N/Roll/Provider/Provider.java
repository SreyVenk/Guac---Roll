package Guac.N.Roll.Provider;

import jakarta.persistence.*;

@Entity
@Table(name = "provider")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int providerId;

    @Column(nullable = false)
    private String name;
    private String email;
    private String password;

    public Provider(int providerId, String name, String email, String password) {
        this.providerId = providerId;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public Provider(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public Provider() {

    }
    public int getProviderId(){
        return providerId;
    }
    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
