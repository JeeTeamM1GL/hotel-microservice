package bookingSystem.hotelservice.hotelservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE")
public interface UserRestClient {
    @GetMapping("/api/v1/users/{id}")
    User findUserById(@PathVariable String id);

    default User getDefaultUser(String id , Exception exception ) {
        User user = new User();
        user.setId(id);
        user.setFirstName("Not available");
        user.setLastName("Not available");
        //user.setEmail("Not available");
        return user;
    }
}
