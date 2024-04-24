const AutherController = require("../controllers/authers.controllers")
module.exports = (app) => {
    app.get("/api/authers", AutherController.findAll)
    app.get("/api/authers/:id", AutherController.findOne)
    app.post("/api/authers/new", AutherController.create)
    app.put("/api/authers/update/:id", AutherController.update)
    app.delete("/api/authers/delete/:id", AutherController.delete)
}