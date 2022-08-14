const Product = require("../models/product.model.js");

module.exports = {
    createProduct:(req,res) => {
        Product.create(req.body)
            .then((newProduct) => res.json(newProduct))
            .catch((err) => console.log(err));
    },

    getAllProducts: (req, res) => {
        Product.find({})
            .then((allProducts) => {
                console.log(allProducts);
                res.json(allProducts);
            })
            .catch((err) => {
                console.log(err);
            })
    },

    getOneProduct: (req, res) => {
        Product.findOne({_id: req.params.id})
            .then((oneProduct)=>{
                console.log(oneProduct);
                res.json(oneProduct);
            })
            .catch((err)=>console.log(err))
    },

    updateProduct: (req, res) => {
        Product.findOneAndUpdate({_id: request.params.id}, request.body, {new:true})
            .then((updatedProduct) => res.json(updatedProduct))
            .catch(err => respone.json(err))
    },

    deleteProduct :(req, res) => {
        Product.deleteOne({_id:req.params.id})
            .then((deletedProduct)=>{
                console.log(deletedProduct);
                res.json(deletedProduct);
            })
            .catch((err)=>console.log(err))
    }
};