const Product = require("../controllers/products.controllers")

module.exports = (app) => {
    app.get("/api/products", Product.findAll)
    app.post("/api/products", Product.create)
}