package dev.naveenkumar.springbootmongo.repository;

import dev.naveenkumar.springbootmongo.model.User;
import dev.naveenkumar.springbootmongo.projection.CountryAggregation;
import dev.naveenkumar.springbootmongo.projection.UserAggregation;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends MongoRepository<User, String> {

//    findBy + fieldName
    Optional<User> findByUsername(String username);

//    find users by custom query
//    value: where condition
//    fields: select items: 1 => include, 0 => exclude
//    _id: 0 to ignore id
//    sort: 1 => ASC, -1 => DESC
    @Query(value="{country: ?0}", fields="{name: 1, _id: 0}", sort="{name: -1}")
    List<User> findByCountryAsCustom(String country);

//    select country, sum(1) = count(*) from users group by country
    @Aggregation("{ $group: { _id: $count, total:{ $sum:1 }}}")
    List<CountryAggregation> countByCountry();

//    select country, [names] from user group by country
    @Aggregation("{$group: { _id: $country, name: { $addToSet: $name } } }")
    List<UserAggregation> groupByCountry();
}
