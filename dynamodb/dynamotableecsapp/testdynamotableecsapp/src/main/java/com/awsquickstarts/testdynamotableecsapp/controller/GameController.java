package com.awsquickstarts.testdynamotableecsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.awsquickstarts.testdynamotableecsapp.exception.BusinessException;
import com.awsquickstarts.testdynamotableecsapp.model.to.ErrorTo;
import com.awsquickstarts.testdynamotableecsapp.model.to.GameTo;
import com.awsquickstarts.testdynamotableecsapp.service.GameService;

@RestController
@RequestMapping(path = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<Object> getGames(@RequestParam(name = "platform", required = false) String platform) {

        try {

            final List<GameTo> games = this.gameService.findByPlatform(platform);

            return new ResponseEntity<Object>(games, null, HttpStatusCode.valueOf(200));

        } catch (BusinessException e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(new ErrorTo(e.getMessage()), null, HttpStatusCode.valueOf(400));
        } catch (Exception e) {
            return new ResponseEntity<Object>(new ErrorTo(e.getMessage()), null, HttpStatusCode.valueOf(500));
        }

    }

    @PostMapping
    public ResponseEntity<Object> postGames(@RequestBody final GameTo game) {

        try {

            final GameTo gameSaved = this.gameService.save(game);

            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("Location", "/games/" + gameSaved.getId());

            return new ResponseEntity<Object>(null, headers, HttpStatusCode.valueOf(201));

        } catch (BusinessException e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(new ErrorTo(e.getMessage()), null, HttpStatusCode.valueOf(400));
        } catch (Exception e) {
            return new ResponseEntity<Object>(new ErrorTo(e.getMessage()), null, HttpStatusCode.valueOf(500));
        }

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getGamesById(@PathVariable(name = "id", required = true) String id) {

        try {

            final GameTo game = this.gameService.findById(id);

            return new ResponseEntity<Object>(game, null, HttpStatusCode.valueOf(200));

        } catch (BusinessException e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(new ErrorTo(e.getMessage()), null, HttpStatusCode.valueOf(400));
        } catch (Exception e) {
            return new ResponseEntity<Object>(new ErrorTo(e.getMessage()), null, HttpStatusCode.valueOf(500));
        }

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> putGamesById(@PathVariable(name = "id", required = true) String id,
            @RequestBody final GameTo game) {

        try {

            game.setId(id);
            this.gameService.save(game);

            return new ResponseEntity<Object>(null, null, HttpStatusCode.valueOf(204));

        } catch (BusinessException e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(new ErrorTo(e.getMessage()), null, HttpStatusCode.valueOf(400));
        } catch (Exception e) {
            return new ResponseEntity<Object>(new ErrorTo(e.getMessage()), null, HttpStatusCode.valueOf(500));
        }

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> putGamesById(@PathVariable(name = "id", required = true) String id) {

        try {

            this.gameService.deleteById(id);

            return new ResponseEntity<Object>(null, null, HttpStatusCode.valueOf(204));

        } catch (BusinessException e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(new ErrorTo(e.getMessage()), null, HttpStatusCode.valueOf(400));
        } catch (Exception e) {
            return new ResponseEntity<Object>(new ErrorTo(e.getMessage()), null, HttpStatusCode.valueOf(500));
        }

    }

}
