class ninja {
    constructor(name) {
        this.name = name;
        this.health = 90;
        this.speed = 3;
        this.strength = 3;
    }
    sayName() {
        console.log(`My name is ${this.name}.`);
    }
    showStats() {
        console.log(`${this.name}'s stats:Strength==> ${this.strength}, Speed==> ${this.speed}, Health==>${this.health}`);
    }
    drinkSake() {
        this.health += 10;
        console.log(`${this.name} gain 10 health.`);
    }
}
const ninja1 = new ninja("Hyabusa");
ninja1.sayName();
ninja1.showStats();
ninja1.drinkSake();
