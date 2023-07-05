var paladin:Paladin = Paladin("Arthas",2500,1,0,800,100)
var littleDragon:LittleDragon= LittleDragon("Wasp",1000,100)


fun main(){
    println("Start battle between ${paladin.name} and ${littleDragon.name}")
    while (paladin.health > 0 && littleDragon.health > 0) {
        littleDragon.takeDamage(paladin.judgment())
        paladin.healOfRighteous()
        if (littleDragon.health > 0) {
            paladin.takeDamage(littleDragon.fireBolt())
        }
    }

    if (paladin.health <= 0) {
        println("${paladin.name} has been defeated. Game over!")
    } else {
        println("${littleDragon.name} has been defeated. ${paladin.name} wins!")
        paladin.expGain()
        paladin.expGain()
        paladin.expGain()
    }
}