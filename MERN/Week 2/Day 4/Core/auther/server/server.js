const express = require('express');
const cors = require('cors');
const app = express();

// ------------------------middleware--------------------
app.use(cors(), express.json(), express.urlencoded({ extended: true }), cors())

require('dotenv').config();
const port = process.env.PORT;

require("./routes/authers.routes")(app)

// DB Connection
require("./config/mongoose.config")

app.listen(port, () => console.log(`🦄🦄🦄🦄 Listening on port ${port} for REQuests to RESpond to.`));