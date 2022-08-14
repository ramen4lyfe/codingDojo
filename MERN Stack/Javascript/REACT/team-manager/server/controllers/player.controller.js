const Player = require("../models/player.models");

const getAllPlayers = (req, res) => {
    Player.find()
        .then((allPlayers) => {
            res.json(allPlayers);
        })
        .catch((err)=> {
            console.log(err);
        });
};

const createNewPlayer = (req,res) => {
    const { body } = req;
    console.log(body);
    Player.create(req.body)
        .then((newPlayer) => {
            res.json(newPlayer);
        })
        .catch((err) => {
            console.log(err);
        });
};

const deletePlayer = (req, res) => {
    Player.deleteOne({_id: req.params.id})
        .then((deletedPlayer) => {
            res.json(deletedPlayer);
        })
        .catch((err) => {
            console.log(err);
        });
};

const updatePlayer = (req, res) => {
    Player.findOneAndUpdate({_id: req.params.id}, req.body, {
        new:true,
        runValidators:true,
    })
        .then((updatedPlayer) => {
            res.json(updatedPlayer);
        })
        .catch((err) => {
            console.log(err);
        });
};

const getOnePlayer = (req, res) => {
    Player.findOne({_id: req.params.id})
        .then((onePlayer) => {
            res.json(onePlayer);
        })
        .catch((err) => {
            console.log(err);
        });
};



module.exports = { getAllPlayers, createNewPlayer, deletePlayer, updatePlayer, getOnePlayer };