var paladin:Paladin = Paladin("Altras Lighthammer",2500,1,0,1500,100,100)
var littleDragon:LittleDragon= LittleDragon("Wasp",10000,200)
var warrior:Warrior = Warrior("Fabian Wyrm",2300,1,0,500,200)


fun main(){
    println("Start battle between ${paladin.name} and ${littleDragon.name}")
    println(warrior)
    repeat(5){
        warrior.attack(littleDragon)
    }
    println(warrior)
    warrior.execute(littleDragon)





}