const Product = require("../models/products.model")
module.exports = {
    // Read All
    findAll: (req, res) => {
        Product.find()
            .then(allProducts => res.json(allProducts))
            .catch(err => res.json(err))
    },
}