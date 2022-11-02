const redis = require('redis');

exports.handler = async (event, context) => {

    const client = redis.createClient({
        url: `redis://${process.env.REDIS_HOST}:${process.env.REDIS_PORT}`
    })

    await client.connect();

    client.set("name", "EMERSON");

    const name = await client.get("name");
    console.log('NAME', name);

    client.quit();

    const response = {
        statusCode: 200,
        body: JSON.stringify('Hello from LambdaRedis!'),
    };

    return response;

};