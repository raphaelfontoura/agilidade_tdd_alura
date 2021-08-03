package br.com.caelum.clines.api.users;

import br.com.caelum.clines.shared.domain.User;
import br.com.caelum.clines.shared.infra.Mapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserViewMapper implements Mapper<User, UserView> {
    @Override
    public UserView map(User user) {
        return new UserView(user.getId(), user.getName(), user.getEmail());
    }
}
