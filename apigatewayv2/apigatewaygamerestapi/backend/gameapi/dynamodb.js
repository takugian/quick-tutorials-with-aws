module.exports = () => {
    
    const AWS = require("aws-sdk");
    
    const dynamo = new AWS.DynamoDB.DocumentClient();
    
    const tableName = "Game";
    
    const gameDynamoDB = {};
    
    gameDynamoDB.list = async function list(queryParameters) {
        try {
            const params = {
                FilterExpression: "platform = :platform",
                ExpressionAttributeValues: {
                    ":platform": queryParameters.platform,
                },
                TableName: tableName,
            };
            return await dynamo.scan(params).promise();
        } catch (err) {
            return err;
        }
    }
    
    gameDynamoDB.save = async function save(game) {
        try {
            const params = {
                TableName: tableName,
                Item: game
            }
            await dynamo.put(params).promise();
        } catch (err) {
            return err;
        }
    }
    
    gameDynamoDB.findById = async function findById(id) {
        try {
            const params = {
                FilterExpression: "id = :id",
                ExpressionAttributeValues: {
                    ":id": id,
                },
                TableName: tableName,
            };
            return await dynamo.scan(params).promise();
        } catch (err) {
            return err;
        }
    }
    
    gameDynamoDB.deleteById = async function deleteById(id) {
        try {
            const params = {
                TableName: tableName,
                Key: {
                    "id": id
                }
            };
            return await dynamo.delete(params).promise();
        } catch (err) {
            return err;
        }
    }
    
    return gameDynamoDB;
    
}