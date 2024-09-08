package pl.edu.wszib.jwd.print3dcontrol;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import pl.edu.wszib.jwd.print3dcontrol.model.User;
import pl.edu.wszib.jwd.print3dcontrol.repository.UserRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("michal@fs.pl");
        user.setFirstName("Michal");
        user.setFirstName("Michal");
        user.setLastName("Dom");

        User savedUSer = repo.save(user);

        User existUser = entityManager.find(User.class, savedUSer.getId());

        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void testFindUSerByEmail() {
        String email = "michalunoo@gmail.com";

        User user = repo.findByEmail(email);

        assertThat(user).isNotNull();
    }

}
