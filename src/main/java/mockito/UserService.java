package mockito;

public class UserService {
    private UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User getById(int id) {
        return repo.findById(id);
    }
}
