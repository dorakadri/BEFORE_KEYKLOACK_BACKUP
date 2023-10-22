const express = require("express");
const { coursefetching } = require("../../controllers/courses");
const { addfav } = require("../../controllers/addtofav");

const courses = express.Router();

courses.post("/:course",coursefetching)
courses.post("/",addfav)

module.exports = courses;