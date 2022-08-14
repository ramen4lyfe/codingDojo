const mongoose = require("mongoose");

const PlayerSchema =  mongoose.Schema (
  {
    name: {
      type: String,
      required: [true, "Name is required!"],
      minLength: [2, "Name must be at least 2 characters!"], // validator constraint and message
    },
    position: {
      type: String,
    },
    matchOneStatus: {
      type: String,
      enum: ["Playing","Not Playing","Undecided"],
      default: "Undecided",
    },
    matchTwoStatus: {
      type: String,
      enum: ["Playing","Not Playing","Undecided"],
      default: "Undecided",
    },
    matchThreeStatus: {
      type: String,
      enum: ["Playing","Not Playing","Undecided"],
      default: "Undecided",
    },
  },
  {timestamps: true}
)

module.exports = mongoose.model("Player", PlayerSchema);