package models;
// Generated 24-feb-2018 17:38:51 by Hibernate Tools 4.3.1

/*
 * author: Jamal
 * 
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "codes")
public class Codes implements java.io.Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "redeem")
    private char redeem;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users user;

    public Codes() {
    }

    public Codes(int id, char redeem, Users user) {
        this.id = id;
        this.redeem = redeem;
        this.user = user;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public char getRedeem() {
        return redeem;
    }

    public void setRedeem(char redeem) {
        this.redeem = redeem;
    }

    
    public Users getUser() {
        return this.user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

}
