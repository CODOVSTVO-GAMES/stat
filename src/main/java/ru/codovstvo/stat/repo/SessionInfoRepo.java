package ru.codovstvo.stat.repo;

import org.springframework.data.repository.CrudRepository;

import ru.codovstvo.stat.entitys.SessionInfo;

public interface SessionInfoRepo extends CrudRepository<SessionInfo, Long> {
    SessionInfo findByPlatformUserIdAndCountSession(String platformUserId, int CountSession);
    boolean deleteAllByPlatformUserId(String platformUserId);
}
