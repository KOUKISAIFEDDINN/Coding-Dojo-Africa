const express = require("express")
const cors = require('cors')
const app = express()

app.use(express.json(), express.urlencoded({ extended: true }), cors());

require("dotenv").config()
require("./config/mongoose.config")
const PORT = process.env.PORT


const AllMoviesRoutes = require("./routes/products.routes")
AllMoviesRoutes(app)

app.listen(PORT, () => {
    console.log(`Connecting to our server with success to this PORT : ${PORT}  🌴🌴🌴🌴`)
    // console.log("xxxxxxxxxx")
})