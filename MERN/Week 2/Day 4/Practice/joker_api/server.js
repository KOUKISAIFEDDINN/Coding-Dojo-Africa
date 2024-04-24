const express = require("express")
const app = express()

app.use(express.json(), express.urlencoded({ extended: true }));

require("dotenv").config()
require("./config/config.mongoose")
const PORT = process.env.PORT


const AllMoviesRoutes = require("./routes/jokes.routes")
AllMoviesRoutes(app)

app.listen(PORT, () => {
    console.log(`Connecting to our server with success to this PORT : ${PORT}  🌴🌴🌴🌴`)
    // console.log("xxxxxxxxxx")
})