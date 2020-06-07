package zxykj;

import java.util.HashMap;
import java.util.Map;

/**
 * - （必答）部⻔门优化
 * 某公司内有 4 个项⽬目组，
 * 项⽬目组 A、B、C、D，
 * 项⽬目组A现有10⼈人，项⽬目组B现有7⼈人，项⽬目组C现 有5⼈人，项⽬目组D现有4⼈人。
 * 为了了实现跨项⽬目组协作，公司决定每⽉月从⼈人数最多的项⽬目组中抽调 3 ⼈人 出来，
 * 到其他剩下 3 组中，每组 1 ⼈人，这称之为⼀一次调整优化（亦即经过第⼀一次调整后，A组有7 ⼈人，B组有8⼈人，C组有6⼈人，D组有5⼈人）。
 * 那么请问，经过⼗十年年的优化调整后，各项⽬目组各有⼏几⼈人？ 编程求解该问题，并思考是否为最优解
 */
public class Test1 {
    /**
     * 1.存储各小组人员与map，组名为key，人数为val
     * 2.遍历找出人数最多的小组
     * 3.进行人员调整
     *
     * 思考:通过遍历每次调整结果，发现人员数4次一循环
     *      可以计算出需调整总次数，求4的余数，来进行遍历，可减少总遍历次数
     * @param args
     */
    public static void main(String[] args) {
        int loop = 12 * 10; //调整次数
        Map<String, Integer> group = new HashMap<>();
        group.put("A", 10);
        group.put("B", 7);
        group.put("C", 5);
        group.put("D", 4);
        Map<String, Integer> result = null;
        //人员调整
        for (int i = 0; i < loop; i++) {
            String maxGroup = getMaxGroup(group);
            result = changePerson(maxGroup, group);
            System.out.println((i+1) +" - "+result);
        }
    }

    //选出人数最多的小组
    private static String getMaxGroup(Map<String, Integer> group) {
        String maxGroup = "";
        int maxPersonNum = 0;
        for (Map.Entry<String, Integer> entry : group.entrySet()) {
            String groupName = entry.getKey();
            int personNum = entry.getValue();
            if (personNum > maxPersonNum) {
                maxPersonNum = personNum;
                maxGroup = groupName;
            }
        }
        return maxGroup;
    }

    //进行人员调整
    private static Map<String, Integer> changePerson(String maxGroup, Map<String, Integer> group) {
        for (Map.Entry<String, Integer> entry : group.entrySet()) {
            String groupName = entry.getKey();
            int personNum = entry.getValue();
            if (maxGroup.equals(groupName)) {
                group.put(groupName, personNum - 3);
            } else {
                group.put(groupName, personNum + 1);
            }
        }
        return group;
    }


}
