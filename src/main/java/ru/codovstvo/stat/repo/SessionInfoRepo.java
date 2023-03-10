package ru.codovstvo.stat.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ru.codovstvo.stat.entitys.SessionInfo;

public interface SessionInfoRepo extends CrudRepository<SessionInfo, Long> {
    SessionInfo findByPlatformUserIdAndCountSession(String platformUserId, int CountSession);
    
    List<SessionInfo> findAllByPlatformUserId(String platformUserId);

    void deleteAllByPlatformUserId(String platformUserId);

    List<SessionInfo> findAll();

    List<SessionInfo> findAllByStartDateSessionAndCountSession(String date, int count);

    List<SessionInfo> findAllByStartDateSession(String date);

    List<SessionInfo> findAllByPlatformUserIdAndStartDateSession(String id, String date);
}
