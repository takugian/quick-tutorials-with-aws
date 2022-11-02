module.exports = () => {

    const gameDynamoDB = require('dynamodb.js')();
    const BusinessException = require('businessexception.js');

    let response = {
        statusCode: 200,
        headers: {
            "Content-Type": "application/json"
        }
    };

    const controller = {};

    controller.getGames = async (queryParameters) => {

        try {

            console.log('Querying games...', queryParameters);

            if (!queryParameters || !queryParameters.platform) {
                throw new BusinessException("platform is required")
            }

            const games = (await gameDynamoDB.list(queryParameters)).Items;

            console.log('Games has queried...');
            console.log('length', games.length);

            response.statusCode = 200;
            response.body = JSON.stringify(games);

        } catch (error) {
            handleError(error);
        }

        return response;

    };

    controller.postGames = async (game) => {

        const { v4: uuidv4 } = require('uuid');

        try {

            game.id = uuidv4();
            console.log('Saving game...', game);

            if (!game.name) {
                throw new BusinessException("name is required")
            } else if (!game.platform) {
                throw new BusinessException("platform is required")
            } else if (!game.company) {
                throw new BusinessException("company is required")
            } else if (!game.developer) {
                throw new BusinessException("developer is required")
            }

            await gameDynamoDB.save(game);

            console.log('Game has saved...');
            response.statusCode = 201;
            response.headers.Location = `/games/${game.id}`;

        } catch (error) {
            handleError(error);
        }

        return response;

    };

    controller.getGamesById = async (id) => {

        try {

            console.log('Finding game...', id);

            const game = await gameDynamoDB.findById(id);

            console.log('Games has queried...');
            response.statusCode = 200;
            response.body = JSON.stringify(game.Items);

        } catch (error) {
            handleError(error);
        }

        return response;

    };

    controller.putGamesById = async (id, game) => {

        try {

            game.id = id;
            console.log('Updating game...', game);

            if (!game.name) {
                throw new BusinessException("name is required")
            } else if (!game.platform) {
                throw new BusinessException("platform is required")
            } else if (!game.company) {
                throw new BusinessException("company is required")
            } else if (!game.developer) {
                throw new BusinessException("developer is required")
            }

            await gameDynamoDB.save(game);
            console.log('Game has updated...');
            response.statusCode = 204;

        } catch (error) {
            handleError(error);
        }

        return response;

    };

    controller.deleteGamesById = async (id) => {

        try {

            console.log('Deleting game...', id);

            await gameDynamoDB.deleteById(id);
            console.log('Game has deleted...');
            response.statusCode = 204;

        } catch (error) {
            handleError(error);
        }

        return response;

    };

    function handleError(error) {
        console.error('Error...', error);
        if (error instanceof BusinessException) {
            response.statusCode = 400;
            response.body = JSON.stringify(error.message);
        } else {
            response.statusCode = 500;
            response.body = JSON.stringify("Internal Server Error");
        }
    }

    return controller;

};