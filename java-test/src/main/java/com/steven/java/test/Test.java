package com.steven.java.test;

/**
 * @author: dr.panda.
 * @date: 2022/9/20.
 * @description: com.steven.java.test.
 * @version: 1.8.
 */
public class Test {

    public static void main(String[] args) {
        String str = "INSERT INTO `dp-lighthouse`.`t_dp_data_label` (`label_name`, `classify_type`, `label_remark`, `status`, `creator`, `updater`) VALUES ('绘本标签测试', 8, '绘本标签', 1, 'system', 'system')";
        for(int i=1;i<40;i++){
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO `dp-lighthouse`.`t_dp_data_label` (`label_name`, `classify_type`, `label_remark`, `status`, `creator`, `updater`) VALUES ('绘本标签_");
            sb.append(i);
            sb.append("', 8, '绘本标签', 1, 'system', 'system');");
            System.out.println(sb.toString());
        }
    }
}
