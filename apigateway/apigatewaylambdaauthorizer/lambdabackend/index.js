
exports.handler = async (event, context) => {

    console.log(`event ${JSON.stringify(event)}`);
    console.log(`context ${JSON.stringify(context)}`);

    let response = {
        statusCode: 200,
        headers: {
            "Content-Type": "application/json"
        },
        body: null,
    };

    const resource = `${event.httpMethod} ${event.path}`;

    try {

        if (resource == `GET /customers`) {

            response.body = JSON.stringify([{ customer_id: "1", customer_name: "EMERSON" }, { customer_id: "2", customer_name: "CAROLLINE" }]);

        } else {
            console.log(`Resource ${resource} not found`);
            response.statusCode = 404;
        }

    } catch (err) {

        console.log(err);
        response.statusCode = 500;
        response.body = JSON.stringify(err.message);

    }

    console.log(`Request has completed with response ${JSON.stringify(response)}`);

    return response;

};