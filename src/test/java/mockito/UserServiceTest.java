package mockito;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository repo;

    @InjectMocks
    private UserService service;

    @BeforeAll
    static void start() {
        System.out.println("test starts");
    }

    @Test
    void findUser() {

        User user = new User(1, "Archit");

        when(repo.findById(1)).thenReturn(user);

        User res = service.getById(1);

        assertEquals("Archit", res.getName());

        verify(repo, times(1)).findById(1);
    }
}
