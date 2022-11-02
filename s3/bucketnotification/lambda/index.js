exports.handler = async (event, context) => {

    console.log(`Event ${JSON.stringify(event)}`);

    return {
        statusCode: 200,
        body: JSON.stringify("OK"),
    };

};