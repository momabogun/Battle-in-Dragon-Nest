var paladin:Paladin = Paladin("Altras Lighthammer",2500,1,0,1500,100,100)
var littleDragon:LittleDragon= LittleDragon("Wasp",10000,200)
var warrior:Warrior = Warrior("Fabian Wyrm",2300,1,0,500,200)


fun main(){
    println("Start battle between ${paladin.name} and ${littleDragon.name}")
    println(paladin)
    paladin.judgment(littleDragon)
    paladin.judgment(littleDragon)
    paladin.wingsOfJustice()
    paladin.judgment(littleDragon)
    paladin.healOfRighteous()
    println(paladin)
    paladin.judgment(littleDragon)
    println(paladin)
    paladin.attack(littleDragon)
    paladin.expGain()
    println(paladin)
    warrior.attack(littleDragon)
    println(warrior)
    warrior.attack(littleDragon)
    warrior.attack(littleDragon)
    println(warrior)
    warrior.attack(littleDragon)
    warrior.attack(littleDragon)

    warrior.execute(littleDragon)
    warrior.execute(littleDragon)
    println(warrior)


}