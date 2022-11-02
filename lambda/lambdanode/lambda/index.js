exports.handler = async (event) => {

    const response = {
        statusCode: 200,
        body: JSON.stringify(process.env.message),
    };

    return response;

};