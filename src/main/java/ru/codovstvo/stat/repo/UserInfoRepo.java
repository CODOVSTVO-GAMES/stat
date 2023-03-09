package ru.codovstvo.stat.repo;

import org.springframework.data.repository.CrudRepository;

import ru.codovstvo.stat.entitys.UserInfo;

public interface UserInfoRepo extends CrudRepository<UserInfo, Long> {
    
}
