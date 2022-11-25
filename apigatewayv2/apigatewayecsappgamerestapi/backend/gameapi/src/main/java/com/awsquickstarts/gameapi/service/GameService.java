package com.awsquickstarts.gameapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.awsquickstarts.gameapi.exception.BusinessException;
import com.awsquickstarts.gameapi.model.entity.GameEntity;
import com.awsquickstarts.gameapi.model.to.GameTo;
import com.awsquickstarts.gameapi.repository.IGameRepository;

@Service
public class GameService {

    @Autowired
    private IGameRepository gameRepository;

    public List<GameTo> findByPlatform(final String platform) {

        System.out.println("Querying games by " + platform);

        if (!StringUtils.hasText(platform)) {
            throw new BusinessException("platform is required");
        }

        final List<GameEntity> gamesEntity = this.gameRepository.findByPlatform(platform);

        final List<GameTo> games = new ArrayList<>();

        for (GameEntity gameEntity : gamesEntity) {
            games.add(new GameTo(gameEntity.getId(), gameEntity.getName(), gameEntity.getPlatform(),
                    gameEntity.getCompany(),
                    gameEntity.getDeveloper()));
        }

        System.out.println("Games has queried...");

        return games;

    }

    public GameTo save(final GameTo game) {

        System.out.println("Saving game " + game);

        if (!StringUtils.hasText(game.getName())) {
            throw new BusinessException("name is required");
        } else if (!StringUtils.hasText(game.getPlatform())) {
            throw new BusinessException("platform is required");
        } else if (!StringUtils.hasText(game.getCompany())) {
            throw new BusinessException("company is required");
        } else if (!StringUtils.hasText(game.getDeveloper())) {
            throw new BusinessException("developer is required");
        }

        final GameEntity gameEntitySaved = this.gameRepository.save(
                new GameEntity(game.getId(), game.getName(), game.getPlatform(), game.getCompany(),
                        game.getDeveloper()));

        System.out.println("Game has saved...");

        return new GameTo(
                gameEntitySaved.getId(), gameEntitySaved.getName(), gameEntitySaved.getPlatform(),
                gameEntitySaved.getCompany(),
                gameEntitySaved.getDeveloper());

    }

    public GameTo findById(final Long id) {

        System.out.println("Finding game by " + id);

        final GameEntity gameEntity = this.gameRepository.findById(id).orElse(null);

        System.out.println("Game has queried...");

        if (gameEntity != null) {
            return new GameTo(gameEntity.getId(), gameEntity.getName(), gameEntity.getPlatform(),
                    gameEntity.getCompany(),
                    gameEntity.getDeveloper());
        }

        return null;

    }

    public void deleteById(final Long id) {

        System.out.println("Deleting game by " + id);

        this.gameRepository.deleteById(id);

        System.out.println("Games has deleted...");

    }

}
