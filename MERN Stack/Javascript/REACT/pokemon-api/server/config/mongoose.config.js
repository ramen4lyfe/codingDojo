// In any file that will use the Mongoose library, you will need to be sure to require it at the top of the file similar to this:
const mongoose = require('mongoose');

// This is where we use mongoose to connect to MongoDb
mongoose.connect('mongodb://localhost/students', {
    useNewUrlParser: true,
    useUnifiedTopology: true
})
    .then(() => console.log('Established a connection to the database'))
    .catch(err => console.log('Something went wrong when connecting to the database ', err));

