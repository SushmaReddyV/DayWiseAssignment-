package optionalclass;
import java.util.Optional;

class User {
    Optional<String> email;
    Optional<String> phone;

    User(String email, String phone) {
        this.email = Optional.ofNullable(email);
        this.phone = Optional.ofNullable(phone);
    }
}

public class UserProfileDemo {
    public static void main(String[] args) {
        User user = new User("user@example.com", null);
        System.out.println("Email: " + user.email.orElse("Not Provided"));
        System.out.println("Phone: " + user.phone.orElse("Not Provided"));
    }
}