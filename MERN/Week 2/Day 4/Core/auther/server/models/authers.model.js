const mongoose = require("mongoose")

// The schema
const AutherSchema = new mongoose.Schema({
    name: {
        type: String,
        require: [true, "{PATH} is required"],
        minlength: [3, "{PATH} must be at least 3 chars"]
    },
}, { timestamps: true })

module.exports.Auther = mongoose.model('Auther', AutherSchema);