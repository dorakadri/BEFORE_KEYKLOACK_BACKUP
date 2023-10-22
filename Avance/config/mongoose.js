mongoose = require("mongoose");
mongoose.set('strictQuery', false); 
module.exports = mongoose
  .connect(process.env.DB_URI)
  .then(() => console.log("Connection established"))
  .catch((err) => console.log(err));
