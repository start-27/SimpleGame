package com.example.game.biginsight.skill;

import com.example.game.biginsight.attribute.ElfAttribute;
import com.example.game.biginsight.parent.Skill;
import com.example.game.biginsight.tribe.Elf;


public class ElfSkill extends Skill {
    // 스킬 쿨타임
    public static final int ELUSION_COOL_TIME = 15000;
    public static final int RAPID_COOL_TIME = 300000;

    // 스킬 지속시간
    public static final int ELUSION_DURATION = 5000;
    public static final int RAPID_DURAION = 60000;

    public static void elusion(Elf elf) {
        int consumeMp = 20+5*elf.getLevel();
        if(checkMp(elf, consumeMp)) {
//            elf.setEvasion(elf.getEvasion()*1.3);
            elf.setEvasionBySkill(elf.getEvasion()*0.3);
            elf.setMp(elf.getMp()-consumeMp);
            System.out.println("Elusion 시전");
        }
    }

    public static void rapid(Elf elf) {
        if (elf.getLevel() < 99) {
            System.out.println("99레벨에 도달하지 않아 사용할 수 없습니다.");
            return;
        }
        int consumeMp = 300;
        if (checkMp(elf, consumeMp)) {
            elf.setAttackSpeedBySkill((elf.getAttackSpeed()+elf.getAttackSpeedByWeapon())*4);
            elf.setMp(elf.getMp()-consumeMp);
            System.out.println("궁극스킬 Rapid 시전");
        }
    }
}
