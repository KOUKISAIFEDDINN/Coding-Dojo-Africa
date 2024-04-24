const Joke = require("../models/jokes.model");

module.exports.AllJokes = (req, res) => {
    Joke.find()
        .then(allDaJokes => res.json({ jokes: allDaJokes }))
        .catch((err) => {
            console.log(err)
            res.status(400).json()
        });
};

module.exports.OneJoke = (req, res) => {
    Joke.findOne({ _id: req.params.id })
        .then(oneSingleJoke => res.json({ joke: oneSingleJoke }))
        .catch((err) => {
            console.log(err)
            res.status(500).json()
        });
};

module.exports.createNewJoke = (req, res) => {
    Joke.create(req.body)
        .then(newlyCreatedJoke => res.json({ joke: newlyCreatedJoke }))
        .catch((err) => {
            console.log(err)
            res.status(600).json()
        });
};

module.exports.updateJoke = (req, res) => {
    Joke.findOneAndUpdate({ _id: req.params.id }, req.body, { new: true })
        .then(updatedJoke => res.json({ joke: updatedJoke }))
        .catch((err) => {
            console.log(err)
            res.status(700).json()
        });
};

module.exports.deleteJoke = (req, res) => {
    Joke.deleteOne({ _id: req.params.id })
        .then(result => res.json({ result: result }))
        .catch((err) => {
            console.log(err)
            res.status(800).json()
        });
};

module.exports.OneRandomJoke = (req, res) => {
    Joke.find()
        .then(allDaJokes => {
            const idArray = allDaJokes.map(val => val.id)
            let idx = Math.floor(Math.random() * idArray.length);
            let randomId = idArray[idx]
            Joke.findOne({ _id: randomId })
                .then(oneSingleJoke => res.json({ random_joke: oneSingleJoke }))
                .catch((err) => {
                    console.log(err)
                    res.status(900).json()
                });
        })
        .catch((err) => {
            console.log(err)
            res.status(990).json()
        });
};
