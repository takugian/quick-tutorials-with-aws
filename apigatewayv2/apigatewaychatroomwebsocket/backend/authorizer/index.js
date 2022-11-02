
exports.handler = function (event, context, callback) {

    console.log('Receiving event...', JSON.stringify(event));

    var token = event.queryStringParameters.authorizationToken;

    switch (token) {
        case 'allow':
            console.log('Allowing the request...');
            callback(null, generatePolicy('user', 'Allow', event.methodArn));
            break;
        case 'deny':
            console.log('Denying the request...');
            callback(null, generatePolicy('user', 'Deny', event.methodArn));
            break;
        case 'unauthorized':
            console.log('Unauthoring the request...');
            callback("Unauthorized");
            break;
        default:
            console.log('Invalid token');
            callback("Error: Invalid token");
    }

};

var generatePolicy = function (principalId, effect, resource) {

    var authResponse = {};

    authResponse.principalId = principalId;

    if (effect && resource) {
        var policyDocument = {};
        policyDocument.Version = '2012-10-17';
        policyDocument.Statement = [];
        var statementOne = {};
        statementOne.Action = 'execute-api:Invoke';
        statementOne.Effect = effect;
        statementOne.Resource = resource;
        policyDocument.Statement[0] = statementOne;
        authResponse.policyDocument = policyDocument;
    }

    authResponse.context = {
        "stringKey": "stringval",
        "numberKey": 123,
        "booleanKey": true
    };

    console.log('Policy generated...', authResponse);

    return authResponse;

}