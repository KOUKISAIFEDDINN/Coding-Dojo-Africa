const mongoose = require("mongoose");
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
const Joke = mongoose.model("Joke", jokeSchema);
module.exports = Joke;