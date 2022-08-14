const faker = require("faker"); // we have to require it to use it
const express = require("express");

const app = express();
const port = 8000;

const generateUserObj = () => ({
    _id: faker.datatype.uuid(),
    firstName: faker.name.firstName(),
    lastName: faker.name.lastName(),
    phoneNumber: faker.phone.phoneNumber(),
    email: faker.internet.email(),
    password: faker.internet.password(),
});

const generateCompanyObj = () => ({
    _id: faker.datatype. uuid(),
    name: faker.company.companyName(),
    address: {
        street: faker.address.streetAddress(),
        city: faker.address.cityName(),
        state: faker.address.state(),
        zipcode: faker.address.zipCodeByState(),
        country: faker.address.country(),
    },
})

// console.log(generateUserObj());
// console.log(generateCompanyObj());

//generating user obj
app.get("/api/users/new",(req, res) => {
    const newUser  = generateUserObj();
    res.json(newUser);
});

// generating company obj
app.get("/api/companies/new",(req,res) => {
    const newCompany = generateCompanyObj();
    res.json(newCompany);
});

// generating user and company in one obj
app.get("/api/user/company",(req,res) => {
    const newUser  = generateUserObj();
    const newCompany = generateCompanyObj();
    // combining the 2 object by creating and putting it in a new obj
    const respondObject = {
        user: newUser,
        company: newCompany
    };

    res.json(respondObject);
    
})

app.listen(port, () => console.log(`express server running on port ${port}`));
