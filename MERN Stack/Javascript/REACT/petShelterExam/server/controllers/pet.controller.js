const Pet = require("../models/pet.models"); //import the model 

//now write all the logic create, getAll, getOne with id, update with id, delete with id

const createPet = (req, res) => {
    const {body} = req;
    console.log(body);
    Pet.create(req.body)
        .then((newPet) => {
            res.json({ newPet });
        })
        .catch((err) => {
            res.status(400).json({error: err });
        });

};

const getAllPets = (req, res) => {
    Pet.find()
        .then((allPets) => {
            res.json(allPets);
        })
        .catch((err) => {
            res.status(400).json({error: err });
        });
};

const getOnePet = (req, res) => {
    Pet.findOne({_id: req.params.id})
    .then((onePet) => {
        res.json(onePet);
    })
    .catch((err) => {
        res.status(400).json({error: err });
    });
};

const updatePet = (req, res) => {
    Pet.findOneAndUpdate({_id: req.params.id}, req.body, {new: true, runValidators: true,})
        .then((updatedPet) => {
            res.json({ updatedPet });
        })
        .catch((err) => {
            res.status(400).json({error: err });
        });
};

const deletePet = (req, res) => {
    Pet.deleteOne({_id: req.params.id})
        .then((deletedPet) => {
            res.json({ deletedPet });
        })
        .catch((err) => {
            res.status(400).json({error: err });
        });
};


module.exports = {
    createPet,
    getAllPets,
    getOnePet,
    updatePet,
    deletePet
};