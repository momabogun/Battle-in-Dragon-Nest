val paladin:Paladin = Paladin("Altras Lighthammer",2500,1,0,1100,100,1000)
var warrior:Warrior = Warrior("Fabian Wyrm",2300,1,0,500,200)
var mage:Mage= Mage("Jessica Stormwind", 1800,1,0,600,20,300)
var priest:Priest =Priest("Adrian Wyrm",1500,1,0,600,20,200)
var littleDragon:LittleDragon= LittleDragon("Wasp",600,1100)
var littleDragon1:LittleDragon= LittleDragon("Marble",600,1100)
var littleDragon2:LittleDragon= LittleDragon("Tito",600,1100)
var littleDragon3:LittleDragon= LittleDragon("Gregy",600,1100)
var littleDragon4:LittleDragon= LittleDragon("Otto",600,1100)
var bossDragon :Dragon = Dragon("FIREZILLA",2500,1760)
var battleground:Battleground= Battleground("DRAGON PIT")

fun main(){
    battleground.entranceBattle()
    println()
    battleground.bossBattle()




}