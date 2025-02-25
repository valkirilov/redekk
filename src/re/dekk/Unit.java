/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package re.dekk;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rasamog
 */
public class Unit {
    String name,rangedtype,meleetype,sign,owner,armortype;
    int hp,rangeddmg,range,meleedmg,armor,resistance,stamina,size;
    
    Unit(){
        name="none";
        owner="none";
        hp=0;
        rangeddmg=0;
        range=0;
        meleedmg=0;
        armor=0;
        resistance=0;
        stamina=0;
        rangedtype="";
        meleetype="";
        sign="N";
        size=0;
        armortype="";
    }
    
    Unit(String type){
        try {
            Unit set=UnitSetter.setUnit(type);
            name=set.name;
            hp=set.hp;
            rangeddmg=set.rangeddmg;
            range=set.range;
            meleedmg=set.meleedmg;
            armor=set.armor;
            resistance=set.resistance;
            stamina=set.stamina;
            rangedtype=set.rangedtype;
            meleetype=set.meleetype;
            sign=set.sign;
            owner=set.owner;
            size=set.size;
            armortype=set.armortype;
        } catch (IOException ex) {
            Logger.getLogger(Unit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    Unit hit(Unit u,boolean range){
        int dmg=0;
        if(range){
            switch (rangedtype) {
                case "kinetic":
                    dmg=rangeddmg-u.armor;
                    break;
                case "laser":
                    dmg=rangeddmg-u.resistance;
                    break;
            }
        }else{
            switch (meleetype) {
                case "kinetic":
                    dmg=meleedmg-u.armor;
                    break;
                case "laser":
                    dmg=meleedmg-u.resistance;
                    break;
            }
        }
        if(dmg<0){
            dmg=0;
        }
        u.hp-=dmg;
        return u;
    }
}
