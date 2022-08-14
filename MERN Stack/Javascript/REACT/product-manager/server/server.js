const express = require("express");
const cors = require("cors");
const app = express(); // this allows us to create an express application

app.use(express.json());// this allow us to read json objects senr in the client's request
app.use(express.urlencoded({ extended: true })); 

app.use(
    cors({
        origin: "http://localhost:3000",
    }),
);

require("./config/mongoose.config");
require("./routes/product.routes")(app);

app.listen(8000, () => {
    console.log("listen on port 8000");
});