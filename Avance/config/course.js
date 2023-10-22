const mongoose=require('mongoose');
const Schema=mongoose.Schema;
const courseSchema=new Schema({
    title:{type:"string"},
    link:{type:"string"},
    user_id:{type:"string"},
}
,{timestamps:true}
);
const Course=mongoose.model('courses',courseSchema);
module.exports=Course;