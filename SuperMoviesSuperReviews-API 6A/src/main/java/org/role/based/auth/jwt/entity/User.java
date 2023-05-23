package org.role.based.auth.jwt.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Entity
@Entity
//@Table(name = "user_data")
public class User {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "user_name")
	
    private String userName;
    
    //@Column(name = "userFirstName")
    private String userFirstName;
   // @Column(name = "userLastName")
    private String userLastName;
   // @Column(name = "userPassword")
    private String userPassword;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }
    )
    
    private Set<Role> role;


  

    
}
