const petController = require("../controllers/pet.controller");

module.exports = (app) => {
    app.get("/api/pet", petController.getAllPets);
    app.get("/api/pet/:id", petController.getOnePet);
    app.post("/api/pet", petController.createPet);
    app.put("/api/pet/:id", petController.updatePet);
    app.delete("/api/pet/:id", petController.deletePet);
    
};