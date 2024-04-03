class Unit {
    constructor(name, cost, power, ) {
        this.name = name;
        this.cost = cost;
        this.power = power;
        this.resilience = 4;
    }

    attack(target) {
        console.log(`${this.name} attacks ${target.name}`);
        target.resilience -= this.power;
        console.log(`${target.name}'s resilience is now ${target.resilience}`);
    }
}

class Effect {
    constructor(name, cost, stat, magnitude) {
        this.name = name;
        this.cost = cost;
        this.stat = stat;
        this.magnitude = magnitude;
    }

    play(target) {
        console.log(`Applying ${this.name} on ${target.name}`);
        if (this.stat === 'resilience') {
            target.resilience += this.magnitude;
            console.log(`${target.name}'s resilience is now ${target.resilience}`);
        } else if (this.stat === 'power') {
            target.power += this.magnitude;
            console.log(`${target.name}'s power is now ${target.power}`);
        }
    }
}


const redBeltNinja = new Unit('Red Belt Ninja', 3, 3);
const blackBeltNinja = new Unit('Black Belt Ninja', 4, 5);
const hardAlgorithm = new Effect('Hard Algorithm', 2, 'resilience', 3);
const unhandledPromiseRejection = new Effect('Unhandled Promise Rejection', 1, 'resilience', -2);
const pairProgramming = new Effect('Pair Programming', 3, 'power', 2);
hardAlgorithm.play(redBeltNinja)
unhandledPromiseRejection.play(redBeltNinja)
pairProgramming.play(redBeltNinja)
redBeltNinja.attack(blackBeltNinja)
