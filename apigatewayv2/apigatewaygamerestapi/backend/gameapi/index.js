const controller = require('controller.js')();

exports.handler = async (event, context) => {

    console.log('Request data...', JSON.stringify(event));
    const httpMethod = event.httpMethod;
    const path = event.path.replace("/dev", "");

    let response;

    if (httpMethod == "GET" && path == "/games") {

        const queryStringParameters = event.queryStringParameters;
        response = await controller.getGames(queryStringParameters);

    } else if (httpMethod == "POST" && path == "/games") {

        const game = JSON.parse(event.body);
        response = await controller.postGames(game);

    } else if (path.includes("/games/")) {

        const id = path.replace("/games/", "");

        if (httpMethod == "GET") {

            response = await controller.getGamesById(id);

        } else if (httpMethod == "PUT") {

            const game = JSON.parse(event.body);
            response = await controller.putGamesById(id, game);

        } else if (httpMethod == "DELETE") {

            response = await controller.deleteGamesById(id);

        }
    }

    console.log('Response data...', JSON.stringify(response));
    return response;

};