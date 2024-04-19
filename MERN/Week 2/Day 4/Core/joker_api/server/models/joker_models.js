const mongoose = require("mongoose");
//const random = require("mongoose-random")

const jokeSchema = new mongoose.Schema({
    setup: {
        type: String,
        required: [true, "{PATH} is required"],
        minLength: [10, "{PATH} must be at least 10 characters"]
    },
    punchline: {
        type: String,
        required: [true, "{PATH} is required"],
        minLength: [3, "{PATH} must be at least 3 characters"]
    }

}, { timestamps: true });

//jokeSchema.plugin(random, { path: 'r' })

const Joke = mongoose.model("Joke", jokeSchema);

module.exports = Joke;