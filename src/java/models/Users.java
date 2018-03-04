package models;
// Generated 24-feb-2018 17:38:51 by Hibernate Tools 4.3.1

/*
 * author: Jamal
 * 
 */
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users  implements java.io.Serializable {

        
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "fullname")
    private String fullname;

    //Coleccion de codigos para un usuario
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Codes> code;
    
    public Users() {
    }

    public Users(int id, String username, String password, String fullname) {
       this.id = id;
       this.username = username;
       this.password = password;
       this.fullname = fullname;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", username=" + username + ", password=" + password + ", fullname=" + fullname + '}';
    }




}


