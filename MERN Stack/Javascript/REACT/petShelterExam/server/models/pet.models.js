const mongoose = require("mongoose");

const PetSchema =  new mongoose.Schema (
  {
    name: {
      type: String,
      required: [true, "Pet name is required!"],
      minLength: [3, "Name must be at least 2 characters!"], // validator constraint and message
    },

    type: {
      type: String,
      required: [true, "Please let us know the type!"],
      minLength: [3, "Must be atleast 3 characters!"],
    },

    description: {
      type: String,
      required: [true, "Please tell us more info about your pet!"],
      minLength: [3, "Must be atleast 3 characters!"],
    },

    skill1: {
      type: String,
    },

    skill2: {
      type: String,
    },

    skill3: {
      type: String,
    },
  },
  { 
    timestamps: true, 
  },
);

module.exports = mongoose.model("Pet", PetSchema);