package com.neuedu.test;

import java.util.*;

public class TestWolferSkill {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int player=scanner.nextInt();
        if (player<12||player>18){
            System.out.println("不符合游戏人数");
        }else {
            List<String> allcard=new ArrayList<>();
            List<String> playingcard=new ArrayList<>();
            List<String> bottomcard=new ArrayList<>();
            initialize(allcard);
            card(allcard,player);
            // 盗贼一定在游戏的牌中  总牌中移除盗贼 放入游戏牌中
            allcard.remove("盗贼");
            playingcard.add("盗贼");
            bottomcard1(allcard,bottomcard);
            playingcard.addAll(allcard);
            // 将游戏牌 打乱顺序 (洗牌)
            Collections.shuffle(playingcard);
            System.out.println("手牌:"+playingcard);
            System.out.println("底牌:"+bottomcard);
        }
    }
    //游戏初始为12人
    public static void initialize(List<String>list){
        //添加四个狼人；
        for (int i=0;i<4;i++){
            list.add("狼人");
        }
        for (int j=0;j<4;j++){
            list.add("村民");
        }
        list.add("预言家");
        list.add("女巫");
        list.add("丘比特");
        list.add("守护");
        list.add("猎人");
        list.add("村长");
        list.add("盗贼");
    }
    //根据不同的人数选择多少张牌
    public static void card(List<String>list ,int player){
        if (player>12)
            list.add("村民");
        if (player>13)
            list.add("替罪羊");
        if (player>14)
            list.add("狼人");
        if (player>15)
            list.add("村民");
        if (player>16)
            list.add("村民");
        if (player>17)
            list.add("吹笛者");
    }
    //从总牌中随机取出3张牌
    public static void bottomcard1(List<String>list,List<String> bottomcard){
        //狼人数应该小于1
        while (bottomcard.size()<3){
            //随机取list的下标
            Random random=new Random();
            int index=random.nextInt(list.size());
            if(bottomcard.contains("狼人")&&list.get(index).equals("狼人"))
                continue;
            else
                bottomcard.add(list.remove(index));
        }

    }
}
