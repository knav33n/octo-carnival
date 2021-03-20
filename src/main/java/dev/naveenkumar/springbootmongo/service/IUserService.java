package dev.naveenkumar.springbootmongo.service;

import dev.naveenkumar.springbootmongo.model.User;
import dev.naveenkumar.springbootmongo.projection.CountryAggregation;
import dev.naveenkumar.springbootmongo.projection.UserAggregation;

import java.util.List;

public interface IUserService {

    void saveUser(User user);

    List<User> findUsersByCountry(String country);

    List<UserAggregation> groupByCountry();

    List<CountryAggregation> countByCountry();
}
