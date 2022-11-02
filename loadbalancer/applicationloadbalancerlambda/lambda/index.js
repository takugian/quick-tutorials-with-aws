exports.handler = async (event, context) => {

    let response = {
        statusCode: 200,
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify("OK"),
    };

    const resource = `${event.httpMethod} ${event.path}`;
    console.log(`Running ${resource}`);

    try {

        if (resource == "GET /") {

            console.log(`Running healthcheck`);

        } else if (resource == "GET /customers") {

            console.log(`Running GET /customers`);

        } else {
            throw new Error(`Resource ${resource} not found`);
        }

    } catch (err) {

        console.log(err);
        response.statusCode = 500;
        response.body = JSON.stringify(err.message);

    }

    console.log(`Request has completed with response ${JSON.stringify(response)}`);

    return response;

};