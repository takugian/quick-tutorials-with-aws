exports.handler = async (event, context) => {

    if (!event.customer_id) {
        context.fail("customer_id is required");
    } else {
        context.succeed("OK");
    }

};