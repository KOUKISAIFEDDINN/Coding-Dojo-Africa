const { Auther } = require('../models/authers.model');

module.exports.findAll = (req, res) => {
    Auther.find()
        .then((objects) => {
            res.json(objects)
        })
        .catch((err) => {
            res.json(err)
        });
}

module.exports.findOne = (req, res) => {
    Auther.findOne({ _id: req.params.id })
        .then(one => {
            console.log(one)
            res.json(one)
        })
        .catch(err => res.json(err));
}

module.exports.create = (req, res) => {
    Auther.create(req.body)
        .then(obj => { res.json(obj) })
        .catch((err) => { res.status(400).json(err) });
}

module.exports.update = (req, res) => {
    Auther.findOneAndUpdate(
        { _id: req.params.id },
        req.body,
        { new: true, runValidators: true }
    )
        .then(updatedobj => {
            res.json({ Auther: updatedobj })
        })
        .catch((err) => {
            res.status(400).json(err)
        });
}

module.exports.delete = (req, res) => {
    Auther.deleteOne({ _id: req.params.id })
        .then(result => {
            res.json(result)
        })
        .catch((err) => {
            res.json(err)
        });
}