package br.com.caelum.clines.api.users;

import br.com.caelum.clines.shared.domain.User;
import br.com.caelum.clines.shared.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserFormMapper formMapper;
    private final UserViewMapper viewMapper;

    public List<UserView> listAll() {
        return repository.findAll();
    }

    public UserView findById(Long id) {
        var user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cannot find user"));

        return viewMapper.map(user);
    }

    public Long createUserBy(UserForm form) {
        User user = formMapper.map(form);
        repository.save(user);
        return user.getId();
    }
}
