package com.awsquickstarts.gameapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.awsquickstarts.gameapi.model.entity.GameEntity;

@Repository
public interface IGameRepository extends JpaRepository<GameEntity, Long> {

    List<GameEntity> findByPlatform(String platform);
    
}
