const playerController = require("../controllers/player.controller");

module.exports = (app) => {
    app.get("/api/player", playerController.getAllPlayers);
    app.post("/api/player", playerController.createNewPlayer);
    app.delete("/api/player/:id", playerController.deletePlayer);
    app.put("/api/player/:id", playerController.updatePlayer);
    app.get("/api/player/:id", playerController.getOnePlayer);
};