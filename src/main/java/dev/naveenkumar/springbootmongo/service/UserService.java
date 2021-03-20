package dev.naveenkumar.springbootmongo.service;

import dev.naveenkumar.springbootmongo.model.User;
import dev.naveenkumar.springbootmongo.projection.CountryAggregation;
import dev.naveenkumar.springbootmongo.projection.UserAggregation;
import dev.naveenkumar.springbootmongo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findUsersByCountry(String country) {
        return userRepository.findByCountryAsCustom(country);
    }

    @Override
    public List<UserAggregation> groupByCountry() {
        return userRepository.groupByCountry();
    }

    @Override
    public List<CountryAggregation> countByCountry() {
        return userRepository.countByCountry();
    }
}

