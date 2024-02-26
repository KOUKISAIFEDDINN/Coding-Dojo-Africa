function pizzaOven(crustType, sauceType, cheese, toppings) {
    var pizza = {};
    pizza.crustType = crustType;
    pizza.sauceType = sauceType;
    pizza.cheese = cheese;
    pizza.toppings = toppings;
    return pizza;
}

var p1 = pizzaOven("deep dish", "traditional", ["mozzarella"], ["pepperoni", "sausage"]);

var p2 = pizzaOven("hand tossed", "marinara", ["mozzarella", "feta"], ["mushrooms", "olives", "onions"]);

var p3 = pizzaOven("thin", "marinara", ["mozzarella", "feta"], ["mushrooms", "olives", "onions"]);

var p4 = pizzaOven("broccoli", "marinara", ["mozzarella", "feta"], ["mushrooms", "olives", "onions"]);

let pizzas = [p1, p2, p3, p4];

function randomPizza(pizzaArray) {
    var randomIndex = Math.floor(Math.random() * pizzaArray.length);
    return pizzaArray[randomIndex];
}

var randomPizzaResult = randomPizza(pizzas);
console.log(randomPizzaResult);
