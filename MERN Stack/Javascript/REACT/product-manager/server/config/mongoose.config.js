const mongoose = require("mongoose");
const dbName= "products";

mongoose.connect(`mongodb://locahost/${dbName}`,{
    useNewUrlParser: true,
    useUnifiedTopology: true
})
    .then(() => console.log(`Connted to ${dbName} database!`))
    .catch((err) => console.log(err));