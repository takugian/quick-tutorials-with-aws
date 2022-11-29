package com.awsquickstarts.testdynamotableecsapp.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.awsquickstarts.testdynamotableecsapp.model.entity.GameEntity;

@Repository
@EnableScan
public interface IGameRepository extends CrudRepository<GameEntity, String> {

    List<GameEntity> findByPlatform(String platform);
    
}
