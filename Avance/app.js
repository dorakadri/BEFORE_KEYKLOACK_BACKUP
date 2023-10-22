require("dotenv").config();
const express = require('express');

var cors = require("cors");
const { registerWithEureka } = require('./config/eureka-client');
const courses = require("./routes/apis/youtubecourses");


const app = express();
require("./config/mongoose")
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cors());

const port = 3000;

app.use(express.json());

app.use("/api/pluscours", courses)

app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
registerWithEureka("avance",process.env.PORT || 5000);