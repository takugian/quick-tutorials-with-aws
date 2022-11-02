const express = require('express');

const app = express();

const customers = [{ customer_id: '1', customer_name: 'EMERSON', customer_birth_at: '1993-01-22' }];

app.get('/', (req, res) => {
    console.log('running /customers');
    res.json(customers);
});

app.post('/', (req, res) => {
    console.log(`create customer_id ${JSON.stringify(req.body)}`);
    customers.push(req.body);
    res.json();
});

app.get('/:customer_id', (req, res) => {
    console.log(`filter customers by customer_id ${req.params.customer_id}`);
    const customer = customers.filter(item => req.params.customer_id === item.customer_id);
    res.json(customer);
});

module.exports = app;