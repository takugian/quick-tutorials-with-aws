exports.handler = async (event) => {

    const response = {
        statusCode: 200,
        body: JSON.stringify("Hello, Lambda No VPC Config!"),
    };

    return response;

};