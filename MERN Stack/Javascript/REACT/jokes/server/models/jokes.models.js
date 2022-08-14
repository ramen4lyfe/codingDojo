const mongoose = require("mongoose");

const JokeSchema = new mongoose.Schema({
    setup: String,
    punchline: String
},{timestamps:true}); // this will give us timecraeted and time updated

const Joke = mongoose.model("Joke", JokeSchema);

module.exports = Joke;