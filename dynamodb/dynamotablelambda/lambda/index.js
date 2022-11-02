const AWS = require("aws-sdk");

const dynamo = new AWS.DynamoDB.DocumentClient();

exports.handler = async (event, context) => {

    const tableName = "Customer";

    let response = {
        statusCode: 200,
        headers: {
            "Content-Type": "application/json"
        },
        body: null,
    };

    console.log(`Running ${event.action}`);

    try {

        if (event.action == "LIST") {

            console.log(`Running dynamo.scan`);
            response.body = JSON.stringify(await dynamo.scan({ TableName: tableName }).promise());

        } else if (event.action == "CREATE") {

            console.log(`Running dynamo.put`);
            await dynamo
                .put({
                    TableName: tableName,
                    Item: {
                        customer_id: event.customer_id,
                        customer_name: event.customer_name,
                        customer_birth_at: event.customer_birth_at
                    }
                })
                .promise();
            response.body = `Customer ${event.customer_id} created`;

        } else if (event.action == "GET") {

            console.log(`Running dynamo.get ${event.customer_id}`);
            response.body = JSON.stringify(await dynamo
                .get({
                    TableName: tableName,
                    Key: {
                        customer_id: event.customer_id
                    }
                })
                .promise());

        } else if (event.action == "UPDATE") {

            console.log(`Running dynamo.put ${event.customer_id}`);
            await dynamo
                .put({
                    TableName: tableName,
                    Item: {
                        customer_id: event.customer_id,
                        customer_name: event.customer_name,
                        customer_birth_at: event.customer_birth_at
                    }
                })
                .promise();
            response.body = `Customer ${event.customer_id} updated`;

        } else if (event.action == "DELETE") {

            console.log(`Running dynamo.delete ${event.customer_id}`);
            await dynamo
                .delete({
                    TableName: tableName,
                    Key: {
                        customer_id: event.customer_id
                    }
                })
                .promise();
            response.body = `Customer ${event.customer_id} deleted`;

        } else {
            throw new Error(`Resource ${event.action} not found`);
        }

    } catch (err) {

        console.log(err);
        response.statusCode = 400;
        response.body = JSON.stringify(err.message);

    }

    console.log(`Request has completed with response ${JSON.stringify(response)}`);

    return response;

};