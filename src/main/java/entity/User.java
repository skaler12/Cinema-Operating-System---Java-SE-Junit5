package entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @NotBlank(message = "Not null")
    @Size(min = 3,max = 10, message = "more than 2, less then 11 chars")
    private String login;

    //minimum 3 znaki
    @NonNull
    @Pattern(regexp = "Dxx.*", message = "Minimum 3 chat and first char can't be number!")
    private String password;

    private int money;

    private List<Spectacle>spectacleList = new LinkedList<>();

    private UserRole userRole = UserRole.CLIENT;

    public User(int userId, String login, String password, int money, List<Spectacle> spectacleList, UserRole userRole) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.money = money;
        this.spectacleList = spectacleList;
        this.userRole = userRole;
    }
}
