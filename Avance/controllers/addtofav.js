
const expressAsyncHandler = require("express-async-handler");
const Courses = require("../config/course");

const addfav = expressAsyncHandler(async (req, res) => {
    try {

      const Course = new Courses({
        title: req.body.title,
        link: req.body.link,
        user_id: req.body.user_id,
      });
  
   
      const savedRecord = await Course.save();
  
      res.status(201).json(savedRecord);
    } catch (err) {
      res.status(500).json({ error: err.message });
    }
  });

  module.exports = {

    addfav,
 
  };