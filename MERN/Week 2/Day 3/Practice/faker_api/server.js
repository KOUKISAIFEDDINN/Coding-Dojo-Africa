const express = require("express");
const { faker } = require('@faker-js/faker');
const app = express();
const port = 8000;

const createUser = () => {
    const user = {
        password: faker.internet.password(),
        email: faker.internet.email(),
        phoneNumber: faker.phone.number(),
        lastName: faker.name.lastName(),
        firstName: faker.name.firstName(),
        _id: faker.database.mongodbObjectId()
    };
    return user;
};
const createCompany = () => {
    const company = {
        _id: faker.database.mongodbObjectId(),
        name: faker.company.name(),
        address: {
            street: faker.address.street(),
            city: faker.address.city(),
            state: faker.address.state(),
            zipCode: faker.address.zipCode(),
            country: faker.address.country()
        }

    }
    return company
}

app.get("/api", (req, res) => {
    res.json({ message: "Hello World" });
});

app.get("/api/users/new", (res) => {
    res.json(createUser())
})

app.get("/api/companies/new", (res) => {
    res.json(createCompany())
})

app.get("/api/user/company", (res) => {
    const userCompany = {
        user: createUser(),
        company: createCompany()
    }
    res.json(userCompany)
})

app.listen(port, () => console.log(`${port}`));